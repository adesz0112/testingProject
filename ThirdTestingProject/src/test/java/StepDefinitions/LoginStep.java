package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import com.microsoft.playwright.*;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStep {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private LoginPage loginPage;
    private HomePage homePage;

    public LoginStep() {
        this.page = Hooks.page; // ✅ Reuse the same browser session
        this.loginPage = new LoginPage(page);
        this.homePage = new HomePage(page);
    }


    @Given("The user is on the {string} page")
    public void the_user_is_on_the_page(String url) {
       /* playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        page.navigate(url);
        loginPage.acceptConsent(); */
        page.navigate(url);
        loginPage.acceptConsent();
    }

    @Given("The user enters the already registered email {string} and password {string}")
    public void the_user_enters_the_already_registered_email_and_password(String email, String password) {

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Given("The user enters not registered email {string} or password {string}")
    public void the_user_enters_not_registered_email_or_password(String email, String password) {
            loginPage.enterEmail(email);
            loginPage.enterPassword(password);
    }

    @When("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("The user is logged in and can log out")
    public void the_user_is_logged_in_and_can_log_out() {
        // Example verification: Check if the logout button appears
        boolean isLogoutVisible = page.locator("a[href='/logout']").isVisible();
        assertTrue(isLogoutVisible, "Login failed! Logout button not found.");

        // Clean up: Close browser after the test
     /*   browser.close();
        playwright.close(); */
    }

    @Then("The user cannot log in to the page")
    public void the_user_cannot_log_in_to_the_page() {
        assertTrue(homePage.isErrorMessageDisplayed());
    }
}
