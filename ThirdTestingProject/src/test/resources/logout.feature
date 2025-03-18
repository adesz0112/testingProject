Feature: The user can logout from the page
  Scenario: User is logged in the site and can logout
    Given The user is logged in to the site "https://automationexercise.com/login"
    And with valid email "test@ter5rt.com" and password "test"
    When The user clicks on the logout button
    Then The user is navigated to the login page