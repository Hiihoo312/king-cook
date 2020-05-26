package cooking.controller;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import cooking.dto.ProductInfo;
import cooking.service.ProductInfoService;

/**
 * 一覧画面コントローラークラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Controller
public class ProductList implements Serializable {

	/** productInfoService.*/
	@Autowired
	private ProductInfoService productInfoService;

	/** messageSource.*/
	@Autowired
	MessageSource messageSource;

	/**
	 * DBから商品情報を取得し、一覧画面に表示するクラス.
	 * @param productInfo 商品情報。
	 * @param bindingResult ModelAttributeが引数とのバインドが失敗かどうかを判定。
	 * @param model リクエストを受け取るメソッドにModelクラスの引数を取る。
	 * @param locale 地域。
	 * @param message メッセージ。
	 * @return 一覧画面。
	 * @throws UnsupportedEncodingException 文字のエンコーディングがサポートされない時に起こりうる例外。
	 */
	@GetMapping("/product-list")
	public String findAll(@ModelAttribute("proInfo") @Validated ProductInfo productInfo, BindingResult bindingResult,
		Model model, Locale locale, @Param(value = "message") String message) throws UnsupportedEncodingException {

		// インターフェスproductInfoServiceのgetProductInfoListメソッドで商品情報を取得。
		List<ProductInfo> productInfoList = productInfoService.getProductInfoList();
		// getProductInfoListメソッドの戻り値で条件判断。
		for (ProductInfo productInfomation : productInfoList) {

			// 戻り値がnullじゃなかったら画像のとこをString型の空文字に設定。
			if (productInfomation.getProductImg() == null) {
				productInfomation.setStringImg("");
			// 他の場合は取得した画像のデータをbase64に変換し、String型に設定します。
			} else {
				productInfomation.setStringImg(new String(Base64.encodeBase64(productInfomation.getProductImg())));
			}
		}
		// 商品情報一覧画面に商品情報件数を渡す。
		model.addAttribute("numberGet", productInfoList.size());
		// 商品画面一覧画面に商品情報を渡す（LIST型）。
		model.addAttribute("productInfos", productInfoList);
		// 一覧画面に遷移。
		return "productlist";
	}

}
