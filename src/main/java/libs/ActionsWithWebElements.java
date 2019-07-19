package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Pages;

public class ActionsWithWebElements extends Pages {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions action = new Actions(driver);


    public ActionsWithWebElements(WebDriver webDriver) {
        this.driver = webDriver;
        webDriverWait = new WebDriverWait(driver, 3);
    }

    public void inputTextToField(WebElement inputField, String inputText) {

        try {
            inputField.clear();
            inputField.sendKeys(inputText);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void clickButton(WebElement SubmitBtn) {

        try {
            SubmitBtn.click();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectElementFromDropdownByText(String locatorDropdownXPath, String textInDropDown) {

        try {
            Select selectDropdown = new Select(driver.findElement(By.xpath(locatorDropdownXPath)));
            selectDropdown.selectByVisibleText(textInDropDown);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectElementFromDropdownByValue(String locatorDropdownXPath, String valueInDropDown) {

        try {
            Select selectDropdown = new Select(driver.findElement(By.xpath(locatorDropdownXPath)));
            selectDropdown.selectByValue(valueInDropDown);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void tickCheckBox(String checkBoxXPath, boolean statusCheckBox) {

        try {
            if ((statusCheckBox) && (!driver.findElement(By.xpath(checkBoxXPath)).isSelected())) {
                driver.findElement(By.xpath(checkBoxXPath)).click();
            } else {
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void hoverMouseOnTheElement(WebElement element) {

            action.moveToElement(element).perform();
    }

    public void tickCheckBox2(String checkBoxXPath, boolean statusCheckBox) {

        try {
            if ((statusCheckBox) && (!driver.findElement(By.xpath(checkBoxXPath)).isSelected())) {
                driver.findElement(By.xpath(checkBoxXPath)).click();
            } else if ((!statusCheckBox) && (driver.findElement(By.xpath(checkBoxXPath)).isSelected())) {
                driver.findElement(By.xpath(checkBoxXPath)).click();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void tickCheckBox3(String checkBoxXPath, boolean statusCheckBox) {

        try {
            if ((statusCheckBox) && (!driver.findElement(By.xpath(checkBoxXPath)).isSelected())
                    || ((!statusCheckBox) && (driver.findElement(By.xpath(checkBoxXPath)).isSelected()))) {
                driver.findElement(By.xpath(checkBoxXPath)).click();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getText (WebElement element) {

        return element.getText();
    }

}
