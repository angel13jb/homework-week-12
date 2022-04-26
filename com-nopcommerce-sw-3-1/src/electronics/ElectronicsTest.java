package electronics;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void testVerified(){
        //1.1 mouse hover on 'Electronics Tab'
        mouseHoverOnElement(By.linkText("Electronics"));
        //1.2 mouse hover on 'cell phones tab'and click
        mouseHoverOnElementAndClick(By.linkText("Cell phones"));
        // 1.3 verify text 'Cell Phones'
        verifyTextMessage("Cell phones",getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")));
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()  {
        //2.1 mouse hover on 'Electronics Tab'
        mouseHoverOnElement(By.linkText("Electronics"));
        //2.2 mouse hover on 'cell phones tab'and click
        mouseHoverOnElementAndClick(By.linkText("Cell phones"));
        //2.3 verify text 'Cell Phones'
        verifyTextMessage("Cell phones",getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]")));
        //2.4 click on list view tab
        mouseHoverOnElementAndClick(By.xpath("//a[contains(text(),'List')]"));
        //2.5click on product 'nokia lumia 1020'link
        mouseHoverOnElementAndClick(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));

        //2.6 verify text 'Nokia Lumia 1020'
        verifyTextMessage("Nokia Lumia 1020",getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]")));
        //2.7 verify price '$349.00'
        verifyTextMessage("$349.00",getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]")));
        //2.8 change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");
        //2.9 click on 'add to cart'
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10 verify message and click on cross button
        verifyTextMessage("The product has been added to your shopping cart",getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]")));
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.11 mouse hover on 'shopping cart' and click on 'go to cart'button
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        mouseHoverOnElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.12 verify the message 'shopping cart
        verifyTextMessage("Shopping cart",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.13 verify quantity 2
        verifyTextMessage("2",getTextFromElement(By.xpath("//input[@id='itemquantity11254']")));
        //2.14 verify total $698.00
        // 2.15 click on check box'Iagree with term of service
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.17 verify text 'please sign in'
        verifyTextMessage("Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
        //2.18 click on register tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.20 fill all details
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Prince");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"York");
        sendTextToElement(By.xpath("//input[@id='Email']"),"prince1@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Password']"),"york12");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"york12");
        //2.21 click on register button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        //2.22 verify mesg youe registration is completed
        verifyTextMessage("Your registration completed",getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]")));
        //2.23 click on continue tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //2.24 verify text 'shopping cart'










    }







}
