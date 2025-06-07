import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class LoginPractise {


    private static Playwright playwright;
    private static Browser browser;

    @BeforeAll
    public static void setup(){

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }
   @AfterAll
    public static void   teardown(){
        browser.close();
        playwright.close();
   }
}
