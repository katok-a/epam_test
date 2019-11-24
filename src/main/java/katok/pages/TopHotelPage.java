package katok.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopHotelPage {

    public TopHotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(.//div[@class='bui-review-score__badge'])[1]")
    private WebElement rating;

//    @FindBy(className = "bk-icon -iconset-wifi hp__important_facility_icon")
//    private WebElement WiFiInDOM;

    @FindAll({
            @FindBy(xpath = "//*[text()[contains(.,'Бесплатный Wi-Fi')]]")})
    private List<WebElement> WiFiInDOM;

    public double getRating(WebDriver driver) {
        return Double.parseDouble(rating.getText().trim());
    }

    public boolean isWiFiOnDOM() {
        return !WiFiInDOM.isEmpty();
    }
}
