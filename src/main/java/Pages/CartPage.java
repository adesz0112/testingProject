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


    public void clickOnTheProceedToCheckout() {
        page.getByText("Proceed To Checkout").click();
    }

    public void clickOnPlaceOrderButton() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Place Order")).click();
    }

    public void fillCreditCardNumber(String number) {
        page.locator("input[name=\"card_number\"]").fill(number);
    }

    public void fillCreditCardHolderName(String holderName) {
        page.locator("input[name=\"name_on_card\"]").fill(holderName);
    }

    public void fillCreditCardCvv(String cvv) {
        page.getByPlaceholder("ex.").fill(cvv);
    }

    public void fillCreditCardExpiryDate(String expiryMonth, String expiryYear) {
        page.getByPlaceholder("MM").fill(expiryMonth);
        page.getByPlaceholder("YYYY").fill(expiryYear);
    }

    public void confirmOrder() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Pay and Confirm Order")).click();
    }

    public boolean isOrderValidationVisible() {
        return page.getByText("Congratulations! Your order").isVisible();
    }



}
