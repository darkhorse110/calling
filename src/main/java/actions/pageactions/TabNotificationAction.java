package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.TabNotificationUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TabNotificationAction extends AbstractPages {
    public WebDriver driver;
    public TabNotificationAction(WebDriver driver){
        this.driver = driver;
    }
    public void clickChatNotification () {
        waitForElement(driver, TabNotificationUI.btnChatNotification,10);
        clickToElement(driver,TabNotificationUI.btnChatNotification);
        sleep(2);
    }
    public void clickEmailNotification () {
        waitForElement(driver, TabNotificationUI.btnEmailNotification,10);
        clickToElement(driver,TabNotificationUI.btnEmailNotification);
        sleep(2);
    }
    public void verifySuccessufully (){
        waitForElement(driver, TabNotificationUI.popupSuccessful,10);
        Assert.assertTrue(isElementDisplay(driver,TabNotificationUI.popupSuccessful));
    }
}
