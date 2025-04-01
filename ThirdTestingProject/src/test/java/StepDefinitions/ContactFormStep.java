package StepDefinitions;

import Pages.ContactPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactFormStep {

    private Page page;
    private ContactPage contactPage;

    public ContactFormStep() {
        this.page = Hooks.page;
        this.contactPage = new ContactPage(page);
    }

    @Given("The user fills out the form with name {string} and email {string}")
    public void the_user_fills_out_the_form_with_name_and_email(String name, String email) {
       contactPage.enterName(name);
       contactPage.enterEmail(email);
    }
    @Given("The user fills out the subject {string} and writes a message {string}")
    public void the_user_fills_out_the_subject_and_writes_a_message(String subject, String message) {
        contactPage.enterSubject(subject);
        contactPage.enterMessage(message);
    }

    @When("The user submit the form")
    public void the_user_submit_the_form() {
        System.out.println("Is Submit Button Visible? " + page.locator("input[data-qa='submit-button']").isVisible());
        System.out.println("Is Submit Button Enabled? " + page.locator("input[data-qa='submit-button']").isEnabled());
        page.evaluate("document.querySelector(\"input[data-qa='submit-button']\").scrollIntoView()");
        int count = page.locator("input[data-qa='submit-button']").count();
        System.out.println("Number of submit buttons found: " + count);
        page.locator("input[data-qa='submit-button']").click(new Locator.ClickOptions().setForce(true));
    }
    @Then("The user gets a message about the successfully sent form")
    public void the_user_gets_a_message_about_the_successfully_sent_form() {
        assertTrue(contactPage.isSuccessMessageVisible(), "Success message should be visible, but it is not!");
    }
    }
