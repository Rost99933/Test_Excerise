package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class HomePage extends Pages{

//    private final String H1_TAG = "h1";
//
//    @FindBy(how = How.TAG_NAME, using = H1_TAG)
//    @CacheLookup
//    private WebElement h1Element;

    public HomePage(WebDriver driver) {
        super(driver);
    }

//    public String getH1() {
//
//        return h1Element.getText();
//    }

    @FindBy(xpath = "//body//sidebar-fat-menu//li[2]")
    private WebElement smartphoneMainFilterBtn;

    @FindBy(xpath = "//li[@class='menu-categories__item menu-categories__item_state_hovered']//div[@class='menu__main-cats-inner']//div[1]//ul[1]//li[1]//ul[1]//li[1]//a[1]")
    private WebElement smartphoneBtn;


    public void hoverSmartphoneElement() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actionsWithWebElements.clickButton(smartphoneMainFilterBtn);
    }

}
