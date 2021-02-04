package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.SelectWorkSpaceAction;
import actions.pageactions.SignInAction;
import actions.pageactions.TopPageAction;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

import static actions.commons.ReadExcelFile.testData;
import static actions.commons.ReportListener.*;

public class TopPage extends AbstractPages {
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public TopPageAction topAction;
    private WebDriver driver;
    public String urlHomePage = null;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        topAction = PageGeneratorManager.getTopPageAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Sign In screen");
        logClass = createNodeForExtentReport(logClass, "Initial Setup successful");
    }

    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logReport = logReport.assignCategory("Pre-Select Workspace and login success");
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
    }

    @Test(priority = 1)
    public void L_2_TC_ID_2() throws IOException {
        logReport = logReport.assignCategory("L_2 : Login Admin");
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-2");
        logStep = logStepInfo(logMethod, "Input user name and password");
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD, logStep);
        logStep = logStepInfo(logMethod, "Click Meeting Button");
        urlHomePage = getCurrentUrl(driver);
        topAction.clickMeetingButton();
        Assert.assertTrue(topAction.isMeeting("Meeting"));
    }

    @Test(priority = 2)
    public void L_2_TC_ID_3() throws IOException {
        logReport = logReport.assignCategory("L2-TC-ID-3 : Login Admin Click ChatBot Button");
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-3");
        logStep = logStepInfo(logMethod, "Click ChatBot Button");
        topAction.clickChatbotButton();
        Assert.assertTrue(topAction.isChatBot("ChatBot"));
    }

    @Test(priority = 3)
    public void L_2_TC_ID_4() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-4");
        openUrl(driver,urlHomePage);
        logStep = logStepInfo(logMethod, "Click Chat Button");
        topAction.clickChatButton();
        Assert.assertTrue(topAction.isChat("Chat"));
    }

    @Test(priority = 4)
    public void L_2_TC_ID_5() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-5");
        logStep = logStepInfo(logMethod, "Click Logo Calling");
        topAction.clickHomeButton();
        logStep = logStepInfo(logMethod, "Verify Back to Home page");
        topAction.verifyRedirectToHomePageSuccess(Constants.WORKSPACE_ID,logStep);
    }

    @Test(priority = 5)
    public void L_2_TC_ID_6() {
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-6");
        topAction.clickBellButton();
        Assert.assertTrue(topAction.isBell(""));
    }

    @Test(priority = 6)
    public void L_2_TC_ID_7() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-7");
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "Click setting Button");
        logStep = logStepInfo(logMethod, "Setting Admin Role");
        topAction.clickIconSetting();
        Assert.assertTrue(topAction.isWorkspaceManagement("ワークスペースの管理"));
        logStep = logStepInfo(logMethod, "Workspace Management");
        Assert.assertTrue(topAction.isManageMember("メンバーの管理"));
        logStep = logStepInfo(logMethod, "Manage Member");
        Assert.assertTrue(topAction.isInviteMember("メンバーを招待"));
        logStep = logStepInfo(logMethod, "Invite Member");
        Assert.assertTrue(topAction.isGroupManage("グループの管理（メンバーの権限）"));
        logStep = logStepInfo(logMethod, "Group Manage");
        Assert.assertEquals(topAction.getTextLanguage(), "English");
        logStep = logStepInfo(logMethod, "English");
    }

    @Test(priority = 7)
    public void L_2_TC_ID_12() throws IOException {
        /* Click All Tabs Setting With Admin Role*/
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-12");
        topAction.clickIconSetting();
        topAction.clickWorkspaceManagement();
        Assert.assertTrue(topAction.isWorkSpaceScreen("ワークスペースの管理"));
        logStep = logStepInfo(logMethod, "Click on Workspace Management");

    }

    @Test(priority = 8)
    public void L_2_TC_ID_13() throws IOException {
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-13");
        topAction.clickIconSetting();
        topAction.clickManageMember();
        Assert.assertTrue(topAction.isManageMemberScreen("メンバー管理"));
        logStep = logStepInfo(logMethod, "Click on Manage Member");

    }

    @Test(priority = 9)
    public void L_2_TC_ID_14() throws IOException {
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-14");
        logStep = logStepInfo(logMethod, "Click on Invite Member");
        topAction.clickIconSetting();
        topAction.clickInviteMember();
        Assert.assertTrue(topAction.isInviteMemberScreen("ワークスペース'" + Constants.WORKSPACE_ID + "'にメンバーを招待"));

    }

    @Test(priority = 10)
    public void L_2_TC_ID_17() throws IOException {
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-17");
        logStep = logStepInfo(logMethod, "Click on Group Management");
        topAction.clickIconSetting();
        topAction.clickGroupManagement();
        Assert.assertTrue(topAction.isGroupManagementScreen("メンバー管理"));

    }

    @Test(priority = 11)
    public void L_2_TC_ID_18() throws IOException {
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-18");
        logStep = logStepInfo(logMethod, "Click on English");
        topAction.clickIconSetting();
        topAction.clickLanguage();
        Assert.assertEquals(topAction.getTextLanguage(), "日本語");
    }

    @Test(priority = 12)
    public void L_2_TC_ID_23() throws IOException {
        topAction.clickIconSetting();
        topAction.clickLanguage();
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-23");
        logStep = logStepInfo(logMethod, "Click on User Info");
        topAction.clickIconUser();
    }

    @Test(priority = 13)
    public void L_2_TC_ID_24() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-24");
        logStep = logStepInfo(logMethod, "Click on User Info");
        topAction.clickAccountInfoButton();
        Assert.assertTrue(topAction.isAccountInfo("アカウント情報"));
    }

    @Test(priority = 14)
    public void L_2_TC_ID_26() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-26");
        logStep = logStepInfo(logMethod, "Sign Out");
        topAction.Logout(logReport);
    }

    @Test(priority = 15)
    public void L_2_TC_ID_8() throws IOException {
        logReport = logReport.assignCategory("L_2 : Login General Common");
        refreshPage(driver);
        signInAction.inputLogin(Constants.EMAIL_GENERALCOMMON, Constants.PASSWORD_GENERALCOMMON, logStep);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-8");
        logStep = logStepInfo(logMethod, "Setting Normal User Role");
        topAction.clickIconSetting();
        Assert.assertTrue(topAction.isAboutWorkSpace("ワークスペースについて"));
        Assert.assertEquals(topAction.getTextLanguage(), "English");
    }

    @Test(priority = 16)
    public void L_2_TC_ID_19() throws IOException {

        /* Click Setting With Common user Role*/

        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-19");

        logStep = logStepInfo(logMethod, "Setting Normal User Role");

        topAction.clickIconSetting();

        logStep = logStepInfo(logMethod, "Click About WorkSpace");

        topAction.clickAboutWorkSpace();

        Assert.assertTrue(topAction.isAboutWorkSpaceTitle("ワークスペースについて"));
    }

    @Test(priority = 17)
    public void L_2_TC_ID_9() throws IOException {
        logReport = logReport.assignCategory("L_2 : Manager member common");
        topAction.Logout(logReport);
        refreshPage(driver);
        signInAction.inputLogin(Constants.EMAIL_MANAGERMEMBERCOMMON, Constants.PASSWORD_MANAGERMEMBERCOMMON, logStep);


        /* Verify Setting With Common user Role*/

        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-9");

        logStep = logStepInfo(logMethod, "Setting Manager member common user Role");

        topAction.clickIconSetting();

        Assert.assertTrue(topAction.isAboutWorkSpace("ワークスペースについて"));

        Assert.assertTrue(topAction.isManageMember("メンバーの管理"));

        Assert.assertTrue(topAction.isInviteMember("メンバーを招待"));

        Assert.assertEquals(topAction.getTextLanguage(), "English");
    }

    @Test(priority = 18)
    public void L_2_TC_ID_10() throws IOException {
        logReport = logReport.assignCategory("L_2 : Group Manager common");
        topAction.Logout(logReport);
        refreshPage(driver);
        signInAction.inputLogin(Constants.EMAIL_GROUPMANAGERCOMMON, Constants.PASSWORD_GROUPMANAGERCOMMON, logStep);
        /* Verify Setting With Common user Role*/

        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-10");
        logStep = logStepInfo(logMethod, "Setting Manager Group common user Role");
        topAction.clickIconSetting();
        Assert.assertTrue(topAction.isAboutWorkSpace("ワークスペースについて"));
        Assert.assertTrue(topAction.isGroupManage("グループの管理（メンバーの権限）"));
        Assert.assertEquals(topAction.getTextLanguage(), "English");
    }

    @Test(priority = 19)
    public void L_2_TC_ID_11() throws IOException {
        logReport = logReport.assignCategory("L_2 : Full Permission common");
        topAction.Logout(logReport);
        refreshPage(driver);
        signInAction.inputLogin(Constants.EMAIL_FULLPERMISSION, Constants.PASSWORD_FULLPERMISSION, logStep);
        /* Verify Setting With Common user Role*/

        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-11");
        logStep = logStepInfo(logMethod, "Setting Full Permission user Role");
        topAction.clickIconSetting();
        Assert.assertTrue(topAction.isAboutWorkSpace("ワークスペースについて"));
        Assert.assertTrue(topAction.isManageMember("メンバーの管理"));
        Assert.assertTrue(topAction.isInviteMember("メンバーを招待"));
        Assert.assertTrue(topAction.isGroupManage("グループの管理（メンバーの権限）"));
        Assert.assertEquals(topAction.getTextLanguage(), "English");
    }

    @Test(priority = 20)
    public void L_2_TC_ID_20() throws IOException {
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-20");
        logStep = logStepInfo(logMethod, "Click Setting");
        topAction.clickIconSetting();
        logStep = logStepInfo(logMethod, "Click Invite Member");
        topAction.clickInviteMember();
        Assert.assertTrue(topAction.isInviteMemberScreen("ワークスペース'" + Constants.WORKSPACE_ID + "'にメンバーを招待"));
    }

    @Test(priority = 21)
    public void L_2_TC_ID_21() throws IOException {
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-21");
        logStep = logStepInfo(logMethod, "Click Setting");
        topAction.clickIconSetting();
        logStep = logStepInfo(logMethod, "Click Manager Group");
        topAction.clickGroupManagement();
        Assert.assertTrue(topAction.isGroupManagementScreen("メンバー管理"));
    }

    @Test(priority = 22)
    public void L_2_TC_ID_22() throws IOException {
        openUrl(driver,urlHomePage);
        logMethod = createNodeForExtentReport(logReport, "L2-TC-ID-22");
        logStep = logStepInfo(logMethod, "Click Setting");
        topAction.clickIconSetting();
        logStep = logStepInfo(logMethod, "Click Invite Member");
        topAction.clickInviteMember();
        Assert.assertTrue(topAction.isInviteMemberScreen("ワークスペース'" + Constants.WORKSPACE_ID + "'にメンバーを招待"));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }
}
