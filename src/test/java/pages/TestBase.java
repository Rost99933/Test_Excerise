package pages;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import utilities.Browser;
import pages.HomePage;
import webdriver.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)


public class TestBase {

    public WebDriver driver;
    public static HomePage homePage;
    private static Object HomePage;
    private String browser;

    private static final String SCREENSHOT_FOLDER = "target/screenshots/";
    private static final String SCREENSHOT_FORMAT = ".png";

    @Rule
    public TestName testName = new TestName();


    public TestBase(String browser) {

        this.browser = browser;
    }


    @Parameterized.Parameters
    public static Collection testData() {

        return Arrays.asList(new Object[][]{
                {"chrome"}
        });
    }

    @Before
    public void init () {

        Browser.Initialize();
        driver = Browser.Driver();
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {

        Browser.close();
    }

    @AfterMethod
    public void setScreenshot(ITestResult result) {
        if (!result.isSuccess()) {
            try {
                WebDriver returned = new Augmenter().augment(Browser.Driver());
                if (returned != null) {
                    File f = ((TakesScreenshot) returned).getScreenshotAs(OutputType.FILE);
                    try {
                        FileUtils.copyFile(f,
                                new File(SCREENSHOT_FOLDER + result.getName() + SCREENSHOT_FORMAT));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (ScreenshotException se) {
                se.printStackTrace();
            }
        }
    }
}
