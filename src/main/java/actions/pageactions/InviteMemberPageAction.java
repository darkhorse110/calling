package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.GroupManagementUI;
import interfaces.InviteMemberPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class InviteMemberPageAction extends AbstractPages {
    private WebDriver driver;
    public InviteMemberPageAction(WebDriver driver){
        this.driver = driver;
    }

    public void clickInviteByUrlButton() {
        waitForElement(driver, InviteMemberPageUI.clickInviteByUrl, 10);
        clickToElement(driver, InviteMemberPageUI.clickInviteByUrl);
        sleep(2);
    }

    public void clickCopyUrlButton() {
        waitForElement(driver, InviteMemberPageUI.clickCopyUrlButton, 10);
        clickToElement(driver, InviteMemberPageUI.clickCopyUrlButton);
        sleep(2);
    }

    /**
     * get URL Invite
     */
    public String getURLInvite(){
        if(driver.toString().equals("chrome")){
            try {
                return  (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getAttributeValue(driver,InviteMemberPageUI.txtInviteURL,"value");
    }

    public void clickToPullDownAndSelectGroup(){
        waitForElement(driver, InviteMemberPageUI.clickToPullDown, 10);
        clickToElement(driver, InviteMemberPageUI.clickToPullDown);
        waitForElement(driver, InviteMemberPageUI.selectGroup, 10);
        clickToElement(driver, InviteMemberPageUI.selectGroup);
    }

    public void inputMail(String mailInvite){
        waitForElement(driver, InviteMemberPageUI.txtInputMail, 10, mailInvite);
        sendKeyToElement(driver, InviteMemberPageUI.txtInputMail, mailInvite);
    }

    public void sendMailButton(){
        waitForElement(driver, InviteMemberPageUI.sendMailButton, 10);
        clickToElement(driver, InviteMemberPageUI.sendMailButton);
    }

}
