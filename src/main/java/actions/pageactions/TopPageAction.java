package actions.pageactions;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import com.aventstack.extentreports.ExtentTest;
import interfaces.SignInUI;
import interfaces.TopPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;


public class TopPageAction extends AbstractPages {
    public WebDriver driver;

    public TopPageAction(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * Click button  Metting
     */
    public void clickMeetingButton() {
        waitForElement(driver, TopPageUI.bntMeeting, 10);
        clickToElement(driver, TopPageUI.bntMeeting);
    }


    /**
     * Click button  Chatbot
     */
    public void clickChatbotButton() {
        waitForElement(driver, TopPageUI.bntChatbot, 10);
        clickToElement(driver, TopPageUI.bntChatbot);
    }


    /**
     * Click button  chat
     */
    public void clickChatButton() {
        waitForElement(driver, TopPageUI.bntChat, 10);
        clickToElement(driver, TopPageUI.bntChat);
    }


    /**
     * Click button  Home
     */
    public void clickHomeButton() {
        waitForElement(driver, TopPageUI.bntHome, 10);
        clickToElement(driver, TopPageUI.bntHome);
    }


    /**
     * Click button  Bell icon
     */
    public void clickBellButton() {
        waitForElement(driver, TopPageUI.btnBell, 10);
        clickToElement(driver, TopPageUI.btnBell);
    }

    /**
     * Click button  Help button
     */
    public void clickHelpButton() {
        waitForElement(driver, TopPageUI.btnHelp, 10);
        clickToElement(driver, TopPageUI.btnHelp);
    }

    /**
     * Verify Title
     */

    public boolean isMeeting(String Meeting) {
        waitForElement(driver, TopPageUI.MeetingTitle, 10, Meeting);
        return isElementDisplay(driver, TopPageUI.MeetingTitle, Meeting);
    }

    public boolean isChatBot(String ChatBot) {
        waitForElement(driver, TopPageUI.ChatbotTitle, 10, ChatBot);
        return isElementDisplay(driver, TopPageUI.ChatbotTitle, ChatBot);
    }

    public boolean isChat(String Chat) {
        waitForElement(driver, TopPageUI.ChatTitle, 10, Chat);
        return isElementDisplay(driver, TopPageUI.ChatTitle, Chat);
    }

    public boolean isBell(String Bell) {
        waitForElement(driver, TopPageUI.BellTitle, 10, Bell);
        return isElementDisplay(driver, TopPageUI.BellTitle, Bell);
    }

    public boolean isHelp(String Help) {
        waitForElement(driver, TopPageUI.HelpTitle, 10, Help);
        return isElementDisplay(driver, TopPageUI.HelpTitle, Help);
    }

    /**
     * Checking Setting Section
     */
    public void clickIconSetting() {
        waitForElement(driver, TopPageUI.iconSetting, 10);
        clickToElement(driver, TopPageUI.iconSetting);
    }


    public boolean isWorkspaceManagement(String WorkspaceManagement) {
        waitForElement(driver, TopPageUI.btnWorkspaceManagement, 10, WorkspaceManagement);
        return isElementDisplay(driver, TopPageUI.btnWorkspaceManagement, WorkspaceManagement);

    }

    public boolean isManageMember(String ManageMember) {
        waitForElement(driver, TopPageUI.btnManageMember, 10, ManageMember);
        return isElementDisplay(driver, TopPageUI.btnManageMember, ManageMember);
    }


    public boolean isInviteMember(String InviteMember) {
        waitForElement(driver, TopPageUI.btnInviteMember, 10, InviteMember);
        return isElementDisplay(driver, TopPageUI.btnInviteMember, InviteMember);
    }


    public boolean isGroupManage(String GroupManage) {
        waitForElement(driver, TopPageUI.btnGroupManagement, 10, GroupManage);
        return isElementDisplay(driver, TopPageUI.btnGroupManagement, GroupManage);
    }


    public boolean isEnglish(String English) {
        waitForElement(driver, TopPageUI.btnEnglish, 10, English);
        return isElementDisplay(driver, TopPageUI.btnEnglish, English);
    }


    /**
     * Tabs in Setting Section
     */
    public void clickWorkspaceManagement() {
        waitForElement(driver, TopPageUI.btnWorkspaceManagement, 10);
        clickToElement(driver, TopPageUI.btnWorkspaceManagement);
    }

    public void clickManageMember() {
        waitForElement(driver, TopPageUI.btnManageMember, 10);
        clickToElement(driver, TopPageUI.btnManageMember);
    }

    public void clickInviteMember() {
        waitForElement(driver, TopPageUI.btnInviteMember, 10);
        clickToElement(driver, TopPageUI.btnInviteMember);
    }

    public void clickGroupManagement() {
        waitForElement(driver, TopPageUI.btnGroupManagement, 10);
        clickToElement(driver, TopPageUI.btnGroupManagement);
    }

    public void clickLanguage() {

        waitForElement(driver, TopPageUI.btnLanguage, 10);

        clickToElement(driver, TopPageUI.btnLanguage);

    }

    public void clickAboutWorkSpace() {

        waitForElement(driver, TopPageUI.btnAboutWorkspace, 10);

        clickToElement(driver, TopPageUI.btnAboutWorkspace);

    }

    /* Verify Tabs in Setting Section*/

    public boolean isWorkSpaceScreen(String WorkSpaceScreen) {
        waitForElement(driver, TopPageUI.WorkspaceManagementTitle, 10, WorkSpaceScreen);
        return isElementDisplay(driver, TopPageUI.WorkspaceManagementTitle, WorkSpaceScreen);
    }


    public boolean isManageMemberScreen(String ManageMemberScreen) {
        waitForElement(driver, TopPageUI.MemberManageTitle, 10, ManageMemberScreen);
        return isElementDisplay(driver, TopPageUI.MemberManageTitle, ManageMemberScreen);
    }


    public boolean isInviteMemberScreen(String InviteMemberScreen) {
        waitForElement(driver, TopPageUI.InviteMemberTitle, 10, InviteMemberScreen);
        return isElementDisplay(driver, TopPageUI.InviteMemberTitle, InviteMemberScreen);
    }


    public boolean isGroupManagementScreen(String GroupManagementScreen) {
        waitForElement(driver, TopPageUI.GroupManagementTitle, 10, GroupManagementScreen);
        return isElementDisplay(driver, TopPageUI.GroupManagementTitle, GroupManagementScreen);
    }

    public boolean isTopPage(String TopPageScreen) {

        waitForElement(driver, TopPageUI.TopPageTitle, 10, TopPageScreen);

        return isElementDisplay(driver, TopPageUI.TopPageTitle, TopPageScreen);
    }


    public boolean isAboutWorkSpace(String AboutWorkSpace) {

        waitForElement(driver, TopPageUI.btnAboutWorkspace, 10, AboutWorkSpace);

        return isElementDisplay(driver, TopPageUI.btnAboutWorkspace, AboutWorkSpace);
    }


    public boolean isAboutWorkSpaceTitle(String AboutWorkSpaceTitle) {

        waitForElement(driver, TopPageUI.AboutWorkspaceTitle, 10, AboutWorkSpaceTitle);

        return isElementDisplay(driver, TopPageUI.AboutWorkspaceTitle, AboutWorkSpaceTitle);
    }

    /* User info  Section*/

    public void clickIconUser() {
        waitForElement(driver, TopPageUI.btniconUser, 10);
        clickToElement(driver, TopPageUI.btniconUser);
        sleep(2);
    }

    public void clickAccountInfoButton() {
        waitForElement(driver, TopPageUI.btnAccountInfo, 10);
        clickToElement(driver, TopPageUI.btnAccountInfo);
    }


    public boolean isAccountInfo(String AccountInfoScreen) {

        waitForElement(driver, TopPageUI.AccountInfoTitle, 10, AccountInfoScreen);
        return isElementDisplay(driver, TopPageUI.AccountInfoTitle, AccountInfoScreen);

    }

    /**
     * Gettext để verify Language
     */

    public String getTextLanguage() {

        waitForElement(driver, TopPageUI.btnLanguage, 10);
        return getTextElementByXpath(driver, TopPageUI.btnLanguage);

    }

    /**
     * Click Logout Button
     */

    private void clickLogoutButton() {
        waitForElement(driver, TopPageUI.btnLogout, 10);
        clickToElement(driver, TopPageUI.btnLogout);
        sleep(2);
    }

    /**
     * Click Confirm Logout Button
     */

    private void clickConfirmLogoutButton() {
        waitForElement(driver, TopPageUI.btnConfirmLogout, 10);
        clickToElement(driver, TopPageUI.btnConfirmLogout);
        sleep(5);
    }

    /**
     * Logout WS
     */
    private void clickLogoutWS() {
        waitForElement(driver, TopPageUI.getBtnLogoutWS, 10);
        clickToElement(driver, TopPageUI.getBtnLogoutWS);

    }
    /* Verify Tabs in Account Section*/

    public boolean isAbout(String WorkSpaceScreen) {

        waitForElement(driver, TopPageUI.WorkspaceManagementTitle, 10, WorkSpaceScreen);

        return isElementDisplay(driver, TopPageUI.WorkspaceManagementTitle, WorkSpaceScreen);
    }

    /*-------- Business  Logout Action start here ----------------*/

    public void Logout(ExtentTest logTest) {

        logInfo(logTest, "Hover Account Button");

        clickIconUser();

        logInfo(logTest, "Click Logout Button");

        clickLogoutButton();

        logInfo(logTest, "Click Confirm Logout button");

        clickConfirmLogoutButton();

//        logInfo(logTest, "Click  Logout WorkSpace");
//
//        clickLogoutWS();
    }

    /**
     * disable - active account
     */

    public void clickLinkListMember() {
        waitForElement(driver, TopPageUI.lnkListMember, 10);
        clickToElement(driver, TopPageUI.lnkListMember);
    }

    public void clickBtnCaretOfMember() {
        waitForElement(driver, TopPageUI.btnCaretAtMember, 10);
        clickToElement(driver, TopPageUI.btnCaretAtMember);

    }
    public void clickBtnDisableAccount() {
        waitForElement(driver, TopPageUI.btnDisableAccount, 10);
        clickToElement(driver, TopPageUI.btnDisableAccount);
    }

    public void clickBtnYesDisableAccount() {
        waitForElement(driver, TopPageUI.btnYesDisableAccount, 10);
        clickToElement(driver, TopPageUI.btnYesDisableAccount);
    }

    public void clickLinkInvalidAccount() {
        waitForElement(driver, TopPageUI.lnkInvalidAccount, 10);
        clickToElement(driver, TopPageUI.lnkInvalidAccount);
    }

    public void clickBtnActiveAccount() {
        waitForElement(driver, TopPageUI.btnActiveAccount, 10);
        clickToElement(driver, TopPageUI.btnActiveAccount);
    }
    public void clickBtnYesActiveAccount() {
        waitForElement(driver, TopPageUI.btnYesActiveAccount, 10);
        clickToElement(driver, TopPageUI.btnYesActiveAccount);
    }

    public boolean isEmailDisplayAtListMember() {
        waitForElement(driver, TopPageUI.txtEmail, 10);
        return isElementDisplay(driver, TopPageUI.txtEmail);
    }

    public void disableAccount(ExtentTest logTest) {
        logInfo(logTest, "Verify '+email+' is display at List member tab");
        verifyTrue(isEmailDisplayAtListMember());
        logInfo(logTest, "Disable account");
        clickLinkListMember();
        clickBtnCaretOfMember();
        clickBtnDisableAccount();
        clickBtnYesDisableAccount();
    }


    public void activeAccount(ExtentTest logTest) {
        logInfo(logTest, "Switch to Invalid Account tab");
        clickLinkInvalidAccount();
        logInfo(logTest, "Verify'+ email +'is display at Invalid account tab");
        verifyTrue(isEmailDisplayAtListMember());
        logInfo(logTest, "Active account");
        clickBtnActiveAccount();
        clickBtnYesActiveAccount();

    }
    public void checkCurrentUrl(String expectedUrl, ExtentTest logTest) {
        String actualUrl = driver.getCurrentUrl();
        logInfo(logTest, "Actual url: " + actualUrl);
        logInfo(logTest, "Expected url: " + expectedUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    public void verifyRedirectToHomePageSuccess(String workspace, ExtentTest logTest) {
        waitForElement(driver, SignInUI.lblLoginMessageSuccess,10);
        checkCurrentUrl(String.format(Constants.WORKSPACE_URL, workspace)+"home", logTest);
    }

}