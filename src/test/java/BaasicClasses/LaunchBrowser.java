package BaasicClasses;

import com.microsoft.playwright.*;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://www.saucedemo.com/");

            page.fill("#user-name", "standard_user");


            page.fill("#password", "secret_sauce");

            Thread.sleep(5000);

            page.click("#login-button");


            Thread.sleep(5000);



        }
    }


}