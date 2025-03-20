package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;

    private final String errorMessage = "//p[contains(text(), 'Your email or password is incorrect!')]";
    private final String logoutButtonSelector = "//a[@href='/logout' and contains(@style, 'color:brown')]";
    private final String productsIconSelector = "//a[@href='/products']";
    private final String cartIconSelector = "a[href='/view_cart']";
    private final String contactIconSelector = "a[href='/contact_us']";
    private final String productPageUrl = "https://automationexercise.com/products";
    private final String cartPageUrl = "https://automationexercise.com/view_cart";
    private final String contactUSPageUrl = "https://automationexercise.com/contact_us";

    public HomePage(Page page) {
        this.page = page;
    }

    public boolean isErrorMessageDisplayed() {
        return page.locator(errorMessage).isVisible();
    }

    public void clickLogoutButton() {
        page.locator(logoutButtonSelector).click();
    }

    public void clickProductsIconSelector() {
        page.locator(productsIconSelector).click();
    }

    public void clickCartIconSelector() {
        page.locator(cartIconSelector).nth(0).click();
    }

    public void clickContactIconSelector() {
        page.locator(contactIconSelector).click();
    }

    public String getProductPageUrl() {
        return productPageUrl;
    }

    public String getCartPageUrl() {
        return cartPageUrl;
    }

    public String getContactPageUrl() {
        return contactUSPageUrl;
    }
}
