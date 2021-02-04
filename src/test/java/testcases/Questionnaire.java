package testcases;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import actions.commons.PageGeneratorManager;
import actions.pageactions.QuestionnaireAction;
import actions.pageactions.SelectWorkSpaceAction;
import actions.pageactions.SignInAction;
import actions.pageactions.TopPageAction;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

;

public class Questionnaire extends AbstractPages {
    private WebDriver driver;
    public SelectWorkSpaceAction selectWorkSpaceAction;
    public SignInAction signInAction;
    public TopPageAction topAction;
    public QuestionnaireAction questionnaireAction;
    public TopPageAction topPageAction;
    public String URLQuestionnaireMenu;
    public String URLQuestionnaireCreate;
    public String name = "name" + currentTime ();
    public String message = "message" + currentTime ();
    public String email = "email" + currentTime () + "@gmail.com";


    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser (browserName);
        selectWorkSpaceAction = PageGeneratorManager.getSelectWorkSpaceAction (driver);
        signInAction = PageGeneratorManager.getSignInAction (driver);
        questionnaireAction = PageGeneratorManager.getQuestionnaireAction  (driver);
        topPageAction = PageGeneratorManager.getTopPageAction (driver);
        logClass = createTestForExtentReport (extent, "Test suit for Questionnaire Top screen");
        logClass = createNodeForExtentReport(logClass, "Initial Setup successful");

    }

    @Test(priority = 0)
    public void PreCondition() throws IOException {
        logReport = logReport.assignCategory ("Pre-condition : Go to Questionnaire ");
        logMethod = createNodeForExtentReport (logReport, "Open Questionnaire");
        logStep = logStepInfo(logMethod, "Input workspace ID");
        selectWorkSpaceAction.inputWorkspaceID(Constants.WORKSPACE_ID, logStep);

        logMethod = createNodeForExtentReport(logReport, "Input user name and password");
        logStep = logStepInfo(logMethod, "Input user nam and password");
        signInAction.inputLogin(Constants.EMAIL, Constants.PASSWORD,logStep);
        logStep = logStepInfo (logMethod, "Click Meeting Button");
        topPageAction.clickMeetingButton ();
        logStep = logStepInfo (logMethod, "Open Questionnaire menu");
        questionnaireAction.clickQuestionaireMenu ();
        URLQuestionnaireMenu = getCurrentUrl (driver);
    }

      @Test(priority = 1)
    public void Question_TC_01_QuestionnaireList() throws IOException {
        openUrl (driver, URLQuestionnaireMenu);
        logReport = logReport.assignCategory ("Questionnaire List screen");
        logStep = logStepInfo(logMethod, "Question_TC_01 : Verify open アンケート (Questionnaire)");
        questionnaireAction.verifyQuestionnairePage (logStep);
        logStep = logStepInfo(logMethod, "Question_TC_01 : Verify Question Title Default");
        questionnaireAction.isQuestionTitle ();
        logStep = logStepInfo(logMethod, "Question_TC_01 : Verify Question Create At");
        questionnaireAction.isQuestionCreate ();
    }
    @Test(priority = 2)
    public void Question_TC_02_QuestionnaireShow() throws IOException {
        openUrl (driver, URLQuestionnaireMenu);
        logReport = logReport.assignCategory ("Show Questionnaire screen");
        logStep = logStepInfo(logMethod, "Question_TC_02 : Click Show button");
        questionnaireAction.clickShowQuestionaire ();
        logStep = logStepInfo(logMethod, "Question_TC_02 : Verify open アンケート (Show Questionnaire)");
        questionnaireAction.verifyShowQuestionnairePage (logStep);

        logStep = logStepInfo(logMethod, "Question_TC_02 : Verify Question Name");
        questionnaireAction.isQuestionName ();
        logStep = logStepInfo(logMethod, "Question_TC_02 : Verify Email");
        questionnaireAction.isEmail ();
        logStep = logStepInfo(logMethod, "Question_TC_02 : Verify Answer1");
        questionnaireAction.isAnswer1 ();
        logStep = logStepInfo(logMethod, "Question_TC_02 : Verify Answer2");
        questionnaireAction.isAnswer2 ();
    }

    @Test(priority = 3)
    public void Question_TC_03_CreateNewQuestionnaire() throws IOException {
        openUrl (driver, URLQuestionnaireMenu);
        logReport = logReport.assignCategory ("Create Questionnaire screen");
        logStep = logStepInfo (logMethod, "Question_TC_03 : Click Create button");
        questionnaireAction.clickCreateNewQuestionaire ();
        logStep = logStepInfo (logMethod, "Question_TC_03 : Verify open アンケートを作成 (Create Questionnaire)");
        questionnaireAction.verifyCreateQuestionnairePage (logStep);
        URLQuestionnaireCreate = getCurrentUrl (driver);
    }

    @Test(priority = 4)
    public void Question_TC_04_BlankQuestionName() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory ("Validation Questionnaire Name");
        logStep = logStepInfo (logMethod, "Question_TC_04 : Blank Question Name");
        questionnaireAction.inputQuestionnaireName (" ", logStep);
        logStep = logStepInfo(logMethod, "Verify Register button is disable");
        questionnaireAction.isBtnRegisterDisable ();
    }
    @Test(priority = 5)
    public void Question_TC_04_MaxlengQuestionName() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory("Create Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Question_TC_04: Check max length Question Name textbox = 255 characters");
        logStep = logStepInfo(logMethod, "Check max length Question Name textbox = 255 characters");
        Assert.assertTrue(questionnaireAction.isMaxLengthQuestionName ("255"));
    }
    @Test(priority = 6)
    public void Question_TC_04_InputQuestionName() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory("Create Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Question_TC_04: Input");
        logStep = logStepInfo(logMethod, "Input Question Name ");
        questionnaireAction.inputQuestionnaireName (Constants.WORKSPACE_ID, logStep);
    }
    @Test(priority = 7)
    public void Question_TC_05_BlankEmail() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory ("Create Questionnaire");
        logStep = logStepInfo (logMethod, "Question_TC_05 : Blank Mail");
        questionnaireAction.inputMail (" ", logStep);
        logStep = logStepInfo(logMethod, "Verify Register button is disable");
        questionnaireAction.isBtnRegisterDisable ();
    }
    @Test(priority = 8)
    public void Question_TC_05_MaxlengEmail() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory("Create Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Question_TC_05: Check max length Email textbox = 255 characters");
        logStep = logStepInfo(logMethod, "Check max length Email textbox = 255 characters");
        Assert.assertTrue(questionnaireAction.isMaxLengthEmail ("255"));
    }

    @Test(priority = 9)
    public void Question_TC_05_InputEmail() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory("Create Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Question_TC_05: Input Email");
        logStep = logStepInfo(logMethod, "Input email");
        questionnaireAction.inputMail (Constants.EMAIL, logStep);
    }

    @Test(priority = 10)
    public void Question_TC_06_BlankQuestionContent() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory("Create Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Question_TC_06: Blank Question Content");
        logStep = logStepInfo(logMethod, "Check Blank Content");
        questionnaireAction.inputQuestionContent ("  ", logStep);
        questionnaireAction.isBtnRegisterDisable ();
    }

    @Test(priority = 11)
    public void Question_TC_06_MaxlengQuestionContent() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory("Create Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Question_TC_06: Check Max Leng Question Content");
        logStep = logStepInfo(logMethod, "Check max length Question Content textbox = 255 characters");
        Assert.assertTrue(questionnaireAction.isMaxLengthQuestionContent ("255"));

    }
    @Test(priority = 12)
    public void Question_TC_06_InputQuestionContent() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory("Create Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Question_TC_06: Input Question Content");
        logStep = logStepInfo(logMethod, "Input Question Content");
        questionnaireAction.inputQuestionContent (" Team Auto ", logStep);

    }
    @Test(priority = 13)
    public void Question_TC_07_CheckRequired() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory("Create Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Question_TC_07: Check Required");
        logStep = logStepInfo(logMethod, "Tick Required");
        questionnaireAction.clickRequired ();
    }

    @Test(priority = 14)
    public void Question_CreateSuccessfully() throws IOException {
        openUrl (driver, URLQuestionnaireCreate);
        logReport = logReport.assignCategory("Create Successfully Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Create Successfully Questionnaire");
        logStep = logStepInfo(logMethod, "Input Question Name");
        questionnaireAction.inputQuestionnaireName (Constants.WORKSPACE_ID, logStep);
        logStep = logStepInfo(logMethod, "Input Email");
        questionnaireAction.inputMail (Constants.EMAIL, logStep);
        logStep = logStepInfo(logMethod, "Input Question Content");
        questionnaireAction.inputQuestionContent (" Team Auto ", logStep);
        logStep = logStepInfo(logMethod, "Tick Required");
        questionnaireAction.clickRequired ();
        logStep = logStepInfo(logMethod, "Tick Radio Question");
        questionnaireAction.selectRadioType ();
        logStep = logStepInfo(logMethod, "Input Question 1");
        questionnaireAction.inputQuestion1 ("Do you like that?", logStep);
        logStep = logStepInfo(logMethod, "Input Question 2");
        questionnaireAction.inputQuestion2 ("Do you have any feedback?", logStep);
        logStep = logStepInfo(logMethod, "Click Register");
        questionnaireAction.clickRegister ();
        logStep = logStepInfo(logMethod, "Confirmation");
        questionnaireAction.ConfirmationPopup ();
    }

    @Test(priority = 15)
    public void Question_TC_8_Search() throws IOException {
        openUrl (driver, URLQuestionnaireMenu);
        logReport = logReport.assignCategory("Create Successfully Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Create Successfully Questionnaire");
        logStep = logStepInfo(logMethod, "Validate Name of search result is shown");
        questionnaireAction.isSearchByNameCorrect ("teamauto");
    }

    @Test(priority = 16)
    public void Question_Delete() throws IOException {
        openUrl (driver, URLQuestionnaireMenu);
        logReport = logReport.assignCategory("Delete Questionnaire");
        logMethod = createNodeForExtentReport(logReport, "Delete Successfully Questionnaire");
        logStep = logStepInfo(logMethod, "Click Delete button");
        questionnaireAction.DeleteQuestion ();
        logStep = logStepInfo(logMethod, "Confirmation");
        questionnaireAction.ConfirmationPopup ();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        closeBrowser(driver);
    }
}
