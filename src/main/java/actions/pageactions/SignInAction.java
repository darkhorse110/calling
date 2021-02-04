package actions.pageactions;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import com.aventstack.extentreports.ExtentTest;
import interfaces.SignInUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;

public class SignInAction extends AbstractPages {
    public WebDriver driver;
    public SignInAction(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Input メールアドレス (mail)
     *
     * @param mail
     */
    private void inputMail(String mail) {
        waitForElement(driver, SignInUI.txtMail, 10, mail);
        sendKeyToElement(driver, SignInUI.txtMail, mail);
    }

    /**
     * Input パスワード(pass)
     *
     * @param passWord
     */
    private void inputPassWord(String passWord) {
        waitForElement(driver, SignInUI.txtPassWord, 10, passWord);
        sendKeyToElement(driver, SignInUI.txtPassWord, passWord);
    }

    /**
     * Click Login button
     */
    private void clickLoginButton() {
        waitForElement(driver, SignInUI.btnLogin, 10);
        clickToElement(driver, SignInUI.btnLogin);
    }

    private String getActualMessage() {
        return getTextElementByXpath(driver, SignInUI.lblLoginFailMessage);
    }

    /**
     * Mouse over Account
     */
    private void mouseoverAccountbutton() {
    waitForElement (driver, SignInUI.iconAccount, 10);
    hoverMouseToElement (driver, SignInUI.iconAccount);
}
    /**
     * Click Logout Button
     */
    private void clickLogoutButton() {
        waitForElement (driver, SignInUI.bntLogout, 10);
        clickToElement (driver, SignInUI.bntLogout);
    }

    /**
     * Click Confirm Logout Button
     */
    private void clickConfirmLogoutButton() {
        waitForElement (driver, SignInUI.bntConfirmLogout, 10);
        clickToElement (driver, SignInUI.bntConfirmLogout);
    }

    /**
     * Get workspace link
     */
    private String getWorkspaceAddress(){
        return getTextElementByXpath(driver, SignInUI.workSpaceAddressTxt);
    }

    /**
     * Check if workspace link correctly
     */
    public void isWorkspaceAddressCorrect(String workspaceID, ExtentTest logTest){
        waitForElement(driver,SignInUI.workSpaceAddressTxt,10);
        String workspaceLink =  workspaceID.concat(".calling.fun");
        logInfo(logTest,"Actual: ".concat(getWorkspaceAddress()).concat("<br> Expected: ").concat(workspaceLink));
        Assert.assertTrue(getWorkspaceAddress().contains(workspaceLink) );
    }

    /**
     * Click  Logout Workspace
     */
    private void clickLogoutWS() {
        waitForElement (driver, SignInUI.bntLogoutWS, 10);
        clickToElement (driver, SignInUI.bntLogoutWS);
    }

    public  void backToSelectWorkspace(){
        clickLinkAnotherWS();
    }

    /*-------- Business login  Action start here ----------------*/
    public void inputLogin(String mail, String passWord, ExtentTest logTest)  {
        logInfo(logTest, "Input mail: " + mail);
        inputMail(mail);
        logInfo(logTest, "Input password: " + passWord);
        inputPassWord(passWord);
        logInfo(logTest, "Click login button");
        clickLoginButton();
        sleep(5);
    }

    /*-------- Business Login  Action end here ----------------*/

    /*-------- Business  Logout Action start here ----------------*/
    public void Logout(ExtentTest logTest){
        logInfo(logTest,"Hover Account Button" );
        mouseoverAccountbutton ();
        logInfo(logTest,"Click Logout Button");
        clickLogoutButton ();
        logInfo(logTest,"Click Confirm Logout button");
        clickConfirmLogoutButton ();
        logInfo(logTest,"Click  Logout WorkSpace");
        clickLogoutWS ();
    }
    /*-------- Business Logout  Action end here ----------------*/
    public void clickRequestPasswordLink(ExtentTest logTest){
        waitForElement(driver, SignInUI.lnkRequestPassword,10);
        clickToElement(driver, SignInUI.lnkRequestPassword);
    }
    /*-------- Business login  Action end here ----------------*/

    public void isLoginFailMsg(String jpErrorMessage, ExtentTest logTest) {
        waitForElement(driver, SignInUI.lblLoginFailMessage, 10, jpErrorMessage);
        logInfo(logTest, "Actual: ".concat(getActualMessage()).concat("<br> Expected: ").concat(jpErrorMessage));
        Assert.assertTrue(getActualMessage().contains(jpErrorMessage));
        logInfo(logTest, "Re-load page signIn");
        refreshPage(driver);
    }

    public void checkCurrentUrl(String expectedUrl, ExtentTest logTest) throws InterruptedException {
        String actualUrl = driver.getCurrentUrl();
        logInfo(logTest, "Actual url: " + actualUrl);
        logInfo(logTest, "Expected url: " + expectedUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    public void verifyRedirectToHomePageSuccess(String workspace, ExtentTest logTest) throws InterruptedException {
        waitForElement(driver,SignInUI.lblLoginMessageSuccess,10);
        checkCurrentUrl(String.format(Constants.WORKSPACE_URL, workspace)+"home", logTest);
    }

    public void checkValidateLogin(String mail, String password, ExtentTest logTest, String jpErrorMessage, String workspace) throws InterruptedException {
        inputLogin(mail, password, logTest);
        if(jpErrorMessage.isEmpty()){
            verifyRedirectToHomePageSuccess(workspace, logTest);
        }
        else {
            isLoginFailMsg(jpErrorMessage, logTest);
        }
    }

    private void clickLinkAnotherWS() {
        waitForElement(driver, SignInUI.linkLoginAnotherWS, 10);
        clickToElement(driver, SignInUI.linkLoginAnotherWS);
    }

    public void verifyClickLinkLoginToAnotherWS(ExtentTest logTest) throws InterruptedException {
        clickLinkAnotherWS();
        checkCurrentUrl(Constants.URL, logTest);
        back(driver);
    }

    private void clickLinkForgotPassword() {
        waitForElement(driver, SignInUI.lnkRequestPassword, 10);
        clickToElement(driver, SignInUI.lnkRequestPassword);
    }

    public void verifyClickLinkForgotPassword(String workspace, ExtentTest logTest) throws InterruptedException {
        clickLinkForgotPassword();
        checkCurrentUrl(String.format(Constants.WORKSPACE_URL, workspace)+"request-password", logTest);
        back(driver);
    }


}
