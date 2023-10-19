package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    WebDriver driver = null;

    public WebDriver initialize() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-gpu");
            driver = new ChromeDriver(chromeOptions);
        return driver;
    }
}
