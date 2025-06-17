@api
Feature: User API testing

  Background:
    Given I have a valid GoRest bearer token

  Scenario: Create a new user
    Given I load payload from file
    When I send a POST request to "/public/v2/users"
    Then the response code should be 201
    And verify the response