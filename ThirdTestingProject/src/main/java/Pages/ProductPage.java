package Pages;

import com.microsoft.playwright.Page;

public class ProductPage {
    private final Page page;

    private final String searchBar= "input[name='search']";
    private final String search = "#submit_search";

    public ProductPage(Page page) {
        this.page = page;
    }

    public void enterProductName(String productName) {
        page.locator(searchBar).fill(productName);
    }

    public void searchForProduct() {
        page.locator(search).click();
    }
}
