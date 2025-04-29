package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class LogoutStep {

    private Page page;
    private LoginPage loginPage;
    private HomePage homePage;

    public LogoutStep() {
        this.page = Hooks.page;
        this.loginPage = new LoginPage(page);
        this.homePage = new HomePage(page);
    }

    @Given("The user is logged in to the site {string}")
    public void the_user_is_logged_in_to_the_site(String url) {
        page.navigate(url);
        loginPage.acceptConsent();
    }
    @Given("with valid email {string} and password {string}")
    public void with_valid_email_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }
    @When("The user clicks on the logout button")
    public void the_user_clicks_on_the_logout_button() {
        homePage.clickLogoutButton();
    }
    @Then("The user is navigated to the login page")
    public void the_user_is_navigated_to_the_login_page() {
        String actualUrl = page.url();
        assertEquals(loginPage.getLoginPageURL(), actualUrl);
    }
}
