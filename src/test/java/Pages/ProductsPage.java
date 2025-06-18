package Pages;

import com.microsoft.playwright.Page;

public class ProductsPage {
    Page page;

    public ProductsPage(Page page) {

        this.page = page;
    }

    public String getProductsPageTile() {

        return page.title();
    }

    // Example locator (you can modify it based on your actual HTML structure):
    // private String productItemSelector = ".product-item";

    // Example method to get the number of products displayed:
    // public int getNumberOfProducts() {
    //     return page.locator(productItemSelector).count();
    // }
}
