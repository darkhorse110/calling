package actions.pageactions;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import com.aventstack.extentreports.ExtentTest;
import interfaces.ChangeAvatarUI;
import interfaces.SelectProfileUI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;

public class ChangeAvatarAction extends AbstractPages {
    public WebDriver driver;
    public ChangeAvatarAction (WebDriver driver){this.driver=driver;}
    public WebElement addFile;

    public void checkCurrentUrl(String expectedUrl, ExtentTest logTest)  {
        sleep(2);
        String actualUrl = driver.getCurrentUrl();
        logInfo(logTest, "Actual url: " + actualUrl);
        logInfo(logTest, "Expected url: " + expectedUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    public void clickBtnSelectImage () {
        waitForElement(driver, ChangeAvatarUI.btnSelectImage,10);
        clickToElement(driver,ChangeAvatarUI.btnSelectImage);
        sleep(2);
    }

    /**
     * get src image avatar
     */
    public String getSRCImageAvatar(){
        waitForElement(driver, ChangeAvatarUI.srcImgAvatar,10);
        sleep(2);
        return getAttributeValue(driver,ChangeAvatarUI.srcImgAvatar,"src");
    }

    /**
     * Verify image avatar updated
     */
    public boolean isImageAvatarUpdated(String srcAvatar){
        if (srcAvatar.equals(getSRCImageAvatar()))
            return true;
        return false;
    }

    public void selectImageToUpload () {
        String sourceUrl = getSourceFolder();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','visibility:visible;');",findElementByXpath(driver, ChangeAvatarUI.lblImgAvatar));
        sleep(2);
        sendKeyToElement(driver,ChangeAvatarUI.imgAvatar,sourceUrl.concat("//src//test//java//testdata//avatar.png"));
        sleep(2);
    }

    public void clickCancelbutton () {
        waitForElement(driver, ChangeAvatarUI.btnCancel,10);
        clickToElement(driver,ChangeAvatarUI.btnCancel);
        sleep(2);
    }
    public void clickSaveAvatarbtn () {
        waitForElement(driver, ChangeAvatarUI.btnSave,10);
        clickToElement(driver,ChangeAvatarUI.btnSave);
        sleep(2);
    }
    public void verifyEditProfilePage (ExtentTest logTest)  {
        checkCurrentUrl(String.format(SelectProfileUI.linkEditProfile, Constants.WORKSPACE_ID),logTest);
    }

    public void verifyAccountInfoPage (ExtentTest logTest)  {
        checkCurrentUrl(String.format(SelectProfileUI.linkNotification, Constants.WORKSPACE_ID),logTest);
    }

}
