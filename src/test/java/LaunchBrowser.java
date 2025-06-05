import com.microsoft.playwright.*;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://www.saucedemo.com/");

            page.fill("#user-name", "standard_user");

            Thread.sleep(5000);




        }
    }


}
