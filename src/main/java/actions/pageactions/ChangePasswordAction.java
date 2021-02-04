package actions.pageactions;

import actions.commons.AbstractPages;
import com.aventstack.extentreports.ExtentTest;
import interfaces.ChangePasswordUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ChangePasswordAction extends AbstractPages {
    public WebDriver driver;
    public ChangePasswordAction (WebDriver driver){this.driver= driver;}

    public void inputOldPassword(String oldPassword, ExtentTest logStep)  {
        waitForElement(driver, ChangePasswordUI.txtOldPassword,10);
        clickToElement(driver,ChangePasswordUI.txtOldPassword);
        sendKeyToElement(driver,ChangePasswordUI.txtOldPassword,oldPassword);
    }
    public void inputNewPassword(String newPassword, ExtentTest logStep) {
        waitForElement(driver,ChangePasswordUI.txtNewPassword,10);
        clickToElement(driver,ChangePasswordUI.txtNewPassword);
        sendKeyToElement(driver,ChangePasswordUI.txtNewPassword,newPassword);
    }
    public void inputConfirmNewPassword(String confirmNewPassword, ExtentTest logStep) {
        waitForElement(driver,ChangePasswordUI.txtConfirmNewPassword,10);
        clickToElement(driver,ChangePasswordUI.txtConfirmNewPassword);
        sendKeyToElement(driver,ChangePasswordUI.txtConfirmNewPassword,confirmNewPassword);
    }
    public void clickbtnSubmit () throws InterruptedException {
        waitForElement(driver,ChangePasswordUI.btnSubmit,10);
        clickToElement(driver,ChangePasswordUI.btnSubmit);
    }
    public boolean isErrorMesssageOldPassword(String errorMessageOldPass){
        waitForElement(driver, ChangePasswordUI.errorMessageOLdPassword,10,errorMessageOldPass);
        return isElementDisplay(driver,ChangePasswordUI.errorMessageOLdPassword,errorMessageOldPass);

    }
    public boolean isSubmitButtonDisable(){
        waitForElement(driver, ChangePasswordUI.bntSubmitDisable,10);
        return isElementDisplay(driver,ChangePasswordUI.bntSubmitDisable);
    }
    public boolean isErrorMessageNewPassword (String errorMessageNewPass) {
        waitForElement(driver, ChangePasswordUI.errorMessageNewPassword,10,errorMessageNewPass);
        return isElementDisplay(driver,ChangePasswordUI.errorMessageNewPassword,errorMessageNewPass);

    }
    public void confirmChangePasswordPopup (){
        waitForElement(driver,ChangePasswordUI.popupConfirmChangePassword,30);
        Assert.assertTrue(isElementDisplay(driver,ChangePasswordUI.popupConfirmChangePassword));
    }
    public void clickbtnChangePasswordOnPopUp () {
        waitForElement(driver,ChangePasswordUI.btnChangePasswordOnPopup,10);
        clickToElement(driver,ChangePasswordUI.btnChangePasswordOnPopup);
        sleep(1);
    }
    public void verifyEditPasswordSuccessful (){
        waitForElement(driver,ChangePasswordUI.popupChangePasswordSuccessful,30);
        Assert.assertTrue(isElementDisplay(driver,ChangePasswordUI.popupChangePasswordSuccessful));
    }


}
