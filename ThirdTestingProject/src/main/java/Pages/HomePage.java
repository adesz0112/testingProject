package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;

    private final String errorMessage = "//p[contains(text(), 'Your email or password is incorrect!')]";

    public HomePage(Page page) {
        this.page = page;
    }

    public boolean isErrorMessageDisplayed() {
        return page.locator(errorMessage).isVisible();
    }
}
