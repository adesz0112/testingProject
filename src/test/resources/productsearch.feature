Feature: The user can search in the products page
  Scenario: The user can search tops in the products page
    Given The user is on the "https://automationexercise.com/products" page
    When The user search for some "top" product
    Then  The products "top" are listed