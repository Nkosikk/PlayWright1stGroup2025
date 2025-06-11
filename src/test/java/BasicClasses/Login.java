package BasicClasses;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
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
        browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void tearDown() {
       browser.close();
       playwright.close();
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
        assertTrue(isLoggedIn, "BasicClasses.Login was not successful!");

        Thread.sleep(2000);

        context.close();
    }
}
