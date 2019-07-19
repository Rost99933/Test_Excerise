package pages;

import org.junit.Test;

public class HomePageTest extends TestBase {

    public HomePageTest(String browser) {

        super(browser);
    }

//    @Test
//    public void testH1Existing() throws InterruptedException {
//
//        Assert.assertTrue(Browser.getTitle() != null);


    @Test
    public void hoverSmartphoneElement() {

        homePage.hoverSmartphoneElement();
    }
}
