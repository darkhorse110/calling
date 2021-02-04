package interfaces;

public class InviteMemberByMailUI {
    //Xpath from Yopmail
    public static String txtInputMailOnYopMail = "//*[@id=\"login\"]";
    public static String clickButtonCheckMail = "//*[@id=\"f\"]/table/tbody/tr[1]/td[3]/input";
    public static String selectMail = "//*[@id=\"m1\"]/div/a/span[2]";
    public static String linkInvite = "//*[@id=\"mailmillieu\"]/div[2]/p[3]";
    public static String getMailButton = "//*[@id=\"lrefr\"]/span/span";
    //Xpath from Calling site
    public static String txtInputName = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[1]/div/form/div[1]/label[2]/input";
    public static String txtInputPass = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[1]/div/form/div[3]/div/input";
    public static String txtInputPassConfirm = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[1]/div/form/div[4]/div/input";
    public static String msgValidatePass = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[1]/div/form/div[3]/span";
    public static String msgValidatePass2 = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[1]/div/form/div[4]/span";
    public static String submitBtn = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[1]/div/form/div[7]/button";
    public static String clickPrivacyLink = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[1]/div/form/div[5]/a";
    public static String clickCallingIcon = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[2]/div[1]/a";
}