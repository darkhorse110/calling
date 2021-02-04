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

import java.io.IOException;

public class UserUsage extends AbstractPages {
    private WebDriver driver;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public SalesTopAction salesTopAction;
    public TopPageAction topPageAction;
    public SalesLightAction salesLightAction;
    public UserUsageAction userUsageAction;
    public String URLSalesLightMenu = null;
    public String connectionNumber = null;
    public String name = "name"+currentTime();
    public String message = "message"+currentTime();
    public String email = "email"+currentTime()+"@gmail.com";
    public int firstCountConnection = 0;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        workSpaceHomeAction = PageGeneratorManager.getWorkSpaceHomeAction(driver);
        salesTopAction = PageGeneratorManager.getSalesTopAction(driver);
        topPageAction = PageGeneratorManager.getTopPageAction(driver);
        salesLightAction = PageGeneratorManager.getSalesLightAction(driver);
        userUsageAction = PageGeneratorManager.getUserUsageAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Platform User Usage screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }

    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logReport = logReport.assignCategory("Pre-condition : Get number sales light ");
        logMethod = createNodeForExtentReport(logReport, "Open sales light");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        openUrl(driver,Constants.URLSALESLIGHT);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open calling url at tab 2");
        openNewTab(driver,Constants.URL);
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logMethod = createNodeForExtentReport(logReport, "Input user name and password");
        logStep = logStepInfo(logMethod, "Input user name and password");
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD,logStep);
        logStep = logStepInfo(logMethod, "Click Meeting Button");
        topPageAction.clickMeetingButton();
        logStep = logStepInfo(logMethod, "Click Usage Situation Button");
        userUsageAction.clickUsageSituationButton();
        logStep = logStepInfo(logMethod, "Click Report On User Usage Button");
        userUsageAction.clickReportOnUserUsageButton();
        logStep = logStepInfo(logMethod, "Get Count Connection Of User");
        firstCountConnection = userUsageAction.getCountConnectionOfUser();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        salesTopAction.clickSalesLightMenu();
        URLSalesLightMenu = getCurrentUrl(driver);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
    }

    @Test (priority = 1)
    public void UserUsage_01() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Number of Count Connection");
        logStep = logStepInfo(logMethod, "Click OK button to join room");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, "Click icon Exit room");
        userUsageAction.clickIconExit();
        logStep = logStepInfo(logMethod, "Click btn Confirm to Exit room");
        userUsageAction.clickBtnConfirmExit();
        logStep = logStepInfo(logMethod, "Wait for a little to always update the correct value on platform");
        sleep(5);
        logStep = logStepInfo(logMethod, "Switch to Platform tab");
        userUsageAction.switchToPlatformTab();
        logStep = logStepInfo(logMethod, "Click Usage Situation Button");
        userUsageAction.clickUsageSituationButton();
        logStep = logStepInfo(logMethod, "Click Report On User Usage Button");
        userUsageAction.clickReportOnUserUsageButton();
        logStep = logStepInfo(logMethod, "Get Count Connection Of User again");
        int secondCountConnection = userUsageAction.getCountConnectionOfUser();
        logStep = logStepInfo(logMethod, "Verify Count Connection +1");
        Assert.assertEquals(secondCountConnection, firstCountConnection+1);
    }
    @Test (priority = 2)
    public void UserUsage_02_Search_Name() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Search by Name");
        logStep = logStepInfo(logMethod, "Input data into Search by name field");
        userUsageAction.InputToSearchByNameField();
        logStep = logStepInfo(logMethod, "Verify have data valid");
        Assert.assertTrue(userUsageAction.DisplayDataByName());
    }
    @Test (priority = 3)
    public void UserUsage_03_Search_Time() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Search by month");
        logStep = logStepInfo(logMethod, "Reset data before check this case");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Choose this month");
        userUsageAction.ChooseThisMonth();
        logStep = logStepInfo(logMethod, "Verify have data valid");
        Assert.assertTrue(userUsageAction.IsDataDisplay());
    }

    @Test (priority = 4)
    public void UserUsage_04_View_Detail_And_Check() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "View detail and check data");
        logStep = logStepInfo(logMethod, "Click on button View");
        userUsageAction.clickOnButtonView();
        logStep = logStepInfo(logMethod, "Verify Type = Sales is display on top data");
        Assert.assertTrue(userUsageAction.IsSalesTypeDisplay());
        logStep = logStepInfo(logMethod, "Get ID SalesLight on top data");
        String IDSalesLight = userUsageAction.getIDSalesLightOnViewDetail();
        logStep = logStepInfo(logMethod, "Verify ID SalesLight same ID at Pre-condition");
        Assert.assertEquals(IDSalesLight, connectionNumber);
        logStep = logStepInfo(logMethod, "Get first Count Connection on top data");
        String firstCountConnection = userUsageAction.getFirstCountConnection();
        logStep = logStepInfo(logMethod, "Verify first Count Connection on top data = 1");
        Assert.assertEquals(firstCountConnection, "1");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
