
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {
     WebDriver wd;

    @BeforeClass
            public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        }
        @Test
                public void testLogIn(){
            openSite();
            clickOnLoginButton();
            fillLoginForm();
            confirmLogin();
        }

    private void clickOnLoginButton() {
        wd.findElement(By.className("header-button-secondary")).click();
    }

    public void openSite() {
        wd.get("https://trello.com/");
    }
    public void fillLoginForm() {
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("dead.file.000@gmail.com");

        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("Bthbrthy5");
    }
    public void confirmLogin() {
        wd.findElement(By.id("login")).click();
    }
    @AfterClass
    public void tearDown(){

    }
}
