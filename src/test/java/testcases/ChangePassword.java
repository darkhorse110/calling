package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.*;
import interfaces.ChangePasswordUI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

import static actions.commons.ReadExcelFile.testData;
import static actions.commons.ReportListener.*;

public class ChangePassword extends AbstractPages {
    public WebDriver driver;
    public SignInAction signInAction;
    public ChangePasswordAction changePasswordAction;
    public SelectProfileAction selectProfileAction;
    public WorkSpaceHomeAction workSpaceHomeAction;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public EditProfileAction editProfileAction;
    public String urlChangePassword;


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
        changePasswordAction = PageGeneratorManager.getChangePasswordAction(driver);
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
        logStep = logStepInfo(logMethod,"Reach to Change Pasword page");
        selectProfileAction.clickbtnChangePassword();
        urlChangePassword = getCurrentUrl(driver);
    }

    @Test(priority = 1)
    public void L16_5_TC2_TC4_VerifyCanInputSuccessfully () throws IOException, InterruptedException {
        openUrl(driver,urlChangePassword);
        logStep = logStepInfo(logMethod, "Verify input Old Password successfully");
        changePasswordAction.inputOldPassword("TestInput",logStep);
        logStep = logStepInfo(logMethod, "Verify Input New Password successfully");
        changePasswordAction.inputNewPassword("TestInput",logStep);
        logStep = logStepInfo(logMethod, "Verify Input Confirm New Password successfully");
        changePasswordAction.inputConfirmNewPassword("TestInput", logStep);

    }
    @Test(priority = 2)
    public void L16_5_TC_5_BlankAllFields () throws IOException, InterruptedException {
        openUrl(driver, urlChangePassword);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputOldPassword("",logStep);
        logStep = logStepInfo(logMethod,"Input New password");
        changePasswordAction.inputNewPassword("",logStep);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputConfirmNewPassword("",logStep);
        logStep = logStepInfo(logMethod,"Click Submit button");
        changePasswordAction.clickbtnSubmit();
        logStep = logStepInfo(logMethod,"Verify Submit disable ");
        verifyTrue(changePasswordAction.isSubmitButtonDisable());
    }

    @Test(priority = 3)
    public void L16_5_TC_6_BlankNewPasswordAndConfirmNewPassword () throws IOException, InterruptedException {
        openUrl(driver, urlChangePassword);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputOldPassword(Constants.PASSWORD,logStep);
        logStep = logStepInfo(logMethod,"Input New password");
        changePasswordAction.inputNewPassword("",logStep);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputConfirmNewPassword(" ",logStep);
        logStep = logStepInfo(logMethod,"Click Submit button");
        changePasswordAction.clickbtnSubmit();
        logStep = logStepInfo(logMethod,"Verify Submit disable ");
        verifyTrue(changePasswordAction.isSubmitButtonDisable());

    }
    @Test(priority = 4)
    public void L16_5_TC_7_BlankConfirmNewPassword () throws IOException, InterruptedException {
        openUrl(driver, urlChangePassword);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputOldPassword(Constants.PASSWORD,logStep);
        logStep = logStepInfo(logMethod,"Input New password");
        changePasswordAction.inputNewPassword(ChangePasswordUI.contentNewPassword,logStep);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputConfirmNewPassword(" ",logStep);
        logStep = logStepInfo(logMethod,"Click Submit button");
        changePasswordAction.clickbtnSubmit();
        logStep = logStepInfo(logMethod,"Verify Submit disable ");
        verifyTrue(changePasswordAction.isSubmitButtonDisable());

    }
    @Test(priority = 5)
    public void L16_5_TC_8_WrongOldPassword () throws IOException, InterruptedException {
        openUrl(driver, urlChangePassword);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputOldPassword("TestAbcd2",logStep);
        logStep = logStepInfo(logMethod,"Input New password");
        changePasswordAction.inputNewPassword(ChangePasswordUI.contentNewPassword,logStep);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputConfirmNewPassword(ChangePasswordUI.contentNewPassword,logStep);
        logStep = logStepInfo(logMethod,"Click Submit button");
        changePasswordAction.clickbtnSubmit();
        logStep = logStepInfo(logMethod,"Check Confirmation pop-up");
        changePasswordAction.confirmChangePasswordPopup();
        logStep = logStepInfo(logMethod,"Click Submit button on Confirmation pop-up");
        changePasswordAction.clickbtnChangePasswordOnPopUp();
        logStep = logStepInfo(logMethod,"Verify Old Password Errror Message");
        verifyTrue(changePasswordAction.isErrorMesssageOldPassword("正しいパスワードを入力してください。"));

    }

    @Test(priority = 6 )
    public void L16_5_TC_9_OldAndNewPasswordAreSame () throws IOException, InterruptedException {
        openUrl(driver, urlChangePassword);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputOldPassword(Constants.PASSWORD,logStep);
        logStep = logStepInfo(logMethod,"Input New password");
        changePasswordAction.inputNewPassword(Constants.PASSWORD,logStep);
        logStep = logStepInfo(logMethod, "Input Old password");
        changePasswordAction.inputConfirmNewPassword(Constants.PASSWORD,logStep);
        logStep = logStepInfo(logMethod,"Click Submit button");
        changePasswordAction.clickbtnSubmit();
        logStep = logStepInfo(logMethod,"Check Confirmation pop-up");
        changePasswordAction.confirmChangePasswordPopup();
        logStep = logStepInfo(logMethod,"Click Submit button on Confirmation pop-up");
        changePasswordAction.clickbtnChangePasswordOnPopUp();
        logStep = logStepInfo(logMethod,"Verify Errror Message New Password");
        verifyTrue(changePasswordAction.isErrorMessageNewPassword("現在のパスワードと違うパスワードを設定してください。"));

    }
//    @Test(priority = 7)
//    public void L16_5_TC_10_ChangePasswordSuccessfully () throws IOException, InterruptedException {
//        openUrl(driver, urlChangePassword);
//        logStep = logStepInfo(logMethod, "Input Old password");
//        changePasswordAction.inputOldPassword(Constants.PASSWORD,logStep);
//        logStep = logStepInfo(logMethod,"Input New password");
//        changePasswordAction.inputNewPassword(Constants.PASSWORD,logStep);
//        logStep = logStepInfo(logMethod, "Input Old password");
//        changePasswordAction.inputConfirmNewPassword(Constants.PASSWORD,logStep);
//        logStep = logStepInfo(logMethod,"Click Submit button");
//        changePasswordAction.clickbtnSubmit();
//        logStep = logStepInfo(logMethod,"Check Confirmation pop-up");
//        changePasswordAction.confirmChangePasswordPopup();
//        logStep = logStepInfo(logMethod,"Click Submit button on Confirmation pop-up");
//        changePasswordAction.clickbtnChangePasswordOnPopUp();
//        logStep = logStepInfo(logMethod,"Verify Change Password Successfully");
//        changePasswordAction.verifyEditPasswordSuccessful();
//
//    }
//    @Test(priority = 8)
//    public void L16_5_TC_10_ChangePasswordAgain () throws IOException, InterruptedException {
//        openUrl(driver, urlChangePassword);
//        logStep = logStepInfo(logMethod, "Input Old password");
//        changePasswordAction.inputOldPassword(Constants.PASSWORD,logStep);
//        logStep = logStepInfo(logMethod,"Input New password");
//        changePasswordAction.inputNewPassword(Constants.PASSWORD,logStep);
//        logStep = logStepInfo(logMethod, "Input Old password");
//        changePasswordAction.inputConfirmNewPassword(Constants.PASSWORD,logStep);
//        logStep = logStepInfo(logMethod,"Click Submit button");
//        changePasswordAction.clickbtnSubmit();
//        logStep = logStepInfo(logMethod,"Check Confirmation pop-up");
//        changePasswordAction.confirmChangePasswordPopup();
//        logStep = logStepInfo(logMethod,"Click Submit button on Confirmation pop-up");
//        changePasswordAction.clickbtnChangePasswordOnPopUp();
//        logStep = logStepInfo(logMethod,"Verify Change Password Successfully");
//        changePasswordAction.verifyEditPasswordSuccessful();
//    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }


}
