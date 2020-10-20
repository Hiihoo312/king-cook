package cooking.controller;

import java.io.IOException;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cooking.dto.ProductInfo;
import cooking.service.ProductInfoService;

/**
 * 商品情報登録画面コントローラークラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Controller
public class ProductRegistration {

	/** productInfoService インターフェス.*/
	@Autowired
	private ProductInfoService productInfoService;

	/** messageSource 登録処理完了後、表示するメッセージ.*/
	@Autowired
	MessageSource messageSource;

	/**
	 * 商品情報登録画面で登録した値をDBに登録し、商品情報一覧画面に表示するメソッド.
	 * @param productInfo 商品情報。
	 * @param bindingResult 入力チェックの結果。
	 * @param attributes リダイレクト先にで値を渡す。
	 * @return エラーの場合は商品情報登録画面、登録時は商品情報一覧画面。
	 * @throws IOException 入出力する際起こりうる例外。
	 */
	@PostMapping("/product-registration")
	public String insert(@ModelAttribute("productInfo") @Valid ProductInfo productInfo, BindingResult bindingResult,
			RedirectAttributes attributes) throws IOException {
		// 入力チェックを行い、エラーの場合は商品情報登録画面に戻り、該当エラーメッセージを表示。
		if (bindingResult.hasErrors()) {
			return "/product-registration";
			// 他の場合は商品情報を登録し、商品情報一覧画面に戻る。
		} else {
			productInfo.setProductImg(productInfo.getMultipartFile().getBytes());
			productInfoService.insertProductInfo(productInfo);
			attributes.addFlashAttribute("message", messageSource.getMessage("IMSG201", null, Locale.JAPAN));
			return "redirect:product-list";
		}
	}

	/**
	 * 商品情報登録画面を表示するメソッド.
	 * @param model リクエストを受けるメソッドにMODELクラスの引数を受け取る。
	 * @return 商品情報登録画面。
	 */
	@GetMapping("/product-registration")
	public String moveToRegisterPage(Model model) {
		// 空オブジェクト「ProductInfo()」の値を属性名「productInfo」にセットする。
		model.addAttribute("productInfo", new ProductInfo());
		return "product-registration";
	}

}
