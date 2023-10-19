package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PropertyHelper;

import java.time.Duration;

public class BasePage extends DriverManager{

    protected static WebDriver driver;
    protected long time;
    {
        try {
            time = Long.parseLong(PropertyHelper.getPropValue("TIMEOUTHANDLER"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToPage(){
        try{
            driver = initialize();
            driver.get(PropertyHelper.getPropValue("URL"));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    protected static WebDriver getDriver(){
        return driver;
    }

    protected void waitThisElement(By locator) {
        WebElement e = driver.findElement(locator);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofMillis(time));
        wait.until(d -> e.isDisplayed());
    }

    protected void clickElement(By locator){
        waitThisElement(locator);
        driver.findElement(locator).click();
    }

    protected void scrollIntoElement(By locator){
        waitThisElement(locator);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollThenClickElement(By locator){
        waitThisElement(locator);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click(true);", element);
    }

    protected void typeIn(By locator, String value){
        waitThisElement(locator);
        driver.findElement(locator).sendKeys(value);
    }

    protected String getTextFromElement(By locator){
        waitThisElement(locator);
        return driver.findElement(locator).getText();
    }

    public static void webdriverQuit(){
        driver.close();
        driver.quit();
    }
}
