package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.AppConstants.EXPECTED_LOGIN_PAGE_TITLE;

public class LoginTests extends BaseTest {

    @Test
    public void verifyLoginDisplayed() {
        String Actual_title = loginPage.getLoginPageTile();
        Assert.assertEquals(Actual_title, EXPECTED_LOGIN_PAGE_TITLE, "Title does not match");
    }


}
