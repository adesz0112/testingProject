package Pages;

import com.microsoft.playwright.Page;

public class SingUpPage {

    private final Page page;

    private final String selectGender = "input[id='id_gender1']";
    private final String passwordField = "input[data-qa='password']";
    private final String selectDays = "select[data-qa='days']";
    private final String selectMonths = "select[data-qa='months']";
    private final String selectYears = "select[data-qa='years']";
    private final String firstNameField = "input[data-qa='first_name']";
    private final String lastNameField = "input[data-qa='last_name']";
    private final String companyField = "input[data-qa='company']";
    private final String addressField = "input[data-qa='address']";
    private final String address2Field = "input[data-qa='address2']";
    private final String selectCountry = "select[data-qa='country']";
    private final String stateField = "input[data-qa='state']";
    private final String cityField = "input[data-qa='city']";
    private final String zipField = "input[data-qa='zipcode']";
    private final String mobileNumberField = "input[data-qa='mobile_number']";
    private final String createAccountButton = "button[data-qa='create-account']";
    private final String emailExistsError = "p[style='color: red;']";


    public SingUpPage(Page page) {
        this.page = page;
    }

    public void selectGender() {
        page.locator(selectGender).check(); // Selects the radio button
    }

    public void enterPassword(String password) {
        page.locator(passwordField).fill(password);
    }

    public void selectDays(String days) {
        page.selectOption(selectDays, days);
    }

    public void selectMonths(String months) {
        page.selectOption(selectMonths, months);
    }

    public void selectYears(String years) {

        page.selectOption(selectYears, years);
    }

    /*public void scrollToElement(String selector) {
        page.evaluate("element => element.scrollIntoView({behavior: 'smooth', block: 'center'})",
                page.locator(selector).elementHandle());
    }
*/
    public void enterFirstName(String firstName) {
       page.locator(firstNameField).scrollIntoViewIfNeeded();
        page.locator(firstNameField).fill(firstName);
    }

    public void enterLastName(String lastName) {
        page.locator(lastNameField).fill(lastName);
    }

    public void enterCompany(String company) {
        page.locator(companyField).fill(company);
    }

    public void enterAddress(String address) {
        page.locator(addressField).fill(address);
    }

    public void enterAddress2(String address2) {
        page.locator(address2Field).fill(address2);
    }

    public void enterCountry(String country) {
        page.selectOption(selectCountry,country);
    }

    public void enterState(String state) {
        page.locator(stateField).fill(state);
    }

    public void enterCity(String city) {
        page.locator(cityField).fill(city);
    }

    public void enterZipCode(String zipCode) {
        page.locator(zipField).fill(zipCode);
    }

    public void enterMobileNumber(String mobileNumber) {
        page.locator(mobileNumberField).fill(mobileNumber);
    }

    public void clickCreateAccountButton() {
        page.locator(createAccountButton).click();
    }

    public boolean isAlreadyExistingEmailErrorVisible() {
        return page.locator(emailExistsError).isVisible();
    }

}
