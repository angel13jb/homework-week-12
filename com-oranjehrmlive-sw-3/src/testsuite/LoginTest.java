package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl="https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    //login with valid credentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username element
        sendTextToElement(By.id("txtUsername"),"Admin");
        //find password element
        sendTextToElement(By.name("txtPassword"),"admin123");
        clickOnElement(By.xpath("//input[@id='btnLogin']"));
        //verify expected and actual result match
        verifyTextMessage("Welcome",getTextFromElement(By.xpath("//a[@id='welcome']")).substring(0,7));



    }
    @After
    public void tearDown(){
        closeBrowser();//closing browser
    }

}


