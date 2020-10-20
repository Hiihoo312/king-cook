package cooking.controller;

import java.io.IOException;
import java.util.Locale;

import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ProductUpdate {

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
	 * @param attributes リダイレクト先にで値を渡す。
	 * @return 更新ボタンを押下後、入力エラーの場合は更新画面に遷移；<br>
	 * 更新件数が１の場合は一覧画面に遷移。；<br>
	 * その他の場合、更新画面に遷移。
	 * @throws IOException 入出力する際起こりうる例外。
	 */
	@PutMapping("/product-update")
	public String update(@ModelAttribute("productInfo") @Valid ProductInfo productInfo,
			BindingResult bindingResult, Model model, RedirectAttributes attributes) throws IOException {
		// 入力チェックをし、エラーの場合はエラーメッセージを表示。
		if (bindingResult.hasErrors()) {
			return "/productupdate";
		}
        //更新画像がある場合にbyte変換し、無い場合は、元の画像をそのままセットする
		if (productInfo.getMultipartFile() != null) {
			productInfo.setProductImg(productInfo.getMultipartFile().getBytes());
		} else {
			productInfo.setProductImg(DatatypeConverter.parseBase64Binary(productInfo.getStringImg()));
		}

		Integer updateNumber = productInfoService.updateProductInfo(productInfo);
		// 更新件数は１件の場合、更新処理を行い、一覧画面にもどる。
		if (1 == updateNumber) {
			attributes.addFlashAttribute("message",
					messageSource.getMessage("IMSG202", null, Locale.JAPAN));
			return "redirect:/product-list";
		}
		// その他の場合、更新画面にてEMSG201メッセージを表示。
		else {
			model.addAttribute("message", messageSource.getMessage("EMSG201", null, Locale.JAPAN));
			return "/productupdate";
		}

	}

	/**
	 * destroyメソッドで商品情報を（論理）削除し、一覧画面にもどる.
	 * @param productInfo 商品情報。
	 * @param model リクエストを受けるメソッドにModelクラスの引数を受け取る。
	 * @param attributes リダイレクト先にで値を渡す。
	 * @return 削除ボタンを押下後、更新件数が1件の場合は一覧画面に遷移；<br>
	 * その他の場合、更新画面に遷移。
	 */
	@DeleteMapping("/product-update")
	public String delete(@ModelAttribute ProductInfo productInfo, Model model,
			RedirectAttributes attributes) {
		// 下でif文で実行を分岐させるため、変数updateCaseの戻り値を取得。
		Integer updateCase = productInfoService.deleteProductInfo(productInfo);
		// 更新件数は１件の場合、削除処理を行い、一覧画面にもどる。
		if (1 == updateCase) {
			attributes.addFlashAttribute("message", messageSource.getMessage("IMSG203", null, Locale.JAPAN));
			return "redirect:/product-list";
		}
		// その他の場合、更新画面にてEMSG201メッセージを表示。
		else {
			model.addAttribute("message", messageSource.getMessage("EMSG201", null, Locale.JAPAN));
			return "/productupdate";
		}

	}

	/**
	 * 一覧画面に選択したIDに基づいた商品情報を更新画面に表示.
	 * @param productID 商品ID。
	 * @param model リクエストを受けるメソッドにModelクラスの引数を受け取る。
	 * @param attributes リダイレクト先にで値を渡す。
	 * @return 商品情報がnullの場合（既に削除された）は一覧画面に遷移；<br>
	 * その他の場合、更新画面に遷移。
	 */
	@PostMapping("/product-update")
	public String findById(int productID, Model model, RedirectAttributes attributes) {

		ProductInfo productInfoItems = productInfoService.getProductInfo(productID);
        //取得件数が0件の場合、一覧画面に戻り、EMSG202メッセージを表示
		if (productInfoItems ==null) {
			attributes.addFlashAttribute("message", messageSource.getMessage("EMSG202", null, Locale.JAPAN));
			return "redirect:/product-list";
		}

		if (productInfoItems.getProductImg() != null) {
			productInfoItems.setStringImg(new String(Base64.encodeBase64(productInfoItems.getProductImg())));
		} else {
			productInfoItems.setStringImg("");
		}

		model.addAttribute("productInfo", productInfoItems);
		return "productupdate";
	}
}
