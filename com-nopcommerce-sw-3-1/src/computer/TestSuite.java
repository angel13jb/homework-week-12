package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void testName(){
        //1.1 click on computer menu
        clickOnElement(By.linkText("Computers"));
        //1.2 click on desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        //1.3 select sort by position Name ZtoA
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: Z to A");
        //1.4 verify the product will arrange in Descending order
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully()  {
        //2.1 click on computer menu
        clickOnElement(By.linkText("Computers"));
        //2.2 click on desktop
        clickOnElement(By.xpath("//a[text()=' Desktops ']"));
        //2.3 select sort by position Name AtoZ
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name: A to Z");
        //2.4 click on add to cart
       mouseHoverOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]"));
       mouseHoverOnElementAndClick(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
       // mouseHoverOnElementAndClick(By.xpath("//div[@data-productid='1']/descendant::button[1]"));
        //2.5 verify the text "build your own computer"
        verifyTextMessage("Build your own computer",getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]")));
        //2.6 select "2.2intel pentium dual-core E2200'by Select class
        mouseHoverOnElement(By.xpath("//label[contains(text(),'Processor')]"));
        selectByVisibleTextFromDropDown(By.cssSelector("#product_attribute_1"),"2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7 select RAM "8GB[+$60.00]" by using select class
        mouseHoverOnElement(By.xpath("//label[contains(text(),'RAM')]"));
        selectByValueFromDropDown(By.cssSelector("#product_attribute_2"),"5");
        //2.8 select HDD"400GB[$100.00]"
        mouseHoverOnElement(By.xpath("//label[contains(text(),'HDD')]"));
        mouseHoverOnElementAndClick(By.cssSelector("#product_attribute_3_7"));
        //2.9select OS radio "vista premium[+$60.00]
        mouseHoverOnElement(By.xpath("//label[contains(text(),'OS')]"));
        mouseHoverOnElementAndClick(By.cssSelector("#product_attribute_4_9"));
        //2.10 check two boxes "Microsoft office[+$50.00] and "total commander"
        mouseHoverOnElement(By.xpath("//label[contains(text(),'Software')]"));
        clickOnElement(By.cssSelector("#product_attribute_5_10"));
        clickOnElement(By.cssSelector("#product_attribute_5_12"));
        //2.11 verify the price $1,475.00
      // verifyTextMessage("$1,425.00",getTextFromElement(By.cssSelector("#price-value-1")));
        //2.12 click on Add to Cart
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 verify the message "the product has been added to your shopping cart"
        verifyTextMessage("The product has been added to your shopping cart",getTextFromElement(By.xpath("//div[@class='bar-notification success']")));
        //close bar clicking on cross button
        clickOnElement(By.xpath("//span[@class='close']"));
        //2.14 mouse hover on shipping cart
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        //2.15 verify the message "shopping cart"
        verifyTextMessage("Shopping cart",getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]")));
        //2.16 change qty 2 and click on 'update shopping cart'
        mouseHoverOnElement(By.xpath("//th[contains(text(),'Qty.')]"));
        driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]")).clear();

        sendTextToElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/input[1]"),"2");

        // mouseHoverOnElement(By.xpath("//input[@id='itemquantity11232']"));
        //clickOnElement(By.xpath("//input[@id='itemquantity11232']"));
        //2.17 click on update shopping cart
        mouseHoverOnElementAndClick(By.xpath("//button[@id='updatecart']"));
        //2.18 click on checkbox @I agree with terms of service'
        mouseHoverOnElementAndClick(By.xpath("//input[@id='termsofservice']"));
        //2.19 click on checkout
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.20 verify text @welcome,please sign in'
        verifyTextMessage("Welcome, Please Sign In!",getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]")));
        //2.21 click on 'checkout as guest
        mouseHoverOnElementAndClick(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 fill all mandatory field
        //firstname field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Tom");
        //lastname field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Smith");
        //email field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"smith12@gmail.com");
        //select country
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");
        //select city
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Newyork");
        //add address
        sendTextToElement(By.cssSelector("#BillingNewAddress_Address1"),"1 Abbey Lane");
        // add zipcode
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"3650052");
        //add phone number
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"007742456892");
        // 2.23 click on continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //2.24 click radio button 'next day'
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        //2.25 click on continue
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 selcet radiobutton 'credit card'
        mouseHoverOnElementAndClick(By.xpath("//input[@id='paymentmethod_1']"));
        //2.27 click on continue
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.28 fill all card details
        //select mastercard
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
        //enter cardholdername
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"TomSmith");
        //enter card number
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5105105105105100");
        //sleect expiry month and date
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"4");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
        //eneter cardcode
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"4564");
        //2.29 click on continue
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        //2.34 click on confirm
        mouseHoverOnElementAndClick(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 verify 'Thank you'
        verifyTextMessage("Thank you",getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]")));
        //2.36 verify 'your order has been successfully processed'
        verifyTextMessage("Your order has been successfully processed!",getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        //2.37 click on continue
        mouseHoverOnElementAndClick(By.xpath("//button[contains(text(),'Continue')]"));
        //2.38 verify message 'welcome to our store
        verifyTextMessage("Welcome to our store",getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")));


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
