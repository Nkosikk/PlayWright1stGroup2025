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

    @Description("Add Items to Cart")
    @Test
    public  void AddingItemsToCart() throws InterruptedException {
        productsPage.viewItem("Sauce Labs Backpack");
        productsPage.addItemToCart();
        Thread.sleep(3000); // Sleep for 3 seconds to observe the items added
        Assert.assertTrue(productsPage.addToCart.isEmpty(), "Item was not added to cart successfully");
        Thread.sleep(3000);
        productsPage.backToProducts();
        productsPage.getProductsPageTile();
    }
}
