package Tests;

import Base.BaseTest;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.AppConstants.*;


public class ProductsTests extends BaseTest {

    @Description("Verify that the products page title is displayed correctly")
    @Test(dependsOnGroups ={"LoginTests.verifyLoginFunctionality"} )
    public void verifyProductsPageTitle() throws InterruptedException {
        String Actual_title = productsPage.getProductsPageTile();
        Assert.assertEquals(Actual_title, EXPECTED_PRODUCTS_PAGE_TITLE, "Actual Title" + Actual_title + "does not match Expected Title: " + EXPECTED_PRODUCTS_PAGE_TITLE);
        Thread.sleep(3000); // Sleep for 3 seconds to observe the title

    }
}
