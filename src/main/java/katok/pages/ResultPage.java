package katok.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultPage {
    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy(xpath = ".//span[@class[contains(.,'sr-hotel__name')]]")})
    private List<WebElement> hotelsList;

    @FindBy(xpath = ".//a[@data-category=\"review_score_and_price\"]")
    private WebElement ratingButton;

    @FindBy(partialLinkText = "сначала самая")
    private WebElement priceButton;

    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div/div/a/span")
    private WebElement firstHotelInList;

    @FindBy(xpath = ".//div[@class[contains(.,'bui-price-display__value prco-inline-block-maker-helper')]]")
    private WebElement firstHotelPrice;

    @FindAll({
            @FindBy(xpath = "//*[text()[contains(.,'5 звезд')]]")})
    private List<WebElement> fiveStarHotels;

    @FindAll({
            @FindBy(xpath = "//div[contains(@class, 'bui-review-score__badge')]")})
    private List<WebElement> hotelRatingsList;

    private void waitUntillPopUpDisappear(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath(".//div[@class='sr-usp-overlay sr-usp-overlay--wide']"))));
    }

    public boolean isEnoughHotels(int minimumHotelsCount) {
        return hotelsList.size() >= minimumHotelsCount;
    }

    public void sortByRating(WebDriver driver) {
        ratingButton.click();
        waitUntillPopUpDisappear(driver);
    }

    public void sortByPrice(WebDriver driver) {
        priceButton.click();
        waitUntillPopUpDisappear(driver);
    }

    public int getFirstHotelPrice() {
        return Integer.parseInt(firstHotelPrice.getText().replaceAll("\\D", ""));
    }

    public void openFirstHotel() {
        firstHotelInList.click();
    }

    public int getNumberOfFiveStarsHotel() {
        return fiveStarHotels.size();
    }

    public void applyFiveStarsFilter(WebDriver driver) {
        fiveStarHotels.get(0).click();
        waitUntillPopUpDisappear(driver);
    }

    public boolean checkHotelsRating(int numberOfHotels, float rating) {
        if (hotelRatingsList.size() < numberOfHotels) {
            return false;
        }
        for (int i = 0; i <= numberOfHotels - 1; i++) {
            if (Float.parseFloat(hotelRatingsList.get(i).getText().replaceAll(" ", "").replaceAll(",", ".")) < rating) {
                return false;
            }
        }
        return true;
    }

    public void goToTopHotelPage(WebDriver driver) {
        ArrayList<String> handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size() - 1));
    }
}