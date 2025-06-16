Feature: Travel and Hospitality Industry Page

  Background:
    Given Publicis Sapient mainpage is opened
    When I navigate to the Travel and Hospitality industry page

  Scenario: Verify headers on the Travel and Hospitality page
    When Scroll to travelSectors
    Then I should see the following headers: