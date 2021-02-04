package actions.pageactions;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import com.aventstack.extentreports.ExtentTest;
import interfaces.SelectProfileUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;

public class SelectProfileAction extends AbstractPages {
    private WebDriver driver;
    public SelectProfileAction (WebDriver driver){this.driver = driver;}

    public void checkCurrentUrl(String expectedUrl, ExtentTest logTest) throws InterruptedException {
        String actualUrl = driver.getCurrentUrl();
        logInfo(logTest, "Actual url: " + actualUrl);
        logInfo(logTest, "Expected url: " + expectedUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    public void clickProfileIcon () {
        waitForElement(driver, SelectProfileUI.profileIcon ,10);
        clickToElement(driver,SelectProfileUI.profileIcon);
        sleep(2);
    }
    public void clickProfileLink ()  {
        waitForElement(driver,SelectProfileUI.prorfileText,10);
        clickToElement(driver,SelectProfileUI.prorfileText);
        sleep(2);
    }

    public void verifyURLProfile (ExtentTest logTest) throws InterruptedException {
        checkCurrentUrl(String.format(SelectProfileUI.linkProfile,Constants.WORKSPACE_ID), logTest);
    }
    public void clickbtnEditProfile ()  {
        waitForElement(driver,SelectProfileUI.btnEditProfile,10);
        clickToElement(driver,SelectProfileUI.btnEditProfile);
        sleep(1);
    }
    public void verifyURLEditProfile (ExtentTest logTest) throws InterruptedException {
        checkCurrentUrl(String.format(SelectProfileUI.linkEditProfile,Constants.WORKSPACE_ID) ,logTest);
        back(driver);
    }

    public void clickbtnChangePassword () {
        waitForElement(driver,SelectProfileUI.btnChangePassword,10);
        clickToElement(driver,SelectProfileUI.btnChangePassword);
        sleep(1);
    }

    public void verifyURLChangePassword (ExtentTest logTest) throws InterruptedException {
        checkCurrentUrl(String.format(SelectProfileUI.linkChangePassword,Constants.WORKSPACE_ID),logTest);
        back(driver);
    }

    public void clickTabNotification () {
        waitForElement(driver,SelectProfileUI.tabNotification,10);
        clickToElement(driver,SelectProfileUI.tabNotification);
        sleep(1);

    }
    public void verifyTabNotification (ExtentTest logTest) throws InterruptedException {
        checkCurrentUrl(String.format(SelectProfileUI.linkNotification,Constants.WORKSPACE_ID),logTest);
        back(driver);
    }
    /**
     * get Name Account Login
     */
    public String getNameAccoutnLogin(){
        waitForElement(driver,SelectProfileUI.getNameAccountLogin,10);
        return getTextElementByXpath(driver,SelectProfileUI.getNameAccountLogin);

    }
    }


