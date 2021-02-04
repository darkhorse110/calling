package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.InviteMemberUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class InviteMemberAction extends AbstractPages {
    public WebDriver driver;
    public InviteMemberAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickInvitedMemberLink(){
        waitForElement(driver, InviteMemberUI.linkCheckInvitedMember,10);
        clickToElement(driver, InviteMemberUI.linkCheckInvitedMember);
    }

    public void isSendInviteButtonShown(){
        waitForElement(driver, InviteMemberUI.btnSendInvite,10);
        Assert.assertTrue(isElementDisplay(driver, InviteMemberUI.btnSendInvite));
    }
}
