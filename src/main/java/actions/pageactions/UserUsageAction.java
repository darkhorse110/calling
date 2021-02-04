package actions.pageactions;

import actions.commons.AbstractPages;
import actions.commons.Constants;
import interfaces.SalesLightUI;
import interfaces.UsageSituationUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserUsageAction extends AbstractPages {
    public WebDriver driver;
    public UserUsageAction(WebDriver driver){this.driver=driver;}
    public WebElement addFile;

    public void clickUsageSituationButton(){
        waitAndClick(driver, UsageSituationUI.btnUsageSituation, 30);
    }

    public void clickReportOnUserUsageButton(){
        waitAndClick(driver, UsageSituationUI.btnReportOnUserUsage, 30);
    }

    public Integer getCountConnectionOfUser(){
        waitForElement(driver, UsageSituationUI.textCountConnectionOfUser, 30);
        return Integer.parseInt(getTextElementByXpath(driver, UsageSituationUI.textCountConnectionOfUser, 30));
    }

    public void clickIconExit(){
        waitAndClick(driver, SalesLightUI.iconExit, 30);
    }

    public void clickBtnConfirmExit(){
        waitAndClick(driver, SalesLightUI.bntExit, 30);
    }

    public void switchToPlatformTab(){
        switchTabWindowIndex(driver, "tab2");
    }

    public void InputToSearchByNameField(){
        waitAndClick(driver, UsageSituationUI.txtSearchByName, 30);
        sendKeyToElement(driver, UsageSituationUI.txtSearchByName, Constants.USERTEAMAUTO);
        sendKeyboardToElement(driver, UsageSituationUI.txtSearchByName, Keys.ENTER);
    }

    public boolean DisplayDataByName(){
        waitForElement(driver, UsageSituationUI.textName, 30);
        return isElementDisplay(driver, UsageSituationUI.textName);
    }

    public void ChooseThisMonth(){
        waitAndClick(driver, UsageSituationUI.selectBoxMonth, 30);
        waitAndClick(driver, UsageSituationUI.optionThisMonth, 30);
    }

    public boolean IsDataDisplay(){
        waitForElement(driver, UsageSituationUI.textName,10);
        return isControlDisplayed(driver, UsageSituationUI.textName);
    }

    public boolean IsSalesTypeDisplay(){
        waitForElement(driver, UsageSituationUI.textTypeSales,30);
        return isControlDisplayed(driver, UsageSituationUI.textTypeSales);
    }

    public void clickOnButtonView(){
        waitAndClick(driver, UsageSituationUI.btnView, 30);
    }

    public String getIDSalesLightOnViewDetail(){
        waitForElement(driver, UsageSituationUI.textFirstIDSalesLight, 30);
        return getTextElementByXpath(driver, UsageSituationUI.textFirstIDSalesLight);
    }

    public String getFirstCountConnection(){
        waitForElement(driver, UsageSituationUI.textFirstCountConnection, 30);
        return getTextElementByXpath(driver, UsageSituationUI.textFirstCountConnection);
    }
}
