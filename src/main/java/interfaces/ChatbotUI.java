package interfaces;

public class ChatbotUI {
    public static String btnChatbot = "//button[@translate='open_chatbot']";
    public static String btnCreateChatbot = "//button[@class='calling-btn bot-page__add-new']";
    public static String btnSubmitToCreateChatbot = "//img[@class='ccb-form__actions__button-icon']";
    public static String btnSettingChatbot = "//span[text()='%s']/..//i[@class='material_icon icon_bot_setting']";
    public static String btnSettingChatbotUpdate = "//span[text()='autotestupdate']/..//button[@class='ccb_btn_base icon btn_bot_setting']";
    public static String btnEditChatbot = "//span[text()='%s']/..//span[@class='pulldown_link' and text()='%s']";
    public static String btnSubtmitToEditChatbot = "//img[@class='ccb-form__actions__button-icon']";
    public static String btnDeleteChatbot = "//li[@class='ccb_util_pdrl16']//span[text()='削除']";
    public static String btnSubmitToDeleteChatbot = "//div[@class='modal-modify__group-button']//span[text()='削除する']";
    public static String txtChatbotName = "//input[@name='data_name']";
    public static String txtChatbotDescription = "//textarea[@name='data_description']";
    public static String lblChatbotTitle = "//div[@class='bot-page__list']//span[@class='title' and text()='%s']";
    public static String bntChatBotDetail ="//div[contains(@class,'card-bot')]//span[@class='title' and text()='%s']";
    public static String bntDefaultScenario ="//span[@class='ccb-card-wf__name' and text()='%s']";
    public static String bntAddMessage ="//button[@id='btn_add_block']";
    public static String bntTypeMessage="//div[@class='box_block_radio']//span[text()='%s']";
    public static String bntCreateTypeMessage="//div[@class='ccb-form__actions']//span[text()='%s']";
    public static String txtContentField="//textarea[@id='text_content']";
    public static String bntSaveChat="//button[@id='btn_save_block']";
    public static String txtContentChatTypeText ="//p[@class='content_message' and text()='%s']";
    public static String txtContentChatTypeScenario ="//span[@class='label ccb_util_ts' and text()='%s']";
    public static String txtTypeFile ="//input[@type='file']";
    public static String imgTypeFile ="//img[@class='content_image']";
    public static String imgTypeFileGallery  ="//img[@class='content_imagecards']";
    public static String cbbScenario  ="//select[@id='workflow_id']";
    public static String txtFirstTypeText = "(//p[@class='content_message'])[1]";
    public static String lblLoading= "//div[@class='ccb_loader' and @data-is-visible='false']";


//Keyword registration
    public static String bntGreetingScenario = "//div[@class='ccb-group-box__list-card-wf']//span[contains(text(), '挨拶シナリオ')]";
    public static String bntAutoReplyScenario = "//div[@class='ccb-group-box__list-card-wf']//span[contains(text(), '自動返答シナリオ')]";
    public static String bntKeywordRegistration ="//button[@class='button-save calling-button calling-button--primary-reverse']";
    public static String bntRemoveKeywordList = "//div[@class='ccb_edit_keyword__item']//img";
    public static String txtKeywordField ="//input[@class='calling-input calling-input--large']";
    public static String listboxSelectKeyword ="//select[@class='calling-select calling-select--large']";
    public static String cbbSelectKeyword= "//select[@name='type']";
    public static String radioPartitionmatch = "//span[contains(text(), '部分一致')]";
    public static String radioExactmatch ="//span[contains(text(), '完全一致のみ')]";
    public static String btnAddKeyword = "//span[@class='ccb_util_tm is-edit']";
    public static String bntSave = "//button[@id='btn_save_block']";
    public static String txtDuplicateKeywordPopup ="//div[@class='rrt-middle-container']//*[contains(text(), '入力されたキーワードはすでに登録済みです。')]]";
    public static String bntClose = "//span[@class='ccb_util_tm']";
    public static String txtTextContent ="//textarea[@name='text_content']";
    public static String bntKeywordConfirmation ="//button[@class='button-save calling-button calling-button--primary']";
    public static String txtContentTitle ="//p[@class='content_message']";

    //Add Choice
    public static String bntAddChoice = "//button[@id='btn_create_bot'";
    public static String txtChoiceName ="//input[@id='data_name']";
    public static String radioScenario ="//input[@value='WORKFLOW']";
    public static String listboxScenario ="//select[@id='workflow_id']//option[@value='13344']";
    public static String radioURL ="//input[@value='URL']";
    public static String txtUrlInput ="//input[@id='url_path']";
    public static String txtRequiredField = "//*[contains(text(), '必須項目です。')]";
    public static String bntToAdd ="//button[@type='button']//span[contains(text(),'追加する')]";



    public static String lblChatbotTitleUpdate = "//span[contains(text(),'autotestupdate')]";
    public static String bntPreviewBot = "//div[@class='ccb-detail__control-action']//span[text()='%s']";
    public static String txtPreviewText = "//div[@class='bot-preview__chat']//span[contains(text(),'%s')]";
    public static String txtPreviewImage = "//div[@class='bot-preview']//div[@class='chat-message-image']/img";
    public static String txtPreviewImageGallery = "//div[@class='bot-preview']//div[contains(@class,'chat-message-imagecards')]/img";
    public static String txtChatBotPreview = "//input[@id='bot-input']";
    public static String bntSendChatBotPreview = "//i[@class='calling-icon calling-icon-send']";
    public static String lblKeywordSelected = "//div[@class='ccb_edit_keyword__item']/span[text()='%s']";


    //scenario
    public static String bntScenario ="//div[@class='ccb-group-box' and @data-group-name='Group']//button/span[text()='%s']";
    public static String txtScenario = "//input[@id='data_name']";
    public static String bntAddScenario = "//div[@class='ccb-form__actions']//button/span[text()='%s']";
    public static String lblScenario = "//div[@class='ccb-group-box' and @data-group-name='Group']//div[@class='ccb-card-wf']//span[text()='%s']";
    public static String bntBackScenarioList = "//span[text()='%s']";
    public static String bntScenarioName = "//div[@class='ccb-card-wf']//span[text()='%s']";
    public static String txtEditScenario = "//input[@id='input_edit_wf_name']";
    public static String bntDeleteScenario ="//div[@class='ccb_modal modal-modify modal-modify__delete-block']//span[text()='%s']";
//keyword
    public static String bntKeywordList = "//button[@class='calling-button calling-button--primary-reverse']//span[contains(text(),'キーワード一覧')]";
    public static String bntCreateKeyword = "//button[@class='calling-button calling-button--primary']//span[contains(text(),'キーワードを追加する')]";
    public static String txtKeywordName = "//input[@class='calling-input calling-input--large ccb_util_mgb16']";
    public static String checkboxPartialMatch = "//div[@class='calling-radio match-type']//div[@class='calling-radio__alter']";
    public static String checkboxExactMatch = "//div[@class='calling-radio match-type-2']//div[@class='calling-radio__alter']";
    public static String bntCreate = "//button[@class='calling-button calling-button--x-large calling-button--primary ccb_util_mgl12 ccb-form__action']";
    public static String txtPartialMatchKeywordName = "//tr[@class='clear-border']//td//span[@class='match-type']";
    public static String txtExactMatchKeywordName = "//tr//td//span[@class='match-type-2']";
    public static String txtEditPartialMatchKeywordName = "//tr//td//span[@class='match-type-2']";
    public static String txtEditExactMatchKeywordName = "//tr//td//span[@class='match-type']";
    public static String bntPartialMatchEdit = "//tr[@class='clear-border']//td[@class='action']//a[@class='ccb_keyword__table__link ccb_keyword__table__link--blue']";
    public static String bntExactMatchEdit = "//tr[contains(.,'%s')]//td[@class='action']//a[@class='ccb_keyword__table__link ccb_keyword__table__link--blue']";
    public static String bntDelete = "//tr[@class='clear-border']//td//a[@class='ccb_keyword__table__link ccb_keyword__table__link--gray confirm-button']//span//span[contains(text(),削除)]";
    public static String bntConfirm = "//button[@class='calling-button calling-button--orange']";
}
