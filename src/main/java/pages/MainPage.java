package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PropertyHelper;

public class MainPage extends BasePage {

    public MainPage(){
        this.driver = getDriver();
    }

    protected WebDriver driver;
    protected By tradingPlatformLink = By.cssSelector(".footer-menu-col a[aria-label=\"Platform\"]");
    protected By acceptCookies = By.cssSelector(".modal-footer a");

    protected long time;
    {
        try {
            time = Long.parseLong(PropertyHelper.getPropValue("TIMEOUTHANDLER"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void acceptModalCookies(){
        clickElement(acceptCookies);
    }

    public void clickTradingPlatformLink(){
        this.acceptModalCookies();
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scrollThenClickElement(tradingPlatformLink);
    }

    public String getTitle(){
        return getDriver().getTitle();
    }

}
