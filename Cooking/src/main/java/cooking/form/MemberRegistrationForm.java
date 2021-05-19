package cooking.form;

/**
 * 会員登録フォームに入力された値を格納するためのクラス。
 */
public class MemberRegistrationForm {
	private String uName;

	private String uPwd;

	public String getUName() {
		return uName;
	}

	public void setUName(String userIdName) {
		this.uName = userIdName;
	}

	public String getUPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

}