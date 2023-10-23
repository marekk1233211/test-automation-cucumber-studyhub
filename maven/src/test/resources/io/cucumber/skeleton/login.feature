Feature: Login
  Scenario: Correct Credentials
    Given I open browser
    And I go to login page
    When I type "Marek@gmail.com" as login
    And I type "Marek123" as password
    And I click login button
    Then I am logged in

  Scenario: Incorrect Credentials
    Given I open browser
    And I go to login page
    When I type "Marek@gmail.com" as login
    And I type "incorrectPassword" as password
    And I click login button
    Then I am NOT logged in