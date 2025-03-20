package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SingUpPage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
    public void the_user_selects_country_and_enters_state_and_city(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters zipcode {string} and mobile number {string}")
    public void the_user_enters_zipcode_and_mobile_number(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();

    }
    @When("click on submit button")
    public void click_on_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user is registered")
    public void user_is_registered() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
