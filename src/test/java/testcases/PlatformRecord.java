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

public class PlatformRecord extends AbstractPages {
    private WebDriver driver;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public SalesTopAction salesTopAction;
    public TopPageAction topPageAction;
    public SalesLightAction salesLightAction;
    public PlatformRecordAction platformRecordAction;
    public SelectProfileAction selectProfileAction;
    public String URLSalesLightMenu = null;
    public String URLPlatformRecord = null;
    public String connectionNumber = null;
    public String getTimeRecord = null;
    public String getCurrentDateJapan = null;
    public String editTitleRecord = "Record"+currentTime();
    public String nameAccountLogin = null;
    public String ShareOFF = "OFF";
    public String ShareON = "ON";

    public String name = "name"+currentTime();
    public String message = "message"+currentTime();
    public String email = "email"+currentTime()+"@gmail.com";

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
        platformRecordAction = PageGeneratorManager.getPlatformRecordAction(driver);
        selectProfileAction = PageGeneratorManager.getSelectProfileAction(driver);

        logClass = createTestForExtentReport(extent, "Test suit for Platform Record screen");
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
        logStep = logStepInfo(logMethod, "Input user nam and password");
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD,logStep);

        logStep = logStepInfo(logMethod, "Get Account Login");
        selectProfileAction.clickProfileIcon();
        selectProfileAction.clickProfileLink();
        nameAccountLogin = selectProfileAction.getNameAccoutnLogin();

        logStep = logStepInfo(logMethod, "Click Meeting Button");
        topPageAction.clickHomeButton();
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

        logStep = logStepInfo(logMethod, " Click Ok Device");
        salesLightAction.clickOnOKDeviceConfirm();

        logStep = logStepInfo(logMethod, " Switch tab 1");
        switchTabWindowIndex(driver,"tab1");
        refreshPage(driver);

        logStep = logStepInfo(logMethod, " Click on カメラをオンにする button");
        salesLightAction.clickOnTurnONCameraAndMicDeviceConfirmGuest();

        logStep = logStepInfo(logMethod, " Switch tab 3");
        switchTabWindowIndex(driver,"tab3");

        logStep = logStepInfo(logMethod, "Click on Start Record");
        salesLightAction.makeSureRecording();
        getTimeRecord = salesLightAction.getTimeRecord();

        logStep = logStepInfo(logMethod, "Wait for 20 second");
        sleep(20);

        logStep = logStepInfo(logMethod, "Click on Stop Record");
        salesLightAction.clickOnStopRecordIcon();
    }
    @Test(priority = 2)
    public void ListDisplay_TC_01() throws IOException {
        logReport = logReport.assignCategory("Platform Record");
        logMethod = createNodeForExtentReport(logReport, "Check List Record display");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        closeTabWindowIndex(driver,"tab3");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        openUrl(driver,URLSalesLightMenu);
        platformRecordAction.openMenuPlatformRecord();
        URLPlatformRecord = getCurrentUrl(driver);

        logStep = logStepInfo(logMethod, "Verify record displays");
        Assert.assertTrue(platformRecordAction.isRecordTitleDisplay(getTimeRecord));
    }
    @Test(priority = 3)
    public void DetailView_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Video playback");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFile(getTimeRecord);

        logStep = logStepInfo(logMethod, "Click play video");
        platformRecordAction.clickOnPlayVideo();

        logStep = logStepInfo(logMethod, "Check video play");
        Assert.assertTrue(platformRecordAction.isVideoPlay());
    }

    @Test(priority = 4)
    public void DetailView_TC_03() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Edit title");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFile(getTimeRecord);

        logStep = logStepInfo(logMethod, "Click edit title");
        platformRecordAction.clickEditTitleRecord();

        logStep = logStepInfo(logMethod, "Input title record");
        platformRecordAction.inputTitleRecordItem(editTitleRecord);

        logStep = logStepInfo(logMethod, "Click on Save title");
        platformRecordAction.clickOnSaveTitleRecordItem();

        logStep = logStepInfo(logMethod, "Click on Close popup video");
        platformRecordAction.clickOnCloseRecordItem();

        logStep = logStepInfo(logMethod, "Verify title show with Record_current date");
        Assert.assertTrue(platformRecordAction.isRecordTitleDisplay(editTitleRecord));
    }
    @Test(priority = 5)
    public void DetailView_TC_04() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Display of recording owner");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Verify recording owner");
        Assert.assertEquals(platformRecordAction.getOwnerRecord(editTitleRecord),nameAccountLogin);
    }

    @Test(priority = 6)
    public void DetailView_TC_05() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Display of recording room");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Verify recording room");
        Assert.assertEquals(platformRecordAction.getIDRooom(editTitleRecord),connectionNumber);
    }
    @Test(priority = 8)
    public void DetailView_TC_06() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check ON Share");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFile(editTitleRecord);

        logStep = logStepInfo(logMethod, "Select ON Share");
        platformRecordAction.selectShareRecord(ShareON);

        logStep = logStepInfo(logMethod, "Verify 1件の録画データを共有する show");
        Assert.assertTrue(platformRecordAction.isSharePersonPopup());

        logStep = logStepInfo(logMethod, "Click on close share person");
        platformRecordAction.clickCloseSharePerson();

        logStep = logStepInfo(logMethod, "Verify Button 共有 enable ");
        Assert.assertTrue(platformRecordAction.buttonShareEnable(true));
    }
    @Test(priority = 7)
    public void DetailView_TC_07() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check OFF Share");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFile(editTitleRecord);

        logStep = logStepInfo(logMethod, "Select OFF Share");
        platformRecordAction.selectShareRecord(ShareOFF);

        logStep = logStepInfo(logMethod, "Verify Button 共有 disable ");
        Assert.assertFalse(platformRecordAction.buttonShareEnable(false));
    }
    @Test(priority = 9)
    public void DetailView_TC_08() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Download");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFile(editTitleRecord);

        logStep = logStepInfo(logMethod, "Click on Download record");
        platformRecordAction.clickOnDownload1Record();

        logStep = createNodeForExtentReport(logReport, "Check download file success");
        Assert.assertTrue(isFileExists(editTitleRecord+".mp4"));

    }
    @Test(priority = 10)
    public void DetailView_TC_09() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Shared link");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFile(editTitleRecord);

        logStep = logStepInfo(logMethod, "Select ON Share");
        platformRecordAction.selectShareRecord(ShareON);

        logStep = logStepInfo(logMethod, "Click on Share link");
        platformRecordAction.clickShareLink();

        logStep = logStepInfo(logMethod, "Verify Title Record item in share link ");
        Assert.assertTrue(platformRecordAction.isRecordTitleDisplayShareLink(editTitleRecord));
    }
    @Test(priority = 11)
    public void DetailView_TC_11() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check search by name");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Input search by name record");
        platformRecordAction.inputSearchByName(editTitleRecord);

        logStep = logStepInfo(logMethod, "Verify title show with Record_current date");
        Assert.assertTrue(platformRecordAction.isRecordTitleDisplaySearch(editTitleRecord));
    }
    @Test(priority = 12)
    public void DetailView_TC_12() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check search by date from");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Input search by current date");
        getCurrentDateJapan = SalesLightAction.getCurrentDateJapan();
        platformRecordAction.inputSearchByFrom(getCurrentDateJapan);

        logStep = logStepInfo(logMethod, "Verify title show with Record_current date");
        Assert.assertTrue(platformRecordAction.isRecordTitleDisplaySearch(editTitleRecord));
    }
    @Test(priority = 13)
    public void DetailView_TC_13() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Basic sharing settings");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Click on 基本の共有設定 button ");
        platformRecordAction.clickOnBasicSharingSettings();

        logStep = logStepInfo(logMethod, "Select first User");
        platformRecordAction.selectFirstUserShare();

        logStep = logStepInfo(logMethod, "Click on 共有する");
        platformRecordAction.clickOnSaveBasicSharingSettings();

        logStep = logStepInfo(logMethod, "Verify message save success");
        Assert.assertTrue(platformRecordAction.doesMessageSaveSuccess("共有設定を変更しました"));
    }

    @Test(priority = 14)
    public void DetailView_TC_14() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Sharing (multiple selection)");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Check すべて選択 ");
        platformRecordAction.clickOnSelectAllCheckBox();

        logStep = logStepInfo(logMethod, "Click on 録画データを共有する");
        platformRecordAction.clickOnShareAllRecord();

        logStep = logStepInfo(logMethod, "Select User share video");
        platformRecordAction.selectUserShareRecord(Constants.EMAIL_FULLPERMISSION);

        logStep = logStepInfo(logMethod, "Click on 共有する");
        platformRecordAction.clickOnShareRecordForUser();

        logStep = logStepInfo(logMethod, "Verify message save success");
        Assert.assertTrue(platformRecordAction.doesMessageSaveSuccess("録画データの共有が完了しました"));
    }
    @Test(priority = 15)
    public void DetailView_TC_15() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Sharing (multiple selection)");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Check すべて選択 ");
        platformRecordAction.clickOnSelectAllCheckBox();

        logStep = logStepInfo(logMethod, "Click on 録画データを共有する");
        platformRecordAction.clickOnShareAllRecord();

        logStep = logStepInfo(logMethod, "Click ゲスト（スペース外のユーザー）");
        platformRecordAction.clickOnShareURLTab();

        logStep = logStepInfo(logMethod, "Click on 共有用のURLを発行する");
        platformRecordAction.clickOnShowURLButton();

        logStep = logStepInfo(logMethod, "Click on URLを");
        platformRecordAction.getURLShareRecord();

        logStep = logStepInfo(logMethod, "Open new tab with URL share record");
        openNewTab(driver,platformRecordAction.getURLShareRecord());

        logStep = logStepInfo(logMethod, "Verify Record title display");
        Assert.assertTrue(platformRecordAction.isRecordTitleDisplayShareManyRecord(editTitleRecord));
    }
    @Test(priority = 16)
    public void RecordingSharedURL_TC_01() throws IOException {
        logReport = logReport.assignCategory("Platform Record - Recording (shared URL)");
        logMethod = createNodeForExtentReport(logReport, "Check  List display");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Check すべて選択 ");
        platformRecordAction.clickOnSelectAllCheckBox();

        logStep = logStepInfo(logMethod, "Click on 録画データを共有する");
        platformRecordAction.clickOnShareAllRecord();

        logStep = logStepInfo(logMethod, "Click ゲスト（スペース外のユーザー）");
        platformRecordAction.clickOnShareURLTab();

        logStep = logStepInfo(logMethod, "Click on 共有用のURLを発行する");
        platformRecordAction.clickOnShowURLButton();

        logStep = logStepInfo(logMethod, "Click on URLを");
        platformRecordAction.getURLShareRecord();

        logStep = logStepInfo(logMethod, "Open new tab with URL share record");
        openNewTab(driver,platformRecordAction.getURLShareRecord());

        logStep = logStepInfo(logMethod, "Verify Record title display");
        Assert.assertTrue(platformRecordAction.isRecordTitleDisplayShareManyRecord(editTitleRecord));
    }
    @Test(priority = 17)
    public void RecordingSharedURL_TC_02() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Details Video playback");
        logStep = logStepInfo(logMethod, "Refresh tab 2 with share record url");
        refreshPage(driver);
        switchTabWindowIndex(driver,"tab2");

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFileShare(editTitleRecord);

        logStep = logStepInfo(logMethod, "Click play video");
        platformRecordAction.clickOnPlayVideo();

        logStep = logStepInfo(logMethod, "Check video play");
        Assert.assertTrue(platformRecordAction.isVideoPlay());
    }
    @Test(priority = 18)
    public void RecordingSharedURL_TC_03() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Display of recording owner");
        logStep = logStepInfo(logMethod, "Refresh tab 2 with share record url");
        refreshPage(driver);
        switchTabWindowIndex(driver,"tab2");

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFileShare(editTitleRecord);

        logStep = logStepInfo(logMethod, "Check Display of recording owner");
        Assert.assertEquals(platformRecordAction.getOwnerRecordShare(),nameAccountLogin);
    }
    @Test(priority = 19)
    public void RecordingSharedURL_TC_04() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Display of recording room");
        logStep = logStepInfo(logMethod, "Refresh tab 2 with share record url");
        refreshPage(driver);
        switchTabWindowIndex(driver,"tab2");

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFileShare(editTitleRecord);

        logStep = logStepInfo(logMethod, "Check Display of recording room");
        Assert.assertEquals(platformRecordAction.getIDRooomShare(),connectionNumber);
    }

    @Test(priority = 20)
    public void RecordingSharedURL_TC_05() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Download Record");
        logStep = logStepInfo(logMethod, "Refresh tab 2 with share record url");
        refreshPage(driver);
        switchTabWindowIndex(driver,"tab2");

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFileShare(editTitleRecord);

        logStep = logStepInfo(logMethod, "Click on Download Record file");
        platformRecordAction.clickOnDownload1Record();

        logStep = logStepInfo(logMethod, "Check Display of recording room");
        Assert.assertTrue(isFileExists(editTitleRecord+".mp4"));
    }
    @Test(priority = 21)
    public void DetailView_TC_10() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Delete record");
        logStep = logStepInfo(logMethod, "Open Platform Record page");
        switchTabWindowIndex(driver,"tab1");
        openUrl(driver,URLPlatformRecord);

        logStep = logStepInfo(logMethod, "Click on Record file");
        platformRecordAction.clickOnRecordFile(editTitleRecord);

        logStep = logStepInfo(logMethod, "Click on Delete button");
        platformRecordAction.clickOnDelete1Record();

        logStep = logStepInfo(logMethod, "Click on confirm Delete button");
        platformRecordAction.clickOnConfirmDelete1Record();

        logStep = logStepInfo(logMethod, "Verify delete title show with Record_current date");
        Assert.assertFalse(platformRecordAction.isRecordTitleDisplay(editTitleRecord));
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
