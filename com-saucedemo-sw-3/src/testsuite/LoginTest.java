package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    @Before
    //opening browser
    public void setUp() {
        openBrowser("https://www.saucedemo.com/");
    }

    @Test
    public void useShouldLoginSuccessfullyWithValidCredentials() {
        //find element username
        sendTextToElement(By.id("user-name"),"standard_user");
        //find elemnet password
        sendTextToElement(By.name("password"),"secret_sauce");
        //find element log in button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //compare expected and actual result match
        verifyTextMessage("PRODUCTS",getTextFromElement(By.xpath("//span[contains(text(),'Products')]")));

            }

    @Test
    public void verifyThatSixProductAreDisplayedOnPage() {
        //find element username
        sendTextToElement(By.id("user-name"),"standard_user");
        //find elemnt password
        sendTextToElement(By.name("password"),"secret_sauce");
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //verify that six products are displaed in page
        //using list interface to get list element
        printSizeOfList(By.className("inventory_item"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
