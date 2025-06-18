package Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;
    private String usernameID = "#user-name";
    private String passwordID = "#password";
    private String loginButtonID = "#login-button"; // Add login button selector

    public LoginPage(Page page) {
        this.page = page;
    }

    public String getLoginPageTile() {
        return page.title();
    }


}
