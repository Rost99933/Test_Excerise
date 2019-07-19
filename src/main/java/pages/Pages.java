package pages;

import libs.ActionsWithWebElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Browser;


public class Pages {

    WebDriver driver;
    ActionsWithWebElements actionsWithWebElements;
    public Pages pages;
    WebElement element;

    public Pages() {

    }

    public static HomePage homePage(){

        return PageFactory.initElements(Browser.Driver(), HomePage.class);
    }

    public Pages (WebDriver driver){
        this.driver = driver;
        actionsWithWebElements = new ActionsWithWebElements(driver);
        PageFactory.initElements(driver,this);
    }
}
