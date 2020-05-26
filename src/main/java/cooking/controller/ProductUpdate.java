package cooking.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cooking.dto.ProductInfo;
import cooking.service.ProductInfoService;

/**
 * 商品情報更新画面コントローラークラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Controller
public class ProductUpdate implements Serializable {

	/** productInfoService.*/
	@Autowired
	ProductInfoService productInfoService;

	/** messageSource.*/
	@Autowired
	MessageSource messageSource;

	/**
	 * updateメソッドで更新した商品情報をDBに更新し、一覧画面に表示する.
	 * @param productInfo 商品情報。
	 * @param bindingResult ModelAttributeが引数とのバインドが失敗かどうかを判定。
	 * @param model リクエストを受けるメソッドにModelクラスの引数を受け取る。
	 * @param locale 地域。
	 * @param attributes リダイレクト先にで値を渡す。
	 * @return product-listにリダイレクト。
	 * @throws IOException 入出力する際起こりうる例外。
	 */
	@PutMapping("/product-update")
	public String update(@ModelAttribute("productInfo") @Validated(ProductInfo.All.class) ProductInfo productInfo,
			BindingResult bindingResult, Model model, Locale locale, RedirectAttributes attributes) throws IOException {

		// 入力チェックをし、エラーの場合はエラーメッセージを表示。
		if (bindingResult.hasErrors()) {
			return "/productupdate";
		}
		// 下でif文で実行を分岐させるため、変数updateNumberの戻り値を取得。
		productInfo.setProductImg(productInfo.getMultipartFile().getBytes());
		Integer updateNumber = productInfoService.updateProductInfo(productInfo);
		// 更新件数は１件の場合、更新処理を行い、一覧画面にもどる。
		if (1 == updateNumber) {
			productInfo.setProductImg(productInfo.getMultipartFile().getBytes());
			productInfoService.updateProductInfo(productInfo);
			model.addAttribute("productImg", productInfo.getMultipartFile().getBytes());
			attributes.addFlashAttribute("message", messageSource.getMessage("IMSG202", new String[] { "" }
			    , Locale.JAPAN));
			return "redirect:/product-list";
		}
			// その他の場合、更新画面にてEMSG201メッセージを表示。
		else {
			model.addAttribute("message", messageSource.getMessage("EMSG201", new String[] { "" }, Locale.JAPAN));
			return "/productupdate";
		}

	}

	/**
	 * destroyメソッドで商品情報を（論理）削除し、一覧画面にもどる.
	 * @param productInfo 商品情報。
	 * @param model リクエストを受けるメソッドにModelクラスの引数を受け取る。
	 * @param locale 地域。
	 * @param attributes リダイレクト先にで値を渡す。
	 * @return 商品情報更新画面。
	 */
	@DeleteMapping("/product-update")
	public String delete(@ModelAttribute ProductInfo productInfo, Model model, Locale locale,
		RedirectAttributes attributes) {

		// 下でif文で実行を分岐させるため、変数updateCaseの戻り値を取得。
		Integer updateCase = productInfoService.deleteProductInfo(productInfo);
		// 更新件数は１件の場合、削除処理を行い、一覧画面にもどる。
		if (1 == updateCase) {
			productInfoService.deleteProductInfo(productInfo);
			attributes.addFlashAttribute("message", messageSource.getMessage("IMSG203", new String[] { "" }
			    , Locale.JAPAN));
			return "redirect:/product-list";
		}
		// その他の場合、更新画面にてEMSG201メッセージを表示。
		else {
			model.addAttribute("message", messageSource.getMessage("EMSG201", new String[] { "" }, Locale.JAPAN));
			return "/productupdate";
		}

	}

	/**
	 * 一覧画面に選択したIDに基づいた商品情報を更新画面に表示.
	 * @param productID 商品ID。
	 * @param model リクエストを受けるメソッドにModelクラスの引数を受け取る。
	 * @param locale 地域。
	 * @param attributes リダイレクト先にで値を渡す。
	 * @return 商品情報更新画面。
	 */
	@PostMapping("/product-update")
	public String findById(int productID, Model model, Locale locale, RedirectAttributes attributes) {

		// 下でif文で実行を分岐させるため、変数productInfoItemsの戻り値を取得。
		ProductInfo productInfoItems = productInfoService.getProductInfo(productID);
		// 戻り値pIはnullか否かで削除されたかどうかを判断させ、nullだったら一覧画面に戻り、EMSG202メッセージを表示。
		if (productInfoItems == null) {
			attributes.addFlashAttribute("message", messageSource.getMessage("EMSG202", new String[] { "" }
			    , Locale.JAPAN));
			return "redirect:/product-list";
		}
		// その他の場合、更新画面にて商品情報を表示。
		else {
			productInfoService.getProductInfo(productID);
			productInfoItems.setStringImg(new String(Base64.encodeBase64(productInfoItems.getProductImg())));
			model.addAttribute("productInfo", productInfoItems);
			return "productupdate";
		}

	}

	/**
	 * 一覧画面に戻るメソッド.
	 * @param model リクエストを受けるメソッドにModelクラスの引数を受け取る。
	 * @return product-listにリダイレクト。
	 */
	@GetMapping("/product-update")
	public String moveToTopPage(Model model) {
		return "redirect:/product-list";
	}
}
