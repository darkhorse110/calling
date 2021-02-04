package interfaces;

public class QuestionnaireUI {

    public static String btnQuestionnaireMenu = "//span[@translate='questionaire']";
    public static String txtQuestionnaireTitle = "//h2[@translate='questionaire_list']";
    public static String linkQuestionnaire = "https://%s.app.dev.calling.fun/questionaire/list";
    public static String linkShowQuestionnaire = "https://%s.app.dev.calling.fun/questionaire/show/267";
    public static String linkEditQuestionnaire = "https://%s.app.dev.calling.fun/questionaire/edit/267";
    public static String linkCreateQuestionnaire = "https://%s.app.dev.calling.fun/questionaire/create";
 //List
    public static String btnCreateQuestionnaire = "//button[@ui-sref='dashboard.questionaire.create']";
    public static String txtSearchByName ="//input[@name='name']";
    public static String txtCreatedDateFrom ="//input[@placeholder='From']";
    public static String txtCreatedDateTo ="//input[@placeholder='To']";
    public static String btnShow="//span[@class='calling-icon calling-icon--blue calling-icon-file-text']";
    public static String btnEdit = "//span[@class='calling-icon calling-icon--blue calling-icon-edit']";
    public static String btnDelete = "//tr[1]//td[3]//div[1]//span[3]//a[1]//span[2]";
    public static String txtQuestionTitle = "//*[contains(text(),'QuestionnaireDefault(No Remov...')]";
    public static String txtQuestionCreateAt = "//*[contains(text(),'2020-12-22 12:38')]";


 //Show
    public static String txtQuestionnaireName = "//*[contains(text(),'QuestionnaireDefault(No Remove)')]";
    public static String txtEmail = "//*[contains(text(),'check@gmail.com')]";
    public static String txtQuestionContent = "//input[@name='question_text']";
    public static String txtQuestionAnswer1 = "//span[text()='what your name ?']";
    public static String txtQuestionAnswer2 = "//span[text()='how old are you?']";
    public static String btnReturnQuestionnaireList = "//span[@translate='return_questionaire_list']";

    //Edit
    public static String txtEditQuestionnaireTitle = "//h2[@translate='edit_questionaire']";
    public static String txtEditQuestionnaireName = "//input[@name='name']";
    public static String txtEmailEdit = "//input[@ng-model='EditQuestionaireCtrl.input.email']";
    public static String txtQuestionContentEdit = "//input[@ng-model='question.content']";
    public static String txtCheckBoxQuestionContentEdit = "//option[@label='Radio question']";
    public static String txtCheckBoxRequiredEdit = "//div[@clas='checkbox__cell']";
    public static String btnAddAnswerEdit = "//span[@translate='add_answer']";
    public static String btnAddQuestion = "//span[@translate='add_question']";
    public static String btnCancelEdit = "//button[@translate='cancel']";
    public static String btnSaveEdit = "//button[@translate='save']";

    //Delete
    public static String btnYesDelete = "//button[@ng-click='vm.onConfirm(); vm.hidePopover()']";
    public static String btnNoDelete = "//button[@ng-click='vm.onCancel(); vm.hidePopover()']";
    public static String txtConfirmationDelete = "//div[@aria-label='Delete survey success']";

    //Create
    public static String txtCreateQuestionnaireTitle = "//div[@translate='create_questionaire']";
    public static String txtQuestionnaireNameInput ="//input[@ng-model='CreateQuestionaireCtrl.input.name']";;
    public static String txtEmailInput ="//input[@ng-model='CreateQuestionaireCtrl.input.email']";;
    public static String txtQuestionContentInput = "//input[@ng-model='question.content']";
    public static String txtCheckBoxQuestionContent = "//option[@label='Radio question']";
    public static String txtCheckBoxRequired = "//div[@clas='checkbox__cell']";
    public static String txtEnterAnswer1 ="//input[@ng-model='choice.content']";
    public static String txtEnterAnswer2 ="//input[@ng-model='choice.content']";
    public static String btnAddAnswer = "//span[@translate='add_answer']";
    public static String btnRegister ="//span[@translate='register']";
    public static String txtCheckBoxRequiredCreate = "//span[@class='checkbox__label ng-scope']";
    public static String droplistQuestionType ="//option[@translate='choose_question_type']";
    public static String selectRadio ="//option[@value='number:1']";
    public static String txtQuestionInput1 ="//input[@ng-model='choice.content']";
    public static String txtQuestionInput2 ="//div[@class='dashboard-layout__container']//div[2]//div[2]//input[1]";
    public static String tableListQuestionName ="//span[@title='teamauto']";
    public static String confirmationCreate ="//div[@class='toast-message']";

}