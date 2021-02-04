package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.ChatbotUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;

public class ChatBotAction extends AbstractPages {
    public WebDriver driver;

    public ChatBotAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBtnChatbot() {
        waitForElement(driver, ChatbotUI.btnChatbot, 10);
        clickToElement(driver, ChatbotUI.btnChatbot);
        sleep(2);

    }

    public void clickbtnCreateChatbot() {
        waitForElement(driver, ChatbotUI.btnCreateChatbot, 10);
        clickToElement(driver, ChatbotUI.btnCreateChatbot);
        sleep(2);
    }

    public void inputChatbotName(String chatbotName) {
        waitForElement(driver, ChatbotUI.txtChatbotName, 10);
        driver.findElement(By.xpath(ChatbotUI.txtChatbotName)).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath(ChatbotUI.txtChatbotName)).sendKeys(Keys.DELETE);
        clickToElement(driver, ChatbotUI.txtChatbotName);
        sleep(2);
        sendKeyToElement(driver, ChatbotUI.txtChatbotName, chatbotName);
    }

    public void inputChatbotDescription(String chatbotDescription) {
        waitForElement(driver, ChatbotUI.txtChatbotDescription, 10);
        driver.findElement(By.xpath(ChatbotUI.txtChatbotDescription)).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath(ChatbotUI.txtChatbotDescription)).sendKeys(Keys.DELETE);
        clickToElement(driver, ChatbotUI.txtChatbotDescription);
        sleep(2);
        sendKeyToElement(driver, ChatbotUI.txtChatbotDescription, chatbotDescription);
    }

    public void clickbtnSubmitToCreateChatbot() {
        waitForElement(driver, ChatbotUI.btnSubmitToCreateChatbot, 10);
        clickToElement(driver, ChatbotUI.btnSubmitToCreateChatbot);
        sleep(5);
    }

    public boolean isChatbotTitle(String nameChatbot) {
        waitForElement(driver, ChatbotUI.lblChatbotTitle, 10,nameChatbot);
        return isControlDisplayed(driver, ChatbotUI.lblChatbotTitle,nameChatbot);
    }

    public String getChatbotTitleUpdate() {
        waitForElement(driver, ChatbotUI.lblChatbotTitleUpdate, 10);
        return getTextElementByXpath(driver, ChatbotUI.lblChatbotTitleUpdate);
    }


    public void clickBtnChatbotSetting(String nameChatBot) {
        waitForElement(driver, ChatbotUI.btnSettingChatbot, 10,nameChatBot);
        clickToElement(driver, ChatbotUI.btnSettingChatbot,nameChatBot);
        sleep(2);
    }

    public void clickBtnSettingChatbotUpdate() {
        waitForElement(driver, ChatbotUI.btnSettingChatbotUpdate, 10);
        clickToElement(driver, ChatbotUI.btnSettingChatbotUpdate);
        sleep(2);

    }

    public void clickBtnChatbotEdit(String nameChatbot, String nameButton) {
        waitForElement(driver, ChatbotUI.btnEditChatbot, 10,nameChatbot,nameButton);
        clickToElement(driver, ChatbotUI.btnEditChatbot,nameChatbot,nameButton);
        sleep(2);
    }

    public void clickBtnSubmitToEditChatbot() {
        waitForElement(driver, ChatbotUI.btnSubtmitToEditChatbot, 10);
        clickToElement(driver, ChatbotUI.btnSubtmitToEditChatbot);
        sleep(2);
        waitForElement(driver, ChatbotUI.lblLoading, 10);
    }

    public void clickBtnChatbotDelete() {
        waitForElement(driver, ChatbotUI.btnDeleteChatbot, 10);
        clickToElement(driver, ChatbotUI.btnDeleteChatbot);
        sleep(2);
    }

    public void clickBtnSubmitToDeleteChatbot() {
        waitForElement(driver, ChatbotUI.btnSubmitToDeleteChatbot, 10);
        clickToElement(driver, ChatbotUI.btnSubmitToDeleteChatbot);
        sleep(2);
        waitForElement(driver, ChatbotUI.lblLoading, 10);
    }

    /**
     * click on chatbot detail with name
     */
    public void clickOnChatBotDetailWithName(String nameBot) {
        waitForElement(driver, ChatbotUI.bntChatBotDetail, 10, nameBot);
        clickToElement(driver, ChatbotUI.bntChatBotDetail, nameBot);
        sleep(2);
    }

    /**
     * click on Default scenario
     */
    public void clickOnAutoReplyScenario(String nameDefaultScenario) {
        waitForElement(driver, ChatbotUI.bntDefaultScenario, 10, nameDefaultScenario);
        clickToElement(driver, ChatbotUI.bntDefaultScenario, nameDefaultScenario);
        sleep(2);
    }

    /**
     * click on bot preview
     */
    public void clickOnBotPreview(String buttonAction) {
        waitForElement(driver, ChatbotUI.bntPreviewBot, 10, buttonAction);
        clickToElement(driver, ChatbotUI.bntPreviewBot, buttonAction);
        sleep(2);
    }

    /**
     * click on add message
     */
    public void clickOnButtonAddMessage() {
        waitForElement(driver, ChatbotUI.bntAddMessage, 10);
        clickToElement(driver, ChatbotUI.bntAddMessage);
        sleep(2);
    }

    /**
     * click on Type Message
     */
    public void clickOnTypeMessage(String typeMsg) {
        waitForElement(driver, ChatbotUI.bntTypeMessage, 10, typeMsg);
        clickToElement(driver, ChatbotUI.bntTypeMessage, typeMsg);
        sleep(2);
    }

    /**
     * click on Create Type Message
     */
    public void clickOnCreateTypeMessage(String nameButton) {
        waitForElement(driver, ChatbotUI.bntCreateTypeMessage, 10, nameButton);
        clickToElement(driver, ChatbotUI.bntCreateTypeMessage, nameButton);
        sleep(2);
    }

    /**
     * input content for Text field
     */
    public void inputContentTextField(String content) {
        waitForElement(driver, ChatbotUI.txtContentField, 10);
        driver.findElement(By.xpath(ChatbotUI.txtContentField)).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath(ChatbotUI.txtContentField)).sendKeys(Keys.DELETE);
        sleep(2);
        sendKeyToElement(driver, ChatbotUI.txtContentField, content);
    }

    /**
     * click on Save Chat
     */
    public void clickOnSaveChat() {
        waitForElement(driver, ChatbotUI.bntSaveChat, 10);
        clickToElement(driver, ChatbotUI.bntSaveChat);
        sleep(2);
        waitForElement(driver, ChatbotUI.lblLoading, 10);
    }

    /**
     * is Content chat with type text
     */
    public boolean isContentChatTypeText(String textContent) {
        waitForElement(driver, ChatbotUI.txtContentChatTypeText, 10, textContent);
        return isControlDisplayed(driver, ChatbotUI.txtContentChatTypeText, textContent);
    }

    /**
     * is Content chat with type text for bot preview
     */
    public boolean isContentChatTypeTextPreviewBot(String textContent) {
        waitForElement(driver, ChatbotUI.txtPreviewText, 10, textContent);
        return isControlDisplayed(driver, ChatbotUI.txtPreviewText, textContent);
    }

    /**
     * is scenario show content chat
     */
    public boolean isContentChatTypeTextScenario(String textContent) {
        waitForElement(driver, ChatbotUI.txtContentChatTypeScenario, 10, textContent);
        return isControlDisplayed(driver, ChatbotUI.txtContentChatTypeScenario, textContent);
    }

    /**
     * Select file image
     */
    public void selectFileImage(String image) {
        String OS = System.getProperty("os.name").toLowerCase();
        boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
        if (IS_WINDOWS) {
            final String dir1 = System.getProperty("user.dir");
            String pathFile = new File(dir1.concat("\\src\\test\\java\\testdata\\" + image)).getAbsolutePath();
            driver.findElement(By.xpath(ChatbotUI.txtTypeFile)).sendKeys(pathFile);
        } else {
            final String dir1 = System.getProperty("user.dir");
            String pathFile = new File(dir1.concat("/src/test/java/testdata/" + image)).getAbsolutePath();
            driver.findElement(By.xpath(ChatbotUI.txtTypeFile)).sendKeys(pathFile);
        }
        sleep(5);
    }

    /**
     * get src Type image
     */
    public String getSRCTypeImage() {
        waitForElement(driver, ChatbotUI.imgTypeFile, 10);
        return getAttributeValue(driver, ChatbotUI.imgTypeFile, "src");
    }

    /**
     * get src Type image Preview Bot
     */
    public String getSRCTypeImagePreviewBot() {
        waitForElement(driver, ChatbotUI.txtPreviewImage, 10);
        return getAttributeValue(driver, ChatbotUI.txtPreviewImage, "src");
    }

    /**
     * get size image Preview Bot
     */
    public int getSizeSRCImagePreviewBot(){
        waitForElement(driver, ChatbotUI.txtPreviewImage, 10);
        return countElementNumber(driver, ChatbotUI.txtPreviewImage);
    }

    /**
     * get src Type image gallery
     */
    public String getSRCTypeImageGallery() {
        waitForElement(driver, ChatbotUI.imgTypeFileGallery, 10);
        return getAttributeValue(driver, ChatbotUI.imgTypeFileGallery, "src");
    }

    /**
     * get src Type image gallery preview bot
     */
    public String getSRCTypeImageGalleryPreviewBot() {
        waitForElement(driver, ChatbotUI.txtPreviewImageGallery, 10);
        return getAttributeValue(driver, ChatbotUI.txtPreviewImageGallery, "src");
    }

    /**
     * get Size src Type image gallery preview bot
     */
    public int getSizeSRCTypeImageGalleryPreviewBot() {
        waitForElement(driver, ChatbotUI.txtPreviewImageGallery, 10);
        return countElementNumber(driver, ChatbotUI.txtPreviewImageGallery);
    }

    /**
     * select Scenario
     */
    public void selectScenario(String scenario) {
        waitForElement(driver, ChatbotUI.cbbScenario, 10);
        selectItemInHtmlDropdown(driver, ChatbotUI.cbbScenario, scenario);
        sleep(2);
    }

    /**
     * click on First Text Auto Reply
     */
    public void clickOnFirstTextAutoReply() {
        waitForElement(driver, ChatbotUI.txtFirstTypeText, 10);
        clickToElement(driver, ChatbotUI.txtFirstTypeText);
        sleep(2);
    }


    //Keyword Registration
    /**
     * click on Getting Scenario
     */
    public void clickOnGreetingScenario(){
        waitForElement(driver, ChatbotUI.bntGreetingScenario, 10);
        clickToElement(driver, ChatbotUI.bntGreetingScenario);
        sleep(2); }

    /**
     * click on Keyword Registration
     */
    public void clickOnKeywordRegistration(){
        waitForElement(driver, ChatbotUI.bntKeywordRegistration, 10);
        clickToElement(driver, ChatbotUI.bntKeywordRegistration);
        sleep(2);
    }

    /**
     * click on Remove Keyword Registration
     */
    public void clickOnRemoveKeywordRegistration(){
        waitForElement(driver, ChatbotUI.bntRemoveKeywordList, 10);
        clickToElement(driver, ChatbotUI.bntRemoveKeywordList);
        sleep(2);
    }

    /**
     * input content for Keyword field
     */
    public void inputKeywordField(String content){
        waitForElement(driver, ChatbotUI.txtKeywordField, 10);
        driver.findElement(By.xpath(ChatbotUI.txtKeywordField)).clear();
        sendKeyToElement(driver, ChatbotUI.txtKeywordField,content);
        sleep(2);
    }
    /**
     * click on radio Partition match
     */
    public void clickOnRadioPartitionMatch(){
        waitForElement(driver, ChatbotUI.radioPartitionmatch, 10);
        clickToElement(driver, ChatbotUI.radioPartitionmatch);
        sleep(2); }
    /**
     * click on radio Exact match
     */
    public void clickOnRadioExactMatch(){
        waitForElement(driver, ChatbotUI.radioExactmatch, 10);
        clickToElement(driver, ChatbotUI.radioExactmatch);
        sleep(2); }
    /**
     * click on Delete Keyword
     */
    public void clickOnAddKeywordButton(){
        waitForElement(driver, ChatbotUI.btnAddKeyword, 10);
        clickToElement(driver, ChatbotUI.btnAddKeyword);
        sleep(2); }

    /**
     * click on Select keyword
     */
    private void clickOnSelectKeywordList(){
        waitForElement(driver, ChatbotUI.listboxSelectKeyword, 10);
        clickToElement(driver, ChatbotUI.listboxSelectKeyword);
        sleep(2);
    }

     public void selectOnVaLueKeyword (String nameKeyword){
         waitForElement(driver, ChatbotUI.cbbSelectKeyword, 10);
         selectItemInHtmlDropdown(driver,ChatbotUI.cbbSelectKeyword,nameKeyword);
         sleep(2);
     }

    /**
     * click on Save button
     */
    public void clickOnSaveButton(){
        waitForElement(driver, ChatbotUI.bntSave, 10);
        clickToElement(driver, ChatbotUI.bntSave);
        sleep(2); }

    /**
     * click on Keyword confirmation button
     */
    public void clickOnKeywordConfirmationButton(){
        waitForElement(driver, ChatbotUI.bntKeywordConfirmation, 10);
        clickToElement(driver, ChatbotUI.bntKeywordConfirmation);
        sleep(2);
    }

    /**
     *  Button Save check status
     */
    public void isBntSaveDisable (){
        boolean isDisable = isElementEnabled(driver, ChatbotUI.bntSave);
        Assert.assertTrue(isDisable);
    }

    /**
     *  Button Keyword Confirmation check status
     */
    public void isBntKeywordConfirmationDisable (){
        boolean isEnable = isElementEnabled(driver, ChatbotUI.bntKeywordConfirmation);
        Assert.assertTrue(isEnable);
    }
    /**
     * input content
     */
    public void inputContentField(String content){
        waitForElement(driver, ChatbotUI.txtTextContent, 10);
        driver.findElement(By.xpath(ChatbotUI.txtTextContent)).clear();
        sendKeyToElement(driver, ChatbotUI.txtTextContent,content);
        sleep(2);
    }
    /**
     * Is Duplicate Keyword
     *
     */
    public boolean isDuplicateKeyword(String errormessage){
        waitForElement(driver, ChatbotUI.txtDuplicateKeywordPopup, 10,errormessage);
        return isControlDisplayed(driver, ChatbotUI.txtDuplicateKeywordPopup,errormessage);
    }

    /**
     *  Max leng check
     */
    public boolean isMaxLengthKeyword(String count){
        waitForElement(driver, ChatbotUI.txtKeywordField,10);
        if(getAttributeValue(driver, ChatbotUI.txtKeywordField, "maxlength").equals(count)){
            return true;
        }
        return false;
    }

    /**
     *  get content message
     */
    public boolean isContentMessageTitle(String textContent){
        waitForElement(driver, ChatbotUI.txtContentTitle, 10,textContent);
        return isControlDisplayed(driver, ChatbotUI.txtContentTitle,textContent);
    }
    //Add Choice
    /**
     * click on Add Choice button
     */
    public void clickOnAddChoiceButton(){
        waitForElement(driver, ChatbotUI.bntAddChoice, 10);
        clickToElement(driver, ChatbotUI.bntAddChoice);
        sleep(2); }

    /**
     * input Choice Name
     */
    public void inputChoiceName(String content){
        waitForElement(driver, ChatbotUI.txtChoiceName, 10);
        driver.findElement(By.xpath(ChatbotUI.txtChoiceName)).clear();
        sendKeyToElement(driver, ChatbotUI.txtChoiceName,content);
        sleep(2);
    }
    /**
     * click on Scenario button
     */
    public void clickOnRadioScenarioButton(){
        waitForElement(driver, ChatbotUI.radioScenario, 10);
        clickToElement(driver, ChatbotUI.radioScenario);
        sleep(2); }

    /**
     * click on List Box Scenario
     */
    public void clickOnListBoxScenario(){
        waitForElement(driver, ChatbotUI.listboxScenario, 10);
        clickToElement(driver, ChatbotUI.listboxScenario);
        sleep(2); }
    /**
     * click on URL radio
     */
    public void clickOnURLRadio(){
        waitForElement(driver, ChatbotUI.radioURL, 10);
        clickToElement(driver, ChatbotUI.radioURL);
        sleep(2); }

    /**
     * input URL
     */
    public void inputURLField(String content){
        waitForElement(driver, ChatbotUI.txtUrlInput, 10);
        driver.findElement(By.xpath(ChatbotUI.txtUrlInput)).clear();
        sendKeyToElement(driver, ChatbotUI.txtUrlInput,content);
        sleep(2);
    }

    /**
     * Is required Choice
     *
     */
    public boolean isRequiredChoice(String required){
        waitForElement(driver, ChatbotUI.txtRequiredField, 10,required);
        return isControlDisplayed(driver, ChatbotUI.txtRequiredField,required);
    }
    /**
     * click on Add Choice
     */
    public void clickOnToAddButton(){
        waitForElement(driver, ChatbotUI.bntToAdd, 10);
        clickToElement(driver, ChatbotUI.bntToAdd);
        sleep(2); }


    /**
     * input chat bot preview
     */
    public void inputChatBotPreview(String content){
        waitForElement(driver, ChatbotUI.txtChatBotPreview, 10);
        sendKeyToElement(driver, ChatbotUI.txtChatBotPreview,content);
        sleep(2);
    }

    /**
     * click on send chat bot preview
     */
    public void clickOnSendChatBotPreview(){
        waitForElement(driver, ChatbotUI.bntSendChatBotPreview, 10);
        clickToElement(driver, ChatbotUI.bntSendChatBotPreview);
        sleep(2);
    }

    /**
     * click on add scenario
     */
    public void clickOnAddScenario(String nameButton){
        waitForElement(driver, ChatbotUI.bntScenario, 10,nameButton);
        clickToElement(driver, ChatbotUI.bntScenario,nameButton);
        sleep(2);
    }

    /**
     * click on save scenario
     */
    public void clickOnSaveScenario(String nameButton){
        waitForElement(driver, ChatbotUI.bntAddScenario, 10,nameButton);
        clickToElement(driver, ChatbotUI.bntAddScenario,nameButton);
        sleep(2);
    }

    /**
     * input Name Scenario
     */
    public void inputNameScenario(String content){
        waitForElement(driver, ChatbotUI.txtScenario, 10,content);
        sendKeyToElement(driver, ChatbotUI.txtScenario,content);
    }

    /**
     * input Edt Name Scenario
     */
    public void inputEditNameScenario(String content){
        waitForElement(driver, ChatbotUI.txtEditScenario, 10);
        driver.findElement(By.xpath(ChatbotUI.txtEditScenario)).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath(ChatbotUI.txtEditScenario)).sendKeys(Keys.DELETE);
        sendKeyToElement(driver, ChatbotUI.txtEditScenario,content);
    }


    /**
     * is name scenario
     */
    public boolean isNameScenario(String name){
        waitForElement(driver, ChatbotUI.lblScenario, 10,name);
        return isControlDisplayed(driver, ChatbotUI.lblScenario,name);
    }

    /**
     * click on Return to the scenario list
     */
    public void clickOnReturnScenarioList(String nameButton){
        waitForElement(driver, ChatbotUI.bntBackScenarioList, 10,nameButton);
        clickToElement(driver, ChatbotUI.bntBackScenarioList,nameButton);
        sleep(2);
    }

    /**
     * click on scenario detail
     */
    public void clickOnScenarioDetail(String name){
        waitForElement(driver, ChatbotUI.bntScenarioName, 10,name);
        clickToElement(driver, ChatbotUI.bntScenarioName,name);
        sleep(2);
    }

    /**
     * click on confirm delete scenario
     */
    public void clickOnConfirmDeleteScenario(String name){
        waitForElement(driver, ChatbotUI.bntDeleteScenario, 10,name);
        clickToElement(driver, ChatbotUI.bntDeleteScenario,name);
        sleep(2);
    }

    /**
     * is keyword selected
     */
    public boolean isKeywordSelected(String nameKeyword){
        waitForElement(driver, ChatbotUI.lblKeywordSelected, 10,nameKeyword);
        return  isControlDisplayed(driver, ChatbotUI.lblKeywordSelected,nameKeyword);
    }

    /**
     * click on keyword list button
     */
    public void clickOnKeywordList(){
        waitForElement(driver, ChatbotUI.bntKeywordList, 10);
        clickToElement(driver, ChatbotUI.bntKeywordList);
        sleep(2);
    }

    /**
     * click on Create keyword button
     */
    public void clickOnCreateKeyword(){
        waitForElement(driver, ChatbotUI.bntCreateKeyword, 10);
        clickToElement(driver, ChatbotUI.bntCreateKeyword);
        sleep(2);
    }

    /**
     * input Keyword Name for Text field
     */
    public void inputKeywordName(String keywordName) {
        waitForElement(driver, ChatbotUI.txtKeywordName, 10);
        clickToElement(driver, ChatbotUI.txtKeywordName);
        sleep(2);
        sendKeyToElement(driver, ChatbotUI.txtKeywordName, keywordName);
    }

    /**
     * select on Partial Match Type keyword
     */
    public void clickOnPartialMatchType(){
        waitForElement(driver, ChatbotUI.checkboxPartialMatch, 10);
        clickToElement(driver, ChatbotUI.checkboxPartialMatch);
        sleep(2);
    }

    /**
     * select on Exact Match Type keyword
     */
    public void clickOnExactMatchType(){
        waitForElement(driver, ChatbotUI.checkboxExactMatch, 10);
        clickToElement(driver, ChatbotUI.checkboxExactMatch);
        sleep(2);
    }

    /**
     * select on Exact Match Type keyword
     */
    public void clickOnSubmit(){
        waitForElement(driver, ChatbotUI.bntCreate, 10);
        clickToElement(driver, ChatbotUI.bntCreate);
        sleep(2);
    }

    /**
     * verify Partial Match Keyword Name
     */
    public boolean isPartialMatchKeywordName(String partialMatchName){
        waitForElement(driver, ChatbotUI.txtPartialMatchKeywordName, 10,partialMatchName);
        return  isControlDisplayed(driver, ChatbotUI.txtPartialMatchKeywordName,partialMatchName);
    }

    /**
     * verify Exact Match Keyword Name
     */
    public boolean isExactMatchKeywordName(String exactMatchName){
        waitForElement(driver, ChatbotUI.txtExactMatchKeywordName, 10,exactMatchName);
        return  isControlDisplayed(driver, ChatbotUI.txtExactMatchKeywordName,exactMatchName);
    }
    /**
     * verify Edit Partial Match Keyword Name
     */
    public boolean isEditPartialMatchKeywordName(String editPartialMatchName){
        waitForElement(driver, ChatbotUI.txtEditPartialMatchKeywordName, 10,editPartialMatchName);
        return  isControlDisplayed(driver, ChatbotUI.txtEditPartialMatchKeywordName,editPartialMatchName);
    }

    /**
     * verify Edit Exact Match Keyword Name
     */
    public boolean isEditExactMatchKeywordName(String editExactMatchName){
        waitForElement(driver, ChatbotUI.txtEditExactMatchKeywordName, 10,editExactMatchName);
        return  isControlDisplayed(driver, ChatbotUI.txtEditExactMatchKeywordName,editExactMatchName);
    }

    /**
     * click on Edit Partial Match keyword button
     */
    public void clickOnEditPartialMatch(){
        waitForElement(driver, ChatbotUI.bntPartialMatchEdit, 10);
        clickToElement(driver, ChatbotUI.bntPartialMatchEdit);
        sleep(2);
    }
    /**
     * click on Edit Exact Match keyword button
     */
    public void clickOnEditExactMatch(String exactMatchName){
        waitForElement(driver, ChatbotUI.bntExactMatchEdit, 10, exactMatchName);
        clickToElement(driver, ChatbotUI.bntExactMatchEdit, exactMatchName);
        sleep(2);
    }
    /**
     * click on Delete button
     */
    public void clickOnDelete(){
        waitForElement(driver, ChatbotUI.bntDelete, 10);
        clickToElement(driver, ChatbotUI.bntDelete);
        sleep(2);
    }
    /**
     * click on Confirm button
     */
    public void clickOnConfirm(){
        waitForElement(driver, ChatbotUI.bntConfirm, 10);
        clickToElement(driver, ChatbotUI.bntConfirm);
        sleep(2);
    }
}
