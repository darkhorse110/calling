package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.SalesLightUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SalesLightAction extends AbstractPages {
    public WebDriver driver;
    public SalesLightAction(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click OK Device
     */
    public void clickOnOKDeviceConfirm(){
        waitForElement(driver, SalesLightUI.bntHostOKDeviceConfirm,30);
        executeClick(driver, SalesLightUI.bntHostOKDeviceConfirm);
        sleep(2);
    }

    /**
     * Click Setting Device icon
     */
    public void clickOnSettingDeviceIcon(){
        waitForElement(driver, SalesLightUI.iconSettingDevice,30);
        clickToElement(driver, SalesLightUI.iconSettingDevice);
        sleep(2);
    }

    /**
     * Click キャンセル button
     */
    public void clickOnCancelDeviceConfirmGuest(){
        sleep(2);
        waitForElement(driver, SalesLightUI.bntGuestCancelDeviceConfirm,30);
        executeClick(driver, SalesLightUI.bntGuestCancelDeviceConfirm);
        sleep(2);
    }
    /**
     * Count user connection
     */
    public int countUserConnect(){
        waitForElement(driver, SalesLightUI.formUserConnect,30);
        return countElementNumber(driver, SalesLightUI.formUserConnect);
    }
    /**
     * Click Detail view profile button
     */
    public void clickOnDetailViewProfile(){
        waitForElement(driver, SalesLightUI.formProfileHost,30);
        clickToElement(driver, SalesLightUI.formProfileHost);
        sleep(2);
    }
    /**
     * Click カメラをオンにする button
     */
    public void clickOnTurnONCameraAndMicDeviceConfirmGuest(){
        waitForElement(driver, SalesLightUI.bntGuestTurnOnCameraAndMicDeviceConfirm,30);
        clickToElement(driver, SalesLightUI.bntGuestTurnOnCameraAndMicDeviceConfirm);
        sleep(3);
    }

    /**
     * get Text Mic Guest
     */
    public String getTextMic(){
        waitForElement(driver, SalesLightUI.txtMicGuest,30);
        return getTextElementByXpath(driver, SalesLightUI.txtMicGuest);
    }

    /**
     * click on Microphone
     */
    public void clickOnMicrophone(){
        waitForElement(driver, SalesLightUI.txtMicGuest,30);
        clickToElement(driver, SalesLightUI.txtMicGuest);
        sleep(2);
    }
    /**
     * click on Camera
     */
    public void clickOnCamera(){
        waitForElement(driver, SalesLightUI.txtCameraGuest,30);
        clickToElement(driver, SalesLightUI.txtCameraGuest);
        sleep(2);
    }
    /**
     * get Text Camera Guest
     */
    public String getTextCamera(){
        waitForElement(driver, SalesLightUI.txtCameraGuest,30);
        return getTextElementByXpath(driver, SalesLightUI.txtCameraGuest);
    }

    /**
     * Profile host display
     */
    public boolean isProfileHostDisplay(boolean status){
        if(status==true){
            waitForElement(driver, SalesLightUI.formProfileHost,10);
        }
        return isControlDisplayed(driver, SalesLightUI.formProfileHost);
    }

    /**
     * is content span profile detail
     */
    public boolean isContentSpanProfileDetail(String content){
        waitForElement(driver, SalesLightUI.txtContentSpanProfileDetail,10,content);
        return isControlDisplayed(driver, SalesLightUI.txtContentSpanProfileDetail,content);
    }

    /**
     * is content tagA profile detail
     */
    public boolean isContenttagAProfileDetail(String content){
        waitForElement(driver, SalesLightUI.txtContentTagAProfileDetail,10,content);
        return isControlDisplayed(driver, SalesLightUI.txtContentTagAProfileDetail,content);
    }


    /**
     * is content tagP profile detail
     */
    public boolean isContenttagPProfileDetail(String content){
        waitForElement(driver, SalesLightUI.txtContentTagPProfileDetail,10,content);
        return isControlDisplayed(driver, SalesLightUI.txtContentTagPProfileDetail,content);
    }

    /**
     * input chat
     */
    public void inputChat(String content){
        waitForElement(driver, SalesLightUI.txtChat,30);
        sendKeyToElement(driver, SalesLightUI.txtChat,content);
    }
    /**
     * enter with chat
     */
    public void enterWithChat(){
        waitForElement(driver, SalesLightUI.txtChat,30);
        driver.findElement(By.xpath(SalesLightUI.txtChat)).sendKeys(Keys.ENTER);;
    }

    /**
     * click send chat icon
     */
    public void clickSendChatIcon(){
        waitForElement(driver, SalesLightUI.bntSendChatIcon,30);
        clickToElement(driver, SalesLightUI.bntSendChatIcon);
    }

    /**
     * click on Enterで送信
     */
    public void clickOnEnterSendMethod(Boolean status){
        if(isElementSelected(driver,SalesLightUI.checkboxEnterMethod)==status) {
            waitForElement(driver, SalesLightUI.chbEnterMethod, 30);
            clickToElement(driver, SalesLightUI.chbEnterMethod);
        }
    }

    /**
     * is content chat send success
     */
    public boolean isConTentChatSend(String content){
        waitForElement(driver, SalesLightUI.txtContentChatSendSuccess,10,content);
        return isControlDisplayed(driver, SalesLightUI.txtContentChatSendSuccess,content);
    }

    /**
     * get max length chat box
     */
    public String isMaxLengthChatBox(){
        waitForElement(driver, SalesLightUI.txtChat,10);
        return getAttributeValue(driver, SalesLightUI.txtChat,"maxlength");
    }

    /**
     * get Time send chat
     */
    public String getTimeSendChat(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Japan"));
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }

    /**
     * is time chat send success
     */
    public boolean isTimeChatSendSuccess(String content,String time){
        waitForElement(driver, SalesLightUI.lblTimeChat,10,content,time);
        return isElementDisplay(driver, SalesLightUI.lblTimeChat,content,time);
    }

    /**
     * is Box chat show
     */
    public boolean isBoxChatShow(Boolean status){
        if(status==true) {
            waitForElement(driver, SalesLightUI.boxChatShow, 10);
        }
        return isControlDisplayed(driver, SalesLightUI.boxChatShow);
    }


    /**
     * Click on X icon box chat
     */
    public void clickXIconBoxChat(){
        waitForElement(driver, SalesLightUI.lblXIconBoxChat,10);
        executeClick(driver, SalesLightUI.lblXIconBoxChat);
    }

    /**
     * Click on open icon box chat
     */
    public void clickOpenIconBoxChat(){
        waitForElement(driver, SalesLightUI.lblOpenIconBoxChat,10);
        executeClick(driver, SalesLightUI.lblOpenIconBoxChat);
    }

    /**
     * is Recording icon show
     */
    public boolean isRecordIconShow(){
        waitForElement(driver, SalesLightUI.lblRecordIcon,10);
        return isControlDisplayed(driver, SalesLightUI.lblRecordIcon);
    }
    /**
     * is Recording Start label show
     */
    public boolean isRecordStartLabelShow(){
        waitForElement(driver, SalesLightUI.lblRecordStartLabel,10);
        return isControlDisplayed(driver, SalesLightUI.lblRecordStartLabel);
    }
    /**
     * is Recording label show
     */
    public boolean isRecordLabelShow(){
        waitForElement(driver, SalesLightUI.lblRecordingStoplabel,10);
        return isControlDisplayed(driver, SalesLightUI.lblRecordingStoplabel);
    }
    /**
     * click on Record icon
     */
    public void clickOnStartRecordIcon(){
        waitForElement(driver, SalesLightUI.lblRecordStartLabel,10);
        clickToElement(driver, SalesLightUI.lblRecordStartLabel);
        sleep(3);
    }
    /**
     * Make sure on Recording
     */
    public void makeSureRecording(){
        if(isControlDisplayed(driver,SalesLightUI.lblRecordingStoplabel)==false) {
            waitForElement(driver, SalesLightUI.lblRecordStartLabel, 10);
            clickToElement(driver, SalesLightUI.lblRecordStartLabel);
            sleep(5);
        }
    }
    /**
     * Make sure on Recording
     */
    public void makeSureStopRecording(){
        if(isControlDisplayed(driver,SalesLightUI.lblRecordingStoplabel)==true) {
            waitForElement(driver, SalesLightUI.lblRecordingStoplabel, 10);
            executeClick(driver, SalesLightUI.lblRecordingStoplabel);
            sleep(5);
        }
    }
    /**
     * click stop Record icon sale
     */
    public void clickStopRecordSale(){
        waitForElement(driver, SalesLightUI.lblRecodingSale,10);
        clickToElement(driver, SalesLightUI.lblRecodingSale);
        sleep(3);
    }
    /**
     * click on Stop Record icon
     */
    public void clickOnStopRecordIcon(){
        waitForElement(driver, SalesLightUI.lblRecordingStoplabel,10);
        clickToElement(driver, SalesLightUI.lblRecordingStoplabel);
        sleep(5);
    }
    /**
     * get Time send chat
     */
    public String getTimeRecord(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Japan"));
        return dtf.format(now);
    }

    /**
     * get Current date japan
     */
    public static String getCurrentDateJapan(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Japan"));
        return dtf.format(now);
    }

    /**
     * click on Exit icon
     */
    public void clickOnExitIcon(){
        waitForElement(driver, SalesLightUI.iconExit,10);
        clickToElement(driver, SalesLightUI.iconExit);
        sleep(2);
    }

    /**
     * click on Exit button
     */
    public void clickOnExitButton(){
        waitForElement(driver, SalesLightUI.bntExit,10);
        clickToElement(driver, SalesLightUI.bntExit);
        sleep(2);
    }
    /**
     * is Form Save Information
     */
    public boolean isFormSaveInformation(){
        waitForElement(driver, SalesLightUI.formSaveInformation,10);
        return isElementDisplay(driver, SalesLightUI.formSaveInformation);
    }

    /**
     * is Device select Popup
     */
    public boolean isDeviceSelection(){
        waitForElement(driver, SalesLightUI.formDeviceSelection,30);
        return isElementDisplay(driver, SalesLightUI.formDeviceSelection);
    }
    /**
     * does Message display
     */
    public boolean doesMessageDisplay(String message){
        waitForElement(driver, SalesLightUI.txtMessage,30,message);
        return isElementDisplay(driver, SalesLightUI.txtMessage,message);
    }

    /**
     * click on Device form selection
     */
    public void clickOnDeviceSettingModal(){
        waitAndClick(driver, SalesLightUI.formDeviceSelection,30);
        sleep(2);
    }

    /*Get camera name*/

    public String getCameraName(){
        waitForElement(driver, SalesLightUI.selectBoxCamera, 30);
        return getSelectItemInHtmlDropdown(driver, SalesLightUI.selectBoxCamera).getText();
    }

    /*Get mic name*/

    public String getMicName(){
        waitForElement(driver, SalesLightUI.selectBoxMic, 30);
        return getSelectItemInHtmlDropdown(driver, SalesLightUI.selectBoxMic).getText();
    }

    /*Get sound output name*/

    public String getSoundOutputName(){
        waitForElement(driver, SalesLightUI.selectBoxSoundOutput, 30);
        return getSelectItemInHtmlDropdown(driver, SalesLightUI.selectBoxSoundOutput).getText();
    }

    /*Check 2 users in this sales room*/
    public boolean get2Users(){
        waitForElement(driver, SalesLightUI.participantComponent, 30);
        int countUsers = findElementsByXpath(driver,SalesLightUI.participantComponent).size();
        if(countUsers == 2){
            return true;
        }
        return false;
    }
    /*Get mic 2 and check value*/
    public String selectMic2(){
        sleep(5);
        waitAndClick(driver, SalesLightUI.selectBoxMic, 30);
        waitAndClick(driver, SalesLightUI.option2Mic, 30);
        return getTextElementByXpath(driver, SalesLightUI.option2Mic);
    }
}
