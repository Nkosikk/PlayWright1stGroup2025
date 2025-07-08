package BrowserFactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.Properties;

public class PlayWrightBrowserFactory {

    private BrowserContext browserContext;
    private Page page;
    Browser browser;
    Properties prop;

    public void initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        Playwright playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch();
                break;
            case "chrome":
                browser = playwright.chromium().launch();
                break;
            case "firefox":
                browser = playwright.firefox().launch();
                break;
            case "webkit":
                browser = playwright.webkit().launch();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        browserContext = browser.newContext();//creating a new browse context
        page = browserContext.newPage();//creating a new page(the browsercontext has new page)
      page.navigate(prop.getProperty("url").trim());
    }
}
