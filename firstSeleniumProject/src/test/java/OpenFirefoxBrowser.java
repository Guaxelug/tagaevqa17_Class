import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenFirefoxBrowser {
    WebDriver wd;

    @BeforeTest
    public void setUp(){
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void testEbaySearch(){
        wd.get("https://www.ebay.com/");
        wd.findElement(By.id("gh-ac")).click();
        wd.findElement(By.id("gh-ac")).clear();
        wd.findElement(By.id("gh-ac")).sendKeys("glasses");

        wd.findElement(By.id("gh-btn")).click();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       // Thread.sleep(5000);
        //wd.quit();
    }
}
