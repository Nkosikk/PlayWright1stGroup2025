package Pages;

import com.microsoft.playwright.Page;

public class SelectProduct {
    Page page;
    private String usernameID = "#user-name";

    public SelectProduct(Page page) {

        this.page = page;
    }

    public String getProductPageTitle() {

        return page.title();
    }
    public void enterUsername(String username) {
        page.fill(usernameID, username);
    }



}
