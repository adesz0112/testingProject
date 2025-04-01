Feature: The user can fill out the contact form
Scenario: The user fills out and send a contact form
  Given The user is on the "https://automationexercise.com/contact_us" page
  And The user fills out the form with name "test" and email "test@test.com"
  And The user fills out the subject "test" and writes a message "Testing contact form"
  When The user submit the form
  Then The user gets a message about the successfully sent form
