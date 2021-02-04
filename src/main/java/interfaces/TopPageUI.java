package interfaces;

import actions.commons.Constants;

public class TopPageUI {
    public static String bntHome = "//a[@class='dashboard-layout__toolbar__logo']";
    public static String bntMeeting = "//button[@translate='open_meeting/sales']";
    public static String bntChatbot = "//button[@translate='open_chatbot']";
    public static String bntChat = "//button[@translate='open_chat']";
    public static String btnBell = "//li[@class='dashboard-layout__toolbar__menu__notice-badge']//a";
    public static String BellTitle = "//a[contains(text(),'TOPへもどる')]";
    public static String btnHelp = "//span[@class='calling-icon calling-icon--gray calling-icon-help fz-22 cursor-pointer']";
    public static String HelpTitle = "//span[contains(text(), 'サポート')]";
    public static String MeetingTitle = "//span[@class='main-text ng-scope']";
    public static String ChatbotTitle = "//span[contains(text(),'Chatbot')]";
    public static String ChatTitle = "//span[@class='calling-icon calling-icon--black calling-icon-chat fz-24']";
    public static String iconSetting = "//span[@class='calling-icon calling-icon--gray calling-icon-setting fz-24']";
    public static String  btnWorkspaceManagement = "//a[@translate='workspace_management']";
    public static String btnManageMember = "//a[@translate='manage_member']";
    public static String  btnInviteMember = "//a[@translate='toolbar_invite_member']";
    public static String btnGroupManagement = "//a[@translate='group_management_member_rights']";
    public static String btnEnglish = "//a[normalize-space()='English']";
    public static String  btnLanguage = "//a[@translate='language']";
    public static String  WorkspaceManagementTitle = "//h2[@class='dashboard-layout__container__calling-top__title ng-binding']";

    public static String  MemberManageTitle ="//li[@ng-if='MemberManagementCtrl.workspaceInfo.isRemoveUser() || MemberManagementCtrl.workspaceInfo.isCreateEditGroup() || MemberManagementCtrl.workspaceInfo.isInviteUser()']";

    public static String  InviteMemberTitle ="//h3[@translate='invite_mail_title']";

    public static String  GroupManagementTitle ="//li[@ng-if='MemberManagementCtrl.workspaceInfo.isCreateEditGroup()']";

    public static String  TopPageTitle = "//title[@ng-bind='$root.pageTitle']";

    public static String  btnAboutWorkspace = "//a[@translate='about_workspace']";

    public static String  AboutWorkspaceTitle ="//div[@class='dashboard-layout__container__calling-top ng-scope']";

    public static String  btnAccountInfo ="//a[@translate='account_info']";

    public static String  btniconUser ="//span[contains(@class,'calling-icon-user')]";

    public static String  btnLogout = "//a[@translate='logout']";

    public static String  btnConfirmLogout = "//button[@translate='logout']/span[1]";

    public static String  getBtnLogoutWS = "//a[@translate='login_another_workspace']";

    public static String  AccountInfoTitle ="//h2[@translate='account_info']";

    public static String  lnkListMember ="//li[@class='uib-tab nav-item ng-scope ng-isolate-scope' and @index='1']";

    public static String  btnCaretAtMember ="//span[contains(text(),'"+ Constants.EMAIL +"')]/following-sibling::div/div";

    public static String  lnkInvalidAccount ="//li[@class='uib-tab nav-item ng-scope ng-isolate-scope' and @index='3']";

    public static String  btnDisableAccount ="//tr[not(contains(@class, 'ng-hide'))]//td//button[@translate='disable_account']";

    public static String  btnYesDisableAccount ="//div[(contains(@style, 'display: block;'))]//button[@class='btn btn-block confirm-button ng-binding btn-danger']";

    public static String  btnActiveAccount = "//span[text()='"+Constants.EMAIL+"']//parent::td/following-sibling::td//button[@translate='active_account']";

    public static String  btnYesActiveAccount ="//div[(contains(@style, 'display: block;'))]//button[@class='btn btn-block confirm-button ng-binding btn-danger']";

    public static String  txtEmail ="//span[contains(text(),'"+Constants.EMAIL+"')]";

}
