package testcases;

import actions.commons.AbstractPages;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URISyntaxException;

import static actions.commons.ReadExcelFile.testData;
import static actions.commons.ReportListener.*;
import static actions.commons.ReportListener.logMethod;

public class InviteMemberPage extends AbstractPages {
    private String inviteURL;
    private WebDriver driver;
    public TopPageAction topAction;
    public SignInAction signInAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public InviteMemberPageAction inviteMemberPageAction;

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        inviteMemberPageAction = PageGeneratorManager.getInviteMemberPageAction(driver);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        topAction = PageGeneratorManager.getTopPageAction(driver);
        logClass = createTestForExtentReport(extent, "Test suit for Sign In screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
    }
    /*

Login
     */

    @Test(dataProvider = "SignInData",priority = 1)
    public void LoginAndGoToTopPage(String testcaseName, String workspaceID, String mail, String password, String JpErrorMessage
            , String EnErrorMessage) throws IOException, InterruptedException {
        logMethod = createNodeForExtentReport(logReport, "TC: " + testcaseName);
        logStep = logStepInfo(logMethod, "Pre- Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(workspaceID, logStep);
        logStep = logStepInfo(logMethod, "Input login");
        signInAction.inputLogin(mail, password, logReport);
        logReport = logReport.assignCategory("Enter Top Page and then select Invite Member in Setting icon");

        topAction.clickIconSetting ();
        topAction.clickInviteMember ();
        logReport = logReport.assignCategory("Entered Invite Screen");
        inviteMemberPageAction.clickToPullDownAndSelectGroup();
        String mailInvite = "dtnhan01@yopmail.com";
        inviteMemberPageAction.inputMail(mailInvite);
        inviteMemberPageAction.sendMailButton();

    }

    //@Test(priority = 2) This method use for InviteMemberByUrl only
    public void GoToInviteByURLPage() throws IOException, InterruptedException {
        logReport = logReport.assignCategory("Select Workspace screen");
        logMethod = createNodeForExtentReport(logReport, "TC001_0 ");
        logStep = logStepInfo(logMethod, "Go to Invite By Url");
        inviteMemberPageAction.clickInviteByUrlButton();
    }
    //@Test(priority = 3)
    public void StoreURLAndOpenInviteURL() throws IOException, InterruptedException, UnsupportedFlavorException, URISyntaxException {
        logReport = logReport.assignCategory("Store URL to invite");
        logMethod = createNodeForExtentReport(logReport, "TC002_0 ");
        logStep = logStepInfo(logMethod, "Store URL");
        inviteMemberPageAction.clickCopyUrlButton();
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // Paste
        Clipboard clipboard = toolkit.getSystemClipboard();
        this.inviteURL = (String) clipboard.getData(DataFlavor.stringFlavor);
    }

    //---------------------Prepare Data to test-------------------------------//
    @DataProvider(name = "SignInData")
    public static Object[][] getData() {
        String excelPath = "src/test/java/testdata/SigninData.xlsx";
        Object[][] data;
        data = testData(excelPath, "SigninData");
        return data;
    }
}
