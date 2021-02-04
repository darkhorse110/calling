package interfaces;

public class RequestPasswordUI {
    public static String txtEmail = "//input[@name='email']";
    public static String btnSubmit = "//button[@type='submit']";
    public static String msgError = "//span[@translate='email_valid'][contains(text(),'%s')]";
    public static String msgNotRegist ="//span[@ng-repeat='error in $ctrl.messages'][contains(text(),'%s')]";
    public static String bntBackLogin = "//a[@translate='request_password_back_to_login']";
}
