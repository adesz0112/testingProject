package StepDefinitions;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ApiRequestStep {

    private APIResponse response;
    private APIRequestContext requestContext;
    private Playwright playwright;


    @Given("The user send GET request to the page {string}")
    public void the_user_send_get_request_to_the_page(String url) {
        playwright = Playwright.create();
        requestContext = playwright.request().newContext();
        response = requestContext.get(url);
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        assertNotNull("Response should not be null", response);
        assertEquals((int) statusCode, response.status());

        // Cleanup
        requestContext.dispose();
        playwright.close();
    }
}
