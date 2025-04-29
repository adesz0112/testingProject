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
        cartPage.clickOnTheProceedToCheckout();

    }

    @When("The user fills out the card payment form")
    public void the_user_fills_out_the_card_payment_form() {
            cartPage.clickOnPlaceOrderButton();
            cartPage.fillCreditCardHolderName("test");
            cartPage.fillCreditCardNumber("1234567890");
            cartPage.fillCreditCardCvv("222");
            cartPage.fillCreditCardExpiryDate("04","2026");
            cartPage.confirmOrder();
    }
    @Then("The user get a confirmation about the order")
    public void the_user_get_a_confirmation_about_the_order() {
        assertTrue(cartPage.isOrderValidationVisible());
    }

    @Then("The user can checkout without registration")
    public void the_user_can_checkout_without_registration() {
        String actualUrl = page.url();
        System.out.println(actualUrl);
        assertEquals(homePage.getCheckOutPageUrl(), actualUrl);
    }
}
