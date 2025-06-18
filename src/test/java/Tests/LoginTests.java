package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.AppConstants.EXPECTED_LOGIN_PAGE_TITLE;

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
        loginPage.enterUsername("standard_user");
        //input password
        loginPage.enterPassword("secret_sauce");

        Thread.sleep(2000); // Sleep for 2 seconds to observe the result
    }



}
