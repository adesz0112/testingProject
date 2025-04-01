package StepDefinitions;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;

    @Before
    public void setUp() {
        playwright = Playwright.create();

        //browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // Change to true for headless mode
        page = browser.newPage();
    }

    @After
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}

