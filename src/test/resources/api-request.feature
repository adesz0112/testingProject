Feature: API request to the webshop
  Scenario: GET request to the  webshop
    Given The user send GET request to the page "https://automationexercise.com/"
    Then the response status code should be 200


