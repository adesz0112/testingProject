package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SingUpPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationStep {

    private Page page;
    private LoginPage loginPage;
    private HomePage homePage;
    private SingUpPage singUpPage;

    public RegistrationStep() {
        this.page = Hooks.page;
        this.loginPage = new LoginPage(page);
        this.homePage = new HomePage(page);
        this.singUpPage = new SingUpPage(page);
    }

    @Given("the user enter valid {string} username and valid {string} email")
    public void the_user_enter_valid_username_and_valid_email(String username, String email) {
        loginPage.enterUserName(username);
        loginPage.enterSingUpEmail(email);
        loginPage.clickSignUpButton();
    }


    @Given("the user enter registered {string} username and registered {string} email")
    public void the_user_enter_registered_username_and_registered_email(String username, String email) {
        loginPage.enterUserName(username);
        loginPage.enterSingUpEmail(email);
    }
    @When("The user clicks on the Sign-up button")
    public void the_user_clicks_on_the_sign_up_button() {
        loginPage.clickSignUpButton();
    }

    @When("the user enters password {string} and chooses gender")
    public void the_user_enters_password_and_chooses_gender(String password) {
        singUpPage.enterPassword(password);
        singUpPage.selectGender();
    }

    @When("the user selects day {string}, month {string}, and year {string}")
    public void the_user_selects_day_month_and_year(String day, String month, String year) {
       singUpPage.selectDays(day);
       singUpPage.selectMonths(month);
       singUpPage.selectYears(year);
    }

    @When("the user enters firstname {string}, lastname {string}")
    public void the_user_enters_firstname_lastname(String firstName, String lastName) {
       singUpPage.enterFirstName(firstName);
       singUpPage.enterLastName(lastName);
    }

    @When("the user enters address {string}, and address2 {string}")
    public void the_user_enters_address_and_address2(String address, String address2) {
        singUpPage.enterAddress(address);
        singUpPage.enterAddress2(address2);
    }

    @When("the user selects country  {string}, and enters state {string}, and city {string}")
    public void the_user_selects_country_and_enters_state_and_city(String country, String state, String city) {
        singUpPage.enterCountry(country);
        singUpPage.enterState(state);
        singUpPage.enterCity(city);
    }

    @When("the user enters zipcode {string} and mobile number {string}")
    public void the_user_enters_zipcode_and_mobile_number(String zipcode, String mobileNumber) {
        singUpPage.enterZipCode(zipcode);
        singUpPage.enterMobileNumber(mobileNumber);

    }
    @When("click on submit button")
    public void click_on_submit_button() {
        singUpPage.clickCreateAccountButton();
    }
    @Then("user is registered")
    public void user_is_registered() {
        String actualUrl = page.url();
        assertEquals("https://automationexercise.com/account_created",actualUrl);
        homePage.clickOnContinueAfterSignUp();
        homePage.deleteAccount();
    }

    @Then("The user gets a warning message that this email is already registered")
    public void the_user_gets_a_warning_message_that_this_email_is_already_registered() {
        assertTrue(singUpPage.isAlreadyExistingEmailErrorVisible());

    }
}
