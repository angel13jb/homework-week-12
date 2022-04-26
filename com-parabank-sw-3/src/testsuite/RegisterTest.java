package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl="https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setup(){
        openBrowser(baseUrl);}
    @Test
    public void verifyThatSigingUPPageDisplay(){
        //find element register and click
        clickOnElement(By.linkText("Register"));
        //this is requirment
        //verify expected and actual result match
        String expectedtext="Signing up is easy!";
        verifyTextMessage("Signing up is easy!",getTextFromElement(By.xpath("//h1[@class='title']")));




    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        clickOnElement(By.linkText("Register"));
        //find firstname element and send value
        sendTextToElement(By.id("customer.firstName"),"Siya");
        //find lastname element and send value
        sendTextToElement(By.id("customer.lastName"),"Patel");
        //find address element and send value
        sendTextToElement(By.name("customer.address.street"),"Swati Bunglows");
        //find city element and send value
        sendTextToElement(By.name("customer.address.city"),"Ahmedabad");
        //find state elemnet and send value
        sendTextToElement(By.name("customer.address.state"),"Gujrat");
        //find zipcod element and send value
        sendTextToElement(By.id("customer.address.zipCode"),"380009");
        //find phonenumber element and send value
        sendTextToElement(By.id("customer.phoneNumber"),"9956077940");
        //find ssn number element and send value
        sendTextToElement(By.name("customer.ssn"),"345-45-6575");
        //find username,password element and send value
        sendTextToElement(By.xpath("//input[@id='customer.username']"),"siya012");
        sendTextToElement(By.xpath("//input[@id='customer.password']"),"spatel123");
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"),"spatel123");
        clickOnElement(By.xpath("//input[@value='Register']"));
        //this is from requirment
        //verify expected nad actual resutl match
        verifyTextMessage("Your account was created successfully. You are now logged in.",getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]")));


           }
    @After
    public void tearDown(){
        closeBrowser();
    }

}

