package homepage;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        clickOnElement(By.linkText("Shipping"));
        String expectedText = "Shipping";
        String actualText = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("Text not Match", expectedText, actualText);
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        clickOnElement(By.linkText("New!"));
        String expectedText="New arrivals";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text not Match",expectedText,actualText);
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        clickOnElement(By.linkText("Coming soon"));
        String expectedText="Coming soon";
        String acutalText=getTextFromElement(By.xpath("//h1[text()='Coming soon']"));
        Assert.assertEquals("Text not Match",expectedText,acutalText);
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        clickOnElement(By.linkText("Contact us"));
       String expectedText="Contact us";
       String actualText=getTextFromElement(By.xpath("//h1[text()='Contact us']"));
       Assert.assertEquals("Text not Match",expectedText,actualText);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
