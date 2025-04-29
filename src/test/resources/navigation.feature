Feature: The user can navigate to different pages
  Scenario: The user can navigate to the products page
    Given The user is on the home "https://automationexercise.com/" page
    When The user clicks on the products icon
    Then The user is navigated to the products page

  Scenario: The user can navigate to the cart page
    Given The user is on the home "https://automationexercise.com/" page
    When The user clicks on the cart icon
    Then The user is navigated to the cart page

  Scenario: The user can navigate to the contact page
    Given The user is on the home "https://automationexercise.com/" page
    When The user clicks on the contact icon
    Then The user is navigated to the contact us page