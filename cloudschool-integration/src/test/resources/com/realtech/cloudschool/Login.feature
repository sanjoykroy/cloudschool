Feature: Login to Cloud School

Scenario Outline: Login with right credentials
    Given I am in login page
    And I enter username <username>
    And I enter password <password>
    When I click on login
    Then I should be able to login

    Examples:
    |username|password|
    |sanjoy  |sanjoy  |