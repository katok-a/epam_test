@All_Tests
@WiFi_test

Feature: Test is it free Wi-Fi in cheapest Hotel in Vilnius

  Scenario: Find cheapest hotel in Vilnius any check it for free WiFi
    Given I am on https://www.booking.com main page
    When I enter to the searchLine Vilnius name
    When I set dates for the trip
    When I click submitButton
    When I sort results by price
    When I open first hotel in list page
    Then I see there is Free WiFi in the Hotel


