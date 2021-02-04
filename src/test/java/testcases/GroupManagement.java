package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.GroupManagementAction;
import actions.pageactions.SelectWorkSpaceAction;
import actions.pageactions.SignInAction;
import actions.pageactions.TopPageAction;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static actions.commons.ReportListener.*;

public class GroupManagement extends AbstractPages {
    public WebDriver driver;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public GroupManagementAction groupManagementAction;
    public String newGroupName = "group"+currentTime();
    public String newGroupNameWithOutUser = "NoUser"+currentTime();
    public String urlGroupManagerList ;
    public String urlGroupManagerCreate;
    public String userPermission;
    public TopPageAction topAction;
    public String email = Constants.EMAILMEMBER;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        topAction = PageGeneratorManager.getTopPageAction(driver);
        groupManagementAction = PageGeneratorManager.getGroupManagementAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Member Management screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");

    }
    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logReport = logReport.assignCategory("Pre-Select Workspace and login success");
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logMethod = createNodeForExtentReport(logReport, "Input user nam and password");
        logStep = logStepInfo(logMethod, "Input user nam and password");
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD,logStep);
    }

    @Test(priority = 1)
    public void DisableAccount() throws IOException {
        topAction.clickIconSetting ();
        topAction.clickGroupManagement ();
        urlGroupManagerList = getCurrentUrl(driver);
        logStep = logStepInfo (logMethod, "Disable account");
        groupManagementAction.disableAccount(logStep);
        logStep = logStepInfo(logMethod,"Verify'+ email +'is not display at List member tab");
        Assert.assertTrue(!groupManagementAction.isEmailDisplayAtListMember());
    }

    @Test(priority = 2)
    public void ActiveAccount() throws IOException {
        logStep = logStepInfo (logMethod, "Active account");
        groupManagementAction.activeAccount(logStep);
        logStep = logStepInfo(logMethod,"Verify'+ email+'is not display at Invalid account tab");
        Assert.assertTrue(!groupManagementAction.isEmailDisplayAtListMember());
    }

    @Test(priority = 3)
    public void L_10_TC_ID_1() throws IOException {
        logReport = logReport.assignCategory("L-10 : List Search Group management");
        logMethod = createNodeForExtentReport(logReport, "TC-ID-1 : Open 権限グループ (Group management)");
        logStep = logStepInfo(logMethod, "TC-ID-1 : Open 権限グループ (Group management)");
        openUrl(driver,urlGroupManagerList);
        logStep = logStepInfo(logMethod, "TC-ID-1 : Verify open 権限グループ (Group management)");
        Assert.assertTrue(groupManagementAction.isGroupManagementURL("member/management/?tab=2",logStep));
    }

    @Test(priority = 4)
    public void L_10_TC_ID_3() throws IOException {
        logReport = logReport.assignCategory("L-10 : click button【＋新規の権限グループを作成】");
        logMethod = createNodeForExtentReport(logReport, "TC-ID-3 : click button【＋新規の権限グループを作成】");
        logStep = logStepInfo(logMethod, "TC-ID-3 : click button【＋新規の権限グループを作成】");
        groupManagementAction.clickCreateGroupManagement(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Verify create 権限グループ (Group management)");
        urlGroupManagerCreate = getCurrentUrl(driver);
        Assert.assertTrue(groupManagementAction.isGroupManagementURL("group/create",logStep));
    }

    @Test(priority = 5)
    public void L_10_1_TC_ID_2() throws IOException {
        logReport = logReport.assignCategory("L-10_1 : Create Group management without name and setting");
        openUrl(driver,urlGroupManagerCreate);
        logMethod = createNodeForExtentReport(logReport, "TC_ID_2 : Create Group management without name");
        logStep = logStepInfo(logMethod, "TC-ID-2 : input name Group management");
        groupManagementAction.createGroupManagement("",logStep);
        logStep = logStepInfo(logMethod, "TC-ID-2 : Verify Button 登録する is disalbe");
        Assert.assertTrue(groupManagementAction.isButtonDisable("登録する",true));
    }

    @Test(priority = 6)
    public void L_10_1_TC_ID_3() throws IOException {
        logReport = logReport.assignCategory("L-10_1 : Create Group management without name group");
        openUrl(driver,urlGroupManagerCreate);
        logMethod = createNodeForExtentReport(logReport, "TC_ID_3 : Create Group management setting permission and without name");
        logStep = logStepInfo(logMethod, "TC-ID-3 : input name Group management");
        groupManagementAction.inputNameCreateGroupManagement("");
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission metting Group management");
        groupManagementAction.selectPermissionSetting("meeting",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission sale Group management");
        groupManagementAction.selectPermissionSetting("sale_light_chat",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission 一般権限グループにメンバーを招待 Group management");
        groupManagementAction.selectPermissionSetting("invite_user_to_default_group",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission 権限グループを選択してメンバーを招待 Group management");
        groupManagementAction.selectPermissionSetting("select_security_and_invite_user",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission アカウントの無効化 Group management");
        groupManagementAction.selectPermissionSetting("disabled_account",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission 権限グループ作成・編集 Group management");
        groupManagementAction.selectPermissionSetting("authority_group_create_edit",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission 新規ルームの作成・編集 Group management");
        groupManagementAction.selectPermissionSetting("create_edit_room",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission 利用実績の表示 Group management");
        groupManagementAction.selectPermissionSetting("display_statistic",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission 録画 Group management");
        groupManagementAction.selectPermissionSetting("record",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Setting Permission 全ユーザーのSales履歴の表示・編集 Group management");
        groupManagementAction.selectPermissionSetting("edit_sales_history",true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Select user for Group management");
        groupManagementAction.selectUserPermissionSetting(true);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Click on save");
        groupManagementAction.clickSaveGroupManagement();
        logStep = logStepInfo(logMethod, "TC-ID-3 : Verify Button 登録する is disalbe");
        Assert.assertTrue(groupManagementAction.isButtonDisable("登録する",true));
    }

    @Test(priority = 7)
    public void L_10_1_TC_ID_4() throws IOException {
        logReport = logReport.assignCategory("L-10_1 : Create Group management without select user");
        openUrl(driver,urlGroupManagerCreate);
        logMethod = createNodeForExtentReport(logReport, "TC_ID_4 : Create Group management setting permission and without name");
        logStep = logStepInfo(logMethod, "TC-ID-4 : input name Group management");
        groupManagementAction.inputNameCreateGroupManagement(newGroupNameWithOutUser);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Setting Permission meeting Group management");
        groupManagementAction.selectPermissionSetting("meeting",true);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Setting Permission sale Group management");
        groupManagementAction.selectPermissionSetting("sale_light_chat",true);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Setting Permission 一般権限グループにメンバーを招待 Group management");
        groupManagementAction.selectPermissionSetting("invite_user_to_default_group",true);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Setting Permission 権限グループを選択してメンバーを招待 Group management");
        groupManagementAction.selectPermissionSetting("select_security_and_invite_user",true);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Setting Permission アカウントの無効化 Group management");
        groupManagementAction.selectPermissionSetting("disabled_account",true);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Setting Permission 権限グループ作成・編集 Group management");
        groupManagementAction.selectPermissionSetting("authority_group_create_edit",true);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Setting Permission 新規ルームの作成・編集 Group management");
        groupManagementAction.selectPermissionSetting("create_edit_room",true);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Setting Permission 利用実績の表示 Group management");
        groupManagementAction.selectPermissionSetting("display_statistic",true);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Setting Permission 録画 Group management");
        groupManagementAction.selectPermissionSetting("record",true);
        logStep = logStepInfo(logMethod, "TC-ID-4: Setting Permission 全ユーザーのSales履歴の表示・編集 Group management");
        groupManagementAction.selectPermissionSetting("edit_sales_history",true);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Select user for Group management");
        groupManagementAction.selectUserPermissionSetting(false);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Click on save");
        groupManagementAction.clickSaveGroupManagement();
        logStep = logStepInfo(logMethod, "TC-ID-4 : Verify created 権限グループ (Group management)");
        groupManagementAction.searchGroupManagementWithEnter(newGroupNameWithOutUser,logStep);
        Assert.assertTrue(groupManagementAction.isResultSearchGroupManagementName(newGroupNameWithOutUser,true));
    }

    @Test(priority = 8)
    public void L_10_1_TC_ID_5() throws IOException {
        logReport = logReport.assignCategory("L-10_1 : Create Group management with name group and select user");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_5 : Created Group management");
        openUrl(driver,urlGroupManagerCreate);
        logStep = logStepInfo(logMethod, "TC-ID-5 : input name Group management");
        groupManagementAction.inputNameCreateGroupManagement(newGroupName);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Setting Permission meeting Group management");
        groupManagementAction.selectPermissionSetting("meeting",true);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Setting Permission sale Group management");
        groupManagementAction.selectPermissionSetting("sale_light_chat",true);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Setting Permission 一般権限グループにメンバーを招待 Group management");
        groupManagementAction.selectPermissionSetting("invite_user_to_default_group",true);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Setting Permission 権限グループを選択してメンバーを招待 Group management");
        groupManagementAction.selectPermissionSetting("select_security_and_invite_user",true);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Setting Permission アカウントの無効化 Group management");
        groupManagementAction.selectPermissionSetting("disabled_account",true);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Setting Permission 権限グループ作成・編集 Group management");
        groupManagementAction.selectPermissionSetting("authority_group_create_edit",true);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Setting Permission 新規ルームの作成・編集 Group management");
        groupManagementAction.selectPermissionSetting("create_edit_room",true);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Setting Permission 利用実績の表示 Group management");
        groupManagementAction.selectPermissionSetting("display_statistic",true);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Setting Permission 録画 Group management");
        groupManagementAction.selectPermissionSetting("record",true);
        logStep = logStepInfo(logMethod, "TC-ID-5: Setting Permission 全ユーザーのSales履歴の表示・編集 Group management");
        groupManagementAction.selectPermissionSetting("edit_sales_history",true);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Select user for Group management");
        groupManagementAction.selectUserPermissionSetting(true);
        userPermission = groupManagementAction.getUserPermissionSetting();
        logStep = logStepInfo(logMethod, "TC-ID-5 : Click on save");
        groupManagementAction.clickSaveGroupManagement();
        logStep = logStepInfo(logMethod, "TC-ID-5 : Verify created 権限グループ (Group management)");
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        Assert.assertTrue(groupManagementAction.isResultSearchGroupManagementName(newGroupName,true));
    }

    @Test(priority = 9)
    public void L_10_1_TC_ID_6() throws IOException {
        logReport = logReport.assignCategory("L-10_1 : Cancel Group management");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_6 : Cancel Group management");
        openUrl(driver,urlGroupManagerCreate);
        logStep = logStepInfo(logMethod, "TC-ID-6 : click Cancel Group management");
        groupManagementAction.clickCancelCreateGroupManagement(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-6 : Verify open 権限グループ (Group management)");
        Assert.assertTrue(groupManagementAction.isGroupManagementURL("member/management/?tab=2",logStep));
    }

    @Test(priority = 10)
    public void L_10_TC_ID_2() throws IOException {
        logReport = logReport.assignCategory("L-10 :Search Group management");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_2 : Search 権限グループ (Group management)");
        openUrl(driver,urlGroupManagerList);
        logStep = logStepInfo(logMethod, "TC_ID_2 : Search 権限グループ (Group management)");
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        logStep = logStepInfo(logMethod, "TC_ID_2 : Verify result search 権限グループ (Group management)");
        Assert.assertTrue(groupManagementAction.isResultSearchGroupManagementNameFirst(newGroupName,true));
    }

    @Test(priority = 11)
    public void L_10_TC_ID_4() throws IOException {
        logReport = logReport.assignCategory("L-10 : click Sub menu");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_4 : Show sub menu");
        openUrl(driver,urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        logStep = logStepInfo(logMethod, "TC-ID-4 : click icon sub menu");
        groupManagementAction.clickIconSubMenu(newGroupName,logStep);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Verify sub menu show");
        Assert.assertTrue(groupManagementAction.isSubMenu());
    }

    @Test(priority = 12)
    public void L_10_TC_ID_5() throws IOException {
        logReport = logReport.assignCategory("L-10 : click 権限を編集する/Edit quyền hạn");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_5 : 権限を編集する/Edit quyền hạn");
        logStep = logStepInfo(logMethod, "Pre-conditon : click icon sub menu");
        openUrl(driver,urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        groupManagementAction.clickIconSubMenu(newGroupName,logStep);
        logStep = logStepInfo(logMethod, "TC-ID-5 : click 権限を編集する/Edit quyền hạn button");
        groupManagementAction.clickEditPermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-5 : Verify group management show");
        Assert.assertEquals(groupManagementAction.getTextGroupManagement(),newGroupName);
    }

    @Test(priority = 13)
    public void L_10_3_TC_ID_2() throws IOException {
        logReport = logReport.assignCategory("L-10_3 : click 権限を編集する/Edit quyền hạn and verify setting");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_2 : Giữ nguyên trạng thái");
        logStep = logStepInfo(logMethod, "Pre-conditon : click icon sub menu");
        openUrl(driver,urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        groupManagementAction.clickIconSubMenu(newGroupName,logStep);
        logStep = logStepInfo(logMethod, "TC-ID-2 : click 権限を編集する/Edit quyền hạn button");
        groupManagementAction.clickEditPermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-2 : Verify group management show");
        Assert.assertEquals(groupManagementAction.getTextGroupManagement(),newGroupName);
        logStep = logStepInfo(logMethod, "TC-ID-2 : Verify Setting Permission meeting Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("meeting",true));
        logStep = logStepInfo(logMethod, "TC-ID-2 : Verify Setting Permission sale Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("sale_light_chat",true));
        logStep = logStepInfo(logMethod, "TC-ID-2 :Verify Setting Permission 一般権限グループにメンバーを招待 Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("invite_user_to_default_group",true));
        logStep = logStepInfo(logMethod, "TC-ID-2 :Verify Setting Permission 権限グループを選択してメンバーを招待 Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("select_security_and_invite_user",true));
        logStep = logStepInfo(logMethod, "TC-ID-2 :Verify Setting Permission アカウントの無効化 Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("disabled_account",true));
        logStep = logStepInfo(logMethod, "TC-ID-2 :Verify Setting Permission 権限グループ作成・編集 Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("authority_group_create_edit",true));
        logStep = logStepInfo(logMethod, "TC-ID-2 :Verify Setting Permission 新規ルームの作成・編集 Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("create_edit_room",true));
        logStep = logStepInfo(logMethod, "TC-ID-2 :Verify Setting Permission 利用実績の表示 Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("display_statistic",true));
        logStep = logStepInfo(logMethod, "TC-ID-2 :Verify Setting Permission 録画 Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("record",true));
        logStep = logStepInfo(logMethod, "TC-ID-2:Verify Setting Permission 全ユーザーのSales履歴の表示・編集 Group management");
        Assert.assertTrue(groupManagementAction.isSettingPermission("edit_sales_history",true));
        logStep = logStepInfo(logMethod, "TC-ID-2:Verify User Checked");
        Assert.assertTrue(groupManagementAction.isUserChecked(true));
    }

    @Test(priority = 14)
    public void L_10_3_TC_ID_3() throws IOException {
        logReport = logReport.assignCategory("L-10_3 : click 権限を編集する/Edit quyền hạn and remove name group");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_3 : Giữ nguyên trạng thái");
        logStep = logStepInfo(logMethod, "Pre-conditon : click icon sub menu");
        openUrl(driver, urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        groupManagementAction.clickIconSubMenu(newGroupName, logStep);
        logStep = logStepInfo(logMethod, "TC-ID-3 : click 権限を編集する/Edit quyền hạn button");
        groupManagementAction.clickEditPermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Remove name group");
        groupManagementAction.clearNameCreateGroupManagement();
        groupManagementAction.clickSaveGroupManagement();
        logStep = logStepInfo(logMethod, "TC-ID-3 : Verify error message 権限グループ (Group management)");
        Assert.assertTrue(groupManagementAction.doesErrorMessageCreateGroupManagement("必須",true));
    }

    @Test(priority = 15)
    public void L_10_3_TC_ID_4() throws IOException {
        logReport = logReport.assignCategory("L-10_4 : click cancel trong 権限を編集する/Edit quyền hạn");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_4 : Cancel Edit quyền hạn");
        logStep = logStepInfo(logMethod, "Pre-conditon : click icon sub menu");
        openUrl(driver, urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        groupManagementAction.clickIconSubMenu(newGroupName, logStep);
        logStep = logStepInfo(logMethod, "TC-ID-4 : click 権限を編集する/Edit quyền hạn button");
        groupManagementAction.clickEditPermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Cancel Edit quyền hạn");
        groupManagementAction.clickCancelCreateGroupManagement(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Verify open 権限グループ (Group management)");
        Assert.assertTrue(groupManagementAction.isGroupManagementURL("member/management/?tab=2",logStep));
    }

    @Test(priority = 16)
    public void L_10_3_TC_ID_5() throws IOException {
        logReport = logReport.assignCategory("L-10_3 : click lưu trong 権限を編集する/Edit quyền hạn");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_5 : lưu Edit quyền hạn");
        logStep = logStepInfo(logMethod, "Pre-conditon : click icon sub menu");
        openUrl(driver, urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        groupManagementAction.clickIconSubMenu(newGroupName, logStep);
        logStep = logStepInfo(logMethod, "TC-ID-5 : click 権限を編集する/Edit quyền hạn button");
        groupManagementAction.clickEditPermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-5 : click lưu Edit quyền hạn");
        groupManagementAction.clickSaveGroupManagement();
        logStep = logStepInfo(logMethod, "TC-ID-5 : Verify open 権限グループ (Group management)");
        Assert.assertTrue(groupManagementAction.isGroupManagementURL("member/management/?tab=2",logStep));
    }

    @Test(priority = 17)
    public void L_10_TC_ID_6() throws IOException {
        logReport = logReport.assignCategory("L-10 : click 【権限を削除する/delete quyền hạn】");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_6 : 【権限を削除する/delete quyền hạn】");
        logStep = logStepInfo(logMethod, "Pre-conditon : click icon sub menu");
        openUrl(driver,urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        groupManagementAction.clickIconSubMenu(newGroupName,logStep);
        logStep = logStepInfo(logMethod, "TC-ID-6 : Click【権限を削除する/delete quyền hạn】 button");
        groupManagementAction.clickDeletePermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-6 : Verify group management show");
        Assert.assertTrue(groupManagementAction.isDeleteGroupManagementPopup(true));
    }

    @Test(priority = 18)
    public void L_10_5_TC_ID_2() throws IOException {
        logReport = logReport.assignCategory("L_10_5 : click dấu × ở phía trên bên phải của màn hình modal");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_2 : click dấu × ở phía trên bên phải của màn hình modal");
        logStep = logStepInfo(logMethod, "Pre-conditon : Click【権限を削除する/delete quyền hạn】 button");
        openUrl(driver,urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        groupManagementAction.clickIconSubMenu(newGroupName,logStep);
        groupManagementAction.clickDeletePermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-2 : click dấu × ở phía trên bên phải của màn hình modal");
        groupManagementAction.clickXButtonDeletePopup(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-2 : Verify delete group management popup close");
        Assert.assertFalse(groupManagementAction.isDeleteGroupManagementPopup(false));
    }

    @Test(priority = 19)
    public void L_10_5_TC_ID_3() throws IOException {
        logReport = logReport.assignCategory("L_10_5 : Click button【キャンセル/cancle】");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_3 : Click button【キャンセル/cancle】");
        logStep = logStepInfo(logMethod, "Pre-conditon : Click【権限を削除する/delete quyền hạn】 button");
        openUrl(driver,urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        groupManagementAction.clickIconSubMenu(newGroupName,logStep);
        groupManagementAction.clickDeletePermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Click button【キャンセル/cancle】");
        groupManagementAction.clickCancelButtonDeletePopup(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Verify delete group management popup close");
        Assert.assertFalse(groupManagementAction.isDeleteGroupManagementPopup(false));
    }

    @Test(priority = 20)
    public void L_10_5_TC_ID_4() throws IOException {
        logReport = logReport.assignCategory("L_10_5 : Click【権限グループを削除する/delete Group quyền hạn】");
        logMethod = createNodeForExtentReport(logReport, "TC_ID_4 : Click【権限グループを削除する/delete Group quyền hạn】");
        logStep = logStepInfo(logMethod, "Pre-condition : Click【権限を削除する/delete quyền hạn】 button");
        openUrl(driver,urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupName,logStep);
        groupManagementAction.clickIconSubMenu(newGroupName,logStep);
        groupManagementAction.clickDeletePermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Click【権限グループを削除する/delete Group quyền hạn】");
        groupManagementAction.clickDeleteButtonDeletePopup(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-3 : Verify delete group management success");
        Assert.assertFalse(groupManagementAction.isResultSearchGroupManagementName(newGroupName,false));
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Delete all group created");
        logStep = logStepInfo(logMethod, "Pre-condition :Delete all group created");
        openUrl(driver,urlGroupManagerList);
        groupManagementAction.searchGroupManagementWithEnter(newGroupNameWithOutUser,logStep);
        groupManagementAction.clickIconSubMenu(newGroupNameWithOutUser,logStep);
        groupManagementAction.clickDeletePermission(logStep);
        logStep = logStepInfo(logMethod, "TC-ID-4 : Click【権限グループを削除する/delete Group quyền hạn】");
        groupManagementAction.clickDeleteButtonDeletePopup(logStep);
        closeBrowser(driver);
    }
}
