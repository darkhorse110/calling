package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static actions.commons.ReportListener.*;

    public class TabNotification extends AbstractPages {
        public WebDriver driver;
        public SignInAction signInAction;
        public SelectProfileAction selectProfileAction;
        public WorkSpaceHomeAction workSpaceHomeAction;
        public SelectWorkSpaceAction selectWorkSpaceAction;
        public TabNotificationAction tabNotificationAction;
        public String urlEditProfile;

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
            tabNotificationAction = PageGeneratorManager.getTabNotificationAction(driver);
        }

        @Test(priority = 0)
        public void PreCondition() throws IOException, InterruptedException {
            logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
            logStep = logStepInfo(logMethod, "Input workspace ID");
            selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
            logStep = logStepInfo(logMethod,"Login Successfully");
            signInAction.inputLogin(Constants.EMAIL,Constants.PASSWORD,logStep);
            selectProfileAction.clickProfileIcon();
            selectProfileAction.clickProfileLink();
            urlEditProfile = getCurrentUrl(driver);
            selectProfileAction.clickTabNotification();
        }

        @Test(priority = 1)
        public void L16_4_TC_2_SwitchBtnChatNotification () throws IOException, InterruptedException {
            openUrl(driver,urlEditProfile);
            selectProfileAction.clickTabNotification();
            logStep = logStepInfo(logMethod,"Click Chat Notification btn");
            tabNotificationAction.clickChatNotification();
            logStep = logStepInfo(logMethod,"Verify click Chat Notification btn successfully");
            tabNotificationAction.verifySuccessufully();
        }

        @Test(priority = 2)
        public void L16_4_TC_3_SwitchBtnMailNotification () throws IOException, InterruptedException {
            openUrl(driver,urlEditProfile);
            selectProfileAction.clickTabNotification();
            logStep = logStepInfo(logMethod,"Click Mail Notification btn");
            tabNotificationAction.clickEmailNotification();
            logStep = logStepInfo(logMethod,"Verify click Mail Notification btn successfully");
            tabNotificationAction.verifySuccessufully();

        }
        @AfterClass(alwaysRun = true)
        public void tearDown() {
            closeBrowser(driver);
        }

        }
