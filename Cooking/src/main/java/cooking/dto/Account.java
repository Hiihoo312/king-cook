package cooking.dto;
/**
 * ログインに必要な会員情報を格納するクラス。
 */
public class Account {

    private String userName;

    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

}