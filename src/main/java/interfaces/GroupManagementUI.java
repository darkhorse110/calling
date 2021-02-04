package interfaces;

import actions.commons.Constants;

public class GroupManagementUI {
    //Top
    public static String lblIconSetting= "//span[contains(@class,'calling-icon-setting')]";
    public static String bntGroupManagementMenu ="//a[@translate='group_management_member_rights']";
    public static String lblLoadingPage ="//div[@class='page-spinner-bar']";
    public static String lblLoadingPageHide ="//div[@class='page-spinner-bar hide']";

    //Search
    public static String txtSearchName = "//input[@name='name']";
    public static String bntSearch = "//form[starts-with(@class,'group-management__search')]//span[contains(@class,'calling-icon-search')]";
    public static String lblGroupManagementName = "//table[@class='groups']//span[text()='%s']";
    public static String lblGroupManagementNameFirst = "//table[@class='groups']//tr[1]//span[text()='%s']";
    public static String bntSearchCreateGroupManagement = "//button[@translate='create_authority_group']";
    public static String bntIconSubMenu = "//td[contains(@class,'groups__name') and contains(.,'%s')]/..//div[@class='caret']";
    public static String lblHeaderSubMenu = "//div[@class='group-permission']";
    public static String bntEditPermission = "//button[@translate='edit_permission']";
    public static String bntDeletePermission = "//button[@translate='delete_permission']";

    //create
    public static String txtCreateNameGroup = "//input[@name='name']";
    public static String bntSaveGroupManagement = "//button[@translate='register_full_text' or @translate='save']";
    public static String lblErrorMessageCreateGroupManagement = "//span[@translate='security_group_name_blank' and contains(text(),'%s')]";
    public static String bntSettingPermission = "//span[@translate='%s']";
    public static String chbUser = "(//div[@class='checkbox__cell'])[1]";
    public static String bntCancel = "//button[@translate='cancel']";
    public static String bntDisable = "//button[@disabled='disabled']/span[text()='%s']";

    //edit
    public static String txtEditNameGroup = "//input[@ng-model='UpdateGroupCtrl.input.name']";
    public static String lblSettingPermissionOn ="//input[contains(@class,'not-empty')]/..//span[@translate='%s']";
    public static String lblSettingPermissionOff ="//input[contains(@class,'ng-empty')]/..//span[@translate='%s']";
    public static String chbUserChecked = "//input[contains(@class,'not-empty')]/../..//span[@ng-bind='item.getName()'][1]";
    public static String chbUserUnChecked = "//input[contains(@class,'ng-empty')]/../..//span[@ng-bind='item.getName()'][1]";

    //delete
    public static String modalDeleteGroupManagement ="//h2[@translate='delete_group']";
    public static String bntXDeleteGroupManagement = "//span[@class='modal-modify__close-button']";
    public static String bntCancelDeleteGroupManagement = "//button[@translate='cancel']";
    public static String bntDeleteGroupManagement = "//button[@translate='delete_group']";

    //disable and active account

    public static String  lnkListMember ="//li[@class='uib-tab nav-item ng-scope ng-isolate-scope' and @index='1']";
    public static String  btnCaretAtMember ="//span[contains(text(),'"+ Constants.EMAILMEMBER +"')]/following-sibling::div/div";
    public static String  lnkInvalidAccount ="//li[@class='uib-tab nav-item ng-scope ng-isolate-scope' and @index='3']";
    public static String  btnDisableAccount ="//tr[not(contains(@class, 'ng-hide'))]//td//button[@translate='disable_account']";
    public static String  btnYesDisableAccount ="//div[(contains(@style, 'display: block;'))]//button[@class='btn btn-block confirm-button ng-binding btn-danger']";
    public static String  btnActiveAccount = "//span[text()='"+Constants.EMAILMEMBER+"']//parent::td/following-sibling::td//button[@translate='active_account']";
    public static String  btnYesActiveAccount ="//div[(contains(@style, 'display: block;'))]//button[@class='btn btn-block confirm-button ng-binding btn-danger']";
    public static String  txtEmail ="//span[contains(text(),'"+Constants.EMAILMEMBER+"')]";
}
