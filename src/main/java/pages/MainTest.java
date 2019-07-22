package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainTest {

public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        String formattedDate = sdf.format(date);

        String baseUrl = "https://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/";
        driver.get(baseUrl);


//        WebElement smartphone = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']//a[.='Смартфоны, ТВ и электроника']")); //Bad xpath
//        smartphone.click();
//        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//
//        WebElement smartphoneBtn = driver.findElement(By.xpath("//div[@class='container']//div[@class='pab-img']/a[@href='https://rozetka.com.ua/telefony/c4627900/']")); //Bad xpath
//        smartphoneBtn.click();
//
//        WebElement smartphoneBtn1 = driver.findElement(By.xpath("//a[.='Смартфоны']")); //Bad xpath
//        smartphoneBtn1.click();

        WebElement sortBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("drop_link")));
        executor.executeScript("arguments[0].click();", sortBtn);

        WebElement lowestPriceSort = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("filter_sortexpensive")));
        executor.executeScript("arguments[0].click();", lowestPriceSort);


        WebElement allPhones = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Еще (72)']")));
        executor.executeScript("arguments[0].click();", allPhones);

        Thread.sleep(5000);
        WebElement appleCheckBox  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[.='Apple']")));
        executor.executeScript("arguments[0].click();", appleCheckBox);

        WebElement samsungCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[.='Samsung']")));
        executor.executeScript("arguments[0].click();", samsungCheckBox);

        WebElement memoryCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@name='41404_842250']//i[@class='filter-parametrs-i-l-i-default-title'][contains(text(),'128')]")));
        executor.executeScript("arguments[0].click();", memoryCheckBox);

        WebElement maxPriceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("price[max]")));
        executor.executeScript("arguments[0].click();", maxPriceInput);
        maxPriceInput.sendKeys("20000");

        WebElement pricceFilterBtnOK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitprice")));
        executor.executeScript("arguments[0].click();", pricceFilterBtnOK);

        WebElement maxPriceInTheGrid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("//div[@id='goods_price_block_35450582']//div[@name='price']")));
        String textMaxPrice = maxPriceInTheGrid.getText();

        PrintWriter out = null;
        try {
                out = new PrintWriter(new FileWriter("./drivers/logs.txt"));
        } catch (IOException e) {
                e.printStackTrace();
        }
        out.println(formattedDate + "Result is Passed, max price is" + textMaxPrice);
        out.close();









//        driver.close();

        }
}
