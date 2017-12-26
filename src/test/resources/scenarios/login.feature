Feature: Login Page Tests

  Scenario: Login page validations
    Given I am on the login page
    When I view login form
    Then The required fields are displayed

  Scenario: Verify successful login
    Given I am on the login page
    When I fill the login form and submit
    Then The page is displayed

  Scenario: Validate dashboard page
    Given I am on the dashboard page
    When I view welcome message
    Then Username is displayed

