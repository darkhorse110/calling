package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Chatbot extends AbstractPages {
    public WebDriver driver;
    public SignInAction signInAction;
    public SelectProfileAction selectProfileAction;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public ChatBotAction chatBotAction;
    public String urlChatbot;
    public String urlChatbotEdit;
    public String chatbotName = "AT" + currentTime();
    public String chatbotNameUpdate = "UP"+ currentTime();
    public String autoReplyScenario = "自動返答シナリオ";
    public String typeMessageText = "テキスト";
    public String KeywordRegistration = "キーワード確定";
    public String getTypeMessageImage = "イメージ";
    public String getTypeMessageGallery = "ギャラリー";
    public String getTypeMessageQuestion = "クエスチョン";
    public String bntCreateTypeMessage = "作成する";
    public String txtContentAutoReply = "Type Text" + currentTime();
    public String txtContentQuestionAutoReply = "Type Question" + currentTime();
    public String txtEditContentAutoReply = "Edit Type Text" + currentTime();
    public String autoGreetingScenario = "挨拶シナリオ";
    public String greetingScenario = "挨拶シナリオ";
    public String bntPreviewBot = "ボットプレビュー";
    public String txtContentScenario = "Scenario Type Text" + currentTime();
    public String txtContentQuestionScenario = "Scenario Type Question" + currentTime();
    public String txtEditContentScenario = "Scenario Edit Type Text" + currentTime();
    public String keywordPartialMatchName = "PM" + currentTime();
    public String keywordExactMatchName = "EM" + currentTime();
    public String editKeywordPartialMatchName = "EditPM";
    public String editKeywordExactMatchName = "EditEM";
    public String updatedKeywordPartialMatchName = "PM" + currentTime() + "EditPM";
    public String updatedKeywordExactMatchName = "EM" + currentTime() + "EditEM";
    public String srcimage = "avatar.png";
    public String image = "avatar";
    public String bntAddScenario ="シナリオを追加する";
    public String bntSaveScenario ="作成する";
    public String nameScenario = "SC" + currentTime();
    public String editNameScenario = "UPSC" + currentTime();
    public String keywordRegistration = "keyword" + currentTime();


    @Parameters({"browser"})
    @BeforeClass
    public void String(String browserName) {
        logClass = createTestForExtentReport(extent, "Test suit for Chatbot screen");
        logClass = createNodeForExtentReport(logClass, "Initial Setup successful");
        driver = getBrowser(browserName);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        workSpaceHomeAction = PageGeneratorManager.getWorkSpaceHomeAction(driver);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        selectProfileAction = PageGeneratorManager.getSelectProfileAction(driver);
        chatBotAction = PageGeneratorManager.getChatBotAction(driver);
    }

    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logReport = logReport.assignCategory("Pre-condition : Login workspace and login user ");
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logStep = logStepInfo(logMethod, "Login Successfully");
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD, logStep);
        logStep = logStepInfo(logMethod, "Click Chatbot button");
        chatBotAction.clickBtnChatbot();
        urlChatbot = getCurrentUrl(driver);
    }

    @Test(priority = 1)
    public void TC_01_ChatbotTop() throws IOException {
        logReport = logReport.assignCategory("create chatbot ");
        openUrl(driver, urlChatbot);
        logStep = logStepInfo(logMethod, "Click create chatbot button");
        chatBotAction.clickbtnCreateChatbot();
        logStep = logStepInfo(logMethod, "Input chatbot name");
        chatBotAction.inputChatbotName(chatbotName);
        logStep = logStepInfo(logMethod, "Input chatbot description");
        chatBotAction.inputChatbotDescription("auto test");
        logStep = logStepInfo(logMethod, "Click button submit to create chatbot");
        chatBotAction.clickbtnSubmitToCreateChatbot();
        logStep = logStepInfo(logMethod, "Verify create chatbot successfully");
        String urlChatbotDetail = getCurrentUrl(driver);
        Assert.assertTrue(urlChatbotDetail.contains("bot.dev.calling.fun/edit"));
        urlChatbotEdit = getCurrentUrl(driver);

    }

    @Test(priority = 2, enabled = true)
    public void TC_02_ChatbotTop() throws IOException {
        logReport = logReport.assignCategory("Chat bot list ");
        openUrl(driver, urlChatbot);
        logStep = logStepInfo(logMethod, "Verify chatbot is shown in list");
        Assert.assertTrue(chatBotAction.isChatbotTitle(chatbotName));
    }

    @Test(priority = 3, enabled = true)
    public void TC_01_ChatBotDetail() throws IOException {
        logReport = logReport.assignCategory("Chat bot detail - Add message auto reply");
        logMethod = createNodeForExtentReport(logReport, "Add text message auto-reply");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 自動返答シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoReplyScenario);

        logStep = logStepInfo(logMethod, "Click メッセージを追加");
        chatBotAction.clickOnButtonAddMessage();

        logStep = logStepInfo(logMethod, "click type Text テキスト");
        chatBotAction.clickOnTypeMessage(typeMessageText);

        logStep = logStepInfo(logMethod, "Click 作成する");
        chatBotAction.clickOnCreateTypeMessage(bntCreateTypeMessage);

        logStep = logStepInfo(logMethod, " enter text to textField");
        chatBotAction.inputContentTextField(txtContentAutoReply);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content text save success");
        Assert.assertTrue(chatBotAction.isContentChatTypeText(txtContentAutoReply));
    }

    @Test(priority = 4, enabled = true)
    public void TC_02_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Add image message auto-reply");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 自動返答シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoReplyScenario);

        logStep = logStepInfo(logMethod, "Click メッセージを追加");
        chatBotAction.clickOnButtonAddMessage();

        logStep = logStepInfo(logMethod, "click type image イメージ");
        chatBotAction.clickOnTypeMessage(getTypeMessageImage);

        logStep = logStepInfo(logMethod, "Click 作成する");
        chatBotAction.clickOnCreateTypeMessage(bntCreateTypeMessage);

        logStep = logStepInfo(logMethod, " select image");
        chatBotAction.selectFileImage(srcimage);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content image save success");
        Assert.assertTrue(chatBotAction.getSRCTypeImage().contains(image));
    }

    @Test(priority = 5, enabled = true)
    public void TC_03_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Add gallery message auto-reply");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 自動返答シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoReplyScenario);

        logStep = logStepInfo(logMethod, "Click メッセージを追加");
        chatBotAction.clickOnButtonAddMessage();

        logStep = logStepInfo(logMethod, "click type image ギャラリー");
        chatBotAction.clickOnTypeMessage(getTypeMessageGallery);

        logStep = logStepInfo(logMethod, "Click 作成する");
        chatBotAction.clickOnCreateTypeMessage(bntCreateTypeMessage);

        logStep = logStepInfo(logMethod, " select image");
        chatBotAction.selectFileImage(srcimage);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content image gallery save success");
        Assert.assertTrue(chatBotAction.getSRCTypeImageGallery().contains(image));
    }

    @Test(priority = 6, enabled = true)
    public void TC_04_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Add question message auto-reply");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 自動返答シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoReplyScenario);

        logStep = logStepInfo(logMethod, "Click メッセージを追加");
        chatBotAction.clickOnButtonAddMessage();

        logStep = logStepInfo(logMethod, "click type question クエスチョン");
        chatBotAction.clickOnTypeMessage(getTypeMessageQuestion);

        logStep = logStepInfo(logMethod, "Click 作成する");
        chatBotAction.clickOnCreateTypeMessage(bntCreateTypeMessage);

        logStep = logStepInfo(logMethod, " Enter text to textField");
        chatBotAction.inputContentTextField(txtContentQuestionAutoReply);

        logStep = logStepInfo(logMethod, " Select scenario ");
        chatBotAction.selectScenario(autoReplyScenario);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content text save success");
        Assert.assertTrue(chatBotAction.isContentChatTypeText(txtContentQuestionAutoReply));

        logStep = logStepInfo(logMethod, " Verify link scenario show success");
        Assert.assertTrue(chatBotAction.isContentChatTypeTextScenario(autoReplyScenario));
    }

    @Test(priority = 7, enabled = true)
    public void TC_05_ChatBotDetail() throws IOException {
        logReport = logReport.assignCategory("Chat bot detail - Edit message auto reply");
        logMethod = createNodeForExtentReport(logReport, "Edit message Greeting ");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 自動返答シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoReplyScenario);

        logStep = logStepInfo(logMethod, "click type text first");
        chatBotAction.clickOnFirstTextAutoReply();

        logStep = logStepInfo(logMethod, " Enter text to textField");
        chatBotAction.inputContentTextField(txtEditContentAutoReply);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content text save success");
        Assert.assertTrue(chatBotAction.isContentChatTypeText(txtEditContentAutoReply));
    }

    @Test(priority = 8, enabled = true)
    public void TC_06_ChatBotDetail() throws IOException {
        logReport = logReport.assignCategory("Chat bot detail - Add message Greeting scenario");
        logMethod = createNodeForExtentReport(logReport, "Add text message scenario");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 挨拶シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoGreetingScenario);

        logStep = logStepInfo(logMethod, "Click メッセージを追加");
        chatBotAction.clickOnButtonAddMessage();

        logStep = logStepInfo(logMethod, "click type Text テキスト");
        chatBotAction.clickOnTypeMessage(typeMessageText);

        logStep = logStepInfo(logMethod, "Click 作成する");
        chatBotAction.clickOnCreateTypeMessage(bntCreateTypeMessage);

        logStep = logStepInfo(logMethod, " enter text to textField");
        chatBotAction.inputContentTextField(txtContentScenario);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content text save success");
        Assert.assertTrue(chatBotAction.isContentChatTypeText(txtContentScenario));
    }

    @Test(priority = 9, enabled = true)
    public void TC_07_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Add image message scenario");
        openUrl(driver, urlChatbot);
        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 挨拶シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoGreetingScenario);

        logStep = logStepInfo(logMethod, "Click メッセージを追加");
        chatBotAction.clickOnButtonAddMessage();

        logStep = logStepInfo(logMethod, "click type image イメージ");
        chatBotAction.clickOnTypeMessage(getTypeMessageImage);

        logStep = logStepInfo(logMethod, "Click 作成する");
        chatBotAction.clickOnCreateTypeMessage(bntCreateTypeMessage);

        logStep = logStepInfo(logMethod, " select image");
        chatBotAction.selectFileImage(srcimage);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content image save success");
        Assert.assertTrue(chatBotAction.getSRCTypeImage().contains(image));
    }

    @Test(priority = 10, enabled = true)
    public void TC_08_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Add gallery message Scenario");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 挨拶シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoGreetingScenario);

        logStep = logStepInfo(logMethod, "Click メッセージを追加");
        chatBotAction.clickOnButtonAddMessage();

        logStep = logStepInfo(logMethod, "click type image ギャラリー");
        chatBotAction.clickOnTypeMessage(getTypeMessageGallery);

        logStep = logStepInfo(logMethod, "Click 作成する");
        chatBotAction.clickOnCreateTypeMessage(bntCreateTypeMessage);

        logStep = logStepInfo(logMethod, " select image");
        chatBotAction.selectFileImage(srcimage);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content image gallery save success");
        Assert.assertTrue(chatBotAction.getSRCTypeImageGallery().contains(image));
    }

    @Test(priority = 11, enabled = true)
    public void TC_09_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Add question message Scenario");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 挨拶シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoGreetingScenario);

        logStep = logStepInfo(logMethod, "Click メッセージを追加");
        chatBotAction.clickOnButtonAddMessage();

        logStep = logStepInfo(logMethod, "click type question クエスチョン");
        chatBotAction.clickOnTypeMessage(getTypeMessageQuestion);

        logStep = logStepInfo(logMethod, "Click 作成する");
        chatBotAction.clickOnCreateTypeMessage(bntCreateTypeMessage);

        logStep = logStepInfo(logMethod, " Enter text to textField");
        chatBotAction.inputContentTextField(txtContentQuestionScenario);

        logStep = logStepInfo(logMethod, " Select scenario ");
        chatBotAction.selectScenario(autoReplyScenario);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content text save success");
        Assert.assertTrue(chatBotAction.isContentChatTypeText(txtContentQuestionScenario));

        logStep = logStepInfo(logMethod, " Verify link scenario show success");
        Assert.assertTrue(chatBotAction.isContentChatTypeTextScenario(autoReplyScenario));
    }

    @Test(priority = 12, enabled = true)
    public void TC_10_ChatBotDetail() throws IOException {
        logReport = logReport.assignCategory("Chat bot detail - Edit message scenario");
        logMethod = createNodeForExtentReport(logReport, "Edit message Greeting ");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 挨拶シナリオ");
        chatBotAction.clickOnAutoReplyScenario(autoGreetingScenario);

        logStep = logStepInfo(logMethod, "click type text first");
        chatBotAction.clickOnFirstTextAutoReply();

        logStep = logStepInfo(logMethod, " Enter text to textField");
        chatBotAction.inputContentTextField(txtEditContentScenario);

        logStep = logStepInfo(logMethod, " Click 保存する");
        chatBotAction.clickOnSaveChat();

        logStep = logStepInfo(logMethod, " Verify Content text save success");
        Assert.assertTrue(chatBotAction.isContentChatTypeText(txtEditContentScenario));
    }

    @Test(priority = 13, enabled = true)
    public void TC_11_ChatBotDetail() throws IOException {
        logReport = logReport.assignCategory("Chat bot detail - Bot preview");
        logMethod = createNodeForExtentReport(logReport, "Check Scenario message show ");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click ボットプレビュー");
        chatBotAction.clickOnBotPreview(bntPreviewBot);

        logStep = logStepInfo(logMethod, " Verify Content text  Scenario show success");
        Assert.assertTrue(chatBotAction.isContentChatTypeTextPreviewBot(txtContentScenario));

        logStep = logStepInfo(logMethod, " Verify Content image Scenario show success");
        Assert.assertTrue(chatBotAction.getSRCTypeImagePreviewBot().contains(image));

        logStep = logStepInfo(logMethod, " Verify Content image gallery Scenario show success");
        Assert.assertTrue(chatBotAction.getSRCTypeImageGalleryPreviewBot().contains(image));

        logStep = logStepInfo(logMethod, " Verify link scenario Scenario show success");
        Assert.assertTrue(chatBotAction.isContentChatTypeTextPreviewBot(txtContentQuestionScenario));
    }

    @Test(priority = 14, enabled = true)
    public void TC_12_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Auto Reply message base on Scenario");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click ボットプレビュー");
        chatBotAction.clickOnBotPreview(bntPreviewBot);

        logStep = logStepInfo(logMethod, "Input chat bot");
        chatBotAction.inputChatBotPreview("Chat");

        logStep = logStepInfo(logMethod, "Click on Send message");
        chatBotAction.clickOnSendChatBotPreview();

        logStep = logStepInfo(logMethod, " Verify Content text  Auto Reply show success");
        Assert.assertTrue(chatBotAction.isContentChatTypeTextPreviewBot(txtContentAutoReply));

        logStep = logStepInfo(logMethod, " Verify Content image Auto Reply show success");
        Assert.assertEquals(chatBotAction.getSizeSRCImagePreviewBot(), 2);

        logStep = logStepInfo(logMethod, " Verify Content image gallery Auto Reply show success");
        Assert.assertEquals(chatBotAction.getSizeSRCTypeImageGalleryPreviewBot(), 2);

        logStep = logStepInfo(logMethod, " Verify link scenario Auto Reply show success");
        Assert.assertTrue(chatBotAction.isContentChatTypeTextPreviewBot(txtContentQuestionAutoReply));
    }
    @Test(priority = 15, enabled = true)
    public void TC_13_ChatBotKeyword() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Create Keyword With Partial Match Type");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open Chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Open Keyword list screen");
        chatBotAction.clickOnKeywordList();

        logStep = logStepInfo(logMethod, "Open Create Keyword popup");
        chatBotAction.clickOnCreateKeyword();

        logStep = logStepInfo(logMethod, "Enter Partial Match Keyword Name");
        chatBotAction.inputKeywordName(keywordPartialMatchName);

        logStep = logStepInfo(logMethod, "Select Partial Match Type");
        chatBotAction.clickOnPartialMatchType();

        logStep = logStepInfo(logMethod, "Press on Submit button");
        chatBotAction.clickOnSubmit();

        logStep = logStepInfo(logMethod, "Verify Create Keyword Partial Match Type successfully");
        Assert.assertTrue(chatBotAction.isPartialMatchKeywordName(keywordPartialMatchName));
    }
    @Test(priority = 16, enabled = true)
    public void TC_14_ChatBotKeyword() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Create Keyword With Exact Match Type");

        logStep = logStepInfo(logMethod, "Open Create Keyword popup");
        chatBotAction.clickOnCreateKeyword();

        logStep = logStepInfo(logMethod, "Enter Exact Match Keyword Name");
        chatBotAction.inputKeywordName(keywordExactMatchName);

        logStep = logStepInfo(logMethod, "Select Exact Match Type");
        chatBotAction.clickOnExactMatchType();

        logStep = logStepInfo(logMethod, "Click on Submit button");
        chatBotAction.clickOnSubmit();

        logStep = logStepInfo(logMethod, "Verify Create Keyword Partial Match Type successfully");
        Assert.assertTrue(chatBotAction.isExactMatchKeywordName(keywordExactMatchName));
    }
    @Test(priority = 17, enabled = true)
    public void TC_15_EditChatBotKeyword() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Edit Keyword With Parital Match Type");

        logStep = logStepInfo(logMethod, "Edit Partial Match Keyword popup");
        chatBotAction.clickOnEditPartialMatch();

        logStep = logStepInfo(logMethod, "Edit Partial Match Keyword Name");
        chatBotAction.inputKeywordName(editKeywordPartialMatchName);

        logStep = logStepInfo(logMethod, "Select Exact Match Type");
        chatBotAction.clickOnExactMatchType();

        logStep = logStepInfo(logMethod, "Click on Submit button");
        chatBotAction.clickOnSubmit();

        logStep = logStepInfo(logMethod, "Verify Update Keyword Name with Partial Match Type successfully");
        Assert.assertTrue(chatBotAction.isEditPartialMatchKeywordName(updatedKeywordPartialMatchName));
    }
    @Test(priority = 18, enabled = true)
    public void TC_16_EditChatBotKeyword() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Edit Keyword With Exact Match Type");

        logStep = logStepInfo(logMethod, "Open Edit Exact Match Keyword popup");
        chatBotAction.clickOnEditExactMatch(keywordExactMatchName);

        logStep = logStepInfo(logMethod, "Edit Exact Match Keyword Name");
        chatBotAction.inputKeywordName(editKeywordExactMatchName);

        logStep = logStepInfo(logMethod, "Select Partial Match Type");
        chatBotAction.clickOnPartialMatchType();

        logStep = logStepInfo(logMethod, "Click on Submit button");
        chatBotAction.clickOnSubmit();

        logStep = logStepInfo(logMethod, "Verify Update Keyword with Exact Match Type successfully");
        Assert.assertTrue(chatBotAction.isEditExactMatchKeywordName(updatedKeywordExactMatchName));
    }
    @Test(priority = 19, enabled = true)
    public void TC_17_DeleteChatBotKeyword() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Check Delete Parital Match Keyword");

        logStep = logStepInfo(logMethod, "Click on Delete button");
        chatBotAction.clickOnDelete();

        logStep = logStepInfo(logMethod, "Click on Confirm button");
        chatBotAction.clickOnConfirm();

        logStep = logStepInfo(logMethod, "Verify Delete Keyword successfully");
        Assert.assertTrue(chatBotAction.isEditExactMatchKeywordName(updatedKeywordExactMatchName));
    }

    @Test(priority = 20, enabled = true)
    public void TC_18_ChatBotDetail() throws IOException {
        logReport = logReport.assignCategory("Keyword Registration Validation");
        logMethod = createNodeForExtentReport(logReport, "Open chatbot detail ");
        openUrl(driver, urlChatbotEdit);
        logStep = logStepInfo(logMethod, "Click 挨拶シナリオ");
        chatBotAction.clickOnAutoReplyScenario(greetingScenario);
        logStep = logStepInfo(logMethod, "Click on Create Keyword");
        chatBotAction.clickOnKeywordRegistration();
        logStep = logStepInfo(logMethod, "Validate Maxleng");
        Assert.assertTrue(chatBotAction.isMaxLengthKeyword("20"));

    }

    @Test(priority = 21, enabled = true)
    public void TC_19_ChatBotDetail() throws IOException {
        logReport = logReport.assignCategory("Keyword Registration Validation");
        logMethod = createNodeForExtentReport(logReport, "Open chatbot detail ");
        openUrl(driver, urlChatbot);
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 挨拶シナリオ");
        chatBotAction.clickOnAutoReplyScenario(greetingScenario);

        logStep = logStepInfo(logMethod, "Click on Create Keyword");
        chatBotAction.clickOnKeywordRegistration();

        logStep = logStepInfo(logMethod, "input TeamAuto");
        chatBotAction.inputKeywordField(keywordRegistration);

        logStep = logStepInfo(logMethod, "Click on Keyword Confirmation");
        chatBotAction.clickOnKeywordConfirmationButton();

        logStep = logStepInfo(logMethod, "Verify keyword created");
        Assert.assertTrue(chatBotAction.isKeywordSelected(keywordRegistration));
    }

    @Test(priority = 22, enabled = true)
    public void TC_20_ChatBotDetail() throws IOException {
        logReport = logReport.assignCategory("Keyword Registration Validation");
        logMethod = createNodeForExtentReport(logReport, "Open chatbot detail ");
        openUrl(driver, urlChatbot);
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click 挨拶シナリオ");
        chatBotAction.clickOnAutoReplyScenario(greetingScenario);

        logStep = logStepInfo(logMethod, "Click on remove Keyword");
        chatBotAction.clickOnRemoveKeywordRegistration();

        logStep = logStepInfo(logMethod, "Click on Create Keyword");
        chatBotAction.clickOnKeywordRegistration();

        logStep = logStepInfo(logMethod, "Select Keyword");
        chatBotAction.selectOnVaLueKeyword(keywordRegistration);

        logStep = logStepInfo(logMethod, "Verify keyword created");
        Assert.assertTrue(chatBotAction.isKeywordSelected(keywordRegistration));
    }

    @Test(priority = 23, enabled = true)
    public void TC_21_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Add a scenario");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click シナリオを追加する");
        chatBotAction.clickOnAddScenario(bntAddScenario);

        logStep = logStepInfo(logMethod, "input name < 20 character");
        chatBotAction.inputNameScenario(nameScenario);

        logStep = logStepInfo(logMethod, "Click on 作成する");
        chatBotAction.clickOnSaveScenario(bntSaveScenario);

        logStep = logStepInfo(logMethod, "Open chat bot detail");
        openUrl(driver, urlChatbot);
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Verify Add a scenario success");
        Assert.assertTrue(chatBotAction.isNameScenario(nameScenario));
    }

    @Test(priority = 24, enabled = true)
    public void TC_22_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Edit a scenario");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click scenario detail");
        chatBotAction.clickOnScenarioDetail(nameScenario);

        logStep = logStepInfo(logMethod, "input name < 20 character");
        chatBotAction.inputEditNameScenario(editNameScenario);

        logStep = logStepInfo(logMethod, "Click on シナリオ一覧に戻る");
        chatBotAction.clickOnReturnScenarioList("シナリオ一覧に戻る");

        logStep = logStepInfo(logMethod, "Click on シナリオ一覧に戻る");
        chatBotAction.clickOnReturnScenarioList("シナリオ一覧に戻る");

        logStep = logStepInfo(logMethod, "Verify edit a scenario success");
        Assert.assertTrue(chatBotAction.isNameScenario(editNameScenario));
    }

    @Test(priority = 25, enabled = true)
    public void TC_23_ChatBotDetail() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Delete a scenario");
        openUrl(driver, urlChatbot);

        logStep = logStepInfo(logMethod, "Open chatbot detail");
        chatBotAction.clickOnChatBotDetailWithName(chatbotName);

        logStep = logStepInfo(logMethod, "Click scenario detail");
        chatBotAction.clickOnScenarioDetail(editNameScenario);

        logStep = logStepInfo(logMethod, "Click on シナリオを削除");
        chatBotAction.clickOnReturnScenarioList("シナリオを削除");

        logStep = logStepInfo(logMethod, "Click on 削除する");
        chatBotAction.clickOnConfirmDeleteScenario("削除する");

        logStep = logStepInfo(logMethod, "Verify edit a scenario success");
        Assert.assertFalse(chatBotAction.isNameScenario(editNameScenario));
    }

    @Test(priority = 26, enabled = true)
    public void TC_03_ChatbotTop() throws IOException {
        logReport = logReport.assignCategory("Edit Chat bot Top");
        openUrl(driver, urlChatbot);
        logStep = logStepInfo(logMethod, "Click Chatbot Setting button");
        chatBotAction.clickBtnChatbotSetting(chatbotName);
        logStep = logStepInfo(logMethod, "Click Chatbot Edit button");
        chatBotAction.clickBtnChatbotEdit(chatbotName,"ボット設定");
        logStep = logStepInfo(logMethod, "Input other chatbot name");
        chatBotAction.inputChatbotName(chatbotNameUpdate);
        logStep = logStepInfo(logMethod, "Input other chatbot description");
        chatBotAction.inputChatbotDescription(chatbotNameUpdate);
        logStep = logStepInfo(logMethod, "Click button Submit to Edit chatbot");
        chatBotAction.clickBtnSubmitToEditChatbot();
        logStep = logStepInfo(logMethod, "Verify Edit chatbot successfully");
        Assert.assertTrue(chatBotAction.isChatbotTitle(chatbotNameUpdate));

    }

    @Test(priority = 27, enabled = true)
    public void TC_04_ChatbotTop() throws IOException {
        logReport = logReport.assignCategory("Delete Chat bot Top");
        openUrl(driver, urlChatbot);
        logStep = logStepInfo(logMethod, "Click Chatbot Setting button");
        chatBotAction.clickBtnChatbotSetting(chatbotNameUpdate);
        logStep = logStepInfo(logMethod, "Click Chatbot delete button");
        chatBotAction.clickBtnChatbotEdit(chatbotNameUpdate,"削除");
        logStep = logStepInfo(logMethod, "Click submit button to delete Chatbot");
        chatBotAction.clickBtnSubmitToDeleteChatbot();
        logStep = logStepInfo(logMethod, "Verify delete chatbot successfully");
        Assert.assertFalse(chatBotAction.isChatbotTitle(chatbotNameUpdate));
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
