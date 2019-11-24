@All_Tests
@IsHotelsTest

Feature: Test is hotel in Moscow for given dates

  Scenario: Check hotel availability in Moscow for given dates
    Given I am on https://www.booking.com main page
    When I enter to the searchLine Moscow name
    When I set dates for the trip
    When I click submitButton
    Then I see page with search results>=1


