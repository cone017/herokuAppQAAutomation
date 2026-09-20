package testCases.misc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DynamicLoadingPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class DynamicLoadingPageTest extends BaseTest {

    @Test
    public void verifyLoadingBarExample1() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Loading");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.openExample1();

        Assert.assertTrue(dynamicLoadingPage.isLoadingBarDisplayed());

    }

    @Test
    public void verifyFinalMessageDisplayedExample1() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Loading");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.openExample1();

        Assert.assertTrue(dynamicLoadingPage.isFinalMessageDisplayedExample1());

    }

}
