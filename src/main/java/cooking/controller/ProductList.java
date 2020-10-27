package cooking.controller;

import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cooking.dto.ProductInfo;
import cooking.service.ProductInfoService;

/**
 * 商品情報一覧画面コントローラークラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
@Controller
public class ProductList {

	/** productInfoService インターフェース.*/
	@Autowired
	private ProductInfoService productInfoService;

	/**
	 * DBから商品情報を取得し、商品情報一覧画面に表示するクラス.
	 * @param model リクエストを受け取るメソッドにModelクラスの引数を取る。
	 * @return 商品情報一覧画面。
	 */
	@GetMapping("/product-list")
	public String findAll(Model model) {

		// インターフェースproductInfoServiceのgetProductInfoListメソッドで商品情報を取得。
		List<ProductInfo> productInfoList = productInfoService.getProductInfoList();
		// getProductInfoListメソッドの戻り値で条件判断。
		for (ProductInfo productInfomation : productInfoList) {
			// 戻り値がnullの場合、商品画像（画面表示用）をString型の空文字に設定。
			if (productInfomation.getProductImg() == null) {
				productInfomation.setStringImg("");
			} else {
				productInfomation.setStringImg(new String(Base64.encodeBase64(productInfomation.getProductImg())));
			}
		}
		// 商品情報一覧画面に商品情報件数を渡す。
		model.addAttribute("numberGet", productInfoList.size());
		// 商品画面一覧画面に商品情報を渡す（LIST型）。
		model.addAttribute("productInfos", productInfoList);
		// 商品情報一覧画面に遷移。
		return "productlist";
	}

}
