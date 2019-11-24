@All_Tests
@FiveStarHotel_Test

Feature: Test that there is no 5-stars hotels in the City

  Scenario: Confirm that it is not possible to find 5-stars hotels in Molodechno
    Given I am on https://www.booking.com main page
    When I enter to the searchLine Molodechno name
    When I set dates for the trip
    When I click submitButton
    Then There is no 5-star hotels at result page


