package actions.pageactions;

import actions.commons.AbstractPages;
import com.aventstack.extentreports.ExtentTest;
import interfaces.RequestWorkSpaceUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;

public class RequestWorkSpaceAction extends AbstractPages {
    public WebDriver driver;

    public RequestWorkSpaceAction(WebDriver driver) {
        this.driver = driver;
    }

    private void inputEmail(String email) {
        waitForElement(driver, RequestWorkSpaceUI.emailTxt, 10, email);
        sendKeyToElement(driver, RequestWorkSpaceUI.emailTxt, email);
    }

    private void clickSubmitBtn() {
        waitForElement(driver, RequestWorkSpaceUI.submitBtn, 10);
        clickToElement(driver, RequestWorkSpaceUI.submitBtn);
    }

    private String getValidateMessage() {
        return getTextElementByXpath(driver, RequestWorkSpaceUI.validateMessage);
    }

    public void backToSelectWorkspace(){
        waitForElement(driver, RequestWorkSpaceUI.backToLoginLink,10);
        clickToElement(driver,RequestWorkSpaceUI.backToLoginLink);
    }
    /*
        Business action
     */
    public void findWorkspaceByEmail(String email, ExtentTest logTest) {
        logInfo(logTest, "Input" + email);
        inputEmail(email);
        logInfo(logTest, "Click find button");
        clickSubmitBtn();
    }

    public void isSubmitBtnDisable(ExtentTest logTest) {
        logInfo(logTest, "Check button submit is disable");
        boolean isDisable = !isElementEnabled(driver, RequestWorkSpaceUI.submitBtn);
        Assert.assertTrue(isDisable);
    }

    public void isValidateMessageCorrect(String jpValidateMessage, ExtentTest logTest) {
        waitForElement(driver, RequestWorkSpaceUI.validateMessage, 10, jpValidateMessage);
        logInfo(logTest, "Actual: ".concat(getValidateMessage()).concat("<br> Expected: ").concat(jpValidateMessage));
        Assert.assertTrue(getValidateMessage().contains(jpValidateMessage));
    }
}
