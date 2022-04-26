package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        //opening browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username element and send value
        sendTextToElement(By.name("username"),"siya012");
         //find password element and send value
        sendTextToElement(By.xpath("//input[@name='password']"),"spatel123");
         clickOnElement(By.xpath("//input[@value='Log In']"));
        //this is requirment
        //verify expected and actual result match
        verifyTextMessage("Accounts Overview",getTextFromElement(By.xpath("//h1[contains(text(),'Accounts Overview')]")));





    }

    @Test
    public void verifyErrorMessage() {
        //send invalid value in username element
        sendTextToElement(By.name("username"),"siya01");

        //send invalid value in password element
        sendTextToElement(By.xpath("//input[@name='password']"),"Spatel12");

        clickOnElement(By.xpath("//input[@value='Log In']"));
        //verify expected and acctual result
        verifyTextMessage("The username and password could not be verified.",getTextFromElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]")));



    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //set valid value for username
        sendTextToElement(By.name("username"),"siya012");

        //set valid value for password
        sendTextToElement(By.xpath("//input[@name='password']"),"spatel123");
         //login successfully
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //click on log out
        clickOnElement(By.linkText("Log Out"));
        //this is requirment
        //verify expected and actual resutl
        verifyTextMessage("Customer Login",getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]")));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
