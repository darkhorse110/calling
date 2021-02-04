package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import interfaces.PlatformDocumentPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static actions.commons.ReportListener.*;

public class PlatformDocumentPage extends AbstractPages {
    public WebDriver driver;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public SignInAction signInAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public PlatformDocumentPageAction platformDocumentPageAction;
    public String urlDocument;
    private String urlOpenDocument;
    public String documentName = "document";
    public String folderName = "folder"+currentTime();

    @Parameters({"browser"})
    @BeforeClass
    public void String (String browserName) {
        logClass = createTestForExtentReport(extent, "Test suit for Plat form document screen");
        logClass = createNodeForExtentReport(logClass, "Initial Setup successful");
        driver = getBrowser(browserName);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        workSpaceHomeAction = PageGeneratorManager.getWorkSpaceHomeAction(driver);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        platformDocumentPageAction = PageGeneratorManager.getDocumentPageAction(driver);
    }
    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logReport = logReport.assignCategory("Pre-Select Workspace and login success");
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
    public void PlatformDocument_TC_ID_11_CreateFolder () {
        openUrl(driver, urlDocument);
        platformDocumentPageAction.deleteAllFileName(documentName);
        logMethod = createNodeForExtentReport(logReport, "Click create folder button");
        platformDocumentPageAction.clickBtnCreateFolder();
        logMethod = createNodeForExtentReport(logReport, "Show label Create Folder");
        //platformDocumentPageAction.getLblCreateFolder();
        logMethod = createNodeForExtentReport(logReport, "Input Folder Name");
        platformDocumentPageAction.inputFolderName(folderName);
        logMethod = createNodeForExtentReport(logReport, "Click Submit button in Create Folder pop-up ");
        platformDocumentPageAction.clickBtnSubmitToCreateFolder();
        logMethod = createNodeForExtentReport(logReport, "Verify show lbl Create Folder successfully ");
        Assert.assertTrue(isElementDisplay(driver, PlatformDocumentPageUI.lblCreateFolderSuccessful));
    }

    @Test(priority = 2)
    public void PlatformDocument_TC_ID_04_UploadDocument () {
        logMethod = createNodeForExtentReport(logReport, "Upload Document");
        openUrl(driver, urlDocument);
        logStep = createNodeForExtentReport(logMethod, "Click Upload button");
        platformDocumentPageAction.clickBtnUpload();
        logStep = createNodeForExtentReport(logMethod, "Show Upload pop-up");
        //Assert.assertTrue(platformDocumentPageAction.showUploadPopup());
        logStep = createNodeForExtentReport(logMethod, "Select file PDF");
        platformDocumentPageAction.selectFileDocument("document.pdf");
        logStep = createNodeForExtentReport(logMethod, "Click Submit to upload document");
        platformDocumentPageAction.clickBtnSubmitUploadDocument();
        logStep = createNodeForExtentReport(logMethod, "Verify document is upload successfully");
        Assert.assertTrue(platformDocumentPageAction.isDocumentFile(documentName));

    }
    @Test(priority = 3)
    public void PlatformDocument_TC_ID_05_UploadDocumentWithTalkscript (){
        openUrl(driver,urlDocument);
        logMethod = createNodeForExtentReport(logReport, "Click Upload button");
        platformDocumentPageAction.clickBtnUpload();
        logStep = createNodeForExtentReport(logMethod, "Select file PDF");
        platformDocumentPageAction.selectFileDocument("document.pdf");
        logStep = createNodeForExtentReport(logMethod, "Select file Talk script");
        platformDocumentPageAction.selectFileTalkscript("talkscript.pdf");
        logMethod = createNodeForExtentReport(logReport, "Click Submit button");
        platformDocumentPageAction.clickBtnSubmitUploadDocument();
        logStep = createNodeForExtentReport(logMethod, "Verify document is upload successfully");
        Assert.assertTrue(platformDocumentPageAction.isDocumentFile(documentName));

    }
    @Test(priority = 4)
    public void PlatformDocument_TC_ID_06_UploadDocumentInFolder (){
        openUrl(driver,urlDocument);
        logMethod = createNodeForExtentReport(logReport, "Click Upload button");
        platformDocumentPageAction.clickBtnUpload();
        logStep = createNodeForExtentReport(logMethod, "Select file PDF");
        platformDocumentPageAction.selectFileDocument("document.pdf");
        logStep = createNodeForExtentReport(logMethod, "Select file Talk script");
        platformDocumentPageAction.selectFileTalkscript("talkscript.pdf");
        logMethod = createNodeForExtentReport(logReport, "Select folder");
        platformDocumentPageAction.selectFolder(folderName);
        logMethod = createNodeForExtentReport(logReport, "Click Submit button");
        platformDocumentPageAction.clickBtnSubmitUploadDocument();
        logStep = createNodeForExtentReport(logMethod, "Verify document is upload successfully");
        Assert.assertTrue(platformDocumentPageAction.isDocumentFile(documentName));
    }

    @Test(priority = 5)
    public void PlatformDocument_TC_ID_07_UploadDocumentWithPassword (){
        openUrl(driver,urlDocument);
        logMethod = createNodeForExtentReport(logReport, "Click Upload button");
        platformDocumentPageAction.clickBtnUpload();
        logStep = createNodeForExtentReport(logMethod, "Select file PDF");
        platformDocumentPageAction.selectFileDocument("document.pdf");
        logStep = createNodeForExtentReport(logMethod, "Select file Talk script");
        platformDocumentPageAction.selectFileTalkscript("talkscript.pdf");
        logMethod = createNodeForExtentReport(logReport, "Turn on Password button");
        platformDocumentPageAction.clickBtnPassword();
        logMethod = createNodeForExtentReport(logReport, "Input password");
        platformDocumentPageAction.inputDocumentPassword("123456");
        logMethod = createNodeForExtentReport(logReport, "Click Submit button");
        platformDocumentPageAction.clickBtnSubmitUploadDocument();
        logStep = createNodeForExtentReport(logMethod, "Verify document is upload successfully");
        Assert.assertTrue(platformDocumentPageAction.isDocumentFile(documentName));

    }

    @Test(priority = 6)
    public void PlatformDocument_TC_ID_01_OpenDocumentOnNewTab (){
        logReport = logReport.assignCategory("Check Document");
        logMethod = createNodeForExtentReport(logReport, "List of documents");
        openUrl(driver,urlDocument);
        logStep = createNodeForExtentReport(logMethod, "Click Document Preview button");
        platformDocumentPageAction.clickbtnDocumentPreview(documentName);
        logStep = createNodeForExtentReport(logMethod, "Verify url Document Preview");
        switchTabWindowIndex(driver,"tab2");
        urlOpenDocument = getCurrentUrl(driver);
        Assert.assertTrue(urlOpenDocument.contains("calling.fun/document-preview/"));
    }

    @Test(priority = 7)
    public void PlatformDocument_TC_ID_02_SearchByName () {
        logMethod = createNodeForExtentReport(logReport, "Search By Name");
        openUrl(driver,urlDocument);
        logStep = createNodeForExtentReport(logMethod, "Input content into search textField");
        platformDocumentPageAction.inputTxtSearchByName("document",logStep);
        logStep = createNodeForExtentReport(logMethod, "Verify Document in Document List");
        Assert.assertEquals(platformDocumentPageAction.getTextFromDocumentList(),documentName);
    }

    @Test(priority = 8)
    public void PlatformDocument_TC_ID_03_SearchByTime () {
        logMethod = createNodeForExtentReport(logReport, "Search By Time");
        openUrl(driver,urlDocument);
        logStep = createNodeForExtentReport(logMethod, "Select time to search");
        platformDocumentPageAction.inputSearchByTime("2020-02-24",logStep);
        logStep = createNodeForExtentReport(logMethod, "Verify Document in Document List");
        Assert.assertEquals(platformDocumentPageAction.getTextFromDocumentList(),documentName);

    }

    @Test(priority = 9)
    public void PlatformDocument_TC_ID_08_TurnOn_TurnOff_Download_Button () {
        openUrl(driver,urlDocument);
        logMethod = createNodeForExtentReport(logReport, "Click Edit button");
        platformDocumentPageAction.clickBtnEdit();
        logMethod = createNodeForExtentReport(logReport, "Verify Edit Document pop-up is displayed");
        platformDocumentPageAction.getEditDocumentPopup();
        logMethod = createNodeForExtentReport(logReport, "Turn On download button");
        platformDocumentPageAction.clickBtnOnPassword();
        logMethod = createNodeForExtentReport(logReport, "Click Submit button");
        platformDocumentPageAction.clickBtnSubmitToSaveSetting();
        logMethod = createNodeForExtentReport(logReport, "Verify Setting is saved");
        platformDocumentPageAction.isSettingSave();
        logMethod = createNodeForExtentReport(logReport, "Click Edit button");
        platformDocumentPageAction.clickBtnEdit();
        logMethod = createNodeForExtentReport(logReport, "Verify Edit Document pop-up is displayed");
        //platformDocumentPageAction.getEditDocumentPopup();
        logMethod = createNodeForExtentReport(logReport, "Turn Off download button");
        platformDocumentPageAction.clickBtnOffPassword();
        logMethod = createNodeForExtentReport(logReport, "Click Submit button");
        platformDocumentPageAction.clickBtnSubmitToSaveSetting();
        logMethod = createNodeForExtentReport(logReport, "Verify Setting is saved");
        Assert.assertTrue(isElementDisplay(driver, PlatformDocumentPageUI.lblEditSuccessfully));
    }
    @Test(priority = 10)
    public void PlatformDocument_TC_ID_09_DeleteTalkscript () {
        openUrl(driver,urlDocument);
        logMethod = createNodeForExtentReport(logReport, "Click Edit button");
        platformDocumentPageAction.clickBtnEdit();
        logMethod = createNodeForExtentReport(logReport, "Verify Edit Document pop-up is displayed");
        //platformDocumentPageAction.getEditDocumentPopup();
        logMethod = createNodeForExtentReport(logReport, "Click Delete Talkscript");
        platformDocumentPageAction.clickBtnDeleteTalkscript();
        logMethod = createNodeForExtentReport(logReport, "Click Submit button");
        platformDocumentPageAction.clickBtnSubmitToSaveSetting();
        logMethod = createNodeForExtentReport(logReport, "Verify Setting is saved");
        Assert.assertTrue(isElementDisplay(driver, PlatformDocumentPageUI.lblEditSuccessfully));

    }

    @Test(priority = 11)
    public void PlatformDocument_TC_ID_10_DeleteDocument () {
        openUrl(driver,urlDocument);
        logMethod = createNodeForExtentReport(logReport, "Click delete document button");
        platformDocumentPageAction.clickBtnDeleteDocument();
        logMethod = createNodeForExtentReport(logReport, "Click Submit to Delete Document button");
        platformDocumentPageAction.clickBtnSubmitToDeleteDocument();
        logMethod = createNodeForExtentReport(logReport, "Verify delete successfully");
        Assert.assertTrue(isElementDisplay(driver, PlatformDocumentPageUI.lblDeleteSuccessful));
    }

    @Test(priority = 12)
    public void PlatformDocument_TC_ID_11_DeleteFolder () {
        openUrl(driver, urlDocument);
        logMethod = createNodeForExtentReport(logReport, "Click delete folder button");
        platformDocumentPageAction.clickBtnDeleteFolder();
        logMethod = createNodeForExtentReport(logReport, "Click Submit btn to delete folder");
        platformDocumentPageAction.clickBtnSubmitToDeleteFolder();
        logMethod = createNodeForExtentReport(logReport, "Verify Delete Folder successfully");
        Assert.assertTrue(isElementDisplay(driver, PlatformDocumentPageUI.lblDeleteSuccessful));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
