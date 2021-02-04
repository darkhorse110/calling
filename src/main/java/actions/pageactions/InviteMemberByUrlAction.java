package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.InviteMemberByUrlUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InviteMemberByUrlAction extends AbstractPages {
    private WebDriver driver;

    public InviteMemberByUrlAction(WebDriver driver){
        this.driver = driver;
    }

    public void clickPrivacyLink() {
        waitForElement(driver, InviteMemberByUrlUI.clickPrivacyLink, 10);
        WebElement link = driver.findElement(byXpath(InviteMemberByUrlUI.clickPrivacyLink));
        String url = link.getAttribute("href");
        Assert.assertEquals(url, "https://neo-lab.co.jp/policy/");
    }
    public void clickCallingIcon() {
        waitForElement(driver, InviteMemberByUrlUI.clickCallingIcon, 10);
        clickToElement(driver, InviteMemberByUrlUI.clickCallingIcon);
        driver.navigate().back();
    }

    //Input name to register
    public void inputName(String name){
        waitForElement(driver, InviteMemberByUrlUI.txtInputName,10, name);
        sendKeyToElement(driver, InviteMemberByUrlUI.txtInputName, name);
    }
    //Input Mail to register
    public void inputMail(String mail){
        waitForElement(driver, InviteMemberByUrlUI.txtInputMail,10, mail);
        sendKeyToElement(driver, InviteMemberByUrlUI.txtInputMail, mail);
    }
    //Input Mail Confirm to register
    public void inputMailConfirm(String mail){
        waitForElement(driver, InviteMemberByUrlUI.txtInputMailConfirm,10, mail);
        sendKeyToElement(driver, InviteMemberByUrlUI.txtInputMailConfirm, mail);
    }

    //Input pass to register
    public void inputPass(String pass){
        waitForElement(driver, InviteMemberByUrlUI.txtInputPass,10, pass);
        sendKeyToElement(driver, InviteMemberByUrlUI.txtInputPass, pass);
    }

    public void inputPassConfirm(String passConfirm){
        waitForElement(driver, InviteMemberByUrlUI.txtInputPassConfirm,10, passConfirm);
        sendKeyToElement(driver, InviteMemberByUrlUI.txtInputPassConfirm, passConfirm);
    }
    //Check Button confirm is Enable or Disable
    public void isSubmitBtnDisable(){
        boolean isDisable = isElementEnabled(driver, InviteMemberByUrlUI.submitBtn);
        Assert.assertTrue(!isDisable);
    }


    //Check Validation at Mail fields
    public void checkValidationMail(String message){
        waitForElement(driver, InviteMemberByUrlUI.msgValidateMail,10);
        Assert.assertEquals(getTextElementByXpath(driver, InviteMemberByUrlUI.msgValidateMail),message);
    }
    //Check Validation at Password fields
    public void checkValidationPass(String message){
        waitForElement(driver, InviteMemberByUrlUI.msgValidatePass,10);
        waitForElement(driver, InviteMemberByUrlUI.msgValidatePass2,10);
        try{
            Assert.assertEquals(getTextElementByXpath(driver, InviteMemberByUrlUI.msgValidatePass), message);
        }catch (Exception e){
            Assert.assertEquals(getTextElementByXpath(driver, InviteMemberByUrlUI.msgValidatePass2), message);
        }
    }

}
