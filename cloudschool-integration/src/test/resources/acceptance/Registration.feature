Feature: Registration

    Scenario Outline: Registration with valid details
        Given I want to register
        And I enter my firstname '<firstname>'
        And I enter my lastname '<lastname>'
        And I enter my email '<email>'
        And I enter my username '<username>'
        And I enter my password '<password>'
        When I click on signup
        Then I should register myself
        And I should be able to logout after registration

        Examples:
            |firstname  |lastname|email             |username|password      |
            |test       |user    |testuser@email.com|testuser|323test999user|