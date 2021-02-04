package interfaces;

public class SignInUI {
    public static String txtMail = "//input[@name='email']";
    public static String txtPassWord = "//input[@name='password']";
    public static String iconAccount = "//span[@class='calling-icon calling-icon--gray calling-icon-user fz-20']";
    public static String bntLogout = "//a[contains(text(),'ログアウト')]";
    public static String bntConfirmLogout = "//span[contains(text(),'ログアウト')]";
    public static String bntLogoutWS ="//a[contains(text(),'他のワークスペースにログインする')]";
    public static String btnLogin = "//button[@calling-test='login-account']";
    public static String lblLoginFailMessage = "//p[@translate='login_failed_message']";
    public static String linkLoginAnotherWS = "//a[@translate='login_another_workspace']";
    public static String lnkRequestPassword ="//a[@href='/request-password']";
    public static String lblLoginMessageSuccess = "//div[text()='ログインに成功しました。']";
    public static String workSpaceAddressTxt = "//div[@class='guest-layout__left-container__signin-workspacename']";
}
