package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductPage {
    private final Page page;

    private final String searchBar= "input[name='search']";
    private final String search = "#submit_search";
    private final String firstProduct = "a[href='/product_details/1']";
    private final String addFirstProductToCart = "button[button.btn-default.cart]";
    private final String productAddedToCartMessage = "tr#product-1";

    public ProductPage(Page page) {
        this.page = page;
    }

    public void enterProductName(String productName) {
        page.locator(searchBar).fill(productName);
    }

    public void searchForProduct() {
        page.locator(search).click();
    }

    public void clickFirstProduct() {
        page.locator(firstProduct).click();
    }

    public void addFirstProductToCart() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add to cart"))
                .click();
    }

    public boolean isProductAddedToCartMessageVisible() {
        page.locator(".modal-content").waitFor();
        return  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue Shopping")).isVisible();
    }

    public void clickContinueShopping() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue Shopping")).click();
    }



}
