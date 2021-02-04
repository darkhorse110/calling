package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import interfaces.SelectProfileUI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static actions.commons.ReportListener.*;

public class EditProfile extends AbstractPages {
public WebDriver driver;
public SignInAction signInAction;
public SelectProfileAction selectProfileAction;
public EditProfileAction editProfileAction;
public WorkSpaceHomeAction workSpaceHomeAction;
public SelectWorkSpaceAction selectWorkSpaceAction;
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
        editProfileAction = PageGeneratorManager.getEditProfileAction(driver);
    }

    @Test(priority = 0)
    public void PreCondition() throws IOException, InterruptedException {
        logMethod = createNodeForExtentReport(logReport, "Input Workspace ID");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);
        logStep = logStepInfo(logMethod,"Login Successfully");
        signInAction.inputLogin(Constants.EMAIL,Constants.PASSWORD,logStep);
        logStep = logStepInfo(logMethod,"Reach to Edit Profile page");
        selectProfileAction.clickProfileIcon();
        selectProfileAction.clickProfileLink();
        selectProfileAction.clickbtnEditProfile();
        urlEditProfile = getCurrentUrl(driver);
    }

    @Test (priority = 1)
    public void L16_1_TC_2_ReachToChangeAvatarPage () throws IOException {
        openUrl(driver, urlEditProfile);
        logStep = logStepInfo(logMethod,"Click Change Avatar button");
        editProfileAction.clickEditAvatarbtn();
        logStep = logStepInfo(logMethod,"Verify Change Avatar URL");
        editProfileAction.verifyEditAvatarPage(logStep);

    }
    @Test(priority = 2)
    public void L16_1_TC_5_BackToProfilePageWhenClickCancelButton () throws IOException {
        openUrl(driver, urlEditProfile);
        logStep = logStepInfo(logMethod,"Click Cancel button");
        editProfileAction.clickCancelbtn();
        logStep = logStepInfo(logMethod,"Verify Back to Profile page");
        editProfileAction.verifyProfilePage(logStep);

    }
    @Test(priority = 3)
    public void L16_1_TC_6_ClearNameField () throws IOException {
        openUrl(driver, urlEditProfile);
        logStep = logStepInfo(logMethod, "Clear Name field");
        editProfileAction.inputRegisterNametxt(" ", logStep);
        logStep = logStepInfo(logMethod, "Verify Submit button is disable");
        editProfileAction.isBtnSubmitDisable();
    }

    @Test(priority = 4)
    public void L16_1_TC_6_ClearMailField () throws IOException {
        openUrl(driver, urlEditProfile);
        logStep = logStepInfo(logMethod, "Clear Name field");
        editProfileAction.inputMailtxt(" ", logStep);
        logStep = logStepInfo(logMethod, "Verify Submit button is disable");
        editProfileAction.isBtnSubmitDisable();
    }

    @Test(priority = 5)
    public void L16_1_TC_8_EditNameSuccessfully () throws IOException {
        openUrl(driver, urlEditProfile);
        logStep = logStepInfo(logMethod,"Input Register Name");
        editProfileAction.inputRegisterNametxt("Update Name",logStep);
        logStep = logStepInfo(logMethod,"Click Submit button");
        editProfileAction.clickSubmitbtn();
        logStep = logStepInfo(logMethod,"Click Edit button on Pop-up");
        editProfileAction.ConfirmationPopup();
        editProfileAction.clickbtnSubmitPopup();
        logStep = logStepInfo(logMethod,"Verify Back to Profile page");
        editProfileAction.verifyProfilePage(logStep);
    }
    @Test(priority = 6)
    public void L16_1_TC_8_EditNameSuccessfullyAgain () throws IOException {
        openUrl(driver, urlEditProfile);
        logStep = logStepInfo(logMethod,"Input Register Name");
        editProfileAction.inputRegisterNametxt("Team Auto",logStep);
        logStep = logStepInfo(logMethod,"Click Submit button");
        editProfileAction.clickSubmitbtn();
        logStep = logStepInfo(logMethod,"Click Edit button on Pop-up");
        editProfileAction.ConfirmationPopup();
        editProfileAction.clickbtnSubmitPopup();
        logStep = logStepInfo(logMethod,"Verify Back to Profile page");
        editProfileAction.verifyProfilePage(logStep);
    }

    @Test(priority = 7)
    public void L16_1_TC_9_EditMailSuccessfully () throws IOException {
        openUrl(driver, urlEditProfile);
        logStep = logStepInfo(logMethod,"Input email");
        editProfileAction.inputMailtxt(Constants.EMAIL,logStep);
        logStep = logStepInfo(logMethod,"Click Submit button");
        editProfileAction.clickSubmitbtn();
        logStep = logStepInfo(logMethod,"Click Edit button on Pop-up");
        editProfileAction.ConfirmationPopup();
        editProfileAction.clickbtnSubmitPopup();
        logStep = logStepInfo(logMethod,"Verify Back to Profile page");
        editProfileAction.verifyProfilePage(logStep);

    }
    @Test(priority = 8)
    public void L16_1_TC_9_EditMailSuccessfullyAgain () throws IOException {
        openUrl(driver, urlEditProfile);
        logStep = logStepInfo(logMethod,"Input email");
        editProfileAction.inputMailtxt(Constants.EMAIL,logStep);
        logStep = logStepInfo(logMethod,"Click Submit button");
        editProfileAction.clickSubmitbtn();
        logStep = logStepInfo(logMethod,"Click Edit button on Pop-up");
        editProfileAction.ConfirmationPopup();
        editProfileAction.clickbtnSubmitPopup();
        logStep = logStepInfo(logMethod,"Verify Back to Profile page");
        editProfileAction.verifyProfilePage(logStep);

    }

    @Test(priority = 9)
    public void L16_1_TC_3_4_ClearMailAndRegisterName ( ) throws IOException {
        openUrl(driver, urlEditProfile);
        logStep = logStepInfo(logMethod,"Input Register Name");
        editProfileAction.inputRegisterNametxt("     ",logStep);
        logStep = logStepInfo(logMethod,"Clear mail");
        editProfileAction.inputMailtxt("",logStep);
        logStep = logStepInfo(logMethod, "Verify Submit button is disable");
        editProfileAction.isBtnSubmitDisable();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }

}
