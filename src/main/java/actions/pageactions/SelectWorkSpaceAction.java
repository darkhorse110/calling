package actions.pageactions;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import com.aventstack.extentreports.ExtentTest;
import interfaces.SelectWorkSpaceUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;

public class SelectWorkSpaceAction extends AbstractPages {
    private final WebDriver driver;

    public SelectWorkSpaceAction(WebDriver driver) {
        this.driver = driver;
    }

    private void inputWorkspace(String workspaceId) {
        waitForElement(driver, SelectWorkSpaceUI.workspaceNameTxt, 10, workspaceId);
        sendKeyToElement(driver, SelectWorkSpaceUI.workspaceNameTxt, workspaceId);
    }

    private String getErrorMessage() {
        return getTextElementByXpath(driver, SelectWorkSpaceUI.errorTxt);
    }

    private void clickSubmitBtn() {
        waitForElement(driver, SelectWorkSpaceUI.submitBtn, 10);
        clickToElement(driver, SelectWorkSpaceUI.submitBtn);
    }

    private void clickRequestWorkspaceLink() {
        waitForElement(driver, SelectWorkSpaceUI.forgotSpaceIdLink, 10);
        clickToElement(driver, SelectWorkSpaceUI.forgotSpaceIdLink);
    }

    private String getSelectWorkspaceUrl(){
        return getCurrentUrl(driver);
    }

    public void inputWorkspaceID(String workspaceId, ExtentTest logTest) {
        logInfo(logTest, "Input workspace id" + workspaceId);
        sleep(2);
        inputWorkspace(workspaceId);
        logInfo(logTest, "Click submit button");
        clickSubmitBtn();
    }

    public void gotoRequestWorkspace() {
        clickRequestWorkspaceLink();
    }

    public void isErrorMessageCorrect(String jpErrorMessage, ExtentTest logTest) {
        waitForElement(driver, SelectWorkSpaceUI.errorTxt, 10, jpErrorMessage);
        logInfo(logTest, "Actual: ".concat(getErrorMessage()).concat("<br> Expected: ").concat(jpErrorMessage));
        Assert.assertTrue(getErrorMessage().contains(jpErrorMessage));
    }

    public void isSelectWorkspaceUrlCorrect(ExtentTest logTest){
        waitForElement(driver, SelectWorkSpaceUI.workspaceNameTxt, 10);
        logInfo(logTest, "Actual: ".concat(getSelectWorkspaceUrl()).concat("<br> Expected: ").concat(Constants.URL));
        Assert.assertTrue(getSelectWorkspaceUrl().contains(Constants.URL));
    }
}
