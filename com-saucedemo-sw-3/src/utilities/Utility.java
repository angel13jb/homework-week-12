package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utility extends BaseTest {
    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    public void verifyTextMessage(String expectedMessage,String actualMessage){

        Assert.assertEquals(expectedMessage,actualMessage);
    }
    public void printSizeOfList(By by){
        List<WebElement> productList = driver.findElements(by);
        int size = productList.size();
        System.out.println(size);
    }

}
