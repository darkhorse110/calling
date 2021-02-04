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

import static actions.commons.ReportListener.*;

public class CallingSalesCallScreen extends AbstractPages {
    private WebDriver driver;
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
    public String companyName = "Company"+currentTime();
    public String department = "deparment"+currentTime();
    public String position = "position"+currentTime();
    public String name = "name"+currentTime();
    public String name_kana = "name_kana"+currentTime();
    public String message = "message"+currentTime();
    public String email = "email"+currentTime()+"@gmail.com";
    public String phone = currentTime();

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
    @Test(priority = 1)
    public void Device_Selection_01() throws IOException {
        logReport = logReport.assignCategory("Device selection form");
        logMethod = createNodeForExtentReport(logReport, "Check camera");
        logStep = logStepInfo(logMethod, "Click on Device form selection");
        salesLightAction.clickOnDeviceSettingModal();
        logStep = logStepInfo(logMethod, "Get camera name");
        String cameraName = salesLightAction.getCameraName();
        logStep = logStepInfo(logMethod, "Click OK Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, "Click on icon setting");
        salesLightAction.clickOnSettingDeviceIcon();
        logStep = logStepInfo(logMethod, "Click on Device form selection when join room");
        salesLightAction.clickOnDeviceSettingModal();
        logStep = logStepInfo(logMethod, "Get camera name when join room successfully");
        String cameraNameInRoom = salesLightAction.getCameraName();
        logStep = logStepInfo(logMethod, "Verify camera name when join room is correct");
        Assert.assertEquals(cameraNameInRoom, cameraName);
    }

    @Test(priority = 2)
    public void Device_Selection_02() throws IOException {
        refreshPage(driver);
        logMethod = createNodeForExtentReport(logReport, "Check mic");
        salesLightAction.clickOnDeviceSettingModal();
        logStep = logStepInfo(logMethod, "Get mic name");
        String micName = salesLightAction.getMicName();
        logStep = logStepInfo(logMethod, "Click OK Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, "Click on icon setting");
        salesLightAction.clickOnSettingDeviceIcon();
        logStep = logStepInfo(logMethod, "Click on Device form selection when join room");
        salesLightAction.clickOnDeviceSettingModal();
        logStep = logStepInfo(logMethod, "Get mic name when join room successfully");
        String micNameInRoom = salesLightAction.getMicName();
        logStep = logStepInfo(logMethod, "Verify mic name when join room is correct");
        Assert.assertEquals(micNameInRoom, micName);
    }

    @Test(priority = 3)
    public void Device_Selection_03() throws IOException {
        refreshPage(driver);
        logMethod = createNodeForExtentReport(logReport, "Check sound output");
        salesLightAction.clickOnDeviceSettingModal();
        logStep = logStepInfo(logMethod, "Get sound output name");
        String soundOutputName = salesLightAction.getSoundOutputName();
        logStep = logStepInfo(logMethod, "Click OK Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, "Click on icon setting");
        salesLightAction.clickOnSettingDeviceIcon();
        logStep = logStepInfo(logMethod, "Click on Device form selection when join room");
        salesLightAction.clickOnDeviceSettingModal();
        logStep = logStepInfo(logMethod, "Get mic name when join room successfully");
        String soundOutputNameInRoom = salesLightAction.getSoundOutputName();
        logStep = logStepInfo(logMethod, "Verify sound output name when join room is correct");
        Assert.assertEquals(soundOutputNameInRoom, soundOutputName);
    }

    @Test(priority = 4)
    public void Device_Selection_04() throws IOException {
        refreshPage(driver);
        logMethod = createNodeForExtentReport(logReport, "Click on Device modal");
        salesLightAction.clickOnDeviceSettingModal();
        logStep = logStepInfo(logMethod, "Select mic2");
        String mic2 = salesLightAction.selectMic2();
        logStep = logStepInfo(logMethod, "Click OK Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, "Click on icon setting");
        salesLightAction.clickOnSettingDeviceIcon();
        logStep = logStepInfo(logMethod, "Click on Device form selection when join room");
        salesLightAction.clickOnDeviceSettingModal();
        logStep = logStepInfo(logMethod, "Get mic name when join room successfully");
        String micActual = salesLightAction.getMicName();
        logStep = logStepInfo(logMethod, "Verify mic2 name when join room is correct ");
        Assert.assertEquals(micActual, mic2);
        logStep = logStepInfo(logMethod, "Click OK button");
        salesLightAction.clickOnOKDeviceConfirm();
    }

    @Test(priority = 5)
    public void Sales_Video_Call() throws IOException {
        logReport = logReport.assignCategory("Sales video call");
        logMethod = createNodeForExtentReport(logReport, "Check Host and Guest join to sales room");
        logStep = logStepInfo(logMethod, "Verify have 2 users in this room");
        Assert.assertTrue(salesLightAction.get2Users());
    }

    @Test(priority = 6)
        public void Chat_TC_01() throws IOException {
        logReport = logReport.assignCategory("Chat in Sales Call screen");
        logMethod = createNodeForExtentReport(logReport, "Check host send chat to sale");
        logStep = logStepInfo(logMethod, " Input text chat User host");
        salesLightAction.inputChat("User host");
        logStep = logStepInfo(logMethod, " Click on Send message icon");
        salesLightAction.clickSendChatIcon();
        logStep = logStepInfo(logMethod, " Check text chat send to successfully");
        Assert.assertTrue(salesLightAction.isConTentChatSend("User host"));
    }
    @Test(priority = 7)
    public void Chat_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check sale send chat to host");
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, " Input text chat User Guest");
        salesLightAction.inputChat("User guest");
        logStep = logStepInfo(logMethod, " Click on Send message icon");
        salesLightAction.clickSendChatIcon();
        logStep = logStepInfo(logMethod, " Check text chat send to successfully");
        Assert.assertTrue(salesLightAction.isConTentChatSend("User guest"));
    }
    @Test(priority = 8)
    public void Chat_TC_03() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check max length chat = 1000 character");
        logStep = logStepInfo(logMethod, " Check max length chat = 1000 character");
        Assert.assertEquals(salesLightAction.isMaxLengthChatBox(),"1000");
    }
    @Test(priority = 9)
    public void Chat_TC_04() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check View message");
        logStep = logStepInfo(logMethod, " Check View message from host");
        Assert.assertTrue(salesLightAction.isConTentChatSend("User host"));
        logStep = logStepInfo(logMethod, " Swith tab 3");
        switchTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, " Check View message from sale");
        Assert.assertTrue(salesLightAction.isConTentChatSend("User guest"));
    }
    @Test(priority = 10)
    public void Chat_TC_05() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check View chat history");
        logStep = logStepInfo(logMethod, " Check View chat history");
        Assert.assertTrue(salesLightAction.isConTentChatSend("User host"));
        logStep = logStepInfo(logMethod, " Swith tab 3");
        switchTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, " Input text chat User host");
        salesLightAction.inputChat("Host Time");
        logStep = logStepInfo(logMethod, " Click on Send message icon");
        salesLightAction.clickSendChatIcon();
        String timeSendChat = salesLightAction.getTimeSendChat();
        logStep = logStepInfo(logMethod, " Check text chat send to successfully");
        Assert.assertTrue(salesLightAction.isTimeChatSendSuccess("Host Time",timeSendChat));
        logStep = logStepInfo(logMethod, " Swith tab 1");
        switchTabWindowIndex(driver,"tab1");
        logStep = logStepInfo(logMethod, " Input text chat User Guest");
        salesLightAction.inputChat("Guest time");
        logStep = logStepInfo(logMethod, " Click on Send message icon");
        salesLightAction.clickSendChatIcon();
        timeSendChat = salesLightAction.getTimeSendChat();
        logStep = logStepInfo(logMethod, " Check text chat send to successfully");
        Assert.assertTrue(salesLightAction.isTimeChatSendSuccess("Guest time",timeSendChat));
    }

    @Test(priority = 11)
    public void Chat_TC_06() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Show / hide Box Chat");
        logStep = logStepInfo(logMethod, " Check Box chat Show");
        Assert.assertTrue(salesLightAction.isBoxChatShow(true));
    }
    @Test(priority = 12)
    public void Chat_TC_07() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Show / hide Box Chat");
        logStep = logStepInfo(logMethod, " User click on X icon box chat");
        salesLightAction.clickXIconBoxChat();
        logStep = logStepInfo(logMethod, " Check Hide Box chat");
        Assert.assertFalse(salesLightAction.isBoxChatShow(false));
    }
    @Test(priority = 13)
    public void Chat_TC_08() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Show / hide Box Chat");
        logStep = logStepInfo(logMethod, " User click on open icon box chat");
        salesLightAction.clickOpenIconBoxChat();
        logStep = logStepInfo(logMethod, " Check Show Box chat");
        Assert.assertTrue(salesLightAction.isBoxChatShow(true));
    }
    @Test(priority = 14)
    public void Chat_TC_09() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Switch send method");
        logStep = logStepInfo(logMethod, " Switch tab 1");
        switchTabWindowIndex(driver,"tab1");
        logStep = logStepInfo(logMethod, " select Enterで送信 checkbox");
        salesLightAction.clickOnEnterSendMethod(false);
        logStep = logStepInfo(logMethod, " Input text chat User Guest");
        salesLightAction.inputChat("Guest Enter");
        logStep = logStepInfo(logMethod, " Key Enter keyboard");
        salesLightAction.enterWithChat();
        logStep = logStepInfo(logMethod, " Check View message show in box chat");
        Assert.assertTrue(salesLightAction.isConTentChatSend("Guest Enter"));
    }
    @Test(priority = 15)
    public void Chat_TC_10() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Switch send method");
        logStep = logStepInfo(logMethod, " Switch tab 1");
        switchTabWindowIndex(driver,"tab1");
        logStep = logStepInfo(logMethod, " select Enterで送信 checkbox");
        salesLightAction.clickOnEnterSendMethod(true);
        logStep = logStepInfo(logMethod, " Input text chat User Guest");
        salesLightAction.inputChat("Guest Without Enter");
        logStep = logStepInfo(logMethod, " Key Enter keyboard");
        salesLightAction.enterWithChat();
        logStep = logStepInfo(logMethod, " Check View message show in box chat");
        Assert.assertFalse(salesLightAction.isConTentChatSend("Guest Without Enter"));
    }
    @Test(priority = 16)
    public void MicroPhone_TC_01() throws IOException {
        logReport = logReport.assignCategory("Check Microphone Host");
        logMethod = createNodeForExtentReport(logReport, "Check Microphone OFF");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, "Check Microphone Host is ON ");
        Assert.assertEquals(salesLightAction.getTextMic(),micON);
        logStep = logStepInfo(logMethod, " Click OFF Microphone Host");
        salesLightAction.clickOnMicrophone();
        logStep = logStepInfo(logMethod, "Check Microphone Host is OFF ");
        Assert.assertEquals(salesLightAction.getTextMic(),micOFF);
    }
    @Test(priority = 17)
    public void MicroPhone_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Microphone OFF");
        logStep = logStepInfo(logMethod, " Click ON Microphone Host");
        salesLightAction.clickOnMicrophone();
        logStep = logStepInfo(logMethod, "Check Microphone Host is ON ");
        Assert.assertEquals(salesLightAction.getTextMic(),micON);
    }
    @Test(priority = 18)
    public void Camera_TC_01() throws IOException {
        logReport = logReport.assignCategory("Check Camera Host");
        logMethod = createNodeForExtentReport(logReport, "Check Camera OFF");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON camera Host");
        salesTopAction.clickCameraHostSetting("ON");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, "Check Camera Host is ON ");
        Assert.assertEquals(salesLightAction.getTextCamera(),cameraON);
        logStep = logStepInfo(logMethod, " Click OFF Camera Host");
        salesLightAction.clickOnCamera();
        logStep = logStepInfo(logMethod, "Check Microphone Camera is OFF ");
        Assert.assertEquals(salesLightAction.getTextCamera(),cameraOFF);
    }
    @Test(priority = 19)
    public void Camera_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Camera OFF");
        logStep = logStepInfo(logMethod, " Click ON Camera Host");
        salesLightAction.clickOnCamera();
        logStep = logStepInfo(logMethod, "Check Camera Host is ON ");
        Assert.assertEquals(salesLightAction.getTextCamera(),cameraON);
    }
    @Test(priority = 20)
    public void Recording_TC_01() throws IOException {
        logReport = logReport.assignCategory("Check Recording");
        logMethod = createNodeForExtentReport(logReport, "Check Host can recording");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, " Check icon recoding show for Host");
        Assert.assertTrue(salesLightAction.isRecordIconShow());
        logStep = logStepInfo(logMethod, " Switch tab 1");
        switchTabWindowIndex(driver,"tab1");
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, " Check icon recoding don't show for sale");
        Assert.assertFalse(salesLightAction.isRecordIconShow());
    }
    @Test(priority = 21)
    public void Recording_TC_03() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Recording notification");
        logStep = logStepInfo(logMethod, "Open host tab 3");
        switchTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Click on Record");
        salesLightAction.clickOnStartRecordIcon();
        logStep = logStepInfo(logMethod, " Check icon recoding show for host");
        Assert.assertTrue(salesLightAction.isRecordLabelShow());
        logStep = logStepInfo(logMethod, " Switch tab 1");
        switchTabWindowIndex(driver,"tab1");
        logStep = logStepInfo(logMethod, " Check icon recoding show for sale");
        Assert.assertTrue(salesLightAction.isRecordIconShow());
    }
    @Test(priority = 22)
    public void Recording_TC_04() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Stop record");
        logStep = logStepInfo(logMethod, "Open sale tab 1");
        switchTabWindowIndex(driver,"tab1");
        logStep = logStepInfo(logMethod, "Click on Record");
        salesLightAction.clickStopRecordSale();
        logStep = logStepInfo(logMethod, " Check icon recoding show for sale");
        Assert.assertTrue(salesLightAction.isRecordIconShow());
        logStep = logStepInfo(logMethod, " Switch tab 3");
        switchTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Click on Stop Record");
        salesLightAction.clickOnStopRecordIcon();
        logStep = logStepInfo(logMethod, " Check icon 録画開始 show for host");
        Assert.assertTrue(salesLightAction.isRecordStartLabelShow());
    }
    @Test(priority = 23)
    public void Recording_TC_05() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Stop record notification");
        logStep = logStepInfo(logMethod, "Open sale tab 1");
        switchTabWindowIndex(driver,"tab1");
        logStep = logStepInfo(logMethod, " Check icon recoding don't show for sale");
        Assert.assertFalse(salesLightAction.isRecordIconShow());
    }
    @Test(priority = 24)
    public void Recording_TC_07() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Host out room < 1 min when recording");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, "Click on Start Record");
        salesLightAction.makeSureRecording();
        logStep = logStepInfo(logMethod, "Close tab 3 of host");
        closeTabWindowIndex(driver,"tab3");
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
        logStep = logStepInfo(logMethod, " Check icon recoding show for host");
        Assert.assertTrue(salesLightAction.isRecordLabelShow());
    }
    @Test(priority = 25)
    public void Recording_TC_06() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Host out room > 1 min when recording");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, "Click on Start Record");
        salesLightAction.makeSureRecording();
        logStep = logStepInfo(logMethod, "Close tab 3 of host");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Wait for 80 second");
        switchTabWindowIndex(driver, "tab2");
        sleep(80);
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();
        logStep = logStepInfo(logMethod, " Check icon 録画開始 show for host");
        Assert.assertTrue(salesLightAction.isRecordStartLabelShow());
    }

    @Test(priority = 26)
    public void HostExit_TC_01() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Host out room");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, " Click Exit icon");
        salesLightAction.makeSureStopRecording();
        salesLightAction.clickOnExitIcon();
        logStep = logStepInfo(logMethod, " Click Exit button");
        salesLightAction.clickOnExitButton();
        logStep = logStepInfo(logMethod, " Verify Save Information Show");
        Assert.assertTrue(salesLightAction.isFormSaveInformation());
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Verify 4 number connection Show");
        Assert.assertTrue(salesTopAction.isConnectNumber());
    }
    @Test(priority = 27)
    public void ConnectionNumber_TC_01() throws IOException {
        logReport = logReport.assignCategory("Check Input 4 connection number");
        logMethod = createNodeForExtentReport(logReport, "Check Input 4 connection number");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, " Verify URL is contains number ");
        Assert.assertTrue(salesTopAction.IsURLIsContainsNumber(connectionNumber));
    }
    @Test(priority = 28)
    public void ConnectionNumber_TC_02() throws IOException {
        logReport = logReport.assignCategory("Check Sale can join room call");
        logMethod = createNodeForExtentReport(logReport, "Check Sale can join room call");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, " Verify 2 form user");
        Assert.assertEquals(salesLightAction.countUserConnect(),2);
    }
    @Test(priority = 29)
    public void WhenEnteringTheRoomHost_TC_01() throws IOException {
        logReport = logReport.assignCategory("Check When entering the room (host)");
        logMethod = createNodeForExtentReport(logReport, "Check Device selection POPUP Show");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Input 4 connection number");
        salesTopAction.inputFirstDigitConnectNumber(connectionNumber);
        salesTopAction.inputSecondDigitConnectNumber(connectionNumber);
        salesTopAction.inputThirdDigitConnectNumber(connectionNumber);
        salesTopAction.inputFourDigitConnectNumber(connectionNumber);
        logStep = logStepInfo(logMethod, " Click on Join button");
        salesTopAction.clickOnJoinButton();
        logStep = logStepInfo(logMethod, " Check popup device selection show");
        Assert.assertTrue(salesLightAction.isDeviceSelection());
    }
    @Test(priority = 30)
    public void WhenEnteringTheRoomHost_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Notification Show");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, " Switch tab 1");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, " Message \"企業ユーザーが入室しました\" display");
        Assert.assertTrue(salesLightAction.doesMessageDisplay("企業ユーザーが入室しました"));
    }
    @Test(priority = 31)
    public void WhenEnteringTheRoomHost_TC_03() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Setting Device selection");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, " Click Setting Device icon ");
        salesLightAction.clickOnSettingDeviceIcon();
        logStep = logStepInfo(logMethod, " Check popup device selection show");
        Assert.assertTrue(salesLightAction.isDeviceSelection());
    }
    @Test(priority = 32)
    public void ProfileHost_TC_01() throws IOException {
        logReport = logReport.assignCategory("Confirm Profile Host");
        logMethod = createNodeForExtentReport(logReport, "Check ON Profile Host");
        logMethod = createNodeForExtentReport(logReport, "Open sales light");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
        switchTabWindowIndex(driver, "tab2");
        logStep = logStepInfo(logMethod, "Click ON camera sale");
        salesTopAction.clickCameraSaleSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON micro host");
        salesTopAction.clickMicHostSetting("ON");
        logStep = logStepInfo(logMethod, "Click ON profile host");
        salesTopAction.clickPostProfileSetting("ON");
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
        switchTabWindowIndex(driver,"tab1");
        logStep = logStepInfo(logMethod, " Click on キャンセル button");
        salesLightAction.clickOnCancelDeviceConfirmGuest();
        logStep = logStepInfo(logMethod, "Profile form  show 担当者のプロフィールを提示 ");
        Assert.assertTrue(salesLightAction.isProfileHostDisplay(true));
    }

    @Test(priority = 33)
    public void ProfileHost_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Detail View Profile Host");
        logMethod = createNodeForExtentReport(logReport, "Open sales light");
        logStep = logStepInfo(logMethod, "Open sales light tab 1");
        closeTabWindowIndex(driver,"tab3");
        logStep = logStepInfo(logMethod, "Open saleslight menu");
        switchTabWindowIndex(driver, "tab2");
        openUrl(driver,URLSalesLightMenu);
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
        logStep = logStepInfo(logMethod, "Click on Close Popup");
        salesTopAction.clickCloseProfile();
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);
        logStep = logStepInfo(logMethod, "Get Connection number");
        connectionNumber = salesTopAction.getConnectionNumber();
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
        logStep = logStepInfo(logMethod, " Switch tab 1");
        switchTabWindowIndex(driver,"tab1");
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
