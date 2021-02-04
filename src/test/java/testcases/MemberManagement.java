package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static actions.commons.ReportListener.*;
import static actions.commons.ReportListener.logClass;

public class MemberManagement extends AbstractPages {
    public WebDriver driver;
    public MemberManagementAction memberManagementAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public TopPageAction topPageAction;
    public InviteMemberAction inviteMemberAction;
    public TransferAdminAction transferAdminAction;
    public AboutAction aboutAction;
    public String urlTransferAdmin = null;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        topPageAction = PageGeneratorManager.getTopPageAction(driver);
        memberManagementAction = PageGeneratorManager.getMemberManagementAction(driver);
        inviteMemberAction  = PageGeneratorManager.getInviteMemberAction(driver);
        transferAdminAction = PageGeneratorManager.getTransferAdminAction(driver);
        aboutAction = PageGeneratorManager.getAboutAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Member Management screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }

    /*

    Test case here

     */
    @Test(priority = 0)
    public void GoToHomePage() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Go to home page");
        logStep = logStepInfo(logMethod, "Input workspace ID and login");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD, logStep);
    }
    @Test(priority = 1)
    public void TC_ID_0_GoToMemberManagementScreen() throws IOException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Go to Member management screen");
        logStep = logStepInfo(logMethod, "Click setting button");
        topPageAction.clickIconSetting();
        logStep = logStepInfo(logMethod, "Click menu Member management");
        topPageAction.clickManageMember();
    }

    @Test(priority = 2)
    public void TC_ID_1_ValidateAllElementInPage() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Validate All Element in Page");
        logStep = logStepInfo(logMethod, "Validate page title is shown");
        memberManagementAction.isPageTitleShown();
        logStep = logStepInfo(logMethod, "Validate Tab list member display");
        memberManagementAction.isTabListMemberShown();
        logStep = logStepInfo(logMethod, "Validate invite button display");
        memberManagementAction.isInviteButtonShown();
        logStep = logStepInfo(logMethod, "Validate Tab authority group display");
        memberManagementAction.isTabAuthorityGroup();
        logStep = logStepInfo(logMethod, "Validate Tab invalid account display");
        memberManagementAction.isNumberOfInvalidAccountCorrect();
        logStep = logStepInfo(logMethod, "Validate Tab invited member display");
        memberManagementAction.isNumberOfInvitedMemberCorrect();
    }
    @Test(priority = 3)
    public void TC_ID_2_ClickInviteButtonAndCheckDirectLinkOK() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check invite button and check link direct OK");
        logStep = logStepInfo(logMethod, "Click tab List member");
        memberManagementAction.clickTabListMember();
        logStep = logStepInfo(logMethod, "Click Invite button");
        memberManagementAction.clickInviteButton();
        logStep = logStepInfo(logMethod, "Validate if Invite page load OK");
        inviteMemberAction.isSendInviteButtonShown();
        inviteMemberAction.clickInvitedMemberLink();
    }
    @Test(priority = 4)
    public void TC_ID_3_ClickTabAuthorityGroupAndCheckLinkOK() throws IOException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Click Tab Authority group and check show ok");
        logStep = logStepInfo(logMethod, "Click tab Authority group");
        memberManagementAction.clickTabAuthorityGroup();
        logStep = logStepInfo(logMethod,"Validate button create authorization group display");
        memberManagementAction.isButtonCreateAuthorizationGroupShown();
    }

    @Test(priority = 5)
    public void TC_ID_4_CheckNumberOfInvalidAccount() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check number of Invalid account is shown correct");
        logStep = logStepInfo(logMethod, "Click tab invalid account ");
        memberManagementAction.clickTabInvalidAccount();
        logStep = logStepInfo(logMethod,"Validate the number of invalid account is correct");
        memberManagementAction.isNumberOfInvalidAccountCorrect();
    }

    @Test(priority = 6)
    public void TC_ID_5_CheckNumberOfInvitedMember() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check number of Invited member display correct");
        logStep = logStepInfo(logMethod, "Click tab invited member ");
        memberManagementAction.clickTabInvitedMember();
        logStep = logStepInfo(logMethod,"Validate the number of invited member is correct");
        memberManagementAction.isNumberOfInvitedMemberCorrect();
    }

    @Test(priority = 7)
    public void TC_ID_10_CheckSearchFunctionWorkNormaly() throws IOException, AWTException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "CHeck search function work normally at tab list member");
        logStep = logStepInfo(logMethod, "Click tab list member ");
        memberManagementAction.clickTabListMember();
        logStep = logStepInfo(logMethod, "Input value Hoang5555 for searching correctly");
        memberManagementAction.isSearchMemberResultCorrect("Hoang5555");
    }

    @Test(priority = 8)
    public void TC_ID_11_VerifyNameSearchResult() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Verify Name Search Result");
        logStep = logStepInfo(logMethod, "Validate Name of search result is shown");
        Assert.assertTrue(memberManagementAction.isNameSearchResult("Hoang5555",true));
    }

    @Test(priority = 9)
    public void TC_ID_12_VerifyGroupSearchResult() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Verify Group Search Result");
        logStep = logStepInfo(logMethod, "Validate Group of search result is shown");
        Assert.assertTrue(memberManagementAction.isGroupActiveSearchResult("マーケティング利用のみ(No remove)",true));
    }

    @Test(priority = 10)
    public void TC_ID_15_CheckButtonChangeAuthorityGroupIsAvailable() throws IOException, AWTException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check button change authority group display");
        logStep = logStepInfo(logMethod, "Check button Change Authority group display ");
        memberManagementAction.isButtonChangeAuthorityGroupDisplay();
    }

    @Test(priority = 11)
    public void TC_ID_16_CheckPopupChangeAuthorityGroupIsShown() throws IOException, AWTException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check Popup change authority group display");
        logStep = logStepInfo(logMethod, "Check popup change authority group display ");
        memberManagementAction.isPopupChangeAuthorityGroupDisplay();
    }

    @Test(priority = 12)
    public void TC_ID_17_ChangeAuthorityGroupWorkOK() throws IOException, AWTException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check change authority group for user OK");
        logStep = logStepInfo(logMethod, "Select authority group");
        memberManagementAction.changeAuthority("マーケティング利用のみ(No remove)");
        logStep = logStepInfo(logMethod, "Click submit button");
        memberManagementAction.clickSubmitChangeAuthorityGroup();
        logStep = logStepInfo(logMethod, "Validate change Authority group success");
        memberManagementAction.isMsgChangeAuthorityGroupSuccessShown();
    }

    @Test(priority = 13)
    public void TC_ID_18_CheckButtonDisableMemberIsAvailable() throws IOException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check button disable member display");
        logStep = logStepInfo(logMethod, "Check button Disable Member is available ");
        memberManagementAction.isButtonDisableMemberDisplay();
    }

    @Test(priority = 14)
    public void TC_ID_18_CheckDeActiveAndActiveMember() throws IOException, InterruptedException, AWTException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check deactive and active member success");
        logStep = logStepInfo(logMethod, "Check popup disable member is shown");
        memberManagementAction.isPopupDisableAccountDisplay();
        logStep = logStepInfo(logMethod, "Confirm disable account");
        memberManagementAction.submitDisableAccount();
        logStep = logStepInfo(logMethod, "Validate message deactive member success");
        memberManagementAction.isMsgDeActiveAccountDisplay();
        logStep = logStepInfo(logMethod, "Check account is display in tab invalid account");
        memberManagementAction.clickTabInvalidAccount();
        logStep = logStepInfo(logMethod, "Input value Hoang5555 for searching");
        memberManagementAction.isSearchDeActiveAccountResultCorrect("Hoang5555");
        logStep = logStepInfo(logMethod, "Click Active account button");
        memberManagementAction.activeAccount();
        logStep = logStepInfo(logMethod, "Submit Active account button");
        memberManagementAction.submitActiveAccount();
        logStep = logStepInfo(logMethod, "Check message active account display");
        memberManagementAction.isMsgActiveAccountDisplay();
    }

    @Test(priority = 15)
    public void TC_ID_19_CheckButtonTransferAdministratorIsDisplay() throws IOException, AWTException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check button transfer administrator display");
        logStep = logStepInfo(logMethod, "Click tab list member ");
        memberManagementAction.clickTabListMember();
        logStep = logStepInfo(logMethod, "Input value Team auto for searching");
        memberManagementAction.isSearchMemberResultCorrect("Team Auto");
        logStep = logStepInfo(logMethod, "Check button transfer administrator display");
        memberManagementAction.isButtonTransferAdministratorDisplay();
    }
    @Test(priority = 16)
    public void TC_ID_20_ClickTabInvitedMember() throws IOException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Click Tab Invited Member");
        logStep = logStepInfo(logMethod, "Click tab Invited Member");
        memberManagementAction.clickTabInvitedMember();
        logStep = logStepInfo(logMethod, "Validate Tab invited member display");
        memberManagementAction.isNumberOfInvitedMemberCorrect();
    }

    @Test(priority = 17)
    public void TC_ID_01_CheckTransferAdminPageLoadSuccess() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen");
        logMethod = createNodeForExtentReport(logReport, "Check transfer administrator page is load success");
        logStep = logStepInfo(logMethod, "Click tab List member ");
        memberManagementAction.clickTabListMember();
        logStep = logStepInfo(logMethod, "Click transfer administrator button ");
        memberManagementAction.clickButtonTransferAdmin();
        urlTransferAdmin = getCurrentUrl(driver);
        logStep = logStepInfo(logMethod, "Validate the transfer administrator title display");
        transferAdminAction.isTransferAdminTitleDisplay();
        transferAdminAction.isTransferAdminWarningDisplay();
        transferAdminAction.isTransferAdminNoticeDisplay("teamauto");
        transferAdminAction.isForgotPasswordLinkDisplay();
        transferAdminAction.isButtonCancelDisplay();
        transferAdminAction.isButtonSubmitDisplay();
    }
    @Test(priority = 18)
    public void TC_ID_04_CheckButtonForgetPassword() throws IOException {
        logReport = logReport.assignCategory("Member management screen/ transfer admin");
        logMethod = createNodeForExtentReport(logReport, "Click Forget your Password button");
        logStep = logStepInfo(logMethod, "Click Forget your Password button");
        transferAdminAction.clickButtonForgetPassword();
        logStep = logStepInfo(logMethod, "Validate Page Forget Password is shown");
        transferAdminAction.isNotificationSendEmailSuccess();
    }

    @Test(priority = 19)
    public void TC_ID_05_CheckButtonCancelTransferAdmin() throws IOException {
        logReport = logReport.assignCategory("Member management screen/ transfer admin");
        logMethod = createNodeForExtentReport(logReport, "Click Cancel button");
        logStep = logStepInfo(logMethod, "Click Cancel button");
        transferAdminAction.clickButtonCancelTransferAdmin();
        logStep = logStepInfo(logMethod, "Validate Member Management Page is shown");
        aboutAction.isPageTitleShown();
    }


    @Test(priority = 20)
    public void TC_ID_06_SubmitButtonIsDisableWhenDontSelectMemberAndPassword() throws IOException, AWTException {
        logReport = logReport.assignCategory("Member management screen/ transfer admin");
        logMethod = createNodeForExtentReport(logReport, "Check submit button is disable when don't input Member and password");
        logStep = logStepInfo(logMethod, "Validate submit button is disabled");
        openUrl(driver,urlTransferAdmin);
        transferAdminAction.isButtonSubmitDisabled();
    }

    @Test(priority = 21)
    public void TC_ID_07_SubmitButtonIsDisableWhenSelectMemberAndPassword() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Member management screen/ transfer admin");
        logMethod = createNodeForExtentReport(logReport, "Check submit button is disable when input Member but don't input password");
        logStep = logStepInfo(logMethod, "Input member");
        transferAdminAction.selectNewAdmin("Hoang5555");
        logStep = logStepInfo(logMethod, "Validate submit button is disabled");
        transferAdminAction.isButtonSubmitDisabled();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }
}
