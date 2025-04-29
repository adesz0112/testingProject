package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationStep {

    private Page page;
    private HomePage homePage;
    private LoginPage loginPage;

    public NavigationStep() {
        this.page = Hooks.page;
        this.homePage = new HomePage(page);
        this.loginPage = new LoginPage(page);
    }

    @Given("The user is on the home {string} page")
    public void the_user_is_on_the_home_page(String url) {
        page.navigate(url);
        loginPage.acceptConsent();
    }

    @When("The user clicks on the products icon")
    public void the_user_clicks_on_the_products_icon() {
        homePage.clickProductsIconSelector();
    }

    @When("The user clicks on the cart icon")
    public void the_user_clicks_on_the_cart_icon() {
        homePage.clickCartIconSelector();
    }

    @When("The user clicks on the contact icon")
    public void the_user_clicks_on_the_contact_icon() {
        homePage.clickContactIconSelector();
    }


    @Then("The user is navigated to the products page")
    public void the_user_is_navigated_to_the_products_page() {
        String actualUrl = page.url();
        assertEquals(homePage.getProductPageUrl(),actualUrl);
    }

    @Then("The user is navigated to the cart page")
    public void the_user_is_navigated_to_the_cart_page() {
       String actualUrl = page.url();
       assertEquals(homePage.getCartPageUrl(),actualUrl);
    }

    @Then("The user is navigated to the contact us page")
    public void the_user_is_navigated_to_the_contact_us_page() {
        String actualUrl = page.url();
        assertEquals(homePage.getContactPageUrl(),actualUrl);
    }
}
