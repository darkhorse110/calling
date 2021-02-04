package actions.pageactions;

import actions.commons.AbstractPages;
import com.aventstack.extentreports.ExtentTest;
import interfaces.MemberManagementUI;
import interfaces.RequestWorkSpaceUI;
import interfaces.TransferAdminUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;

public class TransferAdminAction extends AbstractPages {
    public WebDriver driver;
    public TransferAdminAction(WebDriver driver) {
        this.driver = driver;
    }

    private String getTextTransferAdminTitle(){
        waitForElement(driver, TransferAdminUI.txtTransferAdminTitle,10);
        return getTextElementByXpath(driver, TransferAdminUI.txtTransferAdminTitle);
    }

    private String getTextTransferAdminWarning(){
        waitForElement(driver, TransferAdminUI.txtTransferAdminWarning,10);
        return getTextElementByXpath(driver, TransferAdminUI.txtTransferAdminWarning);
    }

    private String getTextTransferAdminNotice(){
        waitForElement(driver, TransferAdminUI.txtTransferAdminNotice,10);
        return getTextElementByXpath(driver, TransferAdminUI.txtTransferAdminNotice);
    }

    private String getTextForgotPassword(){
        waitForElement(driver, TransferAdminUI.linkForgotPassword,10);
        return getTextElementByXpath(driver, TransferAdminUI.linkForgotPassword);
    }

    private void selectTheOtherAdmin(String newAdmin) {
        waitForElement(driver, TransferAdminUI.ddlNewAdministrator,10);
        sleep(2);
        selectItemInHtmlDropdown(driver, TransferAdminUI.ddlNewAdministrator,newAdmin);
    }


    public void isTransferAdminTitleDisplay(){
        Assert.assertEquals(getTextTransferAdminTitle(), TransferAdminUI.txtPageTitle1);
    }

    public void isTransferAdminWarningDisplay(){
        Assert.assertEquals(getTextTransferAdminWarning(), TransferAdminUI.txtPageTitle2);
    }

    public void isTransferAdminNoticeDisplay(String adminName){
        Assert.assertEquals(getTextTransferAdminNotice(), TransferAdminUI.txtPageTitle3.concat(adminName).concat(TransferAdminUI.txtPageTitle4));
    }

    public void isForgotPasswordLinkDisplay(){
        Assert.assertEquals(getTextForgotPassword(), TransferAdminUI.txtForgotPassword);
    }

    public void isButtonCancelDisplay(){
        Assert.assertTrue(isElementDisplay(driver, TransferAdminUI.btnCancel));
    }

    public void isButtonSubmitDisplay(){
        Assert.assertTrue(isElementDisplay(driver, TransferAdminUI.btnTransferAdmin));
    }

    public void isButtonSubmitDisabled() {
        Assert.assertFalse(isElementEnabled(driver, TransferAdminUI.btnTransferAdmin));
    }

    public void selectNewAdmin(String newAdmin) throws InterruptedException {
        selectTheOtherAdmin(newAdmin);
    }

    public void clickButtonForgetPassword(){
        waitForElement(driver, TransferAdminUI.linkForgotPassword,30);
        clickToElement(driver, TransferAdminUI.linkForgotPassword);
    }

    public void isNotificationSendEmailSuccess() {
        waitForElement(driver, TransferAdminUI.msgSendEmailForgotPassword,30);
        Assert.assertTrue(isElementEnabled(driver, TransferAdminUI.msgSendEmailForgotPassword));
    }

    public void clickButtonCancelTransferAdmin(){
        waitForElement(driver, TransferAdminUI.btnCancel,30);
        clickToElement(driver, TransferAdminUI.btnCancel);
    }
}
