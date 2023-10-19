package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.HelperClass;

public class TradingExperience extends BasePage {
    public TradingExperience(){
        this.driver = getDriver();
    }

    protected WebDriver driver;

    protected By option3 = By.xpath("//input[@aria-label=\"Worked in the Financial Industry\"]/parent::*");
    protected By changeLangauge = By.cssSelector("div[data-company=\"1\"] button:nth-child(1)");
    protected By languageFrancais = By.cssSelector("div[class=\"languages show\"] div[data-language=\"fr\"]");
    protected By optionDaily = By.xpath("//input[@aria-label=\"Daily\"]/parent::*");
    protected By tradeExperienceQuestion = By.cssSelector("span[data-translate=\"trade_kind_title\"]");
    protected By tradeingPurposeQuestion = By.cssSelector("span[data-translate=\"trading_purpose\"]");
    protected By tradeFrequencyQuestion = By.cssSelector("span[data-translate=\"trading_frequency_feb2022\"]");

    public void selectTradingExperienceInPast2Years(String options){
        switch(options){
            case "Worked in the Financial Industry":
                clickElement(option3);
            break;
            // other options
        }
    }

    public void changeLanguage(String language){
        switch (language){
            case "Francais":
                clickElement(changeLangauge);
                clickElement(languageFrancais);
                break;
            // other languages
        }
    }

    public void selectFrequency(String options){
        switch (options){
            case "Daily":
                clickElement(optionDaily);
                break;
            // other options
        }
    }
    public String getPageHeader(String identifier){

        String res = "";
        switch (identifier){
            case "Trading Experience":
                HelperClass.sleep();
                res = getTextFromElement(tradeExperienceQuestion);
                break;
            case "Trading Purpose":
                res = getTextFromElement(tradeingPurposeQuestion);
                break;
            case "Trade Frequency":
                res = getTextFromElement(tradeFrequencyQuestion);
                break;
            // other questionaires

        }
        return res;
    }
}
