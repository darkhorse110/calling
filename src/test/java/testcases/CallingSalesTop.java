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

public class CallingSalesTop extends AbstractPages {
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public SalesTopAction salesTopAction;
    public TopPageAction topPageAction;
    public SalesLightAction salesLightAction;
    public String URLSalesLightMenu = null;
    public String connectionNumber = null;
    public String micOFF = "マイクOFF";
    public String cameraOFF = "カメラOFF";
    public String micON = "マイクON";
    public String cameraON = "カメラON";
    public String companyName = "Company" + currentTime();
    public String department = "deparment" + currentTime();
    public String position = "position" + currentTime();
    public String name = "name" + currentTime();
    public String name_kana = "name_kana" + currentTime();
    public String message = "message" + currentTime();
    public String email = "email" + currentTime() + "@gmail.com";
    public String phone = currentTime();
    private WebDriver driver;

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
        logClass = createTestForExtentReport(extent, "Test suit for Calling Sales Top screen");
        logClass = createNodeForExtentReport(logClass, "Initial Setup successful");
    }

    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logReport = logReport.assignCategory("Pre-condition : Get number sales light ");
        logMethod = createNodeForExtentReport(logReport, "Open sales light");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        openUrl(driver, Constants.URLSALESLIGHT);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open calling url at tab 2");
        openNewTab(driver, Constants.URL);
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logMethod = createNodeForExtentReport(logReport, "Input user name and password");
        logStep = logStepInfo(logMethod, "Input user nam and password");
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD, logStep);
    }

    @Test(priority = 1)
    public void ConnectionNumber_TC_01() throws IOException {
        logReport = logReport.assignCategory("Check Input 4 connection number");
        logMethod = createNodeForExtentReport(logReport, "Check Input 4 connection number");
        logStep = logStepInfo(logMethod, "Click Meeting Button");
        topPageAction.clickMeetingButton();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        salesTopAction.clickSalesLightMenu();
        URLSalesLightMenu = getCurrentUrl(driver);
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Verify URL is contains number ");
        Assert.assertTrue(salesTopAction.IsURLIsContainsNumber(connectionNumber));
    }

    @Test(priority = 2)
    public void Questionnaire_TC_01() throws IOException {
        logReport = logReport.assignCategory("Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Check select Questionnaire");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        closeTabWindowIndex(driver, "tab3");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Select Questionnaire");
        salesTopAction.selectQuestionnairePulldown("QuestionnaireDefault(No Remove)");
        logStep = logStepInfo(logMethod, "Verified Questionnaire selected");
        Assert.assertEquals(salesTopAction.isQuestionnaireSelected(), "QuestionnaireDefault(No Remove)");
    }

    @Test(priority = 3)
    public void Configuration_TC_01() throws IOException {
        logReport = logReport.assignCategory("Configuration");
        logMethod = createNodeForExtentReport(logReport, "Check default camera sale");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Check default camera sale");
        Assert.assertEquals(salesTopAction.isCameraSaleSetting(), "OFF");
    }

    @Test(priority = 4)
    public void Configuration_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check off camera sale");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Check ON camera sale");
        Assert.assertEquals(salesTopAction.isCameraSaleSetting(), "ON");
    }

    @Test(priority = 5)
    public void Configuration_TC_03() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check on camera sale");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click on camera sale");
        salesTopAction.clickCameraSaleSetting("OFF");
        logStep = logStepInfo(logMethod, "Check OFF camera sale");
        Assert.assertEquals(salesTopAction.isCameraSaleSetting(), "OFF");
    }

    @Test(priority = 6)
    public void Configuration_TC_04() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check default camera host");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Check default camera host");
        Assert.assertEquals(salesTopAction.isCameraHostSetting(), "ON");
    }

    @Test(priority = 7)
    public void Configuration_TC_05() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check off camera host");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click Off camera host");
        salesTopAction.clickCameraHostSetting("OFF");
        logStep = logStepInfo(logMethod, "Check Off camera host");
        Assert.assertEquals(salesTopAction.isCameraHostSetting(), "OFF");
    }

    @Test(priority = 8)
    public void Configuration_TC_06() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check on camera host");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click Off camera host");
        salesTopAction.clickCameraHostSetting("OFF");
        logStep = logStepInfo(logMethod, "Click on camera host");
        salesTopAction.clickCameraHostSetting("ON");
        logStep = logStepInfo(logMethod, "Check On camera host");
        Assert.assertEquals(salesTopAction.isCameraHostSetting(), "ON");
    }

    @Test(priority = 9)
    public void Configuration_TC_07() throws IOException {
        logReport = logReport.assignCategory("Configuration");
        logMethod = createNodeForExtentReport(logReport, "Check default mic host");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Check default mic host");
        Assert.assertEquals(salesTopAction.isMicHostSetting(), "ON");
    }

    @Test(priority = 10)
    public void Configuration_TC_08() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check off mic host");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click Off mic host");
        salesTopAction.clickMicHostSetting("OFF");
        logStep = logStepInfo(logMethod, "Check Off mic host");
        Assert.assertEquals(salesTopAction.isMicHostSetting(), "OFF");
    }

    @Test(priority = 11)
    public void Configuration_TC_09() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check on camera guest");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click Off camera guest");
        salesTopAction.clickMicHostSetting("OFF");
        logStep = logStepInfo(logMethod, "Click on camera guest");
        salesTopAction.clickMicHostSetting("ON");
        logStep = logStepInfo(logMethod, "Check On camera guest");
        Assert.assertEquals(salesTopAction.isMicHostSetting(), "ON");
    }

    @Test(priority = 12)
    public void Configuration_TC_10() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check on voice default");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
    }

    @Test(priority = 13)
    public void Configuration_TC_11() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check default Post profile");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Check default Post profile");
        Assert.assertEquals(salesTopAction.isPostProfileSetting(), "OFF");
    }

    @Test(priority = 14)
    public void Configuration_TC_12() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check ON Post profile");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON Post profile");
        salesTopAction.clickPostProfileSetting("ON");
        logStep = logStepInfo(logMethod, "Check ON Post profile");
        Assert.assertEquals(salesTopAction.isPostProfileSetting(), "ON");
    }

    @Test(priority = 15)
    public void Configuration_TC_13() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check OFF Post profile");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click OFF Post profile");
        salesTopAction.clickPostProfileSetting("OFF");
        logStep = logStepInfo(logMethod, "Check OFF Post profile");
        Assert.assertEquals(salesTopAction.isPostProfileSetting(), "OFF");
    }

    @Test(priority = 16)
    public void ConfirmDeviceModalOnGuest_TC_01() throws IOException {
        logReport = logReport.assignCategory("Confirm device modal on Sale");
        logMethod = createNodeForExtentReport(logReport, "Check ON Camera and Mic Sale");
        logMethod = createNodeForExtentReport(logReport, "Open sales light");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera Sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro Host");
        salesTopAction.clickMicHostSetting("ON");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Icon Mic Sale is OFF");
        Assert.assertEquals(salesLightAction.getTextMic(), micOFF);
        logStep = logStepInfo(logMethod, "Icon Camera Sale is OFF");
        Assert.assertEquals(salesLightAction.getTextCamera(), cameraOFF);
    }

    @Test(priority = 17)
    public void ConfirmDeviceModalOnGuest_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check ON Camera and Mic Sale");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        closeTabWindowIndex(driver, "tab3");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Click on カメラをオンにする button");
        salesLightAction.clickOnTurnONCameraAndMicDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Icon Mic sale is ON");
        Assert.assertEquals(salesLightAction.getTextMic(), micON);
        logStep = logStepInfo(logMethod, "Icon Camera sale is ON");
        Assert.assertEquals(salesLightAction.getTextCamera(), cameraON);
    }

    @Test(priority = 18)
    public void ConfirmDeviceModalOnGuest_TC_03() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check ON Camera and OFF Mic Sale");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        closeTabWindowIndex(driver, "tab3");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("OFF");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Icon Mic sale is OFF");
        Assert.assertEquals(salesLightAction.getTextMic(), micOFF);
        logStep = logStepInfo(logMethod, "Icon Camera sale is OFF");
        Assert.assertEquals(salesLightAction.getTextCamera(), cameraOFF);
    }

    @Test(priority = 19)
    public void ConfirmDeviceModalOnGuest_TC_04() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check ON Camera and OFF Mic Sale");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        closeTabWindowIndex(driver, "tab3");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("OFF");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Click on カメラをオンにする button");
        salesLightAction.clickOnTurnONCameraAndMicDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Icon Mic sale is OFF");
        Assert.assertEquals(salesLightAction.getTextMic(), micOFF);
        logStep = logStepInfo(logMethod, "Icon Camera sale is ON");
        Assert.assertEquals(salesLightAction.getTextCamera(), cameraON);
    }

    @Test(priority = 20)
    public void ConfirmDeviceModalOnGuest_TC_05() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check OFF Camera and ON Mic Sale");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        closeTabWindowIndex(driver, "tab3");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("OFF");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Icon Mic sale is OFF");
        Assert.assertEquals(salesLightAction.getTextMic(), micOFF);
        logStep = logStepInfo(logMethod, "Icon Camera sale is OFF");
        Assert.assertEquals(salesLightAction.getTextCamera(), cameraOFF);
    }

    @Test(priority = 21)
    public void ConfirmDeviceModalOnGuest_TC_06() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check OFF Camera and ON Mic Sale");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        closeTabWindowIndex(driver, "tab3");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("OFF");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Click on カメラをオンにする button");
        salesLightAction.clickOnTurnONCameraAndMicDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Icon Mic sale is ON");
        Assert.assertEquals(salesLightAction.getTextMic(), micON);
        logStep = logStepInfo(logMethod, "Icon Camera sale is OFF");
        Assert.assertEquals(salesLightAction.getTextCamera(), cameraOFF);
    }

    @Test(priority = 22)
    public void ConfirmDeviceModalOnGuest_TC_07() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check OFF Camera and OFF Mic Sale");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        closeTabWindowIndex(driver, "tab3");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("OFF");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("OFF");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Icon Mic sale is OFF");
        Assert.assertEquals(salesLightAction.getTextMic(), micOFF);
        logStep = logStepInfo(logMethod, "Icon Camera sale is OFF");
        Assert.assertEquals(salesLightAction.getTextCamera(), cameraOFF);
    }

    @Test(priority = 23)
    public void ProfileHost_TC_01() throws IOException {
        logReport = logReport.assignCategory("Confirm Profile Host");
        logMethod = createNodeForExtentReport(logReport, "Check OFF Profile Host");
        logMethod = createNodeForExtentReport(logReport, "Open sales light");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver, "tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        logStep = logStepInfo(logMethod, "Click OFF profile host");
        salesTopAction.clickPostProfileSetting("OFF");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Profile form not show 担当者のプロフィールを提示 ");
        Assert.assertFalse(salesLightAction.isProfileHostDisplay(false));
    }

    @Test(priority = 24)
    public void ProfileHost_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check ON Profile Host");
        logMethod = createNodeForExtentReport(logReport, "Open sales light");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver, "tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON profile host");
        salesTopAction.clickPostProfileSetting("ON");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Profile form  show 担当者のプロフィールを提示 ");
        Assert.assertTrue(salesLightAction.isProfileHostDisplay(true));
    }

    @Test(priority = 25)
    public void ProfileHost_TC_03() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Edit Profile Host");
        logMethod = createNodeForExtentReport(logReport, "Open sales light");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver, "tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON profile host");
        salesTopAction.clickPostProfileSetting("ON");
        logStep = logStepInfo(logMethod, "Click Edit プロフィールを編集 profile host");
        salesTopAction.clickEditProfile();
        logStep = logStepInfo(logMethod, "Input company_name");
        salesTopAction.inputProfileCompanyName(companyName);
        logStep = logStepInfo(logMethod, "Input department");
        salesTopAction.inputProfileDepartment(department);
        logStep = logStepInfo(logMethod, "Input position");
        salesTopAction.inputProfilePosition(position);
        logStep = logStepInfo(logMethod, "Input name");
        salesTopAction.inputProfileName(name);
        logStep = logStepInfo(logMethod, "Input name_kana");
        salesTopAction.inputProfileNameKana(name_kana);
        logStep = logStepInfo(logMethod, "Input message");
        salesTopAction.inputProfileMessage(message);
        logStep = logStepInfo(logMethod, "Input email");
        salesTopAction.inputProfileEmail(email);
        logStep = logStepInfo(logMethod, "Input phone");
        salesTopAction.inputProfilePhone(phone);
        logStep = logStepInfo(logMethod, "Click on 保存する");
        salesTopAction.clickSaveProfile();
        logStep = logStepInfo(logMethod, "Check message save success 変更完了しました");
        Assert.assertEquals(salesTopAction.messageSaveProfile(), "変更完了しました");
    }

    @Test(priority = 26)
    public void ProfileHost_TC_04() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Detail View Profile Host");
        logMethod = createNodeForExtentReport(logReport, "Open sales light");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver, URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON profile host");
        salesTopAction.clickPostProfileSetting("ON");
        switchTabWindowIndex(driver, "tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver, "tab1");
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Click on 担当者のプロフィールを提示 button ");
        salesLightAction.clickOnDetailViewProfile();
        logStep = logStepInfo(logMethod, "Check company_name");
        Assert.assertTrue(salesLightAction.isContentSpanProfileDetail(companyName));
        logStep = logStepInfo(logMethod, "Check department");
        Assert.assertTrue(salesLightAction.isContentSpanProfileDetail(department));
        logStep = logStepInfo(logMethod, "Check position");
        Assert.assertTrue(salesLightAction.isContentSpanProfileDetail(position));
        logStep = logStepInfo(logMethod, "Check name");
        Assert.assertTrue(salesLightAction.isContentSpanProfileDetail(name));
        logStep = logStepInfo(logMethod, "Check name_kana");
        Assert.assertTrue(salesLightAction.isContentSpanProfileDetail(name_kana));
        logStep = logStepInfo(logMethod, "Check message");
        Assert.assertTrue(salesLightAction.isContenttagPProfileDetail(message));
        logStep = logStepInfo(logMethod, "Check email");
        Assert.assertTrue(salesLightAction.isContenttagAProfileDetail(email));
        logStep = logStepInfo(logMethod, "Check phone");
        Assert.assertTrue(salesLightAction.isContentSpanProfileDetail(phone));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
