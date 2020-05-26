package cooking.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cooking.dto.ProductInfo;
import cooking.service.ProductInfoService;

/**
 * 新規登録画面コントローラークラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Controller
public class ProductRegistration implements Serializable {

	/** productInfoService.*/
	@Autowired
	private ProductInfoService productInfoService;

	/** messageSource.*/
	@Autowired
	MessageSource messageSource;

	/**
	 * 新規登録画面に登録した値をDBに登録し、一覧画面に表示するクラス.
	 * @param productInfo 商品情報。
	 * @param bindingResult ModelAttributeが引数とのバインドが失敗かどうかを判定。
	 * @param model リクエストを受け取るメソッドにModelクラスの引数を取る。
	 * @param locale 地域。
	 * @param attributes リダイレクト先にで値を渡す。
	 * @return product-listにリダイレクト。
	 * @throws IOException 入出力する際起こりうる例外。
	 */
	@PostMapping("/product-registration")
	public String insert(@ModelAttribute("productInfo") @Validated(ProductInfo.All.class) ProductInfo productInfo,
		BindingResult bindingResult, Model model, Locale locale, RedirectAttributes attributes) throws IOException {

		// 入力チェックを行い、エラーの場合は新規登録画面に戻り、該当エラーメッセージを表示。
		if (bindingResult.hasErrors()) {
			return "/productregistration";
		}
		// その他の場合、DBに保存する為バイナリ変換し、インターフェスproductInfoServiceのinsertProductInfoメソッドで
		// 商品情報を登録。
		else {
			productInfo.setProductImg(productInfo.getMultipartFile().getBytes());
			productInfoService.insertProductInfo(productInfo);
		}
		// 画像ファイルをバイナリ型で取得、属性名「productImg」にセットする。
		model.addAttribute("productImg", productInfo.getMultipartFile().getBytes());
		// リダイレクト先にメッセージを送る。
		attributes.addFlashAttribute("message", messageSource.getMessage("IMSG201", new String[] { "" }
		    , Locale.JAPAN));
		// product-listにリダイレクト。
		return "redirect:/product-list";
	}

	/**
	 * 一覧画面に戻るメソッド.
	 * @param model リクエストを受けるメソッドにMODELクラスの引数を受け取る。
	 * @return product-listにリダイレクト。
	 */
	@PutMapping("/product-registration")
	public String moveToTopPage(Model model) {

		// 空オブジェクト「ProductInfo()」の値を属性名「productInfo」にセットする。
		model.addAttribute("productInfo", new ProductInfo());
		// product-listにリダイレクトする。
		return "redirect:/product-list";
	}

	/**
	 * 新規登録画面を表示するメソッド.
	 * @param model リクエストを受けるメソッドにMODELクラスの引数を受け取る。
	 * @return 新規登録画面。
	 */
	@GetMapping("/product-registration")
	public String moveToRegisterPage(Model model) {

		// 空オブジェクト「ProductInfo()」の値を属性名「productInfo」にセットする。
		model.addAttribute("productInfo", new ProductInfo());
		// 新規登録画面に遷移。
		return "productregistration";
	}

}
