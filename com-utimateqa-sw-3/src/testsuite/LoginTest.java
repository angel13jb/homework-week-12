package testsuite;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com";

    @Before
    //opening browser
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        clickOnElement((By.linkText("Sign In")));

        //compare as expected and actual result same
        verifyTextMessage("Welcome Back!",getTextFromElement(By.xpath("//h1[contains(text(),'Welcome Back!')]")));

    }
    @Test
    public void verifyTheErrorMessage(){
        clickOnElement((By.linkText("Sign In")));
        //find element email
        sendTextToElement(By.id("user[email]"),"prime@gmail.com");

        //find element password
        sendTextToElement(By.name("user[password]"),"prime1");

        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));

        //compare expected and actual result
        verifyTextMessage("Invalid email or password.",getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]")));


    }
    @After
    public void tearDown(){
        closeBrowser();//closing browser
    }
}



