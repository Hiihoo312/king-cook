package cooking.controller;

/*@Controller
public class UserSignup {
	//ラジオボタン用の変数
	private Map<String, String> radioMarriage;

	//ラジオボタンの初期化
	private Map<String, String> initRadioMarriage() {
		Map<String, String> radio = new LinkedHashMap<>();

		//既婚、未婚をMapに格納
		radio.put("既婚", "true");
		radio.put("未婚", "false");

		return radio;
	}

	@GetMapping("/product-signup")
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {

		//ラジオボタンの初期化メソッド呼び出し
		radioMarriage = initRadioMarriage();

		//ラジオボタン用のMapをmodelに登録
		model.addAttribute("radioMarriage", radioMarriage);

		//signup.hrmlに画面遷移
//		return "productlogin/productsignup";
		return "productsignup";
	}

//	@PostMapping("/product-signup")
//	//public String postSignUp(Model model) {
//	public String postSignUp(@ModelAttribute("signupForm") @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult, Model model) {
//		//bindingResult.hasErrors()メソッドで入力チェックにひっかかった場合
//		if(bindingResult.hasErrors()) {
//			//GETリクエスト用のメソッドを呼び出して、ユーザ登録画面に戻る
//			return getSignUp(form, model);
//		}
//		//formの中身をコンソールに出して確認する
//		System.out.println(form);

//		//login.htmlにリダイレクト
//		return "redirect:/productlogin";
//	}

	@PostMapping("/product-signup")
	//public String postSignUp(Model model) {
	public String postSignUp(@ModelAttribute("signupForm") @Validated(GroupOrder.class) SignupForm form,
			BindingResult bindingResult, RedirectAttributes attributes) {
		//bindingResult.hasErrors()メソッドで入力チェックにひっかかった場合
		if(bindingResult.hasErrors()) {
			//GETリクエスト用のメソッドを呼び出して、ユーザ登録画面に戻る
			return "/productsignup";
		}else {
		//formの中身をコンソールに出して確認する
		System.out.println(form);

		//login.htmlにリダイレクト
		return "redirect:/product-login";
	}*/
