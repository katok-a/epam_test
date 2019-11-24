@All_Tests
@Rating_test

Feature: Test is it hotel in Vilnius with 9+ rating

  Scenario: Check rating of top rated hotel
    Given I am on https://www.booking.com main page
    When I enter to the searchLine Vilnius name
    When I set dates for the trip
    When I click submitButton
    When I sort results by rating
    Then I see first hotel rating greater then 9


#    -Первый 5 отелей с 5 звездами имеют рейтинг не ниже....




