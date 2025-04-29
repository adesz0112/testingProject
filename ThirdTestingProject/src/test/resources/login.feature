Feature: User can login
  Scenario: User can login with already registered credentials
    Given The user is on the "https://automationexercise.com/login" page
    And The user enters the already registered email "test@ter5rt.com" and password "test"
    When The user clicks on the login button
    Then The user is logged in and can log out

  Scenario Outline: User cannot login with invalid credentials
    Given The user is on the "https://automationexercise.com/login" page
    And The user enters not registered email "<email>" or password "<password>"
    When The user clicks on the login button
    Then The user won't be logged into the site

    Examples:
      | email              | password   |
      | test@ter5rt.com    | wrongpass1 |
      | test@ter5rt.com    | teest      |
      | test@ter5rt.com    | *****      |
      | test@ter5rt.com    | -----      |
      | invalid3@test.com  | test       |
      | invalid4@test.com  | test       |
      | invalid4@test.com  | test       |
      |                    | test       |
      |    ---@.com        | test       |
      | test@ter5rt.com    |            |
      | test@ter5rt.com    | ****       |
      | test@ter5rt.com    |  122222    |
      | ****@******.com    |  test      |



