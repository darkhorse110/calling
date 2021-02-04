package interfaces;

public class EditProfileUI {

    public static String regiterNameTxt = "//input[@name='name']";
    public static String mailTxT = "//input[@type='email']";
    public static String btnCancel = "//button[@translate='cancel']";
    public static String btnSubmit = "//button[@translate='save']//span[1]";
    public static String confirmPopup = "//h2[@translate='confirm_change_email_title']";
    public static String btnSubmitPopup = "//span[contains(text(),'変更する')]";
    public static String btnEditAvatar = "//button[@translate='change_avatar']";
    public static String linkEditAvatarPage ="https://%s.app.dev.calling.fun/account-info/change-avatar";
}
