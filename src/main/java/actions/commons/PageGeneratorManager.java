package actions.commons;

import actions.pageactions.*;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static MemberManagementAction getMemberManagementAction(WebDriver driver) {

        return new MemberManagementAction(driver);
    }

    public static SelectWorkSpaceAction getSelectWorkSpaceAction(WebDriver driver) {

        return new SelectWorkSpaceAction(driver);
    }

    public static RequestPasswordAction getRequestPasswordAction(WebDriver driver) {

        return new RequestPasswordAction(driver);
    }

    public static RequestWorkSpaceAction getRequestWorkSpaceAction(WebDriver driver) {

        return new RequestWorkSpaceAction(driver);
    }

    public static ChangePasswordAction getChangePasswordAction(WebDriver driver){
        return new ChangePasswordAction(driver);
    }

    public static TabNotificationAction getTabNotificationAction(WebDriver driver){
        return new TabNotificationAction(driver);
    }

    public static RequestWorkspaceSuccessAction getRequestWorkspaceSuccessAction(WebDriver driver) {

        return new RequestWorkspaceSuccessAction(driver);
    }


    public static SignInAction getSignInAction(WebDriver driver) {

        return new SignInAction(driver);
    }

    public static WorkSpaceHomeAction getWorkSpaceHomeAction(WebDriver driver) {

		return new WorkSpaceHomeAction(driver);
	}
	public static WorkSpaceManagementAction getWorkSpaceManagementAction(WebDriver driver) {

		return new WorkSpaceManagementAction(driver);
	}

	public static InviteMemberPageAction getInviteMemberPageAction (WebDriver driver){
		return new InviteMemberPageAction(driver);
	}

	public static InviteMemberByMailAction getInviteMemberByMailAction(WebDriver driver){
        return new InviteMemberByMailAction(driver);
    }

	public static InviteMemberByUrlAction getInviteMemberByUrlAction (WebDriver driver){
		return new InviteMemberByUrlAction(driver);
	}
	public static TopPageAction getTopPageAction(WebDriver driver) {

        return new TopPageAction(driver);
    }
    public static GroupManagementAction getGroupManagementAction(WebDriver driver) {

        return new GroupManagementAction(driver);
    }

    public static InviteMemberAction getInviteMemberAction(WebDriver driver){

        return  new InviteMemberAction(driver);
    }

    public static TransferAdminAction getTransferAdminAction(WebDriver driver){

        return  new TransferAdminAction(driver);
    }

    public static SelectProfileAction getSelectProfileAction(WebDriver driver){

        return  new SelectProfileAction(driver);
    }

    public static EditProfileAction getEditProfileAction(WebDriver driver){

        return  new EditProfileAction(driver);
    }

    public static ChangeAvatarAction getChangeAvatarAction(WebDriver driver){

        return  new ChangeAvatarAction(driver);
    }
    public static AboutAction getAboutAction(WebDriver driver){

        return  new AboutAction(driver);
    }

    public static QuestionnaireAction getQuestionnaireAction(WebDriver driver) {
        return new QuestionnaireAction(driver);
    }

    public static SalesTopAction getSalesTopAction(WebDriver driver){

        return  new SalesTopAction(driver);
    }


    public static SalesLightAction getSalesLightAction(WebDriver driver){

        return  new SalesLightAction(driver);
    }

    public static UserUsageAction getUserUsageAction(WebDriver driver){

        return  new UserUsageAction(driver);
    }

    public static PlatformDocumentPageAction getDocumentPageAction (WebDriver driver){

        return new PlatformDocumentPageAction(driver);
    }

    public static PlatformRecordAction getPlatformRecordAction(WebDriver driver) {

        return new PlatformRecordAction(driver);
    }


    public static PlatformPreviewDocumentPageAction getPlatformPreviewDocumentPageAction(WebDriver driver){
        return new PlatformPreviewDocumentPageAction(driver);
    }
    public static ChatBotAction getChatBotAction (WebDriver driver){

        return  new ChatBotAction(driver);
    }
}
