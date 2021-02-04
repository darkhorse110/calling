package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.MemberManagementUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MemberManagementAction extends AbstractPages {
    public WebDriver driver;
    public MemberManagementAction(WebDriver driver) {
        this.driver = driver;
    }

    private String getPageTitleText(){
        waitForElement(driver, MemberManagementUI.txtPageTitle,30);
        return getTextElementByXpath(driver, MemberManagementUI.txtPageTitle);
    }
    private String getPageForgetPasswordText(){
        waitForElement(driver, MemberManagementUI.txtForgetPassowrdTitle,30);
        return getTextElementByXpath(driver, MemberManagementUI.txtForgetPassowrdTitle);
    }
    private String getTabListMemberText(){
        waitForElement(driver, MemberManagementUI.tabListMember,30);
        return getTextElementByXpath(driver, MemberManagementUI.tabListMember);
    }

    private String getInviteButtonText(){
        waitForElement(driver, MemberManagementUI.btnInviteMember,30);
        return getTextElementByXpath(driver, MemberManagementUI.btnInviteMember);
    }

    private String getAuthorityGroupText(){
        waitForElement(driver, MemberManagementUI.tabAuthorityGroup,30);
        return getTextElementByXpath(driver, MemberManagementUI.tabAuthorityGroup);
    }

    private String getInvalidAccountText(){
        waitForElement(driver, MemberManagementUI.tabInvalidAccount,30);
        return getTextElementByXpath(driver, MemberManagementUI.tabInvalidAccount);
    }

    private String getInvitedMemberText(){
        waitForElement(driver, MemberManagementUI.tabInvitedMember,30);
        return getTextElementByXpath(driver, MemberManagementUI.tabInvitedMember);
    }

    public void clickInviteButton()  {
        waitForElement(driver, MemberManagementUI.btnInviteMember,30);
        clickToElement(driver, MemberManagementUI.btnInviteMember);
    }

    public void clickTabListMember() {
        waitForElement(driver, MemberManagementUI.tabListMember,30);
        clickToElement(driver, MemberManagementUI.tabListMember);
        sleep(2);
    }

    public void clickTabInvalidAccount()  {
        waitForElement(driver, MemberManagementUI.tabInvalidAccount,30);
        clickToElement(driver, MemberManagementUI.tabInvalidAccount);
        sleep(2);

    }

    public void clickTabInvitedMember() {
        waitForElement(driver, MemberManagementUI.tabInvitedMember,30);
        clickToElement(driver, MemberManagementUI.tabInvitedMember);

    }

    public void clickTabAuthorityGroup(){
        waitForElement(driver, MemberManagementUI.tabAuthorityGroup,30);
        clickToElement(driver, MemberManagementUI.tabAuthorityGroup);

    }

    private int numberInvitedMember(){
        return countElementNumber(driver, MemberManagementUI.countNumberInvitedMember);
    }

    private int numberInvalidAccount(){
        return countElementNumber(driver, MemberManagementUI.countNumberInvalidAccount);
    }

    private void inputSearchActiveMemberValue(String searchValue) {
        waitForElement(driver, MemberManagementUI.txtSearchActiveMember,30);
        sendKeyToElement(driver, MemberManagementUI.txtSearchActiveMember, searchValue);
        driver.findElement(By.xpath(MemberManagementUI.txtSearchActiveMember)).sendKeys(Keys.ENTER);
        sleep(2);
    }

    private void inputSearchDeActiveMemberValue(String searchValue) {
        waitForElement(driver, MemberManagementUI.txtSearchDeActiveMember,30);
        sendKeyToElement(driver, MemberManagementUI.txtSearchDeActiveMember, searchValue);
        driver.findElement(By.xpath(MemberManagementUI.txtSearchDeActiveMember)).sendKeys(Keys.ENTER);
        sleep(2);
    }

    private String getTextFromTableListMember(){
        waitForElement(driver, MemberManagementUI.tblListStaff,30);
        return getTextElementByXpath(driver, MemberManagementUI.tblListStaff);
    }

    public boolean isNameSearchResult(String getLabelNameSearchResult, boolean result) {
        if (result != false) {
            waitForElement(driver, MemberManagementUI.lblNameSearchResult, 10, getLabelNameSearchResult);
        }
        return isControlDisplayed(driver, MemberManagementUI.lblNameSearchResult, getLabelNameSearchResult);
    }

    public boolean isGroupSearchResult(String getLabelGroupSearchResult, boolean result) {
        if (result != false) {
            waitForElement(driver, MemberManagementUI.lblGroupSearchResult, 10, getLabelGroupSearchResult);
        }
        sleep(2);
        return isControlDisplayed(driver, MemberManagementUI.lblGroupSearchResult, getLabelGroupSearchResult);
    }

    public boolean isGroupActiveSearchResult(String getLabelGroupSearchResult, boolean result) {
        if (result != false) {
            waitForElement(driver, MemberManagementUI.lblGroupActiveSearchResult, 10, getLabelGroupSearchResult);
        }
        sleep(2);
        return isControlDisplayed(driver, MemberManagementUI.lblGroupActiveSearchResult, getLabelGroupSearchResult);
    }

    private String getTextFromTableListDeActiveAccount(){
        waitForElement(driver, MemberManagementUI.tblListDeactiveAccount,30);
        return getTextElementByXpath(driver, MemberManagementUI.tblListDeactiveAccount);
    }

    private void clickArrowDown(){
        waitForElement(driver, MemberManagementUI.arrowDown,30);
        clickToElement(driver, MemberManagementUI.arrowDown);
    }

    private void clickSubmitDisableAccount(){
        waitForElement(driver, MemberManagementUI.btnSubmitDisableAccount, 30);
        clickToElement(driver, MemberManagementUI.btnSubmitDisableAccount);
    }

    private void clickCancelDisableAccount(){
        waitForElement(driver, MemberManagementUI.btnCancelDisableAccount, 30);
        clickToElement(driver, MemberManagementUI.btnCancelDisableAccount);
    }

    private void clickButtonActiveAccount(){
        waitForElement(driver, MemberManagementUI.btnActiveAccount, 30);
        clickToElement(driver, MemberManagementUI.btnActiveAccount);
    }

    private void clickSubmitActiveAccount(){
        waitForElement(driver, MemberManagementUI.btnSubmitActiveAccount, 30);
        clickToElement(driver, MemberManagementUI.btnSubmitActiveAccount);
        sleep(2);
    }

    private void clickCancelActiveAccount(){
        waitForElement(driver, MemberManagementUI.btnCancelActiveAccount, 30);
        clickToElement(driver, MemberManagementUI.btnCancelActiveAccount);
    }

    private void clickButtonChangeAuthorityGroup(){
        waitForElement(driver, MemberManagementUI.btnChangeAuthorityGroup,30);
        clickToElement(driver, MemberManagementUI.btnChangeAuthorityGroup);
    }

    private void clickButtonTransferAdministrator(){
        waitForElement(driver, MemberManagementUI.btnTransferAdministrator,30);
        clickToElement(driver, MemberManagementUI.btnTransferAdministrator);
        sleep(2);
    }
    public void clickButtonForgetPassword(){
//        waitForElement(driver, MemberManagementUI.btnForgetPassword,30);
        clickToElement(driver, MemberManagementUI.btnForgetPassword);
        sleep(2);
    }

    public void clickButtonCancelTransferAdmin(){
        waitForElement(driver, MemberManagementUI.btnCancelTranferAdmin,30);
        clickToElement(driver, MemberManagementUI.btnCancelTranferAdmin);
    }

    private void closePopupChangeAuthorityGroup(){
        waitForElement(driver, MemberManagementUI.btnClosPopupChangeAuthorityGroup,30);
        clickToElement(driver, MemberManagementUI.btnClosPopupChangeAuthorityGroup);
    }

    private void selectAuthorityGroupForDDL(String dropDownList, String searchingKey) throws InterruptedException {
        selectItemInHtmlDropdown(driver, dropDownList,searchingKey);
    }

    private void clickButtonSubmitChangeAuthorityGroup(){
        waitForElement(driver, MemberManagementUI.btnSubmitChangeAuthorityGroup,
                30);
        clickToElement(driver, MemberManagementUI.btnSubmitChangeAuthorityGroup);
    }

    private void clickButtonDisableAccount(){
        waitForElement(driver, MemberManagementUI.btnDisableAccount,
                30);
        clickToElement(driver, MemberManagementUI.btnDisableAccount);
    }

    private String getMessage(){
        waitForElement(driver, MemberManagementUI.msgSaveSuccess,30);
        return getTextElementByXpath(driver, MemberManagementUI.msgSaveSuccess);
    }

    private String getTextOfCreateAuthorityGroup(){
        waitForElement(driver, MemberManagementUI.btnCreateAuthorizationGroup,30);
        return  getTextElementByXpath(driver, MemberManagementUI.btnCreateAuthorizationGroup);
    }

    private String getTextChangeAuthorityGroupTitle(){
        waitForElement(driver, MemberManagementUI.txtPopupChangeAuthorityGroup,30);
        return getTextElementByXpath(driver, MemberManagementUI.txtPopupChangeAuthorityGroup);
    }




    /*-------- Business login  Action start here ----------------*/

    public void isPageTitleShown(){
        Assert.assertTrue(getPageTitleText().contains(MemberManagementUI.txtMemberManagerPageTitle));
    }
    public void isPageForgetPasswordShown(){
        Assert.assertTrue(getPageForgetPasswordText().contains(MemberManagementUI.txtForgetPassowrdTitle));
    }

    public void isTabListMemberShown(){
        Assert.assertTrue(getTabListMemberText().contains(MemberManagementUI.txtTabListMember));
    }

    public void isInviteButtonShown(){ Assert.assertTrue(getInviteButtonText().contains(MemberManagementUI.txtInviteButton));}

    public void isTabAuthorityGroup(){
        Assert.assertTrue(getAuthorityGroupText().contains(MemberManagementUI.txtTabAuthorityGroup));
    }

    public void isTabInvalidAccountShown(int numberInvalidAccount){
        Assert.assertTrue(getInvalidAccountText().contains(MemberManagementUI.txtTabInvalidMember.concat("(".concat(String.valueOf(numberInvalidAccount)).concat(")"))));
    }

    public void isTabInvitedMemberShown(int numberInvitedMember){
        Assert.assertTrue(getInvitedMemberText().contains(MemberManagementUI.txtTabInvitedMember.concat("(".concat(String.valueOf(numberInvitedMember)).concat(")"))));
    }

    public void isButtonCreateAuthorizationGroupShown(){
        Assert.assertEquals(getTextOfCreateAuthorityGroup(),MemberManagementUI.txtBtnCreateAuthorityGroup);
//        Assert.assertTrue(isElementDisplay(driver, MemberManagementUI.btnCreateAuthorizationGroup));
    }

    public void isNumberOfInvitedMemberCorrect() {
        clickTabInvitedMember();
        isTabInvitedMemberShown(numberInvitedMember());
    }

    public void isNumberOfInvalidAccountCorrect()  {
        clickTabInvalidAccount();
        sleep(3);
        isTabInvalidAccountShown(numberInvalidAccount());
    }

    public void isSearchMemberResultCorrect(String searchingValue)  {
        inputSearchActiveMemberValue(searchingValue);
//        Assert.assertTrue(getTextFromTableListMember().contains(searchingValue));
        Assert.assertEquals(getTextFromTableListMember(), searchingValue);
    }

    public void isSearchDeActiveAccountResultCorrect(String searchingValue) {
        inputSearchDeActiveMemberValue(searchingValue);
//        Assert.assertTrue(getTextFromTableListDeActiveAccount().contains(searchingValue));
        Assert.assertEquals(getTextFromTableListDeActiveAccount(), searchingValue);
    }

    public void isNameSearchResult(){
//        Assert.assertTrue(getTextNameSearchResult().contains(MemberManagementUI.txtNameSearchResult));
    }


    public void isButtonChangeAuthorityGroupDisplay(){
        clickArrowDown();
        waitForElement(driver, MemberManagementUI.btnChangeAuthorityGroup,30);
        Assert.assertTrue(isElementDisplay(driver, MemberManagementUI.btnChangeAuthorityGroup));
    }

    public void isButtonTransferAdministratorDisplay(){
        clickArrowDown();
        waitForElement(driver, MemberManagementUI.btnTransferAdministrator,30);
        Assert.assertTrue(isElementDisplay(driver, MemberManagementUI.btnTransferAdministrator));
    }

    public void isPopupChangeAuthorityGroupDisplay() {
        clickButtonChangeAuthorityGroup();
        sleep(2);
//        waitForElement(driver, MemberManagementUI.txtPopupChangeAuthorityGroup,30);
        Assert.assertEquals(getTextChangeAuthorityGroupTitle(), MemberManagementUI.txtChangeAuthorityGroupTitle);
//        Assert.assertTrue(isElementDisplay(driver, MemberManagementUI.txtPopupChangeAuthorityGroup));
//        closePopupChangeAuthorityGroup();
    }

    public void isPopupDisableAccountDisplay() throws InterruptedException {
        clickButtonDisableAccount();
//        Thread.sleep(3000);
        waitForElement(driver, MemberManagementUI.btnSubmitDisableAccount,30);
        Assert.assertTrue(isElementDisplay(driver, MemberManagementUI.btnSubmitDisableAccount));
//        closePopupChangeAuthorityGroup();
    }

    public void changeAuthority(String authorityGroup) throws InterruptedException {
        selectAuthorityGroupForDDL(MemberManagementUI.ddlAuthorityGroup, authorityGroup);
    }

    public void clickSubmitChangeAuthorityGroup(){
        clickButtonSubmitChangeAuthorityGroup();
    }

    public void submitDisableAccount()  {
        clickSubmitDisableAccount();
        sleep(2);
    }

    public void cancelDisableAccount(){
        clickCancelDisableAccount();
    }

    public void submitActiveAccount(){
        clickSubmitActiveAccount();
    }

    public void cancelActiveAccount(){
        clickCancelActiveAccount();
    }

    public void activeAccount(){
        clickButtonActiveAccount();
    }

    public void isMsgChangeAuthorityGroupSuccessShown()  {
//        Assert.assertTrue(getMessage().contains(MemberManagementUI.txtMsgChangeAuthorityGroupSuccess));
        Assert.assertEquals(getMessage(), MemberManagementUI.txtMsgChangeAuthorityGroupSuccess);
    }

    public void isMsgDeActiveAccountDisplay()  {
        Assert.assertTrue(getMessage().contains(MemberManagementUI.txtMsgDeActiveAccountSuccess));
//        Assert.assertEquals(getMessage(),MemberManagementUI.txtMsgActiveAccountSuccess);

    }

    public void isMsgActiveAccountDisplay() {
        Assert.assertTrue(getMessage().contains(MemberManagementUI.txtMsgActiveAccountSuccess));
//        Assert.assertEquals(getMessage(),MemberManagementUI.txtMsgActiveAccountSuccess);

    }

    public void isButtonDisableMemberDisplay(){
        Assert.assertTrue(isElementDisplay(driver, MemberManagementUI.btnDisableAccount));
    }

    public void isPopupDisableMemberDisplay(){
//        Assert.assertTrue(isElementDisplay(driver, MemberManagementUI.btnDisableAccount));
    }

    public void clickButtonTransferAdmin(){
        clickButtonTransferAdministrator();
    }


}
