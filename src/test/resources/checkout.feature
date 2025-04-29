Feature: The user can checkout without registration
  Scenario: The user can checkout without registration
    Given The user is on the "https://automationexercise.com/products" page
    And The user add a product to the cart
    When The user clicks on the checkout
    Then The user can checkout without registration


    Scenario: The user can checkout with registration
      Given The user is on the "https://automationexercise.com/login" page
      And The user enters the already registered email "test@ter5rt.com" and password "test"
      And The user clicks on the login button
      And The user is on the "https://automationexercise.com/products" page
      And The user add a product to the cart
      When The user clicks on the checkout
      When The user fills out the card payment form
      Then The user get a confirmation about the order
