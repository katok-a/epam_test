@All_Tests
@Cheap_test

Feature: Test is it possible for 4 adults to stay 1 night in Vilnius for less then 100 BYN in total

  Scenario: Check hotel minimum price for 4 adults for one night in Vilnius
    Given I am on https://www.booking.com main page
    When I enter to the searchLine Vilnius name
    When I set dates for the trip
    When I set the number of Adults to 4
    When I click submitButton
    When I sort results by price
    Then I see first hotel price less then 100 BYN


