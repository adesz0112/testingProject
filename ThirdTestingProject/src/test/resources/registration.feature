Feature: Sample Test
  Scenario: Simple scenario
    Given The user is on the "https://automationexercise.com/login" page
    And the user enter valid "test2" username and valid "test@ter8rt.com" email
    When the user enters password "password" and chooses gender
    And the user selects day "12", month "May", and year "1988"
    And the user enters firstname "John", lastname "Doe"
    And the user enters address "Test street 6", and address2 "Test"
    And the user selects country  "Canada", and enters state "Test", and city "Toronto"
    And the user enters zipcode "60000" and mobile number "00250055"
    And click on submit button
    Then user is registered

    Scenario: Register with registered email address
      Given The user is on the "https://automationexercise.com/login" page
      And the user enter registered "test2" username and registered "test@ter5rt.com" email
      When The user clicks on the Sign-up button
      Then The user gets a warning message that this email is already registered


