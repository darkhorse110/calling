package interfaces;

import actions.commons.AbstractPages;

public class InviteMemberPageUI extends AbstractPages {
    public static String clickInviteByUrl = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[2]/ui-view/div/div[2]/div/ul/li[2]";
    public static String clickCopyUrlButton = "//div[@translate='copy_url_first']";
    public static String txtInputMail = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[2]/ui-view/div/div[2]/div/div/div[1]/form/div[2]/tag-component/div[1]/input";
    public static String clickToPullDown = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[2]/ui-view/div/div[2]/div/div/div[1]/form/div[1]/select";
    public static String selectGroup = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[2]/ui-view/div/div[2]/div/div/div[1]/form/div[1]/select/option[4]";
    public static String sendMailButton = "//*[@id=\"scroll-top\"]/div[1]/ui-view/div/div[2]/ui-view/div/div[2]/div/div/div[1]/form/div[3]/button[2]/span[1]";
    public static String txtInviteURL ="//div[@class='invite-member__url-token']/textarea";
}
