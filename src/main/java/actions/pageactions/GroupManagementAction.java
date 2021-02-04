package actions.pageactions;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import com.aventstack.extentreports.ExtentTest;
import interfaces.GroupManagementUI;
import interfaces.TopPageUI;
import org.openqa.selenium.*;
import org.testng.Assert;

import static actions.commons.ReportListener.logInfo;

public class GroupManagementAction extends AbstractPages {
    public WebDriver driver;
    public String email = Constants.EMAILMEMBER;

    public GroupManagementAction(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * click 権限グループ (Group quyền hạn)
     */
    public void clickGroupManagement(ExtentTest logTest) {
        logInfo(logTest, "Click on Setting icon");
        clickSettingIcon();
        logInfo(logTest, "Click on Group management menu");
        clickGroupManagementMenu();
    }

    /**
     * click button【＋新規の権限グループを作成/tạo Froup quyền hạn mới】
     */
    public void clickCreateGroupManagement(ExtentTest logTest) {
        logInfo(logTest, "Click on create Group Management button");
        waitForElement(driver, GroupManagementUI.bntSearchCreateGroupManagement, 10);
        sleep(2);
        clickToElement(driver, GroupManagementUI.bntSearchCreateGroupManagement);
    }

    /**
     * click Setting icon
     */
    public void clickSettingIcon() {
        waitForElement(driver, GroupManagementUI.lblIconSetting, 10);
        clickToElement(driver, GroupManagementUI.lblIconSetting);
        sleep(2);
    }

    /**
     * click Group Management Menu
     */
    public void clickGroupManagementMenu() {
        waitForElement(driver, GroupManagementUI.bntGroupManagementMenu, 10);
        clickToElement(driver, GroupManagementUI.bntGroupManagementMenu);
        sleep(2);
    }

    /**
     * Verify Group Management Menu Open success
     */
    public boolean isGroupManagementURL(String expectedUrl, ExtentTest logTest) {
        String currentURL = getCurrentUrl(driver);
        String groupManagementURL = String.format(Constants.WORKSPACE_URL, Constants.WORKSPACE_ID).concat(expectedUrl);
        logInfo(logTest, "Actual url: " + currentURL);
        logInfo(logTest, "Expected url: " + groupManagementURL);
        if (groupManagementURL.equals(currentURL)) {
            return true;
        }
        return false;
    }

    /**
     * search Group Management
     */
    public void searchGroupManagement(String nameSearch, ExtentTest logTest) {
        logInfo(logTest, "input search Group Management");
        inputSearchGroupManagement(nameSearch);
        logInfo(logTest, "click icon search Group Management");
        clickSearchGroupManagement();
    }

    /**
     * search Group Management with enter
     */
    public void searchGroupManagementWithEnter(String nameSearch, ExtentTest logTest) {
        logInfo(logTest, "input search Group Management");
        inputSearchGroupManagement(nameSearch);
        logInfo(logTest, "enter search Group Management");
        //keyPressing("enter");
        //sleep(2);
    }

    /**
     * input search Group Management
     */
    public void inputSearchGroupManagement(String groupManagement) {
        waitForElement(driver, GroupManagementUI.txtSearchName, 10);
        executeClick(driver, GroupManagementUI.txtSearchName);
        sleep(1);
        driver.findElement(By.xpath( GroupManagementUI.txtSearchName)).sendKeys(groupManagement);
        driver.findElement(By.xpath(GroupManagementUI.txtSearchName)).sendKeys(Keys.ENTER);
        sleep(2);
    }

    /**
     * click on search Group Management
     */
    public void clickSearchGroupManagement() {
        waitForElement(driver, GroupManagementUI.bntSearch, 10);
        clickToElement(driver, GroupManagementUI.bntSearch);
    }

    /**
     * verify result search group management
     */
    public boolean isResultSearchGroupManagementName(String nameGroupManagement, boolean result) {
        if (result != false) {
            waitForElement(driver, GroupManagementUI.lblGroupManagementName, 10, nameGroupManagement);
        }
        return isControlDisplayed(driver, GroupManagementUI.lblGroupManagementName, nameGroupManagement);
    }

    /**
     * verify error message create group management
     */
    public boolean doesErrorMessageCreateGroupManagement(String error, boolean result) {
        if (result != false) {
            waitForElement(driver, GroupManagementUI.lblErrorMessageCreateGroupManagement, 10, error);
        }
        return isControlDisplayed(driver, GroupManagementUI.lblErrorMessageCreateGroupManagement, error);
    }

    /**
     * verify is Button disable
     */
    public boolean isButtonDisable(String nameButton, boolean result) {
        if (result != false) {
            waitForElement(driver, GroupManagementUI.bntDisable, 10, nameButton);
        }
        return isControlDisplayed(driver, GroupManagementUI.bntDisable, nameButton);
    }

    /**
     * verify result search group management result first
     */
    public boolean isResultSearchGroupManagementNameFirst(String nameGroupManagement, boolean result) {
        if (result != false) {
            waitForElement(driver, GroupManagementUI.lblGroupManagementNameFirst, 1, nameGroupManagement);
        }
        return isControlDisplayed(driver, GroupManagementUI.lblGroupManagementNameFirst, nameGroupManagement);
    }

    /**
     * verify sub menu
     */
    public boolean isSubMenu() {
        waitForElement(driver, GroupManagementUI.lblHeaderSubMenu, 10);
        return isElementDisplay(driver, GroupManagementUI.lblHeaderSubMenu);
    }

    /**
     * get text group management
     */
    public String getTextGroupManagement() {
        String value = getAttributeValue(driver, GroupManagementUI.txtEditNameGroup, "value");
        return value;
    }

    /**
     * is Delete group management popup show
     */
    public boolean isDeleteGroupManagementPopup(boolean result) {
        if (result != false) {
            waitForElement(driver, GroupManagementUI.modalDeleteGroupManagement, 10);
        }
        return isControlDisplayed(driver, GroupManagementUI.modalDeleteGroupManagement);
    }

    /**
     * input name for create group management
     */
    public void createGroupManagement(String nameGroupManagement, ExtentTest logTest) {
        logInfo(logTest, "input name create group management");
        inputNameCreateGroupManagement(nameGroupManagement);
        logInfo(logTest, "click create group management button");
        clickSaveGroupManagement();
    }

    /**
     * click cancel create new group management
     */
    public void clickCancelCreateGroupManagement(ExtentTest logTest) {
        logInfo(logTest, "click cancel create new group management");
        waitForElement(driver, GroupManagementUI.bntCancel, 10);
        clickToElement(driver, GroupManagementUI.bntCancel);
    }

    /**
     * select Permission setting
     */
    public void selectPermissionSetting(String nameRadio, boolean on) {
        waitForElement(driver, GroupManagementUI.bntSettingPermission, 10, nameRadio);
        if (on == true) {
            clickToElement(driver, GroupManagementUI.bntSettingPermission, nameRadio);
        }
    }

    /**
     * is Setting Permission
     */
    public boolean isSettingPermission(String nameSetting,boolean result){
        if(result==true) {
            return isElementDisplay(driver, GroupManagementUI.lblSettingPermissionOn,nameSetting);
        }else
            return isElementDisplay(driver,GroupManagementUI.lblSettingPermissionOff,nameSetting);
    }

    /**
     * is User checked
     */
    public boolean isUserChecked(boolean result){
        if(result==true) {
            return isElementDisplay(driver, GroupManagementUI.chbUserChecked);
        }else
            return isElementDisplay(driver,GroupManagementUI.chbUserUnChecked);
    }

    /**
     * select user setting
     */
    public void selectUserPermissionSetting(boolean check) {
        if (check == true) {
            waitForElement(driver, GroupManagementUI.chbUser, 10);
            executeClick(driver, GroupManagementUI.chbUser);
        }
    }

    /**
     * get user setting
     */
    public String getUserPermissionSetting() {
        waitForElement(driver, GroupManagementUI.chbUser, 10);
        return getTextElementByXpath(driver, GroupManagementUI.chbUser);
    }

    /**
     * click icon sub menu
     */
    public void clickIconSubMenu(String nameGroupManagement, ExtentTest logTest) {
        waitForElement(driver, GroupManagementUI.bntIconSubMenu, 10, nameGroupManagement);
        clickToElement(driver, GroupManagementUI.bntIconSubMenu, nameGroupManagement);
    }

    /**
     * click edit permission
     */
    public void clickEditPermission(ExtentTest logTest) {
        logInfo(logTest, "click Edit Permission button");
        waitForElement(driver, GroupManagementUI.bntEditPermission, 10);
        clickToElement(driver, GroupManagementUI.bntEditPermission);
        waitLoadingPage();
    }

    /**
     * click delete permission
     */
    public void clickDeletePermission(ExtentTest logTest) {
        logInfo(logTest, "click Delete Permission button");
        waitForElement(driver, GroupManagementUI.bntDeletePermission, 10);
        clickToElement(driver, GroupManagementUI.bntDeletePermission);
    }

    /**
     * click x button in delete permission popup
     */
    public void clickXButtonDeletePopup(ExtentTest logTest) {
        logInfo(logTest, "click X button in Delete Permission Poupp");
        waitForElement(driver, GroupManagementUI.bntXDeleteGroupManagement, 10);
        clickToElement(driver, GroupManagementUI.bntXDeleteGroupManagement);
        sleep(2);
    }

    /**
     * click cancel button in delete permission popup
     */
    public void clickCancelButtonDeletePopup(ExtentTest logTest) {
        logInfo(logTest, "click Cancel button in Delete Permission Poupp");
        waitForElement(driver, GroupManagementUI.bntCancelDeleteGroupManagement, 10);
        clickToElement(driver, GroupManagementUI.bntCancelDeleteGroupManagement);
        sleep(2);
    }

    /**
     * click delete button in delete permission popup
     */
    public void clickDeleteButtonDeletePopup(ExtentTest logTest) {
        logInfo(logTest, "click Cancel button in Delete Permission Poupp");
        waitForElement(driver, GroupManagementUI.bntDeleteGroupManagement, 10);
        clickToElement(driver, GroupManagementUI.bntDeleteGroupManagement);
        sleep(2);
    }

    /**
     * wait loading page
     */
    public void waitLoadingPage() {
        if (isElementDisplay(driver, GroupManagementUI.lblLoadingPage) == true) {
            waitForElementNotDisplay(driver, GroupManagementUI.lblLoadingPage, 10);
        }
    }

    /**
     * input name for create group management
     */
    public void inputNameCreateGroupManagement(String nameGroupManagement) {
        waitForElement(driver, GroupManagementUI.txtCreateNameGroup, 10);
        driver.findElement(By.xpath(GroupManagementUI.txtCreateNameGroup)).sendKeys(nameGroupManagement);
    }
    /**
     * clear name for create group management
     */
    public void clearNameCreateGroupManagement() {
        waitForElement(driver, GroupManagementUI.txtCreateNameGroup, 10);
        driver.findElement(By.xpath(GroupManagementUI.txtCreateNameGroup)).clear();
    }

    /**
     * click create group management button
     */
    public void clickSaveGroupManagement() {
        waitForElement(driver, GroupManagementUI.bntSaveGroupManagement, 10);
        clickToElement(driver, GroupManagementUI.bntSaveGroupManagement);
        sleep(2);
    }

    /** disable - active account */

    public void clickLinkListMember(){
        waitForElement(driver, GroupManagementUI.lnkListMember, 10);
        clickToElement(driver, GroupManagementUI.lnkListMember);
    }
    public void clickBtnCaretOfMember(){
        waitForElement(driver, GroupManagementUI.btnCaretAtMember, 10);
        clickToElement(driver, GroupManagementUI.btnCaretAtMember);
    }
    public void clickBtnDisableAccount(){
        waitForElement(driver, GroupManagementUI.btnDisableAccount, 10);
        clickToElement(driver, GroupManagementUI.btnDisableAccount);
    }
    public void clickBtnYesDisableAccount(){
        waitForElement(driver, GroupManagementUI.btnYesDisableAccount, 10);
        clickToElement(driver, GroupManagementUI.btnYesDisableAccount);
        sleep(2);
    }
    public void clickLinkInvalidAccount(){
        waitForElement(driver, GroupManagementUI.lnkInvalidAccount, 10);
        clickToElement(driver, GroupManagementUI.lnkInvalidAccount);
    }
    public void clickBtnActiveAccount(){
        waitForElement(driver, GroupManagementUI.btnActiveAccount, 10);
        clickToElement(driver, GroupManagementUI.btnActiveAccount);
    }
    public void clickBtnYesActiveAccount(){
        waitForElement(driver, GroupManagementUI.btnYesActiveAccount, 10);
        clickToElement(driver, GroupManagementUI.btnYesActiveAccount);
        sleep(2);
    }
    public boolean isEmailDisplayAtListMember() {
        waitForElement (driver, GroupManagementUI.txtEmail, 10);
        return isElementDisplay (driver, GroupManagementUI.txtEmail);
    };

    public void disableAccount(ExtentTest logTest){
        clickLinkListMember();
        logInfo(logTest,"Verify '+email+' is display at List member tab");
        Assert.assertTrue(isEmailDisplayAtListMember());
        logInfo(logTest,"Disable account");
        clickBtnCaretOfMember();
        clickBtnDisableAccount();
        clickBtnYesDisableAccount();

    }

    public void activeAccount(ExtentTest logTest){
        logInfo(logTest,"Switch to Invalid Account tab");
        clickLinkInvalidAccount();
        logInfo(logTest,"Verify'+ email +'is display at Invalid account tab");
        Assert.assertTrue(isEmailDisplayAtListMember());
        logInfo(logTest,"Active account");
        clickBtnActiveAccount();
        clickBtnYesActiveAccount();
    }
}
