package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ContactPage {
    private final Page page;

    private final String nameField = "input[data-qa='name']";
    private final String emailField = "input[data-qa='email']";
    private final String subjectField = "input[data-qa='subject']";
    private final String messageField = "textarea[data-qa='message']";
    private final String submitButton = "input[data-qa='submit-button']";
    private final String successMessage = "div.status.alert.alert-success";


    public ContactPage(Page page) {
        this.page = page;
    }

    public void enterName(String name) {
        page.locator(nameField).fill(name);
    }

    public void enterEmail(String email) {
        page.locator(emailField).fill(email);
    }

    public void enterSubject(String subject) {
        page.locator(subjectField).fill(subject);
    }

    public void enterMessage(String message) {
        page.locator(messageField).fill(message);
    }

    public void clickSubmit() {
        page.locator(submitButton).scrollIntoViewIfNeeded();
        page.locator("input[data-qa='submit-button']").click(new Locator.ClickOptions().setForce(true));
    }

    public boolean isSuccessMessageVisible() {
        page.locator(successMessage).scrollIntoViewIfNeeded();
        return  page.locator(successMessage).isVisible();
    }

}
