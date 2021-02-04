package actions.pageactions;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import com.aventstack.extentreports.ExtentTest;
import interfaces.ChangePasswordUI;
import interfaces.RequestPasswordUI;
import org.openqa.selenium.WebDriver;

import static actions.commons.ReportListener.logInfo;

public class RequestPasswordAction extends AbstractPages {
    private static WebDriver driver;

    public RequestPasswordAction(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Input メールアドレス (mail)
     *
     * @param email
     */
    public void inputMail(String email) {
        waitForElement(driver, RequestPasswordUI.txtEmail, 10, email);
        sendKeyToElement(driver, RequestPasswordUI.txtEmail, email);
    }
    /**
     * Click Submit button
     *
     * @param
     */
    private void clickSubmit() {
        waitForElement(driver, RequestPasswordUI.btnSubmit,10);
        clickToElement(driver, RequestPasswordUI.btnSubmit);
    }
    /**
     * Get URL Request Password screen
     *
     * @param
     */
    public static String getURLRequestPassword(){
        String urlLogin = driver.getCurrentUrl();
        return urlLogin;
    }
    /*-------- Business login  Action start here ----------------*/
    public void inputRequestPassword(String mail, ExtentTest logTest){
        logInfo(logTest,"Input mail request password " +  mail);
        inputMail(mail);
        logInfo(logTest,"Click submit button");
        clickSubmit();
    }
    /**
     * Check error message shows
     *
     * @param message
     */
    public boolean isErrorMessage(String message){
        waitForElement(driver, RequestPasswordUI.msgError,10,message);
        return isElementDisplay(driver,RequestPasswordUI.msgError,message);
    }
    /**
     * Check error message shows
     *
     * @param message
     */
    public boolean isErrorMessageNotRegist(String message){
        waitForElement(driver, RequestPasswordUI.msgNotRegist,10,message);
        return isElementDisplay(driver,RequestPasswordUI.msgNotRegist,message);
    }
    /**
     * Check max length Email text-box
     *
     * @param count
     */
    public boolean isMaxLengthEmail(String count){
        waitForElement(driver, RequestPasswordUI.txtEmail,10);
        if(getAttributeValue(driver, RequestPasswordUI.txtEmail, "maxlength").equals(count)){
            return true;
        }
        return false;
    }
    /**
     * Click ログイン画面に戻る
     *
     */
    public void clickBackLoginButton() {
        waitForElement(driver, RequestPasswordUI.bntBackLogin, 10);
        clickToElement(driver, RequestPasswordUI.bntBackLogin);
    }

    /**
     * Verify Login Menu Open success
     */
    public boolean isLoginURL(String expectedUrl, ExtentTest logTest) {
        String currentURL = getCurrentUrl(driver);
        String loginURL = String.format(Constants.WORKSPACE_URL, Constants.WORKSPACE_ID).concat(expectedUrl);
        logInfo(logTest, "Actual url: " + currentURL);
        logInfo(logTest, "Expected url: " + loginURL);
        if (loginURL.equals(currentURL)) {
            return true;
        }
        return false;
    }

    /*-------- Business login  Action end here ----------------*/
}

