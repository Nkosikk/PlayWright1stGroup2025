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
                browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(prop.getProperty("headless"))));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "chrome":
                browser = playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browserName);

        }

        browserContext = browser.newContext();
        page = browser.newContext().newPage();
        page.navigate(prop.getProperty("dev_url").trim());

    }

    public Page getPage() {
        return page;
    }

    public void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
    }

    public Properties init_prop() {
            try {
                prop.load(getClass().getClassLoader().getResourceAsStream("src/test/resources/configs/config.properties"));
                prop= new Properties();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return prop;

        }

}
