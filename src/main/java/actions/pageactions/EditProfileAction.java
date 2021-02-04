package actions.pageactions;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import com.aventstack.extentreports.ExtentTest;
import interfaces.EditProfileUI;
import interfaces.SelectProfileUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;

public class EditProfileAction extends AbstractPages {
    private WebDriver driver;
    public EditProfileAction(WebDriver driver){this.driver=driver;}

    public void checkCurrentUrl(String expectedUrl, ExtentTest logTest) {
        String actualUrl = driver.getCurrentUrl();
        logInfo(logTest, "Actual url: " + actualUrl);
        logInfo(logTest, "Expected url: " + expectedUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    public void inputMailtxt(String mail, ExtentTest logStep){
        waitForElement(driver,EditProfileUI.mailTxT,10);
        executeClick(driver,EditProfileUI.mailTxT);
        sleep(2);
        sendKeyToElement(driver,EditProfileUI.mailTxT,mail);
    }

    public void inputRegisterNametxt(String registerName, ExtentTest logStep){
        waitForElement(driver,EditProfileUI.regiterNameTxt,10);
        executeClick(driver,EditProfileUI.regiterNameTxt);
        sleep(2);
        sendKeyToElement(driver,EditProfileUI.regiterNameTxt,registerName);
    }

    public void clickSubmitbtn ()  {
        waitForElement(driver,EditProfileUI.btnSubmit,10);
        sleep(1);
        clickToElement(driver,EditProfileUI.btnSubmit);
        sleep(2);
    }

    public void clickCancelbtn () {
        waitForElement(driver,EditProfileUI.btnCancel,10);
        sleep(1);
        clickToElement(driver,EditProfileUI.btnCancel);
        sleep(2);
    }

    public void verifyProfilePage(ExtentTest logStep) {
        checkCurrentUrl(String.format(SelectProfileUI.linkProfile, Constants.WORKSPACE_ID), logStep);
    }

    public void clickEditAvatarbtn() {
        waitForElement(driver,EditProfileUI.btnEditAvatar,10);
        sleep(1);
        clickToElement(driver,EditProfileUI.btnEditAvatar);
        sleep(2);
    }
    public void verifyEditAvatarPage (ExtentTest logStep)  {
        checkCurrentUrl(String.format(EditProfileUI.linkEditAvatarPage, Constants.WORKSPACE_ID), logStep);
    }

    public void isBtnSubmitDisable (){
        boolean isDisable = isElementEnabled(driver,EditProfileUI.btnSubmit);
        Assert.assertTrue(isDisable);
    }
    public void ConfirmationPopup (){

        Assert.assertTrue(isElementDisplay(driver,EditProfileUI.confirmPopup));
    }
    public void clickbtnSubmitPopup (){
        waitForElement(driver,EditProfileUI.btnSubmitPopup,10);
        sleep(1);
        clickToElement(driver,EditProfileUI.btnSubmitPopup);
        sleep(2);
    }

}
