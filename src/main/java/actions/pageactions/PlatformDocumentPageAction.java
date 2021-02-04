package actions.pageactions;

import actions.commons.AbstractPages;
import com.aventstack.extentreports.ExtentTest;
import interfaces.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;


public class PlatformDocumentPageAction extends AbstractPages {
    public WebDriver driver;
    public PlatformDocumentPageAction(WebDriver driver){this.driver=driver;
    }
    public void clickbtnMeetingSale (){
        waitForElement(driver, PlatformDocumentPageUI.btnMeetingSale,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnMeetingSale);
        sleep(2);
    }
    public void clickbtnDocument (){
        waitForElement(driver, PlatformDocumentPageUI.btnDocument,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnDocument);
        sleep(2);
    }

    public void clickbtnDocumentPreview (String nameDocument){
        waitForElement(driver, PlatformDocumentPageUI.btnDocumentPreview,10,nameDocument);
        clickToElement(driver, PlatformDocumentPageUI.btnDocumentPreview,nameDocument);
        sleep(2);
        switchOtherWindow(driver);
    }
    public void inputTxtSearchByName (String searchByName, ExtentTest logStep){
        waitForElement(driver, PlatformDocumentPageUI.txtSearchByName,10);
        clickToElement(driver, PlatformDocumentPageUI.txtSearchByName);
        sleep(2);
        sendKeyToElement(driver, PlatformDocumentPageUI.txtSearchByName,searchByName);
        driver.findElement(By.xpath(PlatformDocumentPageUI.txtSearchByName)).sendKeys(Keys.ENTER);
    }
    public void inputSearchByTime(String searchbyTime, ExtentTest logStep){
        waitForElement(driver, PlatformDocumentPageUI.txtSearchByTime,10);
        clickToElement(driver, PlatformDocumentPageUI.txtSearchByTime);
        driver.findElement(By.xpath(PlatformDocumentPageUI.txtSearchByTime)).sendKeys(Keys.ENTER);
        sleep(2);
    }
    public String getTextFromDocumentList (){
        waitForElement(driver, PlatformDocumentPageUI.resultSearch,10);
        return getTextElementByXpath(driver, PlatformDocumentPageUI.resultSearch);
    }
    public void clickBtnEdit (){
        waitForElement(driver, PlatformDocumentPageUI.btnEditDocument,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnEditDocument);
        sleep(2);
    }
    public void getEditDocumentPopup (){
        Assert.assertTrue(isElementDisplay(driver, PlatformDocumentPageUI.lblEditDocument));

    }
    public void clickBtnOnPassword () {
        waitForElement(driver, PlatformDocumentPageUI.btnOnDownload,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnOnDownload);
        sleep(2);

    }
    public void clickBtnOffPassword () {
        waitForElement(driver, PlatformDocumentPageUI.btnOffDownload,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnOffDownload);
        sleep(2);

    }
    public void clickBtnSubmitUploadDocument () {
        waitForElement(driver, PlatformDocumentPageUI.btnSubmitUploadDocument,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnSubmitUploadDocument);
        sleep(15);

    }

    public void clickBtnDeleteTalkscript (){
        waitForElement(driver, PlatformDocumentPageUI.btnDeleteTalkscript,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnDeleteTalkscript);
        sleep(2);

    }
    public void clickBtnUpload (){
        waitForElement(driver, PlatformDocumentPageUI.btnUpload,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnUpload);
        sleep(2);
    }
    public boolean showUploadPopup (){

        return isElementDisplay(driver, PlatformDocumentPageUI.btnUpload);
    }
    public void clickBtnUploadDocument (){
        waitForElement(driver, PlatformDocumentPageUI.btnUploadDocument,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnUploadDocument);
        sleep(2);
    }

    /**
     * Select file PDF
     */
    public void selectFileDocument(String documentName){
        String OS = System.getProperty("os.name").toLowerCase();
        boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
        if(IS_WINDOWS) {
            final String dir1 = System.getProperty("user.dir");
            String pathFile = new File(dir1.concat("\\src\\test\\java\\testdata\\" + documentName)).getAbsolutePath();
            driver.findElement(By.xpath(PlatformDocumentPageUI.fileDocumentpdf)).sendKeys(pathFile);
        }else {
            final String dir1 = System.getProperty("user.dir");
            String pathFile = new File(dir1.concat("/src/test/java/testdata/" + documentName)).getAbsolutePath();
            driver.findElement(By.xpath(PlatformDocumentPageUI.fileDocumentpdf)).sendKeys(pathFile);
        }
    }
    public void selectFileTalkscript(String talkscriptName){
        String OS = System.getProperty("os.name").toLowerCase();
        boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
        if(IS_WINDOWS) {
            final String dir1 = System.getProperty("user.dir");
            String pathFile = new File(dir1.concat("\\src\\test\\java\\testdata\\" + talkscriptName)).getAbsolutePath();
            driver.findElement(By.xpath(PlatformDocumentPageUI.fileTalksciprt)).sendKeys(pathFile);
        }else {
            final String dir1 = System.getProperty("user.dir");
            String pathFile = new File(dir1.concat("/src/test/java/testdata/" + talkscriptName)).getAbsolutePath();
            driver.findElement(By.xpath(PlatformDocumentPageUI.fileTalksciprt)).sendKeys(pathFile);
        }
    }

    public void clickBtnUploadTalkScript (){
        waitForElement(driver, PlatformDocumentPageUI.btnUploadTalkScript,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnUploadTalkScript);
        sleep(2);
    }
    public void selectFolder (String folderName){
        waitForElement(driver, PlatformDocumentPageUI.selectFolder,10);
        sleep(2);
        Select drpFolder = new Select(driver.findElement(By.xpath(PlatformDocumentPageUI.selectFolder)));
        drpFolder.selectByVisibleText(folderName);

    }
    public void clickBtnSubmitToSaveSetting (){
        waitForElement(driver, PlatformDocumentPageUI.btnSubmitToSaveSetting,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnSubmitToSaveSetting);

    }
    public void clickBtnPassword (){
        waitForElement(driver, PlatformDocumentPageUI.btnPassword,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnPassword);
        sleep(2);
    }
    public void inputDocumentPassword (String documentPassword){
        waitForElement(driver, PlatformDocumentPageUI.txtPassword,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.txtPassword);
        sleep(2);
        sendKeyToElement(driver, PlatformDocumentPageUI.txtPassword,documentPassword);
        sleep(2);

    }
    public boolean isDocumentFile (String nameFile){
        waitForElementNotDisplay(driver, PlatformDocumentPageUI.uploadProcess,10);
        waitForElement(driver, PlatformDocumentPageUI.fileDocument,10,nameFile);
        return isControlDisplayed(driver, PlatformDocumentPageUI.fileDocument,nameFile);
    }
    public void clickBtnDeleteDocument (){
        waitForElement(driver, PlatformDocumentPageUI.btnDeleteDocument,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnDeleteDocument);
        sleep(2);
    }

    /**
     * delete all file document
     */
    public void deleteAllFileName(String nameFile){
        waitForElement(driver, PlatformDocumentPageUI.btnDeleteFileName,10,nameFile);
        int numberElement = countElementsNumber(driver, PlatformDocumentPageUI.btnDeleteFileName,nameFile);
        if(numberElement>0){
            while (numberElement!=0) {
                clickToElement(driver, PlatformDocumentPageUI.btnDeleteFileName, nameFile);
                clickBtnSubmitToDeleteDocument();
                sleep(3);
                numberElement = countElementsNumber(driver, PlatformDocumentPageUI.btnDeleteFileName, nameFile);
            }
        }

    }
    public void clickBtnSubmitToDeleteDocument (){
        waitForElement(driver,PlatformDocumentPageUI.btnSubmitDeleteDocument,10);
        sleep(4);
        clickToElement(driver,PlatformDocumentPageUI.btnSubmitDeleteDocument);

    }
    public void clickBtnCreateFolder (){
        waitForElement(driver, PlatformDocumentPageUI.btnCreateFolder,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnCreateFolder);
        sleep(2);
    }
    public void getLblCreateFolder (){

        Assert.assertTrue(isElementDisplay(driver, PlatformDocumentPageUI.lblCreateFolder));
    }
    public void inputFolderName (String folderName){
        waitForElement(driver, PlatformDocumentPageUI.txtFolderName,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.txtFolderName);
        sleep(2);
        sendKeyToElement(driver, PlatformDocumentPageUI.txtFolderName,folderName);
        sleep(2);
    }
    public void clickBtnDeleteFolder () {
        waitForElement(driver, PlatformDocumentPageUI.btnDeleteFolder,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnDeleteFolder);
        sleep(2);

    }
    public void clickBtnSubmitToDeleteFolder () {
        waitForElement(driver, PlatformDocumentPageUI.btnSubmitToDeleteFolder,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnSubmitToDeleteFolder);
        sleep(2);

    }

    public void clickBtnSubmitToCreateFolder (){
        waitForElement(driver, PlatformDocumentPageUI.btnSubmitToCreateFolder,10);
        sleep(2);
        clickToElement(driver, PlatformDocumentPageUI.btnSubmitToCreateFolder);
        sleep(2);
    }
    public void isSettingSave (){
        Assert.assertTrue(isElementDisplay(driver, PlatformDocumentPageUI.lblEditSuccessfully));

    }

}
