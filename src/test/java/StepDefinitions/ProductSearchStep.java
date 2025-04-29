package StepDefinitions;

import Pages.ProductPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchStep {

    private Page page;
    private ProductPage productPage;

    public ProductSearchStep() {
        this.page = Hooks.page;
        this.productPage = new ProductPage(page);
    }

    @When("The user search for some {string} product")
    public void the_user_search_for_some_product(String product) {
        productPage.enterProductName(product);
        productPage.searchForProduct();
    }
    @Then("The products {string} are listed")
    public void the_products_are_listed(String product) {
        String currentUrl = page.url();
        assert currentUrl.contains(product);
    }
}
