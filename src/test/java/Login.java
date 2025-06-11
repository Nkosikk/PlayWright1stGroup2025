import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Login {

    private static Playwright playwright;
    private static Browser browser;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @Test
    void testLogin() throws InterruptedException {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://www.saucedemo.com/");

        page.fill("#user-name", "standard_user");
        page.fill("#password", "secret_sauce");
        page.click("#login-button");

        boolean isLoggedIn = page.isVisible(".inventory_list");
        assertTrue(isLoggedIn, "Login was not successful!");

        Thread.sleep(2000);

//        context.close();
    }
    @AfterAll
    static void tearDown() {
       browser.close();
       playwright.close();
    }

}
