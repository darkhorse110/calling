package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static actions.commons.ReportListener.*;

public class ChangeAvatar extends AbstractPages {
    public WebDriver driver;
    public SignInAction signInAction;
    public ChangeAvatarAction changeAvatarAction;
    public SelectProfileAction selectProfileAction;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public EditProfileAction editProfileAction;
    public String urlChangeAvatar;


    @Parameters({"browser"})
    @BeforeClass
    public void String (String browserName) throws InterruptedException {
        logClass = createTestForExtentReport(extent, "Test suit for Select Profile screen");
        logClass = createNodeForExtentReport(logClass,"Initial Setup successful");
        driver = getBrowser(browserName);
        signInAction = PageGeneratorManager.getSignInAction(driver);
        workSpaceHomeAction = PageGeneratorManager.getWorkSpaceHomeAction(driver);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction(driver);
        selectProfileAction = PageGeneratorManager.getSelectProfileAction(driver);
        editProfileAction = PageGeneratorManager.getEditProfileAction(driver);
        changeAvatarAction = PageGeneratorManager.getChangeAvatarAction(driver);
    }

    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logStep = logStepInfo(logMethod,"Login Successfully");
        signInAction.inputLogin(Constants.EMAIL,Constants.PASSWORD,logStep);
        logStep = logStepInfo(logMethod,"Reach to Edit Profile page");
        selectProfileAction.clickProfileIcon();
        selectProfileAction.clickProfileLink();
        selectProfileAction.clickbtnEditProfile();
        editProfileAction.clickEditAvatarbtn();
        urlChangeAvatar = getCurrentUrl(driver);
    }

    @Test(priority = 1)
    public void L16_2_TC_1_SelectImage () throws IOException {
        openUrl(driver,urlChangeAvatar);
        logStep = logStepInfo(logMethod,"Click Select Image button");
        String srcAvatar = changeAvatarAction.getSRCImageAvatar();
        changeAvatarAction.selectImageToUpload();
        logStep = logStepInfo(logMethod,"Verified upload image");
        Assert.assertFalse(changeAvatarAction.isImageAvatarUpdated(srcAvatar));
    }

    @Test(priority = 2)
    public void L16_2_TC_2_PreviewAvatarSelected () throws IOException {
        openUrl(driver,urlChangeAvatar);
        logStep = logStepInfo(logMethod,"Click Select Image button");
        String srcAvatar = changeAvatarAction.getSRCImageAvatar();
        changeAvatarAction.selectImageToUpload();
        logStep = logStepInfo(logMethod,"Verified upload image");
        Assert.assertFalse(changeAvatarAction.isImageAvatarUpdated(srcAvatar));
    }

    @Test(priority = 3)
    public void L16_2_TC_3_ClickCancelButton () throws IOException {
        openUrl(driver,urlChangeAvatar);
        logStep = logStepInfo(logMethod,"Click Cancel button");
        changeAvatarAction.clickCancelbutton();
        logStep = logStepInfo(logMethod,"Verify back to Edit Profile page");
        changeAvatarAction.verifyEditProfilePage(logStep);
    }

    @Test(priority = 4)
    public void L16_2_TC_4_ClickSaveAvatarButton () throws IOException {
        openUrl(driver,urlChangeAvatar);
        logStep = logStepInfo(logMethod,"Click Select Image button");
        changeAvatarAction.selectImageToUpload();
        logStep = logStepInfo(logMethod,"Click Save Avatar button");
        changeAvatarAction.clickSaveAvatarbtn();
        logStep = logStepInfo(logMethod,"Verify back to Edit Profile page");
        changeAvatarAction.verifyAccountInfoPage(logStep);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
