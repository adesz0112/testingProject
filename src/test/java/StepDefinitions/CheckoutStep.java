package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutStep {

    private Page page;
    private HomePage homePage;
    private CartPage cartPage;

    public CheckoutStep() {
        this.page = Hooks.page;
        this.homePage = new HomePage(page);
        this.cartPage = new CartPage(page);
    }


    @When("The user clicks on the checkout")
    public void the_user_clicks_on_the_checkout() {
        homePage.navigateToCartPage();
        page.pause();
        cartPage.clickOnTheProceedToCheckout();

    }

    @Then("The user can checkout without registration")
    public void the_user_can_checkout_without_registration() {
        String actualUrl = page.url();
        assertEquals(homePage.getCheckOutPageUrl(), actualUrl);
    }
}
