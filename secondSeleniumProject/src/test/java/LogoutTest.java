import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        if(!isUserLoggedIn()){
            login();
        }
    }
    @Test
    public void testLogout(){
        clickOnAvatar();
        clickOnLogOutButton();

        Assert.assertFalse(isUserLoggedIn());
    }
}
