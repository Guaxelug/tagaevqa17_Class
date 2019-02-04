import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        //wd = new ChromeDriver();
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/");
    }
    @AfterClass
    public void tearDown(){
        wd.quit();
    }

    public void clickOnLoginButton() {
        wd.findElement(By.className("header-button-secondary")).click();
    }
    public void openSite(String url) {
        wd.get(url);
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
    public void login(){
        clickOnLoginButton();
        fillLoginForm();
        confirmLogin();
    }
    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//span[@class='member']"));
    }
    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickOnAvatar() {
        wd.findElement(By.cssSelector("img.member-avatar")).click();
    }
    public void clickOnLogOutButton() {
        wd.findElement(By.cssSelector("a.js-logout")).click();
    }
}
