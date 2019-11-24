package katok.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import katok.core.apiDataMiner.ExchangeRateMiner;
import katok.core.web_driver.DriverFactory;
import katok.pages.HomePage;
import katok.pages.ResultPage;
import katok.pages.TopHotelPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class bookingSteps {
    private WebDriver driver = DriverFactory.getDriver();
    private HomePage homepage = new HomePage(driver);
    private ResultPage resultPage = new ResultPage(driver);
    private TopHotelPage topHotelPage = new TopHotelPage(driver);

    //    @Before
//    public void setUpDriver(){
//       driver = DriverFactory.getDriver();
//    }
    @After
    public void tearUpDriver() {
        //driver.quit();
    }

    @Given("^I am on (.+) main page$")
    public void loadBookingHomePage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("^I enter to the searchLine (.+) name$")
    public void enterCityName(String city) {
        homepage.enterCity(city);
    }

    @When("^I set dates for the trip$")
    public void entedDates() {
        homepage.setDates();
    }

    @When("I set the number of Adults to (\\d+)$")
    public void setNumberOfAdults(int numberOfAdults) {
        homepage.openAccommodationOptions();
        while (homepage.getNumberOfAdults() < numberOfAdults) {
            homepage.addOneAdult();
        }
    }

    @When("I sort results by price")
    public void sortByPrice() {
        resultPage.sortByPrice(driver);
    }

    @When("^I click submitButton$")
    public void clickSubmit() {
        homepage.clickSubmit();
    }

    @When("^I sort results by rating$")
    public void sortByRating() {
        resultPage.sortByRating(driver);
    }

    @When("^I open first hotel in list page$")
    public void openTopHotel() {
        resultPage.openFirstHotel();
        resultPage.goToTopHotelPage(driver);
    }

    @When("^I choose 5 star hotel only$")
    public void applyFiveStarFilter() {
        resultPage.applyFiveStarsFilter(driver);
    }

    @Then("^I see page with search results>=(\\d+)$")
    public void checkResults(int minimumHotelsCount) {
        Assert.assertTrue(resultPage.isEnoughHotels(minimumHotelsCount));
    }

    @Then("^I see first hotel price less then (\\d+) BYN$")
    public void checkPrice(int maximumPrice) {
        Assert.assertTrue(resultPage.getFirstHotelPrice() <= maximumPrice);
    }

    @Then("^I see first hotel rating greater then (\\d+)$")
    public void isRatingHigher(float rating) {
        Assert.assertTrue(resultPage.checkHotelsRating(1, rating));
    }

    @Then("I see there is Free WiFi in the Hotel")
    public void checkFreeWiFi() {
        Assert.assertTrue(topHotelPage.isWiFiOnDOM());
    }

    @Then("There is no 5-star hotels at result page")
    public void comfirAbsenceOfFiveStarHotel() {
        Assert.assertTrue(resultPage.getNumberOfFiveStarsHotel() < 1);
    }

    @Then("I see first (\\d+) hotel have rating greater then (\\d+)")
    public void checkFirstHotelsRating(int numberOfHotels, float rating) {
        Assert.assertTrue(resultPage.checkHotelsRating(numberOfHotels, rating));
    }

    @Then("I see cheapest hotel price less then (\\d+) (.\\w*)")
    public void checkCheapHotelInEuro(float maximumPrice, String currency) {
        Assert.assertTrue(resultPage.getFirstHotelPrice() / ExchangeRateMiner.getExchangeRateForCurrency(currency) <= maximumPrice);
    }
}
