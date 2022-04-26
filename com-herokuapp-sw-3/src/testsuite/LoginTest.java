package testsuite;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import utilities.Utility;

public class LoginTest extends Utility {
    @Before
    //opening browser
    public void setUp() {
        openBrowser("http://the-internet.herokuapp.com/login");
    }

    @Test
    //login with valid credentials
    public void useShouldLoginSuccessfullyWithValidCredentials() {
        //find username elemnet
        sendTextToElement(By.id("username"),"tomsmith");
        //find password elemnet
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        //verify expected and actual result
        verifyTextMessage("Secure Area",getTextFromElement(By.xpath("//*[@id=\"content\"]/div/h2")));

    }
    @Test
    //error message displayed when enter invalid username
    public void verifyTheUsernameErrorMessage(){
        //find username element and set invalid username
        sendTextToElement(By.id("username"),"tomsmith1");
        //find password element
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        //verify that expected and actual result match
        verifyTextMessage("Your username is invalid!",getTextFromElement(By.xpath("//div[@id='flash-messages']")));





    }
    @Test
    //error message displayed when enter invalid password
    public void verifyThePasswordErrorMessage(){
        //find username element
        sendTextToElement(By.id("username"),"tomsmith");
        //find password element with invalid password
        sendTextToElement(By.name("password"),"SuperSecretPassword");
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));
        //verify that expected and actual result match
        verifyTextMessage("Your password is invalid!",getTextFromElement(By.xpath("/html/body/div[1]/div/div")));

           }
}
