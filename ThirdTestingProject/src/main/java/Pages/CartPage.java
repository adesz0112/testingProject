package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CartPage {

    private final Page page;

    public CartPage(Page page) {
        this.page = page;
    }


    public void clickOnRemoveFirstItemFromCart() {
        page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName(""))
                .locator("a").click();
    }

    public boolean isCartEmptyMessageVisible() {
       // return page.locator("#empty_cart").isVisible();
        String text = page.locator("#empty_cart").innerText();
        return text.contains("Cart is empty");
    }
}
