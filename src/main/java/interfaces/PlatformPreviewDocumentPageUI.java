package interfaces;

public class PlatformPreviewDocumentPageUI {
    public static String txtNameDocument = "//span[@ng-if='DocumentPreviewCtrl.documentDetail.title' and contains(.,'%s')]";
    public static String txtPageNumberDocument = "//span[@ng-if='DocumentPreviewCtrl.documentDetail.title']";
    public static String bntThumbnailViewMenu = "//button[@ng-click='DocumentPreviewCtrl.showSidebar()']";
    public static String menuThumbnailShow = "//ul[@class='document-preview__sidebar__image-thumbnails']";
    public static String bntShareURL = "//span[@class='calling-icon calling-icon-share']";
    public static String bntCopyURL = "//span[@translate='copy_url']";
    public static String txtCopyURLMessage = "//div[@class='toast-message']";
    public static String bntDownLoadFile = "//span[@class='calling-icon calling-icon-download']";
    public static String bntProfileUser ="//div[@class='sales-profile ng-scope']//a";
    public static String txtUserName ="//div[@class='sales-profile ng-scope']//strong";
    public static String txtUserNameProfile = "//span[text()='%s']";
    public static String txtPasswordPage = "//form[@name='documentForm']";


}
