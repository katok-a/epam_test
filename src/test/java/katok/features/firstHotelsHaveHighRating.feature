@All_Tests
@FirstHotelsRating_Test

Feature: Test if first 5 hotels with 5 stars in the City have high rating

  Scenario: Check if first 5 hotel with 5 start in Vilnius have rating grater than 9
    Given I am on https://www.booking.com main page
    When I enter to the searchLine Vilnius name
    When I set dates for the trip
    When I click submitButton
    When I sort results by rating
    When I choose 5 star hotel only
    Then I see first 5 hotel have rating greater then 9


