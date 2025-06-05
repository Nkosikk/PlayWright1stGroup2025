import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

        Thread.sleep(5000);

        context.close();
    }
}
