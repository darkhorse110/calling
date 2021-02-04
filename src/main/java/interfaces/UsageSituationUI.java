package interfaces;

import actions.commons.Constants;

public class UsageSituationUI {
    public static String btnUsageSituation = "//span[@translate='usage_situation']//ancestor::li";
    public static String btnReportOnUserUsage = "//a[@translate='report_on_user_usage']//parent::li";
    public static String textCountConnectionOfUser= "//span[@title='"+Constants.USERTEAMAUTO+"']//ancestor::td//following-sibling::td[4]//span//span";
    public static String btnView= "//span[@title='"+Constants.USERTEAMAUTO+"']//ancestor::td//following-sibling::td[5]//div";
    public static String textName= "//span[@title='"+Constants.USERTEAMAUTO+"']";
    public static String txtSearchByName = "//input[@name='name']";
    public static String selectBoxMonth = "//select[@name='month']";
    public static String optionThisMonth= "//option[1]";
    public static String textTypeSales= "//span[text()='Sales'][1]";
    public static String textFirstIDSalesLight= "(//span[text()='Sales']//ancestor::td/following-sibling::td/span/span)[1]";
    public static String textFirstCountConnection= "(//span[text()='Sales']//ancestor::td/following-sibling::td/span/span)[4]";
}
