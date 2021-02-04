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

public class Platform_DocumentPagePreview extends AbstractPages {
    public WebDriver driver;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public SignInAction signInAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public PlatformDocumentPageAction platformDocumentPageAction;
    public PlatformPreviewDocumentPageAction platformPreviewDocumentPageAction;
    public TopPageAction topAction;
    public String urlDocument;
    private String urlCopyPreview = null;
    public String nameDocument ="document(no remove)";
    public String pageNumberDocument ="(1 / 2)";
    @Parameters({"browser"})
    @BeforeClass
    public void String (String browserName) {
        logClass = createTestForExtentReport(extent, "Test suit for Check plat form preview document screen");
        logClass = createNodeForExtentReport(logClass, "Initial Setup successful");
        driver = getBrowser(browserName);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        workSpaceHomeAction = PageGeneratorManager.getWorkSpaceHomeAction(driver);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        platformDocumentPageAction = PageGeneratorManager.getDocumentPageAction(driver);
        platformPreviewDocumentPageAction = PageGeneratorManager.getPlatformPreviewDocumentPageAction(driver);
        topAction = PageGeneratorManager.getTopPageAction(driver);
    }
    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logStep = logStepInfo(logMethod, "Login Successfully");
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD, logStep);
        logMethod = createNodeForExtentReport(logReport, "Click Sale-Meeting button");
        platformDocumentPageAction.clickbtnMeetingSale();
        logMethod = createNodeForExtentReport(logReport, "Click Document button");
        platformDocumentPageAction.clickbtnDocument();
        urlDocument = getCurrentUrl(driver);
    }
    @Test(priority = 1)
    public void PreviewDocument_TC_ID_01_DisplayDocumentOnNewTab (){
        logReport = logReport.assignCategory("Check Display preview document");
        logMethod = createNodeForExtentReport(logReport, "Check Display preview document");
        logStep = createNodeForExtentReport(logReport, "Open Document page");
        openUrl(driver,urlDocument);
        logMethod = createNodeForExtentReport(logReport, "Verify name Document Preview");
        platformDocumentPageAction.clickbtnDocumentPreview(nameDocument);
        logMethod = createNodeForExtentReport(logReport, "Verify Document Preview Display");
        Assert.assertTrue(platformPreviewDocumentPageAction.isNameDocument(nameDocument));
    }
    @Test(priority = 2)
    public void PreviewDocument_TC_ID_02_DisplayDocumentName (){
        logReport = logReport.assignCategory("Check Display Name preview document");
        logMethod = createNodeForExtentReport(logReport, "Check Display Name preview document");
        logStep = createNodeForExtentReport(logReport, "Open Document page");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        logStep = createNodeForExtentReport(logReport, "Click Document Preview button");
        platformDocumentPageAction.clickbtnDocumentPreview(nameDocument);
        logMethod = createNodeForExtentReport(logReport, "Verify Name Document Preview Display");
        Assert.assertTrue(platformPreviewDocumentPageAction.isNameDocument(nameDocument));
        logMethod = createNodeForExtentReport(logReport, "Verify Number Page Document Preview Display");
        Assert.assertTrue(platformPreviewDocumentPageAction.isPageNumberDocument(pageNumberDocument));
    }
    @Test(priority = 3)
    public void PreviewDocument_TC_ID_03_ThumbnailView (){
        logReport = logReport.assignCategory("Check Thumbnail view preview document");
        logMethod = createNodeForExtentReport(logReport, "Check Thumbnail view preview document");
        logStep = createNodeForExtentReport(logReport, "Open Document page");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        logStep = createNodeForExtentReport(logReport, "Click Document Preview button");
        platformDocumentPageAction.clickbtnDocumentPreview(nameDocument);
        logStep = createNodeForExtentReport(logReport, "Click Thumbnail view button");
        platformPreviewDocumentPageAction.clickThumbnailViewMenu();
        logMethod = createNodeForExtentReport(logReport, "Verify Thumbnail view Document Preview Show");
        Assert.assertTrue(platformPreviewDocumentPageAction.isThumbnailMenuShow());
    }
    @Test(priority = 4)
    public void PreviewDocument_TC_ID_04_CopyURLPreviewDocument (){
        logReport = logReport.assignCategory("Check Copy URL Preview document");
        logMethod = createNodeForExtentReport(logReport, "Check Copy URL Preview document");
        logStep = createNodeForExtentReport(logReport, "Open Document page");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        logStep = createNodeForExtentReport(logReport, "Click Document Preview button");
        platformDocumentPageAction.clickbtnDocumentPreview(nameDocument);
        logStep = createNodeForExtentReport(logReport, "Hold the cursor on Share button");
        platformPreviewDocumentPageAction.holdShareButton();
        logStep = createNodeForExtentReport(logReport, "Click on Copy URL button");
        platformPreviewDocumentPageAction.clickCopyURLButton();
        logMethod = createNodeForExtentReport(logReport, "Verify Copy URL success message");
        Assert.assertEquals(platformPreviewDocumentPageAction.getCopyURLSuccess(),"URLをコピーしました");
        logStep = createNodeForExtentReport(logReport, "Open new tab");
        urlCopyPreview = platformPreviewDocumentPageAction.getURLPreview();
        openNewTab(driver,urlCopyPreview);
        logMethod = createNodeForExtentReport(logReport, "Verify name Document Preview");
        Assert.assertTrue(platformPreviewDocumentPageAction.isNameDocument(nameDocument));
    }

    @Test(priority = 5)
    public void PreviewDocument_TC_ID_06_DownloadFile (){
        logReport = logReport.assignCategory("Check Download File document");
        logMethod = createNodeForExtentReport(logReport, "Check Download File document");
        logStep = createNodeForExtentReport(logReport, "Open Document page");
        closeTabWindowIndex(driver,"tab3");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        logStep = createNodeForExtentReport(logReport, "Click Document Preview button");
        platformDocumentPageAction.clickbtnDocumentPreview(nameDocument);
        logStep = createNodeForExtentReport(logReport, "Click on download file");
        platformPreviewDocumentPageAction.clickDownLoadFile();
        logStep = createNodeForExtentReport(logReport, "Check download file success");
        Assert.assertTrue(isFileExists(nameDocument));
    }
    @Test(priority = 6)
    public void PreviewDocument_TC_ID_09_ProfileDisplay (){
        logReport = logReport.assignCategory("Check Download File document");
        logMethod = createNodeForExtentReport(logReport, "Check Download File document");
        logStep = createNodeForExtentReport(logReport, "Open Document page");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        logStep = createNodeForExtentReport(logReport, "Click Document Preview button");
        platformDocumentPageAction.clickbtnDocumentPreview(nameDocument);
        logStep = createNodeForExtentReport(logReport, "Click on profile user");
        String UserName = platformPreviewDocumentPageAction.getUserNameInPreview();
        platformPreviewDocumentPageAction.clickProfileUser();
        logStep = createNodeForExtentReport(logReport, "Check url Profile user opened");
        Assert.assertTrue(getCurrentUrl(driver).contains("user-profile"));
        logStep = createNodeForExtentReport(logReport, "Check Profile user name show");
        Assert.assertTrue(platformPreviewDocumentPageAction.isUserNameDisplay(UserName));
    }
    @Test(priority = 7)
    public void PreviewDocument_TC_ID_08_OwnerOpenDocument (){
        logReport = logReport.assignCategory("Check Owner Open Document");
        logMethod = createNodeForExtentReport(logReport, "Check Owner Open Document");
        logStep = createNodeForExtentReport(logReport,"Open Document page");
        closeTabWindowIndex(driver,"tab3");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        logStep = createNodeForExtentReport(logReport, "Open new tab");
        openNewTab(driver,urlCopyPreview);
        logMethod = createNodeForExtentReport(logReport, "Verify Password screen doesn't display");
        Assert.assertTrue(platformPreviewDocumentPageAction.isPageNumberDocument(pageNumberDocument));
    }
    @Test(priority = 8)
    public void PreviewDocument_TC_ID_09_AnotherUserOpenDocument (){
        logReport = logReport.assignCategory("Check Another User Open Document");
        logMethod = createNodeForExtentReport(logReport, "Check Another User Open Document");
        logStep = createNodeForExtentReport(logReport,"Open Document page");
        closeTabWindowIndex(driver,"tab2");
        switchTabWindowIndex(driver,"tab1");
        logStep = createNodeForExtentReport(logReport, "Log out");
        topAction.Logout(logReport);
        logStep = createNodeForExtentReport(logReport, "Open Document");
        openNewTab(driver,urlCopyPreview);
        logMethod = createNodeForExtentReport(logReport, "Verify Password screen display");
        Assert.assertTrue(platformPreviewDocumentPageAction.isPasswordPageShown());
        closeBrowser(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }


}
