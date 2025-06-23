package Tests;

import Base.BaseTest;
import Pages.SelectProduct;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.AppConstants.EXPECTED_LOGIN_PAGE_TITLE;
import static Constants.AppConstants.EXPECTED_PRODUCT_PAGE_TITLE;

public class SelectProductTests extends BaseTest {
    @Test
    public void selectProduct() throws InterruptedException {
        // Navigate to the product selection page
        page.navigate("https://www.saucedemo.com/v1/inventory.html");

       /* // Select a product by clicking on it
        page.click("text=Product Name"); // Replace with actual product name or selector

        // Optionally, you can add assertions to verify the product selection
        String selectedProduct = page.textContent("css=.selected-product"); // Adjust selector as needed
        System.out.println("Selected Product: " + selectedProduct);

        Thread.sleep(2000); // Sleep for 2 seconds to observe the selection*/
    }

    @Test
    public void verifyProductsPageTitleDisplayed() throws InterruptedException {
        page.navigate("https://www.saucedemo.com/v1/inventory.html");
        String Actual_title = selectProduct.getProductPageTitle();
        Assert.assertEquals(Actual_title, EXPECTED_PRODUCT_PAGE_TITLE, "Title does not match");
        Thread.sleep(2000); // Sleep for 2 seconds to observe the title


    }

}
