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

public class WorkSpaceManagement extends AbstractPages {
    public WebDriver driver;
    public WorkSpaceManagementAction workSpaceManagementAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public TopPageAction topPageAction;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        topPageAction = PageGeneratorManager.getTopPageAction(driver);
        workSpaceManagementAction = PageGeneratorManager.getWorkSpaceManagementAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Member Management screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }

    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logReport = logReport.assignCategory("Pre-Select Workspace and login success");
        logMethod = createNodeForExtentReport(logReport, "Go to home page");
        logStep = logStepInfo(logMethod, "Input workspace ID and login");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD, logStep);
    }
    @Test(priority = 1)
    public void L_13_TC_ID_2() throws IOException {
        logReport = logReport.assignCategory("L-13 : WorkSpace management screen");
        logMethod = createNodeForExtentReport(logReport, "Go to WorkSpace management screen");
        logStep = logStepInfo(logMethod, "Click setting button");
        topPageAction.clickIconSetting();
        logStep = logStepInfo(logMethod, "Click menu WorkSpace management");
        topPageAction.clickWorkspaceManagement();
        logMethod = createNodeForExtentReport(logReport, "TC-ID-2 : Open About Administrator tab");
        logStep = logStepInfo(logMethod, "Open About Administrator tab");
        workSpaceManagementAction.clickTabAboutAdmin();
        logStep = logStepInfo(logMethod, "Validate Tab About Administrator display");
        workSpaceManagementAction.isTabAboutAdminShown();
    }

    @Test(priority = 2)
    public void L_13_TC_ID_3() throws IOException {
        logReport = logReport.assignCategory("L-13 : WorkSpace management screen");
        logMethod = createNodeForExtentReport(logReport, "TC-ID-3 : Check Confirm Term link");
        logStep = logStepInfo(logMethod, " Click tab WorkSpace Overview");
        workSpaceManagementAction.clickTabWorkSpacerOverview();
        logStep = logStepInfo(logMethod, " Click Confirm Term link");
        workSpaceManagementAction.clickConfirmTermButton();
        switchTabWindowIndex(driver,"tab2");
        logStep = logStepInfo(logMethod, " Check Confirm Term Link");
        Assert.assertEquals(getCurrentUrl(driver),"https://www.calling.fun/terms/");
    }
    @Test(priority = 3)
    public void L_14_3_TC_ID_2() throws IOException {
        logReport = logReport.assignCategory("L-14-3 : About Administrator tab");
        logMethod = createNodeForExtentReport(logReport, "TC-ID-2 : Open Transfer Administrator screen");
        logStep = logStepInfo(logMethod, "Open About Administrator tab");
        switchTabWindowIndex(driver,"tab1");
        workSpaceManagementAction.clickTabAboutAdmin();
        logStep = logStepInfo(logMethod, "Open Transfer Administrator screen");
        workSpaceManagementAction.clickTransferAdministratorButton();
        logStep = logStepInfo(logMethod, "Validate Transfer Administrator screen");
        workSpaceManagementAction.isTransferAdministratorScreen();

    }
    @Test(priority = 4)
    public void L_14_3_TC_ID_3() throws IOException {
        logReport = logReport.assignCategory("L-14-3 : About Administrator tab");
        logMethod = createNodeForExtentReport(logReport, "TC-ID-3 : Open Workspace Overview tab");
        logStep = logStepInfo(logMethod, "Press on Cancel button");
        switchTabWindowIndex(driver,"tab1");
        workSpaceManagementAction.clickCancelButton();
        logStep = logStepInfo(logMethod, "Open About Administrator tab");
        workSpaceManagementAction.clickTabAboutAdmin();
        logStep = logStepInfo(logMethod, " Click tab WorkSpace Overview");
        workSpaceManagementAction.clickTabWorkSpacerOverview();
        logStep = logStepInfo(logMethod, "Validate Tab WorkSpace Overview display");
        workSpaceManagementAction.isTabWorkSpaceOverviewShown();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }
}
