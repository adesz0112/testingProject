Feature: The user like to use the page in tablet or phone view

  Scenario Outline: The user can navigate to the products page on desktop view
    Given The user is on the "https://automationexercise.com/login" page
    When The user sets the screen "<size>" to "<width>" and "<height>"
    And The user clicks on the products button
    Then The user is navigated to the products page
    Examples:
      | size   | width | height |
      | desktop| 1920  | 1080   |
      | tablet | 768   | 1024   |
      |  phone | 375   | 812    |

