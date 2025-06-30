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

        loginPage.clickLoginButton();

        Thread.sleep(2000); // Sleep for 2 seconds to observe the result
    }
    @Test (dependsOnMethods = "verifyLoginFunctionality")
    public void selectItemFromHomePage() throws InterruptedException {
        homePage.addItemToCart();
        Thread.sleep(2000); // Sleep for 2 seconds to observe the result
        String cartItemCount = homePage.getCartItemCount();
        Assert.assertEquals(cartItemCount, "1", "Cart item count does not match");
        homePage.navigateToCart();
        Thread.sleep(2000); // Sleep for 2 seconds to observe the result
        String pageTitle = homePage.getPageTitle();
        //Assert.assertTrue(pageTitle.contains("Your Cart"), "Page title does not contain 'Your Cart'");
    }




}
