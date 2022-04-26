package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //find register element
        clickOnElement(By.linkText("Register"));
        //verify expected and actual result match

        verifyTextMessage("Register",getTextFromElement(By.xpath("//h1[contains(text(),'Register')]")));

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        //find element register
        clickOnElement(By.linkText("Register"));

        //find element genderbutton
        clickOnElement(By.id("gender-female"));

        //find element first name and get value
        sendTextToElement(By.id("FirstName"),"Lily");
        //find element last name and get value
        sendTextToElement(By.name("LastName"),"Smith");
        //select birthday from drop down
         selectByIndexFromDropDown(By.name("DateOfBirthDay"),1);
        //select birthmonth from drop down
        selectByIndexFromDropDown(By.name("DateOfBirthMonth"),2);
        //select drop down from year
        selectByIndexFromDropDown(By.name("DateOfBirthYear"),50);
        //find element email and get value
        sendTextToElement(By.id("Email"),"lilysmith@gmail.com");

        //find element password and get value
        sendTextToElement(By.name("Password"),"lily123");

        sendTextToElement(By.name("ConfirmPassword"),"lily123");

        clickOnElement(By.linkText("Register"));
        //verify expected and actual result match
        verifyTextMessage("Your registration completed",getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")));


    }
    @After
    public void tearDown(){
        closeBrowser();
    }



}
