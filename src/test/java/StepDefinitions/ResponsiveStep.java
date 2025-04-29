package StepDefinitions;

import Pages.HomePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;

public class ResponsiveStep {

    private Page page;
    private HomePage homePage;

    public ResponsiveStep() {
        this.page = Hooks.page;
        this.homePage = new HomePage(page);
    }

    @When("The user sets the screen {string} to {string} and {string}")
    public void the_user_sets_the_screen_to_and(String size, String width, String length) {
        int widthInPixels = Integer.parseInt(width);
        int heightInPixels = Integer.parseInt(length);
        page.setViewportSize(widthInPixels,heightInPixels);
    }
    @When("The user clicks on the products button")
    public void the_user_clicks_on_the_products_button() {
       homePage.clickProductsIconSelector();
    }
}
