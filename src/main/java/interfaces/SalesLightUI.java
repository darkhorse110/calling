package interfaces;

public class SalesLightUI {

    public static String bntHostOKDeviceConfirm = "//div[@class='turn-on-devices ng-scope']//span[text()='OK']";
    public static String bntGuestCancelDeviceConfirm = "//div[@class='turn-on-devices ng-scope']//button[@translate='cancel2' or text()='キャンセル']";
    public static String bntGuestTurnOnCameraAndMicDeviceConfirm = "//div[@class='turn-on-devices ng-scope']//span[@translate='turn_on_mic_and_camera' or @translate='turn_on_camera' or @translate='turn_on_mic']";
    public static String txtMicGuest = "//span[@translate='muted' or @translate='mute']";
    public static String txtCameraGuest = "//span[@translate='video_off' or @translate='video_on']";
    public static String formProfileHost = "(//span[@translate='show_more_profile'])[2]";
    public static String txtContentSpanProfileDetail = "//div[@class='calling-modal__content']//span[text()='%s']";
    public static String txtContentTagAProfileDetail = "//div[@class='calling-modal__content']//a[text()='%s']";
    public static String txtContentTagPProfileDetail = "//div[@class='calling-modal__content']//p[text()='%s']";
    public static String txtChat = "//form[@name='chatForm']//textarea[not(@disabled='disabled')]";
    public static String bntSendChatIcon = "//form[@name='chatForm']//button[@translate='send_chat']";
    public static String txtContentChatSendSuccess ="(//span[@class='chat-message']/span[text()='%s'])";
    public static String lblLoading = "//div[@class='calling-loading ng-scope']";
    public static String lblChatLoading ="//div[@class='chat-loading ng-scope']";
    public static String lblTimeChat ="//p[span[@class='chat-message']/span[text()='%s']]//span[@ng-bind='message.time' and contains(text(),'%s')]";
    public static String boxChatShow = "//chat-component[not(contains(@class,'hide'))]";
    public static String lblXIconBoxChat = "//button[contains(@ng-click,'displayChatContent')]";
    public static String lblOpenIconBoxChat = "//span[contains(@class,'calling-icon-chat-message')]";
    public static String chbEnterMethod = "//span[@translate='press_enter_to_send']";
    public static String checkboxEnterMethod = "//div[@class='chat-component__footer--sent-message']//input";
    public static String lblRecordIcon = "//span[contains(@class,'calling-icon-record')]";
    public static String lblRecordStartLabel = "//span[@translate='start_record_saleslight']";
    public static String lblRecordingStoplabel = "//span[@translate='stop_record_saleslight']";
    public static String lblRecodingSale = "//span[@translate='recording']";
    public static String iconExit ="//button[contains(@uib-popover-template,'close-meeting')]/img";
    public static String bntExit ="//button[@translate='to_exit']";
    public static String formSaveInformation = "//h3[@translate='your_information']";
    public static String formUserConnect ="//div[contains(@class,'participant-saleslight__main')]";
    public static String formDeviceSelection = "//span[@translate='setting']//parent::div";
    public static String txtMessage = "//div[@class='toast-message' and text()='%s']";
    public static String iconSettingDevice = "//span[contains(@class,'calling-icon-setting')]";
    public static String selectBoxCamera = "//select[@id='camera_option']";
    public static String selectBoxMic = "//select[@id='microphone_option']";
    public static String selectBoxSoundOutput= "//select[@id='sound_output_option']";
    public static String participantComponent= "//participant-saleslight-component";
    public static String option2Mic= "//option[text()='Fake Audio Input 1']";
}

