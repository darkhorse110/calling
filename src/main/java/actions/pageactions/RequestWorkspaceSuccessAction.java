package actions.pageactions;

import actions.commons.AbstractPages;
import com.aventstack.extentreports.ExtentTest;
import interfaces.RequestWorkspaceSuccessUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;

public class RequestWorkspaceSuccessAction extends AbstractPages {
    public WebDriver driver;
    public RequestWorkspaceSuccessAction(WebDriver driver) {
        this.driver = driver;
    }

    private String getSuccessMessage(){
        return getTextElementByXpath(driver, RequestWorkspaceSuccessUI.successMessage);
    }

    public void backToPreviousPage(){
        back(driver);
    }

    public void isValidateMessageCorrect(String validateMessage, ExtentTest logTest ){
        waitForElement(driver, RequestWorkspaceSuccessUI.successMessage,10);
        logInfo(logTest,"Actual: ".concat(getSuccessMessage().concat("<br> Expected: ").concat(validateMessage)));
        Assert.assertTrue(getSuccessMessage().contains(validateMessage));
    }
}
