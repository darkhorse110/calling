package testcases;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import actions.pageactions.RequestPasswordAction;
import actions.pageactions.SelectWorkSpaceAction;
import actions.pageactions.SignInAction;
import actions.pageactions.WorkSpaceHomeAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static actions.commons.ReportListener.*;
import static actions.commons.ReportListener.logClass;

public class WorkSpaceHome extends AbstractPages {
    public WebDriver driver;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public WorkSpaceHomeAction workSpaceHomeAction;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        workSpaceHomeAction = PageGeneratorManager.getWorkSpaceHomeAction(driver);

        logClass = createTestForExtentReport(extent, "Test suit for Workspace Home screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }
    /*

    Test case here

     */

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }
}
