package Pages;

import com.microsoft.playwright.Page;

public class ProductsPage {
    Page page;
    private String productItemBackPack = "Sauce Labs Backpack";
    private String productItemBikeLight = "Sauce Labs Bike Light";
    private String productItemTShirt = "Sauce Labs Bolt T-Shirt";
    private String productItemFleeceJacket = "Sauce Labs Fleece Jacket";
    private String productItemOnesie = "Sauce Labs Onesie";
    private String productItemAllThings = "Test.allTheThings() T-Shirt (Red)";
    public String addToCart = "#add-to-cart";
    public String removeItem = "#remove";
    private String backToProducts = "#back-to-products";


    public ProductsPage(Page page) {

        this.page = page;

    }

    public String getProductsPageTile() {

        return page.title();
    }

    public void viewItem(String productName) {
        switch (productName.toLowerCase()) {
            case "Sauce Labs Backpack":
                page.click("text=" + productItemBackPack);
                break;
            case "Sauce Labs Bike Light":
                page.click("text=" + productItemBikeLight);
                break;
            case "Sauce Labs Bolt T-Shirt":
                page.click("text=" + productItemTShirt);
                break;
            default:
                throw new IllegalArgumentException("Product not found: " + productName);
        }
    }

    public void addItemToCart() {
        page.click(addToCart);
    }

    public void removeItem() {
        page.click(removeItem);
    }

    public void backToProducts() {
        page.click(backToProducts);
    }
}
