package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl="https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        //find element computer
        clickOnElement(By.linkText("Computers"));
        //verify expected and actual result match
        verifyTextMessage("Computers",getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]")));

    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        //find element electronics
        clickOnElement(By.linkText("Electronics"));
        //verify expected and actual result match
        verifyTextMessage("Electronics",getTextFromElement(By.xpath("//h1[contains(text(),'Electronics')]")));

    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        //find element apparel
        clickOnElement(By.linkText("Apparel"));
        //verify expected and actual result match
        verifyTextMessage("Apparel",getTextFromElement(By.xpath("//h1[contains(text(),'Apparel')]")));



    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        //find element digital downloads
        clickOnElement(By.linkText("Digital downloads"));
        //verify expected and actual result match
        verifyTextMessage("Digital downloads",getTextFromElement(By.xpath("//h1[contains(text(),'Digital downloads')]")));

    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //find element books
        clickOnElement(By.linkText("Books"));
        //verify expected and actual result match
        verifyTextMessage("Books",getTextFromElement(By.xpath("//h1[contains(text(),'Books')]")));

    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //fine element jewelry
        clickOnElement(By.linkText("Jewelry"));
        //verify expected and actual result match
         verifyTextMessage("Jewelry",getTextFromElement(By.xpath("//h1[contains(text(),'Jewelry')]")));

    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //find element gifcards
        clickOnElement(By.linkText("Gift Cards"));
        //verify expected and actual result match
        verifyTextMessage("Gift Cards",getTextFromElement(By.xpath("//h1[contains(text(),'Gift Cards')]")));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}


