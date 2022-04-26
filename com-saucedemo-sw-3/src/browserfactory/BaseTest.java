package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;//declare webdriver as global variable
    public void openBrowser(String baseUrl){
        //setup chrome driver
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver =new ChromeDriver();
        // Launch the URL.
        driver.get(baseUrl);
        // Maximise Window
        driver.manage().window().maximize();
        // We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser(){
        driver.quit();
    }
}


