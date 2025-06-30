package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    Page page;
    private String addToCartButton = "#add-to-cart-sauce-labs-backpack"; // Example selector for add to cart button
    private String cartButton = "#shopping_cart_container"; // Example selector for cart button

    public HomePage(Page page) {
        this.page = page;
    }

    public void addItemToCart() {
        page.click(addToCartButton);
    }

    public String getCartItemCount() {
        return page.innerText(".shopping_cart_badge"); // Example selector for cart item count
    }

    public void navigateToCart() {
        page.click(".shopping_cart_link"); // Example selector for cart link
    }

    public String getPageTitle() {
        return page.title();
    }
   
}


