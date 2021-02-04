package actions.pageactions;

import actions.commons.AbstractPages;
import interfaces.PlatformPreviewDocumentPageUI;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class PlatformPreviewDocumentPageAction extends AbstractPages {
    public WebDriver driver;

    public PlatformPreviewDocumentPageAction(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * is Name document
     *
     * @param nameDocument
     * @return
     */
    public boolean isNameDocument(String nameDocument) {
        waitForElement(driver, PlatformPreviewDocumentPageUI.txtNameDocument, 10, nameDocument);
        return isElementDisplay(driver, PlatformPreviewDocumentPageUI.txtNameDocument, nameDocument);
    }
    /**
     * is Number Page document
     *
     * @param pageNumberDocument
     * @return
     */
    public boolean isPageNumberDocument(String pageNumberDocument) {
        waitForElement(driver, PlatformPreviewDocumentPageUI.txtPageNumberDocument, 10, pageNumberDocument);
        return isElementDisplay(driver, PlatformPreviewDocumentPageUI.txtPageNumberDocument, pageNumberDocument);
    }
    /**
     * is Password Page Show
     *
     */
    public boolean isPasswordPageShown() {
        waitForElement(driver, PlatformPreviewDocumentPageUI.txtPasswordPage, 10);
        return isElementDisplay(driver, PlatformPreviewDocumentPageUI.txtPasswordPage);
    }
    /**
     * is Thumbnail Menu Show
     */
    public boolean isThumbnailMenuShow() {
        waitForElement(driver, PlatformPreviewDocumentPageUI.menuThumbnailShow, 10);
        return isElementDisplay(driver, PlatformPreviewDocumentPageUI.menuThumbnailShow);
    }

    /**
     * click on Thumbnail view menu
     */
    public void clickThumbnailViewMenu() {
        waitForElement(driver, PlatformPreviewDocumentPageUI.bntThumbnailViewMenu, 10);
        clickToElement(driver, PlatformPreviewDocumentPageUI.bntThumbnailViewMenu);
    }

    /**
     * get Copy URL success message
     */
    public String getCopyURLSuccess() {
        waitForElement(driver, PlatformPreviewDocumentPageUI.txtCopyURLMessage, 10);
        return getTextElementByXpath(driver, PlatformPreviewDocumentPageUI.txtCopyURLMessage);
    }

    /**
     * get URL Preview
     */
    public String getURLPreview() {
        if (driver.toString().equals("chrome")) {
            try {
                return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getCurrentUrl(driver);
    }

    /**
     * Hold the cursor on Share button
     */
    public void holdShareButton() {
        waitForElement(driver, PlatformPreviewDocumentPageUI.bntShareURL, 10);
        hoverMouseToElement(driver, PlatformPreviewDocumentPageUI.bntShareURL);
    }

    /**
     * click on Copy URL button
     */
    public void clickCopyURLButton() {
        waitForElement(driver, PlatformPreviewDocumentPageUI.bntCopyURL, 10);
        clickToElement(driver, PlatformPreviewDocumentPageUI.bntCopyURL);
        sleep(2);
    }
    /**
     * click on Download File
     */
    public void clickDownLoadFile(){
        waitForElement(driver, PlatformPreviewDocumentPageUI.bntDownLoadFile, 10);
        clickToElement(driver, PlatformPreviewDocumentPageUI.bntDownLoadFile);
        sleep(10);
    }
    /**
     * click on Profile User
     */
    public void clickProfileUser(){
        waitForElement(driver, PlatformPreviewDocumentPageUI.bntProfileUser, 10);
        clickToElement(driver, PlatformPreviewDocumentPageUI.bntProfileUser);
        sleep(3);
        switchOtherWindow(driver);
    }

    /**
     * get User Name
     */
    public String getUserNameInPreview(){
        waitForElement(driver, PlatformPreviewDocumentPageUI.txtUserName, 10);
        return getTextElementByXpath(driver, PlatformPreviewDocumentPageUI.txtUserName);
    }

    /**
     * is User Name
     */
    public boolean isUserNameDisplay(String userName){
        waitForElement(driver, PlatformPreviewDocumentPageUI.txtUserNameProfile, 30,userName);
        return isElementDisplay(driver, PlatformPreviewDocumentPageUI.txtUserNameProfile,userName);
    }

}
