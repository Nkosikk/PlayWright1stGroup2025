package Base;

import BrowserFactory.PlayWrightBrowserFactory;
import Pages.LoginPage;
import Pages.ProductsPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    PlayWrightBrowserFactory pf;
    protected Page page;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    Properties prop;

    @BeforeTest
    public void setup() {

        pf = new PlayWrightBrowserFactory();
        prop = pf.init_prop(); // Initialize properties if needed
        pf.initBrowser(prop);
        page = pf.getPage();
        loginPage = new LoginPage(page);
        productsPage = new ProductsPage(page);
    }

    @AfterTest
    public void tearDown() {

        pf.closeBrowser(); // Use the factory's close method to clean up
    }
}
