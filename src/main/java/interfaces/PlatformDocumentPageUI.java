package interfaces;

public class PlatformDocumentPageUI {
    public static String btnMeetingSale = "//button[contains(text(),'Meeting/Salesを開く')]";
    public static String btnDocument = "//span[contains(text(),'資料')]";
    public static String btnDocumentPreview = "//div/span[text()='%s']/..//span[@translate='preview'][1]";
    public static String btnOnDownload = "//input[@name='can_download' and @value=1]";
    public static String btnOffDownload = "//input[@name='can_download' and @value=0]";
    public static String btnSubmitToSaveSetting = "//span[@translate='save']";
    public static String btnDeleteTalkscript = "//input[@name='delete_talk_script' and @value='1']";
    public static String btnDeleteDocument = "//div[@class='document-file__actions']//span[@translate='delete']";
    public static String btnDeleteFileName = "(//div[@class='document-file__name-with-actions'][span[text()='%s']]//div[@class='document-file__actions']//span[@translate='delete'])";
    public static String btnSubmitDeleteDocument = "//div[contains(@style,'display: block;')]//button[@ng-click='vm.onConfirm(); vm.hidePopover()']";
    public static String btnCreateFolder = "//button[@translate='create_folder']";
    public static String btnSubmitToCreateFolder = "//span[contains(text(),'作成する')]";
    public static String btnUpload = "//button[@translate='upload_material']";
    public static String btnUploadDocument = "//button[@ng-model='UploadDocumentModalCtrl.documentFile']";
    public static String btnUploadTalkScript = "//button[@ng-model='UploadDocumentModalCtrl.talkScriptFile']";
    public static String btnSubmitUploadDocument = "//span[contains(text(),'アップロードする')]";
    public static String btnPassword = "//div[@class='switch-button__slider']";
    public static String btnEditDocument = "//button[@ng-click='DocumentTreeCtrl.openEditDocumentModal(document)']";
    public static String btnDeleteFolder = "//div[@class='document-folder__actions']//span[@translate='delete']";
    public static String btnSubmitToDeleteFolder = "//div[@class='col-xs-6 ng-scope']//button[@ng-click='vm.onConfirm(); vm.hidePopover()']";
    public static String txtSearchByName ="//input[@placeholder='名前で検索']";
    public static String txtSearchByTime = "//input[@placeholder='From']";
    public static String txtFolderName = "//input[@placeholder='フォルダ名を入力してください']";
    public static String txtPassword = "//input[@name='document_password']";
    public static String selectFolder = "//select[@name='document_folder']";
    public static String resultSearch = "//span[contains(text(),'document')]";
    public static String lblEditDocument = "//h2[@translate='update_document']";
    public static String lblEditSuccessfully = "//div[@aria-label='変更完了しました']";
    public static String lblDeleteSuccessful = "//div[contains(text(),'削除しました')]";
    public static String lblCreateFolder = "//h2[contains(text(),'フォルダを作成')]";
    public static String lblCreateFolderSuccessful = "//div[contains(text(),'作成完了しました')]";
    public static String fileDocument = "(//span[contains(text(),'%s')])[1]";
    public static String uploadProcess = "//span[@translate='processing']";
    public static String fileDocumentpdf = "//input[@type='file' and contains(@ng-model,'documentFile')]";
    public static String fileTalksciprt = "//input[@type='file' and contains(@ng-model,'talkScriptFile')]";

}
