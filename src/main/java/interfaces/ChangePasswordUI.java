package interfaces;

public class ChangePasswordUI {
    public static String txtOldPassword = "//input[@name='current_password']";
    public static String txtNewPassword = "//input[@name='password']";
    public static String txtConfirmNewPassword = "//input[@name='password_confirmation']";
    public static String btnSubmit = "//span[contains(text(),'変更する')]";
    public static String popupConfirmChangePassword = "//h2[contains(text(),'パスワードを変更します')]";
    public static String btnChangePasswordOnPopup = "//span[contains(text(),'変更する')]";
    public static String contentNewPassword = "TestUpdate123";
    public static String popupChangePasswordSuccessful = "//*[@class='toast-message']";
    public static String errorMessageOLdPassword = "//span[contains(text(),'正しいパスワードを入力してください。')]";
    public static String errorMessageNewPassword = "//span[contains(text(),'現在のパスワードと違うパスワードを設定してください。')]";
    public static String bntSubmitDisable ="//button[@translate='change' and @disabled='disabled']";

}
