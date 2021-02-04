package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URISyntaxException;

import static actions.commons.ReadExcelFile.testData;
import static actions.commons.ReportListener.*;
import static actions.commons.ReportListener.logReport;

public class InviteMemberByUrl extends AbstractPages {
    private WebDriver driver;
    public TopPageAction topAction;
    public SignInAction signInAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public InviteMemberByUrlAction inviteMemberByUrlAction;
    public InviteMemberPageAction inviteMemberPageAction;
    private String inviteURL = null; //Store invite URL link

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        inviteMemberByUrlAction = PageGeneratorManager.getInviteMemberByUrlAction(driver);
        inviteMemberPageAction = PageGeneratorManager.getInviteMemberPageAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        topAction = PageGeneratorManager.getTopPageAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Sign In screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }
    /*

Login
     */

    @Test(priority = 1)
    public void LoginAndGoToTopPage() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Precondition Login ");
        logStep = logStepInfo(logMethod, "Pre- Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logStep = logStepInfo(logMethod, "Input login");
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD, logReport);
        logReport = logReport.assignCategory("Enter Top Page and then select Invite Member in Setting icon");
        topAction.clickIconSetting ();
        topAction.clickInviteMember ();
        logReport = logReport.assignCategory("Entered Invite Screen");
    }

    @Test(priority = 2)
    public void GoToInviteByURLPage() throws IOException {
        logReport = logReport.assignCategory("Select Workspace screen");
        logMethod = createNodeForExtentReport(logReport, "TC001_0 ");
        logStep = logStepInfo(logMethod, "Go to Invite By Url");
        inviteMemberPageAction.clickInviteByUrlButton();
    }
    @Test(priority = 3)
    public void StoreURLAndOpenInviteURL() throws IOException, UnsupportedFlavorException {
        logReport = logReport.assignCategory("Store URL to invite");
        logMethod = createNodeForExtentReport(logReport, "TC002_0 ");
        logStep = logStepInfo(logMethod, "Store URL");
        inviteMemberPageAction.clickCopyUrlButton();
        inviteURL = inviteMemberPageAction.getURLInvite();
        System.out.printf(inviteURL);
    }

//-----------------Run test case from here------------------------------------------//

    @Test(priority = 4)
    public void checkIconCallingAndPrivacyLink_TC_ID_03_04()
            throws IOException {
        logReport = logReport.assignCategory("Check Submit button is disable");
        logMethod = createNodeForExtentReport(logReport, "TC-ID-3, TC-ID-4");
        logStep = logStepInfo(logMethod, "Check Submit button");
        driver.manage().deleteAllCookies();
        openUrl(driver,this.inviteURL);
        inviteMemberByUrlAction.clickCallingIcon();
        inviteMemberByUrlAction.clickPrivacyLink();
    }
    //Check Confirm Button on Invite screen when do not input fully text boxes
    @Test(dataProvider = "InviteCheckConfirmButton", priority = 5)
    public void checkInviteSubmitBtn(String testcaseName,String name, String mail , String pass, String passConfirm, String jpErrorMessage, String enErrorMessage)
            throws IOException{
        logReport = logReport.assignCategory("Check Submit button is disable");
        logMethod = createNodeForExtentReport(logReport, testcaseName);
        logStep = logStepInfo(logMethod, "Check Submit button");
        openUrl(driver,this.inviteURL);
        inviteMemberByUrlAction.inputName(name);
        inviteMemberByUrlAction.inputMail(mail);
        inviteMemberByUrlAction.inputMailConfirm(mail);
        inviteMemberByUrlAction.inputPass(pass);
        inviteMemberByUrlAction.inputPassConfirm(passConfirm);
        //Check Submit button
        inviteMemberByUrlAction.isSubmitBtnDisable();
        logStep = logStepInfo(logMethod, "Is Submit button disable?");
    }

    //Check Validation mail fields
    @Test(priority = 6, dataProvider = "InviteValidationMail")
    public void checkValidation(String testcaseName,String name, String mail , String pass, String passConfirm, String jpErrorMessage, String enErrorMessage)
            throws IOException, InterruptedException, UnsupportedFlavorException, URISyntaxException {
        logReport = logReport.assignCategory("Store URL to invite");
        logMethod = createNodeForExtentReport(logReport, testcaseName);
        logStep = logStepInfo(logMethod, "Store URL");
        openUrl(driver,this.inviteURL);
        //Input data here and check Validation
        inviteMemberByUrlAction.inputName(name);
        inviteMemberByUrlAction.inputMail(mail);
        inviteMemberByUrlAction.inputMailConfirm(mail);
        inviteMemberByUrlAction.inputPass(pass);
        inviteMemberByUrlAction.inputPassConfirm(passConfirm);
        //Check Validation Mail
        inviteMemberByUrlAction.checkValidationMail(jpErrorMessage);
        logStep = logStepInfo(logMethod, "Check error message shows");
    }
    //Check Validation Password fields
    @Test(priority = 7, dataProvider = "InviteValidationPass")
    public void checkValidationPass(String testcaseName,String name, String mail , String pass, String passConfirm, String jpErrorMessage, String enErrorMessage)
            throws IOException, InterruptedException, UnsupportedFlavorException, URISyntaxException {
        logReport = logReport.assignCategory("Check Validation for Password field");
        logMethod = createNodeForExtentReport(logReport, testcaseName);
        logStep = logStepInfo(logMethod, "Check Validation for Password field");
        openUrl(driver,this.inviteURL);
        //Input data here and check Validation
        inviteMemberByUrlAction.inputName(name);
        inviteMemberByUrlAction.inputMail(mail);
        inviteMemberByUrlAction.inputMailConfirm(mail);
        inviteMemberByUrlAction.inputPass(pass);
        inviteMemberByUrlAction.inputPassConfirm(passConfirm);
        //Check Validation Mail
        inviteMemberByUrlAction.checkValidationPass(jpErrorMessage);
        logStep = logStepInfo(logMethod, "Check error message shows");
    }
    //---------------------TEST CASE END!!!!-------------------------------//


    //---------------------Prepare Data to test-------------------------------//
    @DataProvider(name = "SignInData")
    public static Object[][] getData() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath, "SigninData");
        return data;
    }
    @DataProvider(name = "InviteValidationMail")
    public static Object[][] getInviteValidationMail() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath,"InviteValidationMail");
        return data;
    }

    @DataProvider(name = "InviteValidationPass")
    public static Object[][] getInviteValidationPass() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath,"InviteValidationPass");
        return data;
    }
    @DataProvider(name = "InviteCheckConfirmButton")
    public static Object[][] getInviteCheckConfirmButton() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath,"InviteCheckConfirmButton");
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
