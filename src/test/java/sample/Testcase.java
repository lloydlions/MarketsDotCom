package sample;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CountryResidencePage;
import pages.MainPage;
import pages.PlatformPage;
import pages.TradingExperience;
import utilities.HelperClass;

public class Testcase {
    MainPage mainPage;
    PlatformPage platformPage;
    CountryResidencePage countryResidencePage;
    TradingExperience tradingExperience;

    @Test
    public void testOne() throws InterruptedException {

        mainPage = new MainPage();
        platformPage = new PlatformPage();
        tradingExperience = new TradingExperience();

        mainPage.navigateToPage();
        Assert.assertEquals(mainPage.getTitle(), "Markets.com: Online Forex & Gold CFD Trading platform");

        mainPage.clickTradingPlatformLink();
        Assert.assertEquals(platformPage.getTitle(),"What is the best online trading platform");
        platformPage.fillUp(HelperClass.reformatEmail("test@test.com"),"Test123!");

        countryResidencePage = new CountryResidencePage(platformPage.getWindowHandle());
        Assert.assertEquals(countryResidencePage.getTitle(),"markets.com Account Registration");
        Assert.assertEquals(countryResidencePage.getPageHeader(),"Country of Residence");
        countryResidencePage.selectCountryOfResidence("France");

        Assert.assertEquals(tradingExperience.getPageHeader("Trading Experience"),"What statement best describes your trading experience in the past 2 years?");
        tradingExperience.selectTradingExperienceInPast2Years("Worked in the Financial Industry");
        Assert.assertEquals(tradingExperience.getPageHeader("Trade Frequency"),"Your frequency of trading in the last 2 years:");
        tradingExperience.changeLanguage("Francais");
        Assert.assertEquals(tradingExperience.getPageHeader("Trade Frequency"),"Votre fréquence de trading au cours des 2 dernières années :");
        tradingExperience.selectFrequency("Daily");
        Assert.assertEquals(tradingExperience.getPageHeader("Trading Purpose"),"Objectif et nature de votre trading :");


    }

}
