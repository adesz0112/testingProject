package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;

    private final String errorMessage = "//p[contains(text(), 'Your email or password is incorrect!')]";
    private final String logoutButtonSelector = "//a[@href='/logout' and contains(@style, 'color:brown')]";

    public HomePage(Page page) {
        this.page = page;
    }

    public boolean isErrorMessageDisplayed() {
        return page.locator(errorMessage).isVisible();
    }

    public void clickLogoutButton() {
        page.locator(logoutButtonSelector).click();
    }
}
