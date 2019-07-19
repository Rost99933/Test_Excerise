package webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browser;


public class WebDriverFactory extends Browser {

    public static final String CHROME = "chrome";

    private WebDriverFactory(){}

    public static WebDriver getInstance(String browserName){

        WebDriver webDriver = null;

        if (CHROME.equals(browserName)) {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            webDriver = new ChromeDriver();
        }
        else {
            throw new IllegalArgumentException("Blah! Unsupported browser!");
        }
        return webDriver;
    }
}
