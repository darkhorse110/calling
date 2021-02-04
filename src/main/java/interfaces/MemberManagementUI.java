package interfaces;

public class MemberManagementUI {
    public static String txtPageTitle = "//h2[@translate='member_management']";
    public static String tabListMember = "//ul[@class='nav nav-tabs']/li[1]";
    public static String tabAuthorityGroup = "//ul[@class='nav nav-tabs']/li[2]";
    public static String tabInvalidAccount = "//ul[@class='nav nav-tabs']/li[3]";
    public static String tabInvitedMember = "//ul[@class='nav nav-tabs']/li[4]";
    public static String btnInviteMember = "//span[@translate='invite_member']";
    public static String txtSearchActiveMember = "//user-management-component[@type='active_account']//input[@name='free_word']";
    public static String txtSearchDeActiveMember = "//user-management-component[@type='deactive_account']//input[@name='free_word']";
    public static String btnCreateAuthorizationGroup = "//button[@translate='create_authority_group']";
    public static String countNumberInvitedMember = "//div[@class='list-user__caret']";
    public static String countNumberInvalidAccount ="//button[@translate='active_account']";
    public static String tblListStaff ="//div[@class='active_account']//td[@class='list-user__user-info']";
    public static String tblListDeactiveAccount = "//div[@class='deactive_account']//td[@class='list-user__user-info']";
    public static String arrowDown ="//div[@class='list-user__caret ng-scope']";
    public static String btnChangeAuthorityGroup ="//button[@translate='change_authority_group']";
    public static String btnDisableAccount ="//button[@translate='disable_account']";
    public static String txtPopupChangeAuthorityGroup = "//h2[@translate='change_authority_group']";
    public static String btnClosPopupChangeAuthorityGroup ="//span[@class='modal-modify__close-button']";
    public static String btnSubmitChangeAuthorityGroup ="//button[@type='submit']";
    public static String ddlAuthorityGroup ="//select[@ng-model='ChangeAuthorityGroupModalCtrl.group']";
    public static String msgSaveSuccess = "//div[@class='toast-message']";
    public static String btnTransferAdministrator ="//button[@translate='transfer_administrator']";
    public static String btnSubmitDisableAccount = "//div[contains(@style,'block')]//button[@class='btn btn-block confirm-button ng-binding btn-danger']";
    public static String btnCancelDisableAccount ="//div[contains(@style,'block')]//button[@class='btn btn-block cancel-button ng-binding btn-default']";
    public static String btnSubmitActiveAccount = "//div[contains(@style,'block')]//button[@class='btn btn-block confirm-button ng-binding btn-danger']";
    public static String btnCancelActiveAccount ="//div[contains(@style,'block')]//button[@class='btn btn-block cancel-button ng-binding btn-default']";
    public static String btnActiveAccount ="//button[@translate='active_account']";
    public static String btnForgetPassword ="//a[@translate='did_you_forgot_password_transfer_admin']";
    public static String btnCancelTranferAdmin ="//button[@translate='cancel']";

    //Text
    public static String txtMemberManagerPageTitle = "メンバー管理";
    public static String txtTabListMember = "メンバー一覧";
    public static String txtInviteButton = "メンバーを招待する";
    public static String txtTabAuthorityGroup = "権限グループ";
    public static String txtTabInvalidMember ="無効アカウント";
    public static String txtTabInvitedMember = "招待中のメンバー";
    public static String txtMsgChangeAuthorityGroupSuccess = "権限グループの変更が完了しました";
    public static String txtMsgDeActiveAccountSuccess   = "を無効にしました";
    public static String txtMsgActiveAccountSuccess     = "を有効にしました";
    public static String txtBtnCreateAuthorityGroup = "新規の権限グループを作成";
    public static String txtChangeAuthorityGroupTitle = "権限グループを変更する";
    public static String txtForgetPassowrdTitle ="ForgetPassword";
    public static String lblNameSearchResult = "//td[@class='list-user__user-info']//span[text()='%s']";
    public static String lblGroupSearchResult = "//table[@class='groups']//span[text()='%s']";
    public static String lblGroupActiveSearchResult = "//div[@class='active_account']//span[text()='%s']";
}
