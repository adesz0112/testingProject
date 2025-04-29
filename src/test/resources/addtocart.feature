Feature: The user can add products to the cart
  Scenario: The user can add a single product to the cart
    Given The user is on the "https://automationexercise.com/products" page
    When The user add a product to the cart
    Then The product is in the cart

    Scenario: The user can remove product from the cart
      Given The user is on the "https://automationexercise.com/products" page
      And The user add a product to the cart
      When The user removes the product from the cart
      Then The cart is empty