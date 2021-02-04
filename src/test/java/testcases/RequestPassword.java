package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.RequestPasswordAction;
import actions.pageactions.SelectWorkSpaceAction;
import actions.pageactions.SignInAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.io.IOException;

import static actions.commons.ReadExcelFile.testData;
import static actions.commons.ReportListener.*;
import static actions.commons.ReportListener.logClass;

public class RequestPassword extends AbstractPages {
    private WebDriver driver;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public RequestPasswordAction requestPasswordAction;
    public String urlRequestPassword;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        requestPasswordAction = PageGeneratorManager.getRequestPasswordAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Request Password screen");
        logClass = createTestForExtentReport(extent, "Test suit for Sign In screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }
    /*

    Test case here

     */

    @Test(priority = 0)
    public void PR00_00_SelectWorkSpaceAndClickRequestPassword() throws IOException {
        logReport = logReport.assignCategory("Pre-Select Workspace screen");
        logMethod = createNodeForExtentReport(logReport, "Go to Request password screen");
        logStep = logStepInfo(logMethod, "Pre- Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logStep = logStepInfo(logMethod, "Click Request Password link");
        signInAction.clickRequestPasswordLink(logStep);
        urlRequestPassword= requestPasswordAction.getURLRequestPassword();
    }

    @Test(dataProvider = "RequestPassword",priority = 1)
    public void TC01_00_CheckValidateRequestPassword(String testcaseName, String workspaceID, String mail ,  String pass,String jpErrorMessage, String enErrorMessage) throws IOException {
        openUrl(driver,urlRequestPassword);
        logReport = logReport.assignCategory("Request Password screen");
        logMethod = createNodeForExtentReport(logReport, "TC: " + testcaseName);
        logStep = logStepInfo(logMethod, "Input login information");
        requestPasswordAction.inputMail(mail);
        logStep = logStepInfo(logMethod, "Check error message shows");
        Assert.assertTrue(requestPasswordAction.isErrorMessage(jpErrorMessage));
    }
    @Test(dataProvider = "NotRegist",priority = 2)
    public void TC02_00_CheckValidateRequestPassword(String testcaseName, String mail ,String jpErrorMessage, String enErrorMessage) throws IOException {
        openUrl(driver,urlRequestPassword);
        logReport = logReport.assignCategory("Request Password screen");
        logMethod = createNodeForExtentReport(logReport, "TC: " + testcaseName);
        logStep = logStepInfo(logMethod, "Input login information");
        requestPasswordAction.inputRequestPassword( mail, logStep);
        logStep = logStepInfo(logMethod, "Check error message shows");
        Assert.assertTrue(requestPasswordAction.isErrorMessageNotRegist(jpErrorMessage));
    }
    @Test(priority = 3)
    public void L_1_2_TC_ID_5_CheckMaxLengthEmail() throws IOException {
        openUrl(driver,urlRequestPassword);
        logReport = logReport.assignCategory("Request Password screen");
        logMethod = createNodeForExtentReport(logReport, "TC: Check max length Email textbox = 255 characters");
        logStep = logStepInfo(logMethod, "Check max length Email textbox = 255 characters");
        Assert.assertTrue(requestPasswordAction.isMaxLengthEmail("255"));

    }

    @Test(priority = 4)
    public void L_1_2_TC_ID_2_CheckBackLogin() throws IOException {
        openUrl(driver,urlRequestPassword);
        logReport = logReport.assignCategory("Request Password screen");
        logMethod = createNodeForExtentReport(logReport, "TC: Check Back Login");
        logStep = logStepInfo(logMethod, "Click on ログイン画面に戻る");
        requestPasswordAction.clickBackLoginButton();
        logStep = logStepInfo(logMethod, "Check Login Page open");
        Assert.assertTrue(requestPasswordAction.isLoginURL("signIn",logStep));

    }
    /**
     * Get data tu file excel
     */
    @DataProvider(name = "RequestPassword")
    public static Object[][] getRequestPasswordData() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath, "RequestPassword");
        return data;
    }

    @DataProvider(name = "SigninData")
    public static Object[][] getSignInData() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath, "SigninData");
        return data;
    }
    @DataProvider(name = "NotRegist")
    public static Object[][] getNotRegistData() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath, "NotRegist");
        return data;
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
