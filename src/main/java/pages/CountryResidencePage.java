package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.HelperClass;

public class CountryResidencePage extends BasePage {
    public CountryResidencePage(String windowHandle){
        this.driver = getDriver();
        this.currentWindow = windowHandle;
    }

    protected WebDriver driver;
    protected String currentWindow;
    protected By countrySelector = By.cssSelector(".country-selector span[data-selector-id=\"desktop_country_selector\"]");
    protected By continueBtn = By.cssSelector(".question-footer span[data-translate=\"continue\"]");
    protected By pageTitle = By.cssSelector(".question-header h3");

    protected By getCountryElement(String cor) {
        return By.xpath("//div[@data-text=\"" + cor + "\"][2]");
    }

    public void selectCountryOfResidence(String cor){
        clickElement(countrySelector);
        typeIn(countrySelector,cor);
        clickElement(getCountryElement(cor));
        clickElement(continueBtn);
    }

    protected void switchWindow(){
        for (String windowHandle : driver.getWindowHandles()) {
            if(!currentWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                HelperClass.sleep();
                break;
            }
        }
    }

    public String getTitle(){
        this.switchWindow();
        return getDriver().getTitle();
    }

    public String getPageHeader(){
        return getTextFromElement(pageTitle);
    }
}
