package shopping;

import Utilities.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
        // 1.1 mouse hover on Hot deals link
        mouseHoverOnElement(By.xpath("//li[@class='leaf has-sub']/following::span[text()='Hot deals']"));
        //1.2 mouse hover on the Bestsellers link and click
        mouseHoverOnElementAndClick(By.linkText("Bestsellers"));
        //1.3 verify the text Bestsellers
        String expectedText="Bestsellers";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text not Match",expectedText,actualText);
        //1.4 mouse hover on Sort by and select Name A-Z
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverOnElementAndClick(By.xpath("//a[@data-sort-by='translations.name'and @data-sort-order='asc']"));
        //1.5 click on add to cart button for product "Apple iphone"
        mouseHoverOnElement(By.xpath("//a[@class='fn url next-previous-assigned' and contains(text(),'Apple iPhone')]"));
        mouseHoverOnElementAndClick(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-42']"));
        //1.6 verify message "Product has been added to your cart "
        String expectedText1="Product has been added to your cart";
        String actualText1=getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        Assert.assertEquals("Text not Match",expectedText1,actualText1);
        //1.8 click on "your cart"icon and click on "view cart" button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(10000);
        mouseHoverOnElementAndClick(By.linkText("View cart"));
        //1.9 verify text "your shopping cart-1 item"
        String expectedText2="Your shopping cart - 1 item";
       String actualText2=getTextFromElement(By.xpath("//*[@id=\"page-title\"]"));
        Assert.assertEquals("Text not Match",expectedText2,actualText2);
        //1.10 verify subtotal $299.00
        String expectedsubtotal="Subtotal: $299.00";
        String actualsubtotal=getTextFromElement(By.xpath("//li[@class='subtotal']/parent::ul[@class='sums']"));
        Assert.assertEquals("TExt not Match",expectedsubtotal,actualsubtotal);
        //1.11 verify total $309
        String expectedTotal="309";
        String actualTotal=getTextFromElement(By.xpath("//span[contains(text(),'309')]"));
        Assert.assertEquals("Text not Match",expectedTotal,actualTotal);
        //1.12 click on go to checkout
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));
        //1.13 verify the Text "No account yet"
        String expectedText3="No account yet?";
        String actualText3=getTextFromElement(By.xpath("//h3[contains(text(),'No account yet?')]"));
        Assert.assertEquals("Text not Match",expectedText3,actualText3);
        //1.14 enter email address
        sendTextToElement(By.xpath("//input[@id='email']"),"xyz@gmail.com");
        //1.15 click on continue button
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));
        //1.16 verify text "secure checkout"
        String expectedText4="Secure Checkout";
        String actualText4=getTextFromElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]"));
        Assert.assertEquals("Text not Match",expectedText4,actualText4);
        //1.17 fill all the mandatory fields
        //enter firstname
        sendTextToElement(By.id("shippingaddress-firstname"),"Lily");
        //enter Lastname
        sendTextToElement(By.id("shippingaddress-lastname"),"Smith");
        //enter Address
        sendTextToElement(By.name("shippingAddress[street]"),"10 Abbey street");
        //enter city
        sendTextToElement(By.name("shippingAddress[city]"),"London");
        //select country
        selectByVisibleTextFromDropDown(By.id("shippingaddress-country-code"),"United Kingdom");
        //enter state
        sendTextToElement(By.id("shippingaddress-custom-state"),"UK");
        //enter zipcode
        sendTextToElement(By.name("shippingAddress[zipcode]"),"900451");
        //check the check box "create an account
        mouseHoverOnElementAndClick(By.id("//input[@id='create_profile']"));
        //1.18 enter password
        sendTextToElement(By.name("password"),"smith123");
        //1.19 select the delivery method to "Local shipping"
        mouseHoverOnElementAndClick(By.xpath("//span[contains(text(),'Local shipping')]"));
        //1.20 select payment method 'COD'
        mouseHoverOnElementAndClick(By.xpath("//span[contains(text(),'COD')]"));
        //1.23 click on "place Order"
        mouseHoverOnElementAndClick(By.xpath("//span[contains(text(),'Place order: $311.03')]"));
        //1.24 verify text 'thank you for your order'
        String expectedText5="Thank you for your order";
        String actualText5=getTextFromElement(By.linkText("Thank you for your order"));
        Assert.assertEquals("TExt not Match",expectedText5,actualText5);



    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        // 1.1 mouse hover on Hot deals link
        mouseHoverOnElement(By.xpath("//li[@class='leaf has-sub']/following::span[text()='Hot deals']"));
        //1.2 mouse hover on the Bestsellers link and click
        mouseHoverOnElementAndClick(By.linkText("Bestsellers"));
        //1.3 verify the text Bestsellers
        String expectedText="Bestsellers";
        String actualText=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text not Match",expectedText,actualText);
        //1.4 mouse hover on Sort by and select Name A-Z
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverOnElementAndClick(By.xpath("//a[@data-sort-by='translations.name'and @data-sort-order='asc']"));
        //1.5 click on "add to cart" button of product "Vinyl idol Ghostbusters
        mouseHoverOnElement(By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']"));
        mouseHoverOnElementAndClick(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));
        //1.6 verify message "product has been added to your cart"
        String expectedMessage="Product has been added to your cart";
        String actualMessage=getTextFromElement(By.xpath("//li[contains(text(),'Product has been added to your cart')]"));
        Assert.assertEquals("Text not Match",expectedMessage,actualMessage);
        //1.7 click on 'x' sing
        //1.8 click on "Your cart" and click on "view cart"
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(10000);
        mouseHoverOnElementAndClick(By.xpath("//span[contains(text(),'View cart')]"));
        //1.9 verify the text "your shopping cart-1 item
        String expectedText1="Your shopping cart - 1 item";
        String actualText1=getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 1 item']"));
        Assert.assertEquals(expectedText1,actualText1);
        //1.10 click on "Empty your cart"link
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        //1.11 verify the text "Are you sure want to clear your cart?"
        switchToAlert();
        //1.12 click "ok" on alert
        acceptAlert();
        //1.13 verify message "item deleted from your cart"
        String expectedText2="Item(s) deleted from your cart";
        String actualText2=getTextFromElement(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"));
        Assert.assertEquals("Text not Match",expectedText2,actualText2);
        //1.14 verify text "your cart is empty"
        String expectedText3="Your cart is empty";
        String actualText3=getTextFromElement(By.xpath("//h1[text()='Your cart is empty']"));
        Assert.assertEquals("Text not Match",expectedText3,actualText3);




    }
}
