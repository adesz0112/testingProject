package StepDefinitions;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCartStep {

    private Page page;
    private ProductPage productPage;
    private HomePage homePage;
    private CartPage cartPage;

    public AddToCartStep() {
        this.page = Hooks.page;
        this.productPage = new ProductPage(page);
        this.homePage = new HomePage(page);
        this.cartPage = new CartPage(page);
    }

    @When("The user add a product to the cart")
    public void the_user_add_a_product_to_the_cart() {
        productPage.clickFirstProduct();
        productPage.addFirstProductToCart();
        page.waitForTimeout(1000);

    }

    @When("The user removes the product from the cart")
    public void the_user_removes_the_product_from_the_cart() {
       productPage.clickContinueShopping();
       homePage.clickOnCartPage();
       cartPage.clickOnRemoveFirstItemFromCart();
    }
    @Then("The cart is empty")
    public void the_cart_is_empty() {
        //page.pause();
        Locator emptyCart = page.locator("#empty_cart");
        System.out.println("Cart message: " + emptyCart.textContent());
        System.out.println("Visible: " + page.locator("#empty_cart").isVisible());
        System.out.println("Hidden: " + page.locator("#empty_cart").evaluate("e => window.getComputedStyle(e).display"));
        assertTrue(cartPage.isCartEmptyMessageVisible());
    }


    @Then("The product is in the cart")
    public void the_product_is_in_the_cart() {
        assertTrue(productPage.isProductAddedToCartMessageVisible());
    }


}
