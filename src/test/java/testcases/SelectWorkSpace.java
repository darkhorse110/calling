package testcases;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import actions.pageactions.SelectWorkSpaceAction;
import actions.pageactions.SignInAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static actions.commons.ReadExcelFile.testData;
import static actions.commons.ReportListener.*;
import static actions.commons.ReportListener.logClass;

public class SelectWorkSpace extends AbstractPages {
    public WebDriver driver;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Select workspace screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }
    /*

    Test case here

     */

    @Test(dataProvider = "selectWorkspaceData")
    public void TC00_01_CheckValidateMessageAtSelectWorkspaceScreen(String testcaseName, String workspaceID, String resultAction, String jpErrorMessage, String enErrorMessage) throws IOException {
        logReport = logReport.assignCategory("Select Workspace screen");
        logMethod = createNodeForExtentReport(logReport, "TC: " + testcaseName);
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(workspaceID, logStep);
        if (resultAction.equals("error")) {
            logStep = logStepInfo(logMethod, "Verify Error message ".concat(jpErrorMessage).concat(" is available "));
            selectWorkSpaceAction.isErrorMessageCorrect(jpErrorMessage, logStep);
        }
        else if (resultAction.equals("pass")){
            logStep = logStepInfo(logMethod, "Web direct to sign in page OK");
            signInAction = PageGeneratorManager.getSignInAction(driver);
            signInAction.isWorkspaceAddressCorrect(workspaceID, logStep);
            signInAction.backToSelectWorkspace();
        }
    }

    /**
     * Get data tu file excel
     */
    @DataProvider(name = "selectWorkspaceData")
    public static Object[][] getData() {
        String excelPath = "src/test/java/testdata/selectWorkspaceData.xlsx";
        Object[][] data;
        data = testData(excelPath, "selectWorkspaceId");
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }


}
