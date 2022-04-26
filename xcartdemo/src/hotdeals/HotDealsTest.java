package hotdeals;

import Utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
        //mouse hover on Hot deals link
        mouseHoverOnElement(By.xpath("//li[@class='leaf has-sub']/following::span[text()='Hot deals']"));
        //mouse hover on sale link and click
        mouseHoverOnElementAndClick(By.linkText("Sale"));
        //verify text sales
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text not Match", expectedText, actualText);
        //mouse hover on sort by and select name A-Z
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverOnElementAndClick(By.xpath("//a[@data-sort-by='translations.name'and @data-sort-order='asc']"));
        //verify name arrange AtoZ
    }

    @Test
    public void verifySaleProductsArrangeLowToHigh() {
        //mouse hover on Hot deals link
        mouseHoverOnElement(By.xpath("//li[@class='leaf has-sub']/following::span[text()='Hot deals']"));
        //mouse hover on sale link and click
        mouseHoverOnElementAndClick(By.linkText("Sale"));
        //verify text sales
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text not Match", expectedText, actualText);
        //mouse hover on sort by and select price low-high
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverOnElementAndClick(By.xpath("//a[@data-sort-order='asc' and @data-sort-by='p.price']"));
        //verify price arrange low to high


    }

    @Test
    public void verifySalesProductsArrangeByRates() {
        mouseHoverOnElement(By.xpath("//li[@class='leaf has-sub']/following::span[text()='Hot deals']"));
        mouseHoverOnElementAndClick(By.linkText("Sale"));
        //verify text sales
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text not Match", expectedText, actualText);
        //mouse hover on sort by and select Rates
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverOnElementAndClick(By.xpath("//a[@data-sort-by='r.rating' and @data-sort-order='asc']"));
        //verify that products arrange rates
    }

    @Test
    public void verifySaleProductsArrangeByZToA() {
        //mouse hover on Hot deals link
        mouseHoverOnElement(By.xpath("//li[@class='leaf has-sub']/following::span[text()='Hot deals']"));
        //mouse hover on sale link and click
        mouseHoverOnElementAndClick(By.linkText("Sale"));
        //verify text sales
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text not Match", expectedText, actualText);
        //mouse hover on sort by and select name Z-A
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverOnElementAndClick(By.xpath("//a[@data-sort-by='translations.name'and @data-sort-order='desc']"));
        //verify name arrange ZtoA

    }
    @Test
    public void verifySaleProductsArrangeHighToLow() {
        //mouse hover on Hot deals link
        mouseHoverOnElement(By.xpath("//li[@class='leaf has-sub']/following::span[text()='Hot deals']"));
        //mouse hover on sale link and click
        mouseHoverOnElementAndClick(By.linkText("Sale"));
        //verify text sales
        String expectedText = "Sale";
        String actualText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Text not Match", expectedText, actualText);
        //mouse hover on sort by and select price high-low
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Sort by:')]"));
        mouseHoverOnElementAndClick(By.xpath("//a[@data-sort-order='desc' and @data-sort-by='p.price']"));
        //verify price arrange high to low
    }
        @After
        public void tearDown() {
            closeBrowser();
        }
    }
