package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.AboutUI;
import interfaces.MemberManagementUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AboutAction extends AbstractPages {
    public WebDriver driver;
    public AboutAction (WebDriver driver){this.driver=driver;}
    public WebElement addFile;

    private String getPageTitleText(){
        waitForElement(driver, AboutUI.txtPageTitle,30);
        return getTextElementByXpath(driver, AboutUI.txtPageTitle);
    }

    public void isPageTitleShown(){
        Assert.assertTrue(getPageTitleText().contains(AboutUI.txtPageTitleContent));
    }
}
