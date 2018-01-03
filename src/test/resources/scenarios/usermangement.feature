Feature: User Management page features

  Background:
    Given Load TestCases for "usermanagement"
    Given I am already logged in

  @usermanagement
  Scenario: Check for Add button functionality
    Given I am on the "usermanagement" page
    When I select Admin -> User Management -> Users -> Add for "Verify user add button"
    Then "Add button" web element is displayed for "Verify user add button"