package homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
      clickOnElement(By.linkText(menu));

    }
    @Test
    public void verifyPageNavigation(){
        //select Books menu tab by using selectmenu method
        selectMenu("Books");
        //verify that page navigate
        //using verify textmessage method to verify expected and actual result
        verifyTextMessage("Books",getTextFromElement(By.xpath("//h1[contains(text(),'Books')]")));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}