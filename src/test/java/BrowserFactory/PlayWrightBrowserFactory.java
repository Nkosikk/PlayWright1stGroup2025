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

    public void initBrowser(Properties
                                    prop) {
        String browserName = prop.getProperty("browser").trim();
        Playwright playwright = Playwright.create();



}
