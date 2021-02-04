package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.WorkSpaceManagementUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;


public class WorkSpaceManagementAction extends AbstractPages {
    public WebDriver driver;

    public  WorkSpaceManagementAction(WebDriver driver) {
        this.driver = driver;
    }

    private String getPageTitleText(){
        waitForElement(driver, WorkSpaceManagementUI.txtPageTitle, 30);
        return getTextElementByXpath(driver, WorkSpaceManagementUI.txtPageTitle);
    }
    /**
     * Verify WorkSpace overview tab
     */
    private String getTabWorkSpaceOverviewText () {
        waitForElement(driver, WorkSpaceManagementUI.tabWorkSpaceOverview, 30);
        return getTextElementByXpath(driver, WorkSpaceManagementUI.tabWorkSpaceOverview);
    }
    /**
     * Verify Confirm Term link
     */
    private String getConfirmTermButtonText () {
        waitForElement(driver, WorkSpaceManagementUI.btnConfirmTerm, 30);
        return getTextElementByXpath(driver, WorkSpaceManagementUI.btnConfirmTerm);
    }
    /**
     * Verify tab About Admin
     */
    private String getTabAboutAdminText () {
        waitForElement(driver, WorkSpaceManagementUI.tabAboutAdmin, 30);
        return getTextElementByXpath(driver, WorkSpaceManagementUI.tabAboutAdmin);
    }
    /**
     * Verify Transfer Administrator screen
     */
    private String getTransferAdministratorText () {
        waitForElement(driver, WorkSpaceManagementUI.txtTransferAdministrator, 30);
        return getTextElementByXpath(driver, WorkSpaceManagementUI.txtTransferAdministrator);
    }

    /**
     * Click link Confirm Term button
     */
    public void clickConfirmTermButton () {
        clickToElement(driver, WorkSpaceManagementUI.btnConfirmTerm);
        sleep(5);
    }

    /**
     * Click tab WorkSpacer Overview
     */
    public void clickTabWorkSpacerOverview () {
        waitForElement(driver, WorkSpaceManagementUI.tabWorkSpaceOverview, 30);
        clickToElement(driver, WorkSpaceManagementUI.tabWorkSpaceOverview);
        sleep(5);
    }
    /**
     * Click tab About Administrator
     */
    public void clickTabAboutAdmin () {
        waitForElement(driver, WorkSpaceManagementUI.tabAboutAdmin, 30);
        clickToElement(driver, WorkSpaceManagementUI.tabAboutAdmin);
        sleep(5);
    }
    /**
     * Click Transfer Administrator button
     */
    public void clickTransferAdministratorButton () {
        waitForElement(driver, WorkSpaceManagementUI.btnTransferAdministrator, 30);
        clickToElement(driver, WorkSpaceManagementUI.btnTransferAdministrator);
        sleep(5);
    }
    /**
     * Click Cancel button
     */
    public void clickCancelButton () {
        waitForElement(driver, WorkSpaceManagementUI.btnCancel, 30);
        clickToElement(driver, WorkSpaceManagementUI.btnCancel);
        sleep(5);
    }
    /*-------- Business login  Action start here ----------------*/

    public void isPageTitleShown () {
        Assert.assertTrue(getPageTitleText().contains(WorkSpaceManagementUI.txtWorkSpaceManagementPageTitle));
    }

    public void isTabWorkSpaceOverviewShown () {
        Assert.assertTrue(getTabWorkSpaceOverviewText().contains(WorkSpaceManagementUI.txtTabWorkSpaceOverview));
    }

    public void isConfirmTermButtonShown () {
        Assert.assertTrue(getConfirmTermButtonText().contains(WorkSpaceManagementUI.txtConfirmTermButton));
    }
    public void isTabAboutAdminShown() {
        Assert.assertTrue(getTabAboutAdminText().contains(WorkSpaceManagementUI.txtTabAboutAdmin));
    }
    public void isTransferAdministratorScreen() {
        Assert.assertTrue(isElementDisplay(driver,WorkSpaceManagementUI.txtTransferAdministrator));
    }
}