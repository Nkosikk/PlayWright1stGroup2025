package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.AppConstants.*;

public class LoginTests extends BaseTest {

    @Test
    public void verifyLoginDisplayed() throws InterruptedException {
        String Actual_title = loginPage.getLoginPageTile();
        Assert.assertEquals(Actual_title, EXPECTED_LOGIN_PAGE_TITLE, "Title does not match");
        Thread.sleep(2000); // Sleep for 2 seconds to observe the title


    }

    @Test
    public void verifyLoginFunctionality() throws InterruptedException {
        //input username
        loginPage.enterUsername(userName);
        //input password
        loginPage.enterPassword(password);

        loginPage.clickLoginButton();

        Thread.sleep(2000); // Sleep for 2 seconds to observe the result
    }
}
