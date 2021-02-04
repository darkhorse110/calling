package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.InviteMemberByMailUI;
import interfaces.InviteMemberByUrlUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InviteMemberByMailAction extends AbstractPages {
    private WebDriver driver;
    public InviteMemberByMailAction(WebDriver driver){
        this.driver = driver;
    }

    public void inputMailOnYopMail(String mail){
        waitForElement(driver, InviteMemberByMailUI.txtInputMailOnYopMail,10);
        sendKeyToElement(driver, InviteMemberByMailUI.txtInputMailOnYopMail,mail);
    }

    public void clickCheckMailButton(){
        waitForElement(driver, InviteMemberByMailUI.clickButtonCheckMail,10);
        clickToElement(driver, InviteMemberByMailUI.clickButtonCheckMail);
        sleep(2);
    }

    public void clickGetMailButton(){
        waitForElement(driver, InviteMemberByMailUI.getMailButton,10);
        clickToElement(driver,InviteMemberByMailUI.getMailButton);
        sleep(2);
    }

    public void selectMail(){
        switchToFrame(driver,"ifinbox");
        waitForElement(driver, InviteMemberByMailUI.selectMail,10);
        clickToElement(driver, InviteMemberByMailUI.selectMail);
        sleep(2);
        switchToFrame(driver,"defaultContent");
        switchToFrame(driver,"ifmail");
        waitForElement(driver,InviteMemberByMailUI.linkInvite,10);
    }
    //Input name
    public void inputName(String name){
        waitForElement(driver, InviteMemberByMailUI.txtInputName,10, name);
        sendKeyToElement(driver, InviteMemberByMailUI.txtInputName, name);
    }

    //Input pass to register
    public void inputPass(String pass){
        waitForElement(driver, InviteMemberByMailUI.txtInputPass,10, pass);
        sendKeyToElement(driver, InviteMemberByMailUI.txtInputPass, pass);
    }
    //Input Pass Confirmation
    public void inputPassConfirm(String passConfirm){
        waitForElement(driver, InviteMemberByMailUI.txtInputPassConfirm,10, passConfirm);
        sendKeyToElement(driver, InviteMemberByMailUI.txtInputPassConfirm, passConfirm);
    }
    //Check Button confirm is Enable or Disable
    public boolean isSubmitBtnDisable(){
        boolean isDisable = isElementEnabled(driver, InviteMemberByMailUI.submitBtn);
        return isDisable;
    }

//    public void checkValidationPass(String message){
//        //waitForElement(driver, InviteMemberByMailUI.msgValidatePass,10);
//        //waitForElement(driver, InviteMemberByMailUI.msgValidatePass2,10);
//        try{
//            Assert.assertEquals(InviteMemberByMailUI.msgValidatePass,message);
//        }catch (Exception e){
//            Assert.assertEquals(InviteMemberByMailUI.msgValidatePass2,message);
//        }
//    }

    public String clickPrivacyLink() {
        waitForElement(driver, InviteMemberByMailUI.clickPrivacyLink, 10);
        WebElement link = driver.findElement(byXpath(InviteMemberByMailUI.clickPrivacyLink));
        String url = link.getAttribute("href");
        return url;
    }

    public void clickCallingIcon() {
        waitForElement(driver, InviteMemberByMailUI.clickCallingIcon, 10);
        clickToElement(driver, InviteMemberByMailUI.clickCallingIcon);
        driver.navigate().back();
    }

}
