package katok.core.web_driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
    private DriverFactory() {};
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver==null) {
            return new ChromeDriver();
        }
        driver.quit();
        return driver;
    }
}
