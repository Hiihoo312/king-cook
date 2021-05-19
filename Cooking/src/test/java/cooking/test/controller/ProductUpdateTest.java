package cooking.test.controller;

/**
 * 商品情報更新画面コントローラークラス.
 * @author ris.h.hen
 * @version 1.0.0
 */
/*@Controller
public class ProductUpdateTest {

	*//** productInfoService インターフェース.*/
/*
@Autowired
private ProductInfoService productInfoService;

*//** messageSource 排他メッセージ、更新、削除、サーチ処理完了後、表示するメッセージ.*/
/*
@Autowired
MessageSource messageSource;

*//**
	* 商品情報一覧画面で選択したIDに基づいた商品情報を商品情報更新画面に表示するメソッド.
	* @param productId 商品ID。
	* @param model リクエストを受けるメソッドにModelクラスの引数を受け取る。
	* @param attributes リダイレクト先にで値を渡す。
	* @return 商品情報がnullの場合（既に削除された）は商品情報一覧画面、その他の場合は商品情報更新画面。
	*/
/*
@PostMapping("/product-update")
public String findById(Integer productId, Model model, RedirectAttributes attributes) {

ProductInfo productInfoItems = productInfoService.getProductInfo(productId);

// 取得件数が0件の場合、商品情報一覧画面に戻り、EMSG202メッセージを表示。
if (productInfoItems == null) {
	attributes.addFlashAttribute("exlusiveControlMessage",
			messageSource.getMessage("EMSG202", null, Locale.JAPAN));
	return "redirect:/product-list";
}
if (productInfoItems.getProductImg() == null) {
	productInfoItems.setStringImg("");
} else {
	productInfoItems.setStringImg(new String(Base64.encodeBase64(productInfoItems.getProductImg())));
}
model.addAttribute("productInfo", productInfoItems);
return "productupdate";
}

*//**
	* 更新した商品情報をDBに更新し、商品情報一覧画面に表示するメソッド.
	* @param productInfoUp 商品情報。
	* @param bindingResult 入力チェックの結果。
	* @param model リクエストを受けるメソッドにModelクラスの引数を受け取る。
	* @param attributes リダイレクト先にで値を渡す。
	* @return エラーの場合は商品情報更新画面、既に更新された場合は商品情報更新画面、更新時は商品情報一覧画面。
	* @throws IOException 入出力する際起こりうる例外。
	*/
/*
@PutMapping("/product-update")
public String update(@ModelAttribute("productInfo") @Valid ProductInfo productInfoUp, BindingResult bindingResult,
	Model model, RedirectAttributes attributes) throws IOException {
// 入力チェックをし、エラーの場合はエラーメッセージを表示。
if (bindingResult.hasErrors()) {
	return "/productupdate";
}
// 更新画像が無い場合は、元の画像をそのままセットする。
if (productInfoUp.getMultipartFile().isEmpty()) {
	productInfoUp.setStringImg(new String(Base64.encodeBase64(productInfoUp.getProductImg())));
}
// 更新画像がある場合はbyteに変換、セットする。
else {
	productInfoUp.setProductImg(productInfoUp.getMultipartFile().getBytes());
}
Integer updateNumber = productInfoService.updateProductInfo(productInfoUp);
// 更新件数は0件の場合、商品情報更新画面にてメッセージEMSG201を表示。
if (0 == updateNumber) {
	model.addAttribute("exlusiveControlMessage", messageSource.getMessage("EMSG201", null, Locale.JAPAN));
	return "/productupdate";
}
// その他の場合、更新処理を行い、商品情報一覧画面にもどり、メッセージIMSG202を表示。
else {
	attributes.addFlashAttribute("message", messageSource.getMessage("IMSG202", null, Locale.JAPAN));
	return "redirect:/product-list";
}
}

*//**
	* 商品情報を（論理）削除し、商品情報一覧画面にもどるメソッド.
	* @param productInfoDele 商品情報。
	* @param model リクエストを受けるメソッドにModelクラスの引数を受け取る。
	* @param attributes リダイレクト先にで値を渡す。
	* @return 既に削除された場合は商品情報更新画面、削除時は商品情報一覧画面。
	*//*
		@DeleteMapping("/product-update")
		public String delete(@ModelAttribute ProductInfo productInfoDele, Model model,
			RedirectAttributes attributes) {
		// 下でif文で実行を分岐させるため、変数updateCaseの戻り値を取得。
		Integer updateCase = productInfoService.deleteProductInfo(productInfoDele);
		// 削除件数0件の場合、商品情報更新画面にもどり、メッセージEMSG201を表示。
		if (0 == updateCase) {
			model.addAttribute("exlusiveControlMessage", messageSource.getMessage("EMSG201", null, Locale.JAPAN));
			return "/productupdate";
		}
		// その他の場合、商品情報一覧画面に戻り、メッセージIMSG203を表示。
		else {
			attributes.addFlashAttribute("message", messageSource.getMessage("IMSG203", null, Locale.JAPAN));
			return "redirect:/product-list";
		}
		}
		}
		*/