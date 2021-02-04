package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.SelectProfileAction;
import actions.pageactions.SelectWorkSpaceAction;
import actions.pageactions.SignInAction;
import actions.pageactions.WorkSpaceHomeAction;
import com.aventstack.extentreports.ExtentTest;
import interfaces.SelectProfileUI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static actions.commons.ReportListener.*;
import static actions.commons.ReportListener.logClass;

public class SelectProfile extends AbstractPages {
    public WebDriver driver;
    public SignInAction signInAction;
    public SelectProfileAction selectProfileAction;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public String url;

    @Parameters({"browser"})
    @BeforeClass
    public void String (String browserName){
        logClass = createTestForExtentReport(extent, "Test suit for Select Profile screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
        driver = getBrowser(browserName);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        workSpaceHomeAction = PageGeneratorManager.getWorkSpaceHomeAction(driver);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        selectProfileAction = PageGeneratorManager.getSelectProfileAction(driver);
    }

    @Test(priority = 0)
    public void PreCondition() throws IOException, InterruptedException {
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logStep = logStepInfo(logMethod,"Login Successfully");
        signInAction.inputLogin(Constants.EMAIL,Constants.PASSWORD,logStep);
    }

    @Test(priority = 1)
    public void L16_TC_1_GoToProfilePage () throws IOException,InterruptedException {
        logReport = logReport.assignCategory("Select Profile");
        logStep = logStepInfo(logMethod,"Click Profile icon");
        selectProfileAction.clickProfileIcon();
        logStep = logStepInfo(logMethod,"Click Profile button");
        selectProfileAction.clickProfileLink();
        logStep = logStepInfo(logMethod,"Verified URL Profile");
        selectProfileAction.verifyURLProfile(logStep);
        url = getCurrentUrl(driver);

    }
    @Test(priority = 2)
    public void L16_TC_2_GoToEditProfilePage() throws IOException,InterruptedException {
        openUrl(driver,url);
        logStep = logStepInfo(logMethod,"Click Edit Profile btn");
        selectProfileAction.clickbtnEditProfile();
        logStep = logStepInfo(logMethod,"Verify Edit Profile");
        selectProfileAction.verifyURLEditProfile(logStep);
    }
    @Test(priority = 3)
    public void L16_TC_3_GoToChangePasswordPage () throws IOException,InterruptedException{
        openUrl(driver,url);
        logStep = logStepInfo(logMethod,"Click Change Password btn");
        selectProfileAction.clickbtnChangePassword();
        logStep = logStepInfo(logMethod,"Verify Change Password URL");
        selectProfileAction.verifyURLChangePassword(logStep);

    }

    @Test(priority = 4)
    public void L16_TC_4_GoToTabNotification() throws IOException,InterruptedException{
        openUrl(driver,url);
        logStep = logStepInfo(logMethod,"Click Tab Notification");
        selectProfileAction.clickTabNotification();
        logStep = logStepInfo(logMethod,"Verify Tab Notification");
        selectProfileAction.verifyTabNotification(logStep);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }


}
