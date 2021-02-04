package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import interfaces.InviteMemberByMailUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URISyntaxException;

import static actions.commons.ReadExcelFile.testData;
import static actions.commons.ReportListener.*;
import static actions.commons.ReportListener.logMethod;

public class InviteMemberByMail extends AbstractPages {
    public WebDriver driver;
    public InviteMemberByMailAction inviteMemberByMailAction;
    public InviteMemberPageAction inviteMemberPageAction;
    public TopPageAction topAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    private String inviteURL = null;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        inviteMemberByMailAction = PageGeneratorManager.getInviteMemberByMailAction(driver);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        inviteMemberPageAction = PageGeneratorManager.getInviteMemberPageAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        topAction = PageGeneratorManager.getTopPageAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Sign In screen");
        logClass = createNodeForExtentReport(logClass, "Initial Setup successful");
    }
    @Test(priority = 1, dataProvider = "SignInData")
    public void R_4_LoginAndSendInvite(String testcaseName, String workspaceID, String mail, String password, String JpErrorMessage
            , String EnErrorMessage) throws IOException, InterruptedException {
        logMethod = createNodeForExtentReport(logReport, "TC: " + testcaseName);
        logStep = logStepInfo(logMethod, "Pre- Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(workspaceID, logStep);
        logStep = logStepInfo(logMethod, "Input login");
        signInAction.inputLogin(mail, password, logReport);
        logReport = logReport.assignCategory("Enter Top Page and then select Invite Member in Setting icon");
        topAction.clickIconSetting ();
        topAction.clickInviteMember ();
        logReport = logReport.assignCategory("Entered Invite Screen");
        inviteMemberPageAction.clickToPullDownAndSelectGroup();
        inviteMemberPageAction.inputMail(Constants.YOPMAIL_INVITE);
        inviteMemberPageAction.sendMailButton();
        driver.manage().deleteAllCookies();
    }
    @Test(priority = 2)
    public void R_4_OpenYopMailAndGetInviteURL() throws IOException {
        logReport = logReport.assignCategory("Select Workspace screen");
        logMethod = createNodeForExtentReport(logReport, "TC001_0 ");
        logStep = logStepInfo(logMethod, "Go to Invite By Url");
        openUrl(driver, Constants.YOPMAIL);
        inviteMemberByMailAction.inputMailOnYopMail(Constants.YOPMAIL_INVITE);
        inviteMemberByMailAction.clickCheckMailButton();
        inviteMemberByMailAction.clickGetMailButton(); //Click 3 times to make sure the mail is sent
        inviteMemberByMailAction.clickGetMailButton();
        inviteMemberByMailAction.clickGetMailButton();
        inviteMemberByMailAction.selectMail();
        //Store invite URL from mail
        this.inviteURL = getTextElementByXpath(driver,InviteMemberByMailUI.linkInvite);
    }
    @Test(priority = 3, dataProvider = "InviteByMail_CheckSubmitButton")
    public void R_4_CheckSubmitButton(String testcaseName,String name, String pass, String passConfirm)
            throws IOException{
        //Check Confirm Button on Invite screen when do not input fully text boxes
        openUrl(driver, this.inviteURL);
        logReport = logReport.assignCategory("Check Submit button is disable");
        logMethod = createNodeForExtentReport(logReport, testcaseName);
        logStep = logStepInfo(logMethod, "Check Submit button");
        inviteMemberByMailAction.inputName(name);
        inviteMemberByMailAction.inputPass(pass);
        inviteMemberByMailAction.inputPassConfirm(passConfirm);
        //Check Submit button
        Assert.assertTrue(!inviteMemberByMailAction.isSubmitBtnDisable());
        logStep = logStepInfo(logMethod, "Is Submit button disable?");
    }

    //Check Validation Password fields
    @Test(priority = 4, dataProvider = "InviteByMail_ValidationPass")
    public void R_4_checkValidationPass(String testcaseName,String name, String pass, String passConfirm, String jpErrorMessage, String enErrorMessage)
            throws IOException {
        logReport = logReport.assignCategory("Check Validation for Password field");
        logMethod = createNodeForExtentReport(logReport, testcaseName);
        logStep = logStepInfo(logMethod, "Check Validation for Password field");
        openUrl(driver,this.inviteURL);
        //Input data here and check Validation
        inviteMemberByMailAction.inputName(name);
        inviteMemberByMailAction.inputPass(pass);
        inviteMemberByMailAction.inputPassConfirm(passConfirm);
        //Check Validation of Password input
        try{
            Assert.assertEquals(getTextElementByXpath(driver, InviteMemberByMailUI.msgValidatePass),jpErrorMessage);
        }catch (Exception e){
            Assert.assertEquals(getTextElementByXpath(driver, InviteMemberByMailUI.msgValidatePass2),jpErrorMessage);
        }
    }

    @Test(priority = 5)
    public void R_4_checkIconCallingAndPrivacyLink_TC_ID_03_04()
            throws IOException, InterruptedException, UnsupportedFlavorException, URISyntaxException {
        logReport = logReport.assignCategory("Check icon Calling and Privacy link");
        logMethod = createNodeForExtentReport(logReport, "TC-ID-3, TC-ID-4");
        logStep = logStepInfo(logMethod, "Check Submit button");
        driver.manage().deleteAllCookies();
        openUrl(driver,this.inviteURL);
        inviteMemberByMailAction.clickCallingIcon(); //Click on icon Calling and move back
        Assert.assertEquals(inviteMemberByMailAction.clickPrivacyLink(), "https://neo-lab.co.jp/policy/");
    }


    //--------------------------DATA PROVIDER---------------------------------------//
    @DataProvider(name = "SignInData")
    public static Object[][] getData() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath, "SigninData");
        return data;
    }

    @DataProvider(name = "InviteByMail_ValidationPass")
    public static Object[][] getDataCheckValidation() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath, "InviteByMail_ValidationPass");
        return data;
    }

    @DataProvider(name = "InviteByMail_CheckSubmitButton")
    public static Object[][] getDataCheckSubmitButton() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath, "InviteByMail_CheckSubmitButton");
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}