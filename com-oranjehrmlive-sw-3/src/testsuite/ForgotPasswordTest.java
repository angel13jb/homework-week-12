package testsuite;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import utilities.Utility;

public class ForgotPasswordTest extends Utility {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);//opening browser
    }

    @Test
    // verify forget password text
    public void userShouldNavigateTOForgotPasswordPageSuccessfully() {
        clickOnElement(By.linkText("Forgot your password?"));
        //verify expected and actual result match
        verifyTextMessage("Forgot Your Password?",getTextFromElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/h1")));



    }

    @After
    public void tearDown() {
        closeBrowser();//closing browser
    }


}
