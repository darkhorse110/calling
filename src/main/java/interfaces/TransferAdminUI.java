package interfaces;

public class TransferAdminUI {
    public static String txtTransferAdminTitle = "//h2[@translate='transfer_admin']";
    public static String txtTransferAdminWarning = "//p[@translate='transfer_admin_warning']";
    public static String txtTransferAdminNotice = "//p[@translate='transfer_admin_notice']";
    public static String ddlNewAdministrator = "//select[@ng-model='TransferAdminCtrl.input.user_selected']";
    public static String txtPassword ="//input[@type='password']";
    public static String btnCancel = "//button[@translate='cancel']";
    public static String btnTransferAdmin = "//button[@translate='transfer_admin']";
    public static String linkForgotPassword ="//label[@class='dashboard-layout__container__form__label text-right']/a";
    public static String msgSendEmailForgotPassword = "//span[@translate='request_password_success_checkmail']";

    public static String txtPageTitle1 = "管理者権限を譲渡する";
    public static String txtPageTitle2 = "管理者権限を譲渡すると、あなたの権限は一般権限に戻ります。";
    public static String txtPageTitle3 = "以後、新しい管理者のみがワークスペース";
    public static String txtPageTitle4 = "においてプラン申込、管理者権限の再譲渡を行えます";
    public static String txtForgotPassword = "パスワードをお忘れですか？";


}
