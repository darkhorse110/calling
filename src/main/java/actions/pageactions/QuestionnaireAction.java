package actions.pageactions;


import actions.commons.AbstractPages;
import actions.commons.Constants;
import com.aventstack.extentreports.ExtentTest;
import interfaces.QuestionnaireUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class QuestionnaireAction extends AbstractPages {
    private WebDriver driver;

    public QuestionnaireAction(WebDriver driver) {
        this.driver = driver;

    }

    public void checkCurrentUrl(String expectedUrl, ExtentTest logTest) {
        String actualUrl = driver.getCurrentUrl ();
        logInfo (logTest, "Actual url: " + actualUrl);
        logInfo (logTest, "Expected url: " + expectedUrl);
        Assert.assertEquals (actualUrl, expectedUrl);
    }


    /**
     * Click on Questionaire menu
     */
    public void clickQuestionaireMenu() {
        waitForElement (driver, QuestionnaireUI.btnQuestionnaireMenu, 30);
        clickToElement (driver, QuestionnaireUI.btnQuestionnaireMenu);
    }

    /**
     * Click on Create new Questionaire
     */
    public void clickCreateNewQuestionaire() {
        waitForElement (driver, QuestionnaireUI.btnCreateQuestionnaire, 30);
        clickToElement (driver, QuestionnaireUI.btnCreateQuestionnaire);
    }

    /**
     * Input search by name
     */
    public void inputSearchByName() {
        waitForElement (driver, QuestionnaireUI.txtSearchByName, 30);
        clickToElement (driver, QuestionnaireUI.txtSearchByName);
    }

    /**
     * Input search by Date
     */
    public void inputSearchByDateFrom() {
        waitForElement (driver, QuestionnaireUI.txtCreatedDateFrom, 30);
        clickToElement (driver, QuestionnaireUI.txtCreatedDateFrom);
    }

    public void inputSearchByDateTo() {
        waitForElement (driver, QuestionnaireUI.txtCreatedDateTo, 30);
        clickToElement (driver, QuestionnaireUI.txtCreatedDateTo);
    }

    /**
     * Click on Show
     */
    public void clickShowQuestionaire() {
        waitForElement (driver, QuestionnaireUI.btnShow, 30);
        clickToElement (driver, QuestionnaireUI.btnShow);
    }

    /**
     * Click on Edit
     */
    public void clickEditQuestionaire() {
        waitForElement (driver, QuestionnaireUI.btnEdit, 30);
        clickToElement (driver, QuestionnaireUI.btnEdit);
    }

    /**
     * Click on Delete
     */
    public void clickDeleteQuestionnaire() {
        waitForElement (driver, QuestionnaireUI.btnDelete, 30);
        clickToElement (driver, QuestionnaireUI.btnDelete);
    }
    /**
     * Click on Register
     */
    public void clickRegister() {
        waitForElement (driver, QuestionnaireUI.btnRegister, 30);
        clickToElement (driver, QuestionnaireUI.btnRegister);
    }
    /**
     * Verify Questionnaire Menu Open success
     */
    public void verifyQuestionnairePage(ExtentTest logTest) {
        checkCurrentUrl (String.format (QuestionnaireUI.linkQuestionnaire, Constants.WORKSPACE_ID), logTest);
    }

    /**
     * Verify Questionnaire Show Open success
     */
    public void verifyShowQuestionnairePage(ExtentTest logTest) {
        checkCurrentUrl (String.format (QuestionnaireUI.linkShowQuestionnaire, Constants.WORKSPACE_ID), logTest);
    }
    /**
     * Verify Questionnaire Edit Open success
     */
    public void verifyEditQuestionnairePage(ExtentTest logTest) {
        checkCurrentUrl (String.format (QuestionnaireUI.linkEditQuestionnaire, Constants.WORKSPACE_ID), logTest);
    }
    /**
     * Verify Questionnaire Edit Open success
     */
    public void verifyCreateQuestionnairePage(ExtentTest logTest) {
        checkCurrentUrl (String.format (QuestionnaireUI.linkCreateQuestionnaire, Constants.WORKSPACE_ID), logTest);
    }
    /**
     * Verify Question Title
     */

    public void isQuestionTitle() {
        waitForElement (driver, QuestionnaireUI.txtQuestionTitle, 30);
        Assert.assertTrue (isElementDisplay (driver, QuestionnaireUI.txtQuestionTitle));
    }

    /**
     * Verify Question Create At
     */

    public void isQuestionCreate() {
        waitForElement (driver, QuestionnaireUI.txtQuestionCreateAt, 30);
        Assert.assertTrue (isElementDisplay (driver, QuestionnaireUI.txtQuestionCreateAt));
    }

    /**
     * Verify Question Title
     */

    public void isQuestionName() {
        waitForElement (driver, QuestionnaireUI.txtQuestionnaireName, 30);
        Assert.assertTrue (isElementDisplay (driver, QuestionnaireUI.txtQuestionnaireName));
    }

    /**
     * Verify Email
     */

    public void isEmail() {
        waitForElement (driver, QuestionnaireUI.txtEmail, 30);
        Assert.assertTrue (isElementDisplay (driver, QuestionnaireUI.txtEmail));
    }

    /**
     * Verify Answer 1
     */

    public void isAnswer1() {
        waitForElement (driver, QuestionnaireUI.txtQuestionAnswer1, 30);
        Assert.assertTrue (isElementDisplay (driver, QuestionnaireUI.txtQuestionAnswer1));
    }
    /**
     * Verify Answer 2
     */

    public void isAnswer2() {
        waitForElement (driver, QuestionnaireUI.txtQuestionAnswer2, 30);
        Assert.assertTrue (isElementDisplay (driver, QuestionnaireUI.txtQuestionAnswer2));
    }

    /**
     * Input Fields Question
     */
    public void inputQuestionnaireName(String questionname, ExtentTest logStep){
        waitForElement(driver, QuestionnaireUI.txtEditQuestionnaireName,10);
        clickToElement(driver,QuestionnaireUI.txtEditQuestionnaireName);
        sleep(2);
        sendKeyToElement(driver,QuestionnaireUI.txtEditQuestionnaireName, questionname);
    }
    public void inputMail(String email, ExtentTest logStep){
        waitForElement(driver, QuestionnaireUI.txtEmailInput,10);
        clickToElement(driver,QuestionnaireUI.txtEmailInput);
        sleep(2);
        sendKeyToElement(driver,QuestionnaireUI.txtEmailInput, email);
    }
    public void inputQuestionContent(String content, ExtentTest logStep){
        waitForElement(driver, QuestionnaireUI.txtQuestionContentInput,10);
        clickToElement(driver,QuestionnaireUI.txtQuestionContentInput);
        sleep(2);
        sendKeyToElement(driver,QuestionnaireUI.txtQuestionContentInput, content);
    }
    public void inputQuestion1(String question1 , ExtentTest logStep){
        waitForElement(driver, QuestionnaireUI.txtQuestionInput1,10);
        clickToElement(driver,QuestionnaireUI.txtQuestionInput1);
        sleep(2);
        sendKeyToElement(driver,QuestionnaireUI.txtQuestionInput1, question1);
    }
    public void inputQuestion2(String question2 , ExtentTest logStep){
        waitForElement(driver, QuestionnaireUI.txtQuestionInput2,10);
        clickToElement(driver,QuestionnaireUI.txtQuestionInput2);
        sleep(2);
        sendKeyToElement(driver,QuestionnaireUI.txtQuestionInput2, question2);
    }
    /**
     *  Register button check status
     */
    public void isBtnRegisterDisable (){
        boolean isDisable = isElementEnabled(driver, QuestionnaireUI.btnRegister);
        Assert.assertTrue(isDisable);
    }
    /**
     *  Click required
     */
    public void clickRequired() {
        waitForElement(driver, QuestionnaireUI.txtCheckBoxRequiredCreate,10);
        clickToElement(driver, QuestionnaireUI.txtCheckBoxRequiredCreate);
    }
    /**
     *  Choose Radio Question Type
     */
    public void selectRadioType() {
        waitForElement(driver, QuestionnaireUI.droplistQuestionType,10);
        clickToElement(driver, QuestionnaireUI.droplistQuestionType);
        waitForElement(driver, QuestionnaireUI.selectRadio,10);
        clickToElement(driver, QuestionnaireUI.selectRadio);
    }

    /**
     *  Max leng check
     */
    public boolean isMaxLengthQuestionName(String count){
        waitForElement(driver, QuestionnaireUI.txtEditQuestionnaireName,10);
        if(getAttributeValue(driver, QuestionnaireUI.txtEditQuestionnaireName, "maxlength").equals(count)){
            return true;
        }
        return false;
    }
    public boolean isMaxLengthEmail(String count){
        waitForElement(driver, QuestionnaireUI.txtEmailInput,10);
        if(getAttributeValue(driver, QuestionnaireUI.txtEmailInput, "maxlength").equals(count)){
            return true;
        }
        return false;
    }
    public boolean isMaxLengthQuestionContent(String count){
        waitForElement(driver, QuestionnaireUI.txtQuestionContent,10);
        if(getAttributeValue(driver, QuestionnaireUI.txtQuestionContent, "maxlength").equals(count)){
            return true;
        }
        return false;
    }

    /**
     *  Search
     */
    private void inputSearchByName(String searchValue) {
        waitForElement(driver, QuestionnaireUI.txtSearchByName,30);        clickToElement(driver,QuestionnaireUI.txtQuestionInput2);
        clickToElement(driver,QuestionnaireUI.txtSearchByName);
        sleep(2);
        sendKeyToElement(driver, QuestionnaireUI.txtSearchByName, searchValue);
        driver.findElement(By.xpath(QuestionnaireUI.txtSearchByName)).sendKeys(Keys.ENTER);

    }
    private String getTextFromTableQuestion(){
        waitForElement(driver, QuestionnaireUI.tableListQuestionName,30);
        return getTextElementByXpath(driver, QuestionnaireUI.tableListQuestionName);
    }
    public void isSearchByNameCorrect(String searchingValue)  {
        inputSearchByName(searchingValue);
        Assert.assertEquals(getTextFromTableQuestion(), searchingValue);
    }


    /**
     *  Delete
     */
    private void clickDelete() {
        waitForElement(driver, QuestionnaireUI.btnDelete,10);
        clickToElement(driver, QuestionnaireUI.btnDelete);
    }
    private void clickYes (){
        waitForElement(driver, QuestionnaireUI.btnYesDelete,10);
        clickToElement(driver, QuestionnaireUI.btnYesDelete);
    }
    public void DeleteQuestion()  {
        clickDelete ();
        clickYes ();
    }

    /**
     *  Confirmation
     */
    public void ConfirmationPopup (){
        Assert.assertTrue(isElementDisplay(driver, QuestionnaireUI.confirmationCreate));
    }

}

