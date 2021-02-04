/**
 * Dinh nghia lai may ham seleium thanh ham cua minh cho tien su dung
 */

package actions.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public abstract class AbstractPages extends ReportListener {
    public Actions action;
    public Select select;
    public WebElement element;
    JavascriptExecutor jsExecutor;
    WebDriverWait waitExplicit;
    private WebDriver driver;

    /**
     * Open maxium browser with an Url
     *
     * @param url The url value need access
     */
    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    /**
     * Get the title of the current page.
     */
    public static String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    /**
     * Get the title of the current page.
     */
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    /**
     * Move back in the browser's history
     */
    public void back(WebDriver driver) {
        driver.navigate().back();
    }

    /**
     * Refresh the current page
     */
    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
        sleep(2);
    }

    /**
     * Click OK button in alert
     */
    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    /**
     * Click Cancel button in alert
     */
    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    /**
     * Get text in alert
     */
    public String getTextAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    /**
     * Input value into alert
     */
    public void sendKeyToAlert(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public WebElement findElementByXpath(WebDriver driver, String locator) {
        return driver.findElement(byXpath(locator));
    }

    /**
     * Find Element by xpath with many values
     *
     * @param driver
     * @param locator
     * @param values
     * @return
     */
    public WebElement findElementByXpath(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        return driver.findElement(byXpath(locator));
    }

    /**
     * Find Element by xpath with values
     *
     * @param driver
     * @param locator
     * @param values
     * @return
     */
    public List<WebElement> findElementsByXpath(WebDriver driver, String locator, String values) {
        locator = String.format(locator, values);
        return driver.findElements(byXpath(locator));
    }

    /**
     * Find Elements by Css with many values
     *
     * @param driver
     * @param locator
     * @param values
     * @return
     */

    private WebElement findElementByCss(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        return driver.findElement(byCss(locator));
    }

    /**
     * Find Element by Xpath
     *
     * @param driver
     * @param locator
     * @return
     */

    public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
        return driver.findElements(byXpath(locator));
    }

    /**
     * By Xpath
     *
     * @param locator
     * @return
     */
    public By byXpath(String locator) {
        return By.xpath(locator);
    }

    /**
     * By Css
     *
     * @param locator
     * @return
     */

    public By byCss(String locator) {
        return By.cssSelector(locator);
    }

    /**
     * Click to Element
     *
     * @param driver
     * @param locator
     */

    public void clickToElement(WebDriver driver, String locator) {
        findElementByXpath(driver, locator).click();
    }

    /**
     * Click to Element with many values
     *
     * @param driver
     * @param locator
     * @param values
     */
    public void clickToElement(WebDriver driver, String locator, String... values) {
        findElementByXpath(driver, locator, values).click();
    }

    /**
     * Input to Element
     *
     * @param driver
     * @param locator
     * @param valueInput
     */
    public void sendKeyToElement(WebDriver driver, String locator, String valueInput) {
        findElementByXpath(driver, locator).clear();
        findElementByXpath(driver, locator).sendKeys(valueInput);
    }

    /**
     * Input to Element with many values
     *  @param driver
     * @param locator
     * @param values
     */
    public void sendKeyToElement(WebDriver driver, String locator, String... values) {
        findElementByXpath(driver, locator, values[0]).clear();
        findElementByXpath(driver, locator, values[0]).sendKeys(values[1]);
    }

    /**
     * Select dropdown
     *
     * @param driver
     * @param locator
     * @param valueSelect
     */

    public void selectItemInHtmlDropdown(WebDriver driver, String locator, String valueSelect) {
        select = new Select(findElementByXpath(driver, locator));
        select.selectByVisibleText(valueSelect);
    }

    /**
     * Select dropdown with many values
     *
     * @param driver
     * @param locator
     * @param values
     */
    public void selectItemInHtmlDropdown(WebDriver driver, String locator, String... values) {
        select = new Select(findElementByXpath(driver, locator, values[0]));
        select.selectByVisibleText(values[1]);
    }

    /**
     * Get value in dropdown
     *
     * @param driver
     * @param locator
     * @return
     */
    public WebElement getSelectItemInHtmlDropdown(WebDriver driver, String locator) {
        select = new Select(findElementByXpath(driver, locator));
        return select.getFirstSelectedOption();
    }

    /**
     * Get value in dropdown with many values
     *
     * @param driver
     * @param locator
     * @param values
     * @return
     */
    public WebElement getSelectItemInHtmlDropdown(WebDriver driver, String locator, String... values) {
        select = new Select(findElementByXpath(driver, locator, values[0]));
        return select.getFirstSelectedOption();
    }

    /**
     * Select item in dropdown
     *
     * @param driver
     * @param dropdownLocator
     * @param allItemInDropdownLocator
     * @param expectedItemValue
     * @throws InterruptedException
     */

    public void selectItemInCustomDropdown(WebDriver driver, String dropdownLocator,
                                           String allItemInDropdownLocator,
                                           String expectedItemValue) throws InterruptedException {
        jsExecutor = (JavascriptExecutor) driver;
        waitExplicit = new WebDriverWait(driver, 30);

        // Click in dropdown for display all items
        WebElement paretnDropdown = findElementByXpath(driver, dropdownLocator);
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", paretnDropdown);
        Thread.sleep(2000);
        jsExecutor.executeScript("arguments[0].click();", paretnDropdown);
        Thread.sleep(2000);

        // Wait all items loaded
        //waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(allItemInDropdownLocator)));

        // Loop and get expected item
        List<WebElement> allItems = findElementsByXpath(driver, allItemInDropdownLocator);
        for (WebElement item : allItems) {
            if (item.getText().equals(expectedItemValue)) {
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                Thread.sleep(1000);
                item.click();
                break;
            }
        }
    }

    /**
     * Get Attribute value
     *
     * @param driver
     * @param locator
     * @param attributeName
     * @return
     */
    public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
        return findElementByXpath(driver, locator).getAttribute(attributeName);
    }

    /**
     * Get text of element by xpath
     *
     * @param driver
     * @param locator
     * @return
     */
    public String getTextElementByXpath(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).getText();
    }

    /**
     * Get text of element with many values by xpath
     *
     * @param driver
     * @param locator
     * @param values
     * @return
     */

    public String getTextElementByXpath(WebDriver driver, String locator, long timeout, String... values) {
        waitForElement(driver, locator, timeout, values);
        return findElementByXpath(driver, locator, values).getText();
    }

    /**
     * Get text by CSS
     *
     * @param driver
     * @param locator
     * @return
     */
    public String getTextElementByCss(WebDriver driver, String locator) {
        return findElementByCss(driver, locator).getText();
    }

    /**
     * Get text of element with many values by css
     *
     * @param driver
     * @param locator
     * @param values
     * @return
     */
    public String getTextElementByCss(WebDriver driver, String locator, String... values) {
        return findElementByCss(driver, locator, values).getText();
    }


    /**
     * Verify element selected
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isElementSelected(WebDriver driver, String locator,String... values) {
        return findElementByXpath(driver, locator,values).isSelected();
    }

    /**
     * Count element number
     *
     * @param driver
     * @param locator
     * @return
     */
    public int countElementNumber(WebDriver driver, String locator) {
        return findElementsByXpath(driver, locator).size();
    }

    /**
     * Count elements number
     *
     * @param driver
     * @param locator
     * @return
     */
    public int countElementsNumber(WebDriver driver, String locator,String values) {
        return findElementsByXpath(driver, locator,values).size();
    }

    /**
     * Verify element display
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isElementDisplay(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).isDisplayed();
    }

    /**
     * Verify element display with many values
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isElementDisplay(WebDriver driver, String locator, String... values) {
        return findElementByXpath(driver, locator, values).isDisplayed();
    }

    /**
     * Verify element selected
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isElementSelected(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).isSelected();
    }

    /**
     * Verify element selected
     *
     * @param driver
     * @param locator
     * @return
     */
    public String isElementFirstSelected(WebDriver driver,String locator) {
        findElementByXpath(driver, locator);
        WebElement option = select.getFirstSelectedOption();
        return option.getText();
    }

    /**
     * Verify element enabled
     *
     * @param driver
     * @param locator
     * @return
     */
    public boolean isElementEnabled(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).isEnabled();
    }

    /**
     * Switch to another window by page tile
     *
     * @param title The title of window need switch
     */
    public void switchToWindowByTile(WebDriver driver, String title) {
        Set<String> allWindow = driver.getWindowHandles();
        for (String runWindow : allWindow) {
            driver.switchTo().window(runWindow);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    /**
     * Close all window with out parrent window
     *
     * @param parrentWindowTitle The title of parent window
     */
    public void closeAllWindowsWithoutParent(WebDriver driver, String parrentWindowTitle) {
        Set<String> allWindow = driver.getWindowHandles();
        for (String runWindow : allWindow) {
            if (!runWindow.equals(parrentWindowTitle)) {
                driver.switchTo().window(runWindow);
                driver.close();
            }
        }
    }

    /**
     * Swith to 1st Tab
     */
    public void switchToFirstTab(WebDriver driver) {
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(0));
        driver.switchTo().window(handlesList.get(1));
        driver.close();
    }
    /**
     * Switch Tab index
     */
    public WebDriver switchTabWindowIndex(WebDriver driver, String nametab) {
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        if (nametab.equals("tab1")){
            driver.switchTo().window(tab.get(0));
        }
        if (nametab.equals("tab2")){
            driver.switchTo().window(tab.get(1));
        }
        if (nametab.equals("tab3")){
            driver.switchTo().window(tab.get(2));
        }
        return driver;
    }

    /**
     * Swith to frame
     *
     * @param driver
     * @param frameName
     */
    public void switchToFrame(WebDriver driver, String frameName) {
        if (frameName == "defaultContent"){
            driver.switchTo().defaultContent();
        }else {
            driver.switchTo().frame(frameName);
        }
    }

    /**
     * Double click
     *
     * @param driver
     * @param locator
     */

    public void doubleClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.doubleClick(findElementByXpath(driver, locator)).perform();
    }

    /**
     * Hover mouse
     *
     * @param driver
     * @param locator
     */
    public void hoverMouseToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.moveToElement(findElementByXpath(driver, locator)).perform();
    }

    /**
     * right click
     *
     * @param driver
     * @param locator
     */
    public void rightClick(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.contextClick(findElementByXpath(driver, locator)).perform();
    }

    /**
     * Drag and drop element
     *
     * @param driver
     * @param sourceLocator
     * @param targetLocator
     */
    public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
        action = new Actions(driver);
        action.dragAndDrop(findElementByXpath(driver, sourceLocator), findElementByXpath(driver, targetLocator)).perform();
    }

    /**
     * Input keyboard to element
     *  @param driver
     * @param locator
     * @param value
     */
    public void sendKeyboardToElement(WebDriver driver, String locator, Keys value) {
        action = new Actions(driver);
        action.sendKeys(findElementByXpath(driver, locator), value).perform();
    }

    /**
     * Wait for Element
     *
     * @param driver
     * @param locator
     * @param timeout
     */
    public void waitForElement(WebDriver driver, final String locator, long timeout) {
        try {
            By by = getBy(driver, locator);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("Element doesn't exist");
        }
    }

    /**
     * get by for element
     *
     * @param driver
     * @param controlName
     */
    public By getBy(WebDriver driver, String controlName) {
        By by = null;
        by = By.xpath(controlName);
        return by;
    }

    /**
     * get by for element many values
     *
     * @param driver
     * @param locator
     */
    public By getBy(WebDriver driver, String locator, String... values) {
        By by = null;
        String control = String.format(locator, values);
        by = By.xpath(control);
        return by;
    }

    /**
     * Wait for Element with many values
     *
     * @param driver
     * @param locator
     * @param timeout
     */
    public void waitForElement(WebDriver driver, final String locator, long timeout, String... values) {
        try {
            By by = getBy(driver, locator, values);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("Element doesn't exist");
        }
    }

    /**
     * get Attribute Value Xpath
     *
     * @param driver
     * @param locator
     * @return
     */
    public String getAttributeValueXpath(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).getAttribute("value");
    }

    /**
     * getA ttribute Value Xpath with many values
     *
     * @param driver
     * @param locator
     * @param timeout
     * @param values
     * @return
     */
    public String getAttributeValueXpath(WebDriver driver, String locator, long timeout, String... values) {
        waitForElement(driver, locator, timeout, values);
        return findElementByXpath(driver, locator, values).getAttribute("value");
    }

    /**
     * Ham nay dung de detect trinh duyet dung de test
     */
    public WebDriver getBrowser(String browserName) {
        switch (browserName) {
            case Constants.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case Constants.HEADLESS_FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                final FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                firefoxOptions.addArguments("window-size=1920x1080");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case Constants.CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("use-fake-device-for-media-stream");
                chromeOptions.addArguments("use-fake-ui-for-media-stream");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("download.default_directory",System.getProperty("user.dir"));
                chromeOptions.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(chromeOptions);
                break;

            case Constants.HEADLESS_CHROME:
                WebDriverManager.chromedriver().setup();
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("window-size=1920x1080");
                chromeOptions.addArguments("allow-file-access-from-files");
                chromeOptions.addArguments("use-fake-device-for-media-stream");
                chromeOptions.addArguments("use-fake-ui-for-media-stream");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(chromeOptions);
                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        driver.get(Constants.URL);
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * Close browser and kill chromedriver.exe/IEDriverServer.exe process
     *
     * @param driver
     */
    public void closeBrowser(WebDriver driver) {
        String OS = System.getProperty("os.name").toLowerCase();
        boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
//        boolean IS_MAC = (OS.indexOf("mac") >= 0);
//        boolean IS_UNIX = (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
//        boolean IS_SOLARIS = (OS.indexOf("sunos") >= 0);
        try {
            driver.quit();
            System.gc();
            if (driver.toString().toLowerCase().contains("chrome")) {
                if (IS_WINDOWS) {
                    String cmd = "taskkill /IM chromedriver.exe /F";
                    Process process = Runtime.getRuntime().exec(cmd);
                    process.waitFor();
                }
            }
            if (driver.toString().toLowerCase().contains("internetexplorer")) {
                String cmd = "taskkill /IM IEDriverServer.exe /F";
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    protected boolean verifyTrue(boolean condition, boolean halt) {
        boolean pass = true;
        if (halt == false) {
            try {
                Assert.assertTrue(condition);
            } catch (Throwable e) {
                pass = false;
            }
        } else {
            Assert.assertTrue(condition);
        }
        return pass;
    }

    protected boolean verifyTrue(boolean condition) {
        return verifyTrue(condition, false);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
    /**
     * sleep
     *
     * @param timeout
     */
    public void sleep(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check control displayed
     * @return
     */
    public boolean isControlDisplayed(WebDriver driver, String locator) {
        try {
            return findElementByXpath(driver, locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Check control displayed with many value
     * @return
     */
    public boolean isControlDisplayed(WebDriver driver, String locator, String... values) {
        try {
            return findElementByXpath(driver, locator, values).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Wait for Element not display
     *
     * @param driver
     * @param locator
     * @param timeout
     */
    public void waitForElementNotDisplay(WebDriver driver, final String locator, long timeout) {
        try {
            By by = getBy(driver, locator);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("Control does not close");
        }
    }

    /**
     * open new tab
     *
     * @param driver
     * @param
     * @return
     */
    public WebDriver openNewTab(WebDriver driver, String url) {
        try {
            ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
            Thread.sleep(2000);
            //To switch to the new tab
            Set<String> handles = driver.getWindowHandles();
            String currentWindowHandle = driver.getWindowHandle();
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            for (String handle : handles) {
                if (!currentWindowHandle.equals(handle)) {
                    driver.switchTo().window(handle);
                }
            }
            driver.get(url);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return driver;
    }
    /**
     * switch Other Window
     *
     * @param driver
     * @return
     */
    public WebDriver switchOtherWindow(WebDriver driver) {
        WebDriver tmp = driver;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (String winHandle : driver.getWindowHandles()) {
            tmp = driver.switchTo().window(winHandle);
        }
        return tmp;
    }

    /**
     * Cloase Tab index
     */
    public WebDriver closeTabWindowIndex(WebDriver driver, String nametab) {
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        if (nametab.equals("tab1")&&tab.size()==1 ){
            driver.switchTo().window(tab.get(0));
            driver.close();
        }
        if (nametab.equals("tab2")&&tab.size()==2){
            driver.switchTo().window(tab.get(1));
            driver.close();
        }
        if (nametab.equals("tab3")&&tab.size()==3){
            driver.switchTo().window(tab.get(2));
            driver.close();
        }
        return driver;
    }
    /**
     * check file is existed
     *
     * @param  fileName
     * @return true/false
     */
    public boolean isFileExists(String fileName) {
        boolean flag = false;
        String OS = System.getProperty("os.name").toLowerCase();
        boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
        if (IS_WINDOWS) {
            final String dir1 = System.getProperty("user.dir");
            String pathFile = new File(dir1).getAbsolutePath();
            System.out.println(pathFile);
            File dir = new File(pathFile);
            File[] dir_contents = dir.listFiles();

            for (int i = 0; i < dir_contents.length; i++) {
                if (dir_contents[i].getName().equals(fileName)) {
                    dir_contents[i].delete();
                    return flag = true;
                }
            }

            return flag;
        }else {
            final String dir1 = System.getProperty("user.dir");
            String pathFile = new File(dir1).getAbsolutePath();
            System.out.println(pathFile);
            File dir = new File(pathFile);
            File[] dir_contents = dir.listFiles();

            for (int i = 0; i < dir_contents.length; i++) {
                if (dir_contents[i].getName().equals(fileName)==true) {
                    dir_contents[i].delete();
                    return flag = true;
                }
            }

            return flag;
        }
    }
    /**
     * get current time yyMMddHHmmss
     */
    public static String currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);
    }
    public static String getSourceFolder() {
        return System.getProperty("user.dir");
    }
    /**
     * Click by css
     * @param driver
     * @param controlName
     */
    public void executeClick(WebDriver driver, String controlName) {
        element = findElementByXpath(driver, controlName);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void waitAndClick(WebDriver driver, String locator, long timeout){
        waitForElement(driver, locator, timeout);
        clickToElement(driver, locator);
    }
}