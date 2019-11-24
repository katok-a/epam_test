@All_Tests
@Euro_Test

Feature: Test is it the Hotel in the City for less then 20 Euro

  Scenario: Check is it hotel in Vilnius for less then 20 Euro
    Given I am on https://www.booking.com main page
    When I enter to the searchLine Vilnius name
    When I set dates for the trip
    When I click submitButton
    When I sort results by price
    Then I see cheapest hotel price less then 20 EUR


