package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));

        //verify actual and expected message
       verifyTextMessage("Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));



    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        clickOnElement(By.linkText("Log in"));
        sendTextToElement(By.id("Email"),"tomsmith@gmail.com");
        //find the password field element
        sendTextToElement(By.name("Password"),"tomsmith1");
        clickOnElement(By.xpath("//button[normalize-space()='Log in']"));
        //verify message
        verifyTextMessage("Log out",getTextFromElement(By.xpath("//a[contains(text(),'Log out')]")));


    }

    @Test
    public void verifyErrorMessagewithInvalidCredentials() {
        clickOnElement(By.linkText("Log in"));
        sendTextToElement(By.id("Email"),"prime123@gmail.com");
        //find the password field element
        sendTextToElement(By.name("Password"),"Prime123");

        clickOnElement(By.xpath("//button[normalize-space()='Log in']"));
        //verify expected and actual result match

        verifyTextMessage("Login was unsuccessful. Please correct the errors and try again.\n"+
         "No customer account found",getTextFromElement(By.xpath("//div[@class='message-error validation-summary-errors']")));



    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
