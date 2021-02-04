package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.SalesTopUI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesTopAction extends AbstractPages {
    public WebDriver driver;
    public SalesTopAction(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * get connection Number
     */
    public String getConnectionNumber(){
        waitForElement(driver, SalesTopUI.txtConnectionNumber,10);
        if(isControlDisplayed(driver, SalesTopUI.txtConnectionNumber)==false){
            refreshPage(driver);
        }
        return getTextElementByXpath(driver, SalesTopUI.txtConnectionNumber);
    }

    /**
     *is Connection Number
     */
    public boolean isConnectNumber(){
        waitForElement(driver, SalesTopUI.txtConnectionNumber,10);
        return isElementDisplay(driver, SalesTopUI.txtConnectionNumber);
    }

    /**
     * Click on Sale light menu
     */
    public void clickSalesLightMenu(){
        waitForElement(driver, SalesTopUI.bntSalesLightMenu,30);
        clickToElement(driver, SalesTopUI.bntSalesLightMenu);
    }

    /**
     * Input first Digit connection number
     */
    public void inputFirstDigitConnectNumber(String connectionNumber){
        String firstDitgit = connectionNumber.substring(0);
        waitForElement(driver, SalesTopUI.txtFirstDigitConnectionNumber,30);
        sendKeyToElement(driver, SalesTopUI.txtFirstDigitConnectionNumber,firstDitgit);
    }
    /**
     * Input second Digit connection number
     */
    public void inputSecondDigitConnectNumber(String connectionNumber){
        String secondDitgit = connectionNumber.substring(1);
        waitForElement(driver, SalesTopUI.txtSecondDigitConnectionNumber,30);
        sendKeyToElement(driver, SalesTopUI.txtSecondDigitConnectionNumber,secondDitgit);
    }
    /**
     * Input Third Digit connection number
     */
    public void inputThirdDigitConnectNumber(String connectionNumber){
        String thirdDitgit = connectionNumber.substring(2);
        waitForElement(driver, SalesTopUI.txtThirdDigitConnectionNumber,30);
        sendKeyToElement(driver, SalesTopUI.txtThirdDigitConnectionNumber,thirdDitgit);
    }
    /**
     * Input Four Digit connection number
     */
    public void inputFourDigitConnectNumber(String connectionNumber){
        String fourDitgit = connectionNumber.substring(3);
        waitForElement(driver, SalesTopUI.txtFourDigitConnectionNumber,30);
        sendKeyToElement(driver, SalesTopUI.txtFourDigitConnectionNumber,fourDitgit);
    }
    /**
     * Click on Join button
     */
    public void clickOnJoinButton(){
        waitForElement(driver, SalesTopUI.bntJoinSalesLightRoom,30);
        clickToElement(driver, SalesTopUI.bntJoinSalesLightRoom);
        switchOtherWindow(driver);
    }

    /**
     * Select Questionnaire pulldown
     */
    public void selectQuestionnairePulldown(String questionnaire){
        waitForElement(driver, SalesTopUI.pulldownQuestionnaire,30);
        selectItemInHtmlDropdown(driver, SalesTopUI.pulldownQuestionnaire,questionnaire);
    }

    /**
     * get Questionnaire selected
     */
    public String isQuestionnaireSelected(){
        waitForElement(driver, SalesTopUI.pulldownQuestionnaire,30);
        return isElementFirstSelected(driver, SalesTopUI.pulldownQuestionnaire);
    }
    /**
     * Verify element selected
     *
     * @param driver
     * @param locator
     * @return
     */
    public String isElementFirstSelected(WebDriver driver,String locator) {
        findElementByXpath(driver, locator);
        WebElement option = select.getFirstSelectedOption();
        return option.getText();
    }
    /**
     * Verify URL is contains number
     */
    public boolean IsURLIsContainsNumber(String connectionNumber){
        String urlCurrent = getCurrentUrl(driver);
        if(urlCurrent.contains(connectionNumber))
            return true;
        return false;
    }

    /**
     * Verify camera on host setting
     */
    public String isCameraHostSetting(){
        waitForElement(driver, SalesTopUI.getTextCameraHost,30);
        String script = "return window.getComputedStyle(document.querySelector('div.connect-camera div div.switch-button__slider'),':before').getPropertyValue('content')";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String content = (String) js.executeScript(script);
        return content.replace('"',' ').trim();
    }

    /**
     * Verify camera on Sale setting
     */
    public String isCameraSaleSetting(){
        waitForElement(driver, SalesTopUI.getTextCameraSales,30);
        String script = "return window.getComputedStyle(document.querySelector('div.guest-connect-camera div div.switch-button__slider'),':before').getPropertyValue('content')";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String content = (String) js.executeScript(script);
        return content.replace('"',' ').trim();
    }

    /**
     * Verify Post profile setting
     */
    public String isPostProfileSetting(){
        waitForElement(driver, SalesTopUI.getTextPostProfile,30);
        String script = "return window.getComputedStyle(document.querySelector('div.show-profile div div.switch-button__slider'),':before').getPropertyValue('content')";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String content = (String) js.executeScript(script);
        return content.replace('"',' ').trim();
    }

    /**
     * Verify Mic on host setting
     */
    public String isMicHostSetting(){
        waitForElement(driver, SalesTopUI.getTextMicHost,30);
        String script = "return window.getComputedStyle(document.querySelector('div.connect-audio div div.switch-button__slider'),':before').getPropertyValue('content')";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String content = (String) js.executeScript(script);
        return content.replace('"',' ').trim();
    }

    /**
     * Click camera sale Setting
     */
    public void clickCameraSaleSetting(String status){
        String statusButton = isCameraSaleSetting();
        if(!status.equals(statusButton)){
            waitForElement(driver, SalesTopUI.bntCameraSale,30);
            clickToElement(driver, SalesTopUI.bntCameraSale);
        }
        sleep(2);
    }
    /**
     * Click Post profile Setting
     */
    public void clickPostProfileSetting(String status){
        String statusButton = isPostProfileSetting();
        if(!status.equals(statusButton)){
            waitForElement(driver, SalesTopUI.bntPostProfile,30);
            clickToElement(driver, SalesTopUI.bntPostProfile);
        }
        sleep(2);
    }


    /**
     * Click camera host Setting
     */
    public void clickCameraHostSetting(String status){
        String statusButton = isCameraHostSetting();
        if(!status.equals(statusButton)){
            waitForElement(driver, SalesTopUI.bntCameraHost,30);
            clickToElement(driver, SalesTopUI.bntCameraHost);
        }
        sleep(2);
    }


    /**
     * Click mic host Setting
     */
    public void clickMicHostSetting(String status){
        String statusButton = isMicHostSetting();
        if(!status.equals(statusButton)){
            waitForElement(driver, SalesTopUI.bntMicHost,30);
            clickToElement(driver, SalesTopUI.bntMicHost);
        }
        sleep(2);
    }

    /**
     * Click Edit profile
     */
    public void clickEditProfile(){
        waitForElement(driver, SalesTopUI.bntEditProfile,30);
        clickToElement(driver, SalesTopUI.bntEditProfile);
    }

    /**
     * input profile Company name
     */
    public void inputProfileCompanyName(String companyName){
        waitForElement(driver, SalesTopUI.txtCompanyName,30);
        sendKeyToElement(driver, SalesTopUI.txtCompanyName,companyName);
    }

    /**
     * input profile department
     */
    public void inputProfileDepartment(String department){
        waitForElement(driver, SalesTopUI.txtDepartment,30);
        sendKeyToElement(driver, SalesTopUI.txtDepartment,department);
    }

    /**
     * input profile position
     */
    public void inputProfilePosition(String position){
        waitForElement(driver, SalesTopUI.txtPosition,30);
        sendKeyToElement(driver, SalesTopUI.txtPosition,position);
    }

    /**
     * input profile name
     */
    public void inputProfileName(String name){
        waitForElement(driver, SalesTopUI.txtName,30);
        sendKeyToElement(driver, SalesTopUI.txtName,name);
    }

    /**
     * input profile name_kana
     */
    public void inputProfileNameKana(String name_kana){
        waitForElement(driver, SalesTopUI.txtNameKana,30);
        sendKeyToElement(driver, SalesTopUI.txtNameKana,name_kana);
    }

    /**
     * input profile message
     */
    public void inputProfileMessage(String message){
        waitForElement(driver, SalesTopUI.txtMessage,30);
        sendKeyToElement(driver, SalesTopUI.txtMessage,message);
    }

    /**
     * input profile email
     */
    public void inputProfileEmail(String email){
        waitForElement(driver, SalesTopUI.txtEmail,30);
        sendKeyToElement(driver, SalesTopUI.txtEmail,email);
    }

    /**
     * input profile Phone
     */
    public void inputProfilePhone(String phone){
        waitForElement(driver, SalesTopUI.txtPhone,30);
        sendKeyToElement(driver, SalesTopUI.txtPhone,phone);
    }
    /**
     * click Save profile
     */
    public void clickSaveProfile(){
        waitForElement(driver, SalesTopUI.bntSaveProfile,30);
        clickToElement(driver, SalesTopUI.bntSaveProfile);
        sleep(3);
    }

    /**
     * click Close profile
     */
    public void clickCloseProfile(){
        waitForElement(driver, SalesTopUI.bntClosePopup,30);
        clickToElement(driver, SalesTopUI.bntClosePopup);
        sleep(2);
    }
    /**
     *  Save profile success
     */
    public String messageSaveProfile(){
        waitForElement(driver, SalesTopUI.msgSaveProfile,30);
        return getTextElementByXpath(driver, SalesTopUI.msgSaveProfile);
    }
}
