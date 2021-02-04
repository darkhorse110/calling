package testcases;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import actions.pageactions.SelectWorkSpaceAction;
import actions.pageactions.SignInAction;
import actions.pageactions.WorkSpaceHomeAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import javax.management.Notification;
import java.io.IOException;

import static actions.commons.ReadExcelFile.testData;
import static actions.commons.ReportListener.*;

public class SignIn extends AbstractPages {
    private WebDriver driver;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public String workspace = null;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        workSpaceHomeAction = PageGeneratorManager.getWorkSpaceHomeAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Sign In screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }

    @Test(dataProvider = "WorkspaceData")
    public void PreCondition(String workspaceID) throws IOException {
        logReport = logReport.assignCategory("Select Workspace");
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(workspaceID, logStep);
        this.workspace = workspaceID;
    }

    @Test(priority = 1)
    public void TC_01_RedirectToLoginAnotherWSPage() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Login to another workspace");
        logMethod = createNodeForExtentReport(logReport, "Login to another workspace");
        logStep = logStepInfo(logMethod, "Click into 'Log in to another workspace' link");
        signInAction.verifyClickLinkLoginToAnotherWS(logStep);
    }

    @Test(priority = 2)
    public void TC_02_RedirectToForgotPasswordPage() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Redirect to Forgot Password");
        logMethod = createNodeForExtentReport(logReport, "Redirect to Forgot Password when click link");
        logStep = logStepInfo(logMethod, "Click into 'Forgot password' link");
        signInAction.verifyClickLinkForgotPassword(workspace, logStep);
    }

    @Test(dataProvider = "SignInDataInvalid", priority = 3)
    public void TC00_03_CheckValidateMsg(String testcaseName, String mail, String password , String jpErrorMessage, String enErrorMessage) throws IOException, InterruptedException {
        logMethod = createNodeForExtentReport(logReport, "TC: " + testcaseName);
        logStep = logStepInfo(logMethod,"Input and check validate");
        signInAction.checkValidateLogin(mail, password,logStep, jpErrorMessage, workspace);
    }

    /**
     * Get data tu file excel
     */

    @DataProvider(name = "SignInDataInvalid")
    public static Object[][] getDataInvalidData() {
        return getData("SignInDataInvalid");
    }
    @DataProvider(name = "WorkspaceData")
    public static Object[][] getDataWorkspace() {
        return getData("Workspace");
    }

    public static Object[][] getData(String sheet) {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath, sheet);
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
