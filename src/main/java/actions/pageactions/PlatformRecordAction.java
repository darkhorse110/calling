package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.InviteMemberPageUI;
import interfaces.PlatformRecordUI;
import interfaces.SalesTopUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class PlatformRecordAction extends AbstractPages {
    public WebDriver driver;
    public PlatformRecordAction(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * Open menu platform record
     */
    public void openMenuPlatformRecord(){
        sleep(10);
        waitForElement(driver, PlatformRecordUI.bntPlatFormRecord,30);
        clickToElement(driver, PlatformRecordUI.bntPlatFormRecord);
    }
    /**
     * is Record title display
     */
    public boolean isRecordTitleDisplay(String title){
        waitForElement(driver, PlatformRecordUI.lblTitleRecord,30,title);
        return isControlDisplayed(driver, PlatformRecordUI.lblTitleRecord,title);
    }

    /**
     * is Record title display search
     */
    public boolean isRecordTitleDisplaySearch(String title){
        waitForElement(driver, PlatformRecordUI.lblTitleRecordSearch,30,title);
        return isControlDisplayed(driver, PlatformRecordUI.lblTitleRecordSearch,title);
    }
    /**
     * click on Record file
     */
    public void clickOnRecordFile(String nameFile){
        waitForElement(driver, PlatformRecordUI.bntRecordItem,30,nameFile);
        clickToElement(driver, PlatformRecordUI.bntRecordItem,nameFile);
        sleep(5);
    }
    /**
     * click on Record file share
     */
    public void clickOnRecordFileShare(String nameFile){
        waitForElement(driver, PlatformRecordUI.bntRecordItemShare,30,nameFile);
        clickToElement(driver, PlatformRecordUI.bntRecordItemShare,nameFile);
        sleep(5);
    }
    /**
     * click Play video
     */
    public void clickOnPlayVideo(){
        waitForElement(driver, PlatformRecordUI.bntPlayVideo,30);
        executeClick(driver, PlatformRecordUI.bntPlayVideo);
    }
    /**
     * Video play base on element
     */
    public boolean isVideoPlay(){
        waitForElement(driver, PlatformRecordUI.videoPlay,30);
        return isElementDisplay(driver, PlatformRecordUI.videoPlay);
    }
    /**
     * click on Edit title record item
     */
    public void clickEditTitleRecord(){
        waitForElement(driver, PlatformRecordUI.bntEditTitle,30);
        clickToElement(driver, PlatformRecordUI.bntEditTitle);
    }
    /**
     * input Title record item
     */
    public void inputTitleRecordItem(String nameRecord){
        waitForElement(driver, PlatformRecordUI.txtTitleRecord,30);
        sendKeyToElement(driver, PlatformRecordUI.txtTitleRecord,nameRecord);
    }
    /**
     * click on Save Title Record item
     */
    public void clickOnSaveTitleRecordItem(){
        waitForElement(driver, PlatformRecordUI.bntSaveTitleRecord,30);
        executeClick(driver, PlatformRecordUI.bntSaveTitleRecord);
    }
    /**
     * click on Close Record item
     */
    public void clickOnCloseRecordItem(){
        waitForElement(driver, PlatformRecordUI.bntCloseRecordPopup,30);
        clickToElement(driver, PlatformRecordUI.bntCloseRecordPopup);
    }
    /**
     * Verify owner record base user login
     */
    public String getOwnerRecord(String titleRecord){
        waitForElement(driver, PlatformRecordUI.lblOwnerRecord,30,titleRecord);
        return getTextElementByXpath(driver, PlatformRecordUI.lblOwnerRecord,2,titleRecord);
    }

    /**
     * Verify owner record share base user login
     */
    public String getOwnerRecordShare(){
        waitForElement(driver, PlatformRecordUI.lblOwnerRecordShare,30);
        return getTextElementByXpath(driver, PlatformRecordUI.lblOwnerRecordShare);
    }

    /**
     * Verify room record base ID room record
     */
    public String getIDRooom(String titleRecord){
        waitForElement(driver, PlatformRecordUI.lblRoomIDRecord,30,titleRecord);
        return getTextElementByXpath(driver, PlatformRecordUI.lblRoomIDRecord,2,titleRecord);
    }

    /**
     * Verify room record Share base ID room record
     */
    public String getIDRooomShare(){
        waitForElement(driver, PlatformRecordUI.getLblRoomIDRecordShare,30);
        return getTextElementByXpath(driver, PlatformRecordUI.getLblRoomIDRecordShare,2);
    }

    /**
     * Verify Share Record
     */
    public String isShareRecord(){
        waitForElement(driver, PlatformRecordUI.getTextShareRecord,30);
        String script = "return window.getComputedStyle(document.querySelector('div[class*=\"share-url\"] div div.switch-button__slider'),':before').getPropertyValue('content')";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String content = (String) js.executeScript(script);
        return content.replace('"',' ').trim();
    }

    /**
     * Select Share
     */
    public void selectShareRecord(String status){
        String statusButton = isShareRecord();
        if(!status.equals(statusButton)){
            waitForElement(driver, PlatformRecordUI.bntShareRecord,30);
            clickToElement(driver, PlatformRecordUI.bntShareRecord);
        }
        sleep(2);
    }

    /**
     * is Share person POPUP
     * @return
     */

    public boolean isSharePersonPopup(){
        waitForElement(driver, PlatformRecordUI.popupSharePerson,30);
        return isElementDisplay(driver, PlatformRecordUI.popupSharePerson);
    }
    /**
     * Click on Close share person
     */
    public void clickCloseSharePerson(){
        waitForElement(driver, PlatformRecordUI.bntCloseSharePerson,30);
        clickToElement(driver, PlatformRecordUI.bntCloseSharePerson);
    }
    /**
     * is button Share enable
     */
    public boolean buttonShareEnable(boolean status){
        if(status==true) {
            waitForElement(driver, PlatformRecordUI.bntShareVideo, 30);
        }
        return isControlDisplayed(driver, PlatformRecordUI.bntShareVideo);
    }

    /**
     * click on Share Link
     */
    public void clickShareLink(){
        waitForElement(driver, PlatformRecordUI.bntShareVideo,30);
        clickToElement(driver, PlatformRecordUI.bntShareVideo);
        switchOtherWindow(driver);
    }

    /**
     * is Record title display in Share link
     */
    public boolean isRecordTitleDisplayShareLink(String title){
        waitForElement(driver, PlatformRecordUI.lblTitleRecordShareLink,30,title);
        return isElementDisplay(driver, PlatformRecordUI.lblTitleRecordShareLink,title);
    }

    /**
     * is Record title display in Share link
     */
    public boolean isRecordTitleDisplayShareManyRecord(String title){
        waitForElement(driver, PlatformRecordUI.lblTitleRecordShareManyRecord,30,title);
        return isElementDisplay(driver, PlatformRecordUI.lblTitleRecordShareManyRecord,title);
    }

    /**
     * click on Delete 1 record
     */
    public void clickOnDelete1Record(){
        waitForElement(driver, PlatformRecordUI.bntDelete1Record,30);
        clickToElement(driver, PlatformRecordUI.bntDelete1Record);
    }

    /**
     * click on confirm Delete 1 record
     */
    public void clickOnConfirmDelete1Record(){
        waitForElement(driver, PlatformRecordUI.bntConfirmDelete1Record,30);
        clickToElement(driver, PlatformRecordUI.bntConfirmDelete1Record);
        sleep(5);
    }

    /**
     * click on Download 1 record
     */
    public void clickOnDownload1Record(){
        waitForElement(driver, PlatformRecordUI.bntDownload1Record,30);
        clickToElement(driver, PlatformRecordUI.bntDownload1Record);
        sleep(20);
    }

    /**
     * input search by name
     */
    public void inputSearchByName(String nameRecord){
        waitForElement(driver, PlatformRecordUI.txtSearchByName,30);
        clickToElement(driver, PlatformRecordUI.txtSearchByName);
        sleep(2);
        driver.findElement(By.xpath( PlatformRecordUI.txtSearchByName)).sendKeys(nameRecord);
        driver.findElement(By.xpath(PlatformRecordUI.txtSearchByName)).sendKeys(Keys.ENTER);
    }
    /**
     * input search by date from
     */
    public void inputSearchByFrom(String currentDate){
        waitForElement(driver, PlatformRecordUI.txtSearchByFrom,30);
        clickToElement(driver, PlatformRecordUI.txtSearchByFrom);
        sleep(2);
        driver.findElement(By.xpath( PlatformRecordUI.txtSearchByFrom)).sendKeys(currentDate);
        driver.findElement(By.xpath(PlatformRecordUI.txtSearchByFrom)).sendKeys(Keys.ENTER);
    }

    /**
     * click on Basic sharing settings
     */
    public void clickOnBasicSharingSettings(){
        sleep(2);
        waitForElement(driver, PlatformRecordUI.bntBasicSharingSettings,30);
        clickToElement(driver, PlatformRecordUI.bntBasicSharingSettings);
        sleep(5);
    }

    /**
     * Select First User Share
     */
    public void selectFirstUserShare(){
        if(isElementSelected(driver, PlatformRecordUI.cbbFirstUserChecked)==true) {
            clickToElement(driver, PlatformRecordUI.chbFirstUserShare);
            sleep(2);
            clickToElement(driver, PlatformRecordUI.chbFirstUserShare);
        }else{
            clickToElement(driver, PlatformRecordUI.chbFirstUserShare);
        }
    }

    /**
     * Select User Share Record
     */
    public void selectUserShareRecord(String email){
        sleep(2);
        if(isElementSelected(driver, PlatformRecordUI.cbbUserChecked,email)==false) {
            clickToElement(driver, PlatformRecordUI.chbUserShare,email);
        }
    }

    /**
     * Verify First User checked
     */
    public boolean isFirstUserSelect(){
        //waitForElement(driver, PlatformRecordUI.chbFirstUserShare);
        return isElementSelected(driver, PlatformRecordUI.cbbFirstUserChecked);
    }

    /**
     * click on Save Basic sharing settings
     */
    public void clickOnSaveBasicSharingSettings(){
        waitForElement(driver, PlatformRecordUI.bntSaveBasicSharingSettings,30);
        clickToElement(driver, PlatformRecordUI.bntSaveBasicSharingSettings);
    }

    /**
     * does message save success
     */
    public boolean doesMessageSaveSuccess(String title){
        waitForElement(driver, PlatformRecordUI.txtMessageSaveSuccess,30,title);
        return isControlDisplayed(driver, PlatformRecordUI.txtMessageSaveSuccess,title);
    }

    /**
     * click Select all checkbox
     */
    public void clickOnSelectAllCheckBox(){
        sleep(2);
        waitForElement(driver, PlatformRecordUI.chbSelectAll,30);
        executeClick(driver, PlatformRecordUI.chbSelectAll);
        sleep(2);
    }

    /**
     * click Share all record
     */
    public void clickOnShareAllRecord(){
        waitForElement(driver, PlatformRecordUI.bntActionWithManyRecord,30);
        executeClick(driver, PlatformRecordUI.bntActionWithManyRecord);
        sleep(2);
        waitForElement(driver, PlatformRecordUI.bntShareWithManyRecord,30);
        clickToElement(driver, PlatformRecordUI.bntShareWithManyRecord);
    }


    /**
     * click share record for user
     */
    public void clickOnShareRecordForUser(){
        waitForElement(driver, PlatformRecordUI.bntShareRecordForUser,30);
        clickToElement(driver, PlatformRecordUI.bntShareRecordForUser);
    }

    /**
     * click on Share URL tab
     */
    public void clickOnShareURLTab(){
        waitForElement(driver, PlatformRecordUI.bntShareURLTab,30);
        clickToElement(driver, PlatformRecordUI.bntShareURLTab);
    }

    /**
     * click on Show URL
     */
    public void clickOnShowURLButton(){
        waitForElement(driver, PlatformRecordUI.bntShowURL,30);
        clickToElement(driver, PlatformRecordUI.bntShowURL);
    }

    /**
     * get URL Share record
     */
    public String getURLShareRecord(){
        if(driver.toString().equals("chrome")){
            waitForElement(driver, PlatformRecordUI.bntCopyURL, 10);
            clickToElement(driver, PlatformRecordUI.bntCopyURL);
            try {
                return  (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getAttributeValue(driver, PlatformRecordUI.txtURLShare,"value");
    }
}
