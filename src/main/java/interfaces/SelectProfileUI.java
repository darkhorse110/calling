package interfaces;

public class SelectProfileUI {

    public static String profileIcon = "//span[contains(@class,'calling-icon-user')]";
    public static String prorfileText = "//a[@translate='account_info']";
    public static String btnEditProfile = "//button[@translate='edit_profile']";
    public static String btnChangePassword = "//button[@translate='change_password']";
    public static String tabNotification = "//a[contains(text(),'通知')]";
    public static String linkProfile = "https://%s.app.dev.calling.fun/account-info";
    public static String linkEditProfile = "https://%s.app.dev.calling.fun/account-info/edit";
    public static String linkChangePassword = "https://%s.app.dev.calling.fun/account-info/change-password";
    public static String linkNotification = "https://%s.app.dev.calling.fun/account-info";
    public static String getNameAccountLogin = "//p[@ng-bind='AccountInfoCtrl.userInfo.getName()']";

}
