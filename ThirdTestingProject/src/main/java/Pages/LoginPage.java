package Pages;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final String loginPageURL = "https://automationexercise.com/login";

    private final String loginButtonSelector = "button[data-qa='login-button']";
    private final String loginEmailSelector = "input[data-qa='login-email']";
    private final String loginPasswordSelector = "input[data-qa='login-password']";
    private final String consentButtonXPath = "//p[contains(@class, 'fc-button-label') and text()='Beleegyezés']";
    private final String singUpButton = "button[data-qa='signup-button']";
    private final String userNameField= "input[data-qa='signup-name']";
    private final String singUpEmailField = "input[data-qa='signup-email']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLoginPage() {
        page.navigate(loginPageURL);
    }

    public void enterEmail(String email) {
        page.locator(loginEmailSelector).fill(email);
    }

    public void enterPassword(String password) {
        page.locator(loginPasswordSelector).fill(password);
    }

    public void clickLoginButton() {
        page.locator(loginButtonSelector).click();
    }

    public void acceptConsent() {
        page.locator(consentButtonXPath).click();
    }

    public String getLoginPageURL() {
        return loginPageURL;
    }

    public void clickSignUpButton() {
        page.locator(singUpButton).click();
    }

    public void enterUserName(String userName) {
        page.locator(userNameField).fill(userName);
    }

    public void enterSingUpEmail(String singUpEmail) {
        page.locator(singUpEmailField).fill(singUpEmail);
    }
}
