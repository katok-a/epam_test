package katok.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//input[@id='ss']")
    private WebElement searchLine;

    @FindBy(xpath = ".//div[@class='xp__dates-inner xp__dates__checkin']")
    private WebElement datesDialogue;

    @FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button/span[1]")
    private WebElement submitButton;

    @FindBy(xpath = ".//td[@data-date='2019-12-28']")
    WebElement checkInDate;

    @FindBy(xpath = ".//td[@data-date='2019-12-29']")
    WebElement checkOutDate;

    @FindBy(xpath = "//*[@id=\"xp__guests__toggle\"]")
    WebElement accommodationOptions;

    @FindBy(xpath = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/span")
    WebElement numberOfAdults;

    @FindBy(xpath = "//*[@id=\"xp__guests__inputs-container\"]/div/div/div[1]/div/div[2]/button[2]/span")
    WebElement addOneAdultButton;

    public void enterCity(String city) {
        searchLine.clear();
        searchLine.sendKeys(city);
    }

    public void setDates() {
        datesDialogue.click();
        checkInDate.click();
        checkOutDate.click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void openAccommodationOptions(){
        accommodationOptions.click();
    }

    public int getNumberOfAdults(){
        return Integer.parseInt(numberOfAdults.getText());
    }
    public void addOneAdult(){
        addOneAdultButton.click();
    }

//    public void doBasicSetUp(String city) {
//        enterCity(city);
//        setDates();
//        clickSubmit();
//    }
}
