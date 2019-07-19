package utilities;

import org.openqa.selenium.WebDriver;
import webdriver.WebDriverFactory;
import java.util.concurrent.TimeUnit;

public class Browser {

    private static String baseUrl = PropertyLoader.loadProperty("site.url");
    private static String BrowserName = PropertyLoader.loadProperty("browser.name");
    private static WebDriver driver;

    public static void Initialize(){

        driver = WebDriverFactory.getInstance(BrowserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        goTo("");
    }

    public static String getTitle(){

        return driver.getTitle();
    }

    public static WebDriver Driver(){

        return driver;
    }

    public static void goTo(String url){

        driver.get(baseUrl + url);
    }

    public static void close(){

        driver.close();
    }
}
