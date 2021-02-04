package testcases;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import actions.pageactions.RequestWorkSpaceAction;
import actions.pageactions.RequestWorkspaceSuccessAction;
import actions.pageactions.SelectWorkSpaceAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static actions.commons.ReadExcelFile.testData;
import static actions.commons.ReportListener.*;

public class RequestWorkSpace extends AbstractPages {
    public WebDriver driver;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public RequestWorkSpaceAction requestWorkSpaceAction;
    public RequestWorkspaceSuccessAction requestWorkspaceSuccessAction;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) throws IOException {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        selectWorkSpaceAction.gotoRequestWorkspace();
        requestWorkSpaceAction = PageGeneratorManager.getRequestWorkSpaceAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Request Workspace screen");
        logClass = createNodeForExtentReport(logClass, "Initial Setup successful");
    }

    /*

    Test case here

     */
    @Test(dataProvider = "selectWorkspaceData")
    public void TC00_01_CheckValidateMessageAtRequestWorkspaceScreen(String testcaseName, String email,String resultAction, String jpValidateMessage, String enValidateMessage) throws IOException {
        logReport = logReport.assignCategory("Request Workspace screen");
        logMethod = createNodeForExtentReport(logReport, "TC: " + testcaseName);
        logStep = logStepInfo(logMethod, "Input Email");
        requestWorkSpaceAction.findWorkspaceByEmail(email, logStep);
        if (resultAction.equals("disable")) {
            logStep = logStepInfo(logMethod, "Verify submit button is disable ");
            requestWorkSpaceAction.isSubmitBtnDisable(logStep);
        }
        else if (resultAction.equals("error")){
            logStep = logStepInfo(logMethod, "Verify Error message ".concat(jpValidateMessage).concat(" is available "));
            requestWorkSpaceAction.isValidateMessageCorrect(jpValidateMessage, logStep);
        }
        else if (resultAction.equals("success")){
            logStep = logStepInfo(logMethod, "Forget workspace Id success");
            requestWorkspaceSuccessAction = PageGeneratorManager.getRequestWorkspaceSuccessAction(driver);
            requestWorkspaceSuccessAction.isValidateMessageCorrect(jpValidateMessage, logStep);
            requestWorkspaceSuccessAction.backToPreviousPage();
        }
        else if (resultAction.equals("back")){
            logStep = logStepInfo(logMethod, "Back to select workspace screen");
            requestWorkSpaceAction.backToSelectWorkspace();
            selectWorkSpaceAction.isSelectWorkspaceUrlCorrect(logStep);
            selectWorkSpaceAction.gotoRequestWorkspace();
        }

//
    }

    /**
     * Get data tu file excel
     */
    @DataProvider(name = "selectWorkspaceData")
    public static Object[][] getData() {
        String excelPath = "src/test/java/testdata/selectWorkspaceData.xlsx";
        Object[][] data;
        data = testData(excelPath, "requestWorkspace");
        return data;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }
}
