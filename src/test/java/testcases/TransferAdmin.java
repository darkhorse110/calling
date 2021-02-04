package testcases;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static actions.commons.ReportListener.*;
import static actions.commons.ReportListener.logClass;

public class TransferAdmin extends AbstractPages {

    public WebDriver driver;
    public MemberManagementAction memberManagementAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public TopPageAction topPageAction;
    public InviteMemberAction inviteMemberAction;
    public TransferAdminAction transferAdminAction;


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        topPageAction = PageGeneratorManager.getTopPageAction(driver);
        memberManagementAction = PageGeneratorManager.getMemberManagementAction(driver);
        inviteMemberAction  = PageGeneratorManager.getInviteMemberAction(driver);
        transferAdminAction = PageGeneratorManager.getTransferAdminAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Member Management screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }
      /*

    Test case here

     */

}
