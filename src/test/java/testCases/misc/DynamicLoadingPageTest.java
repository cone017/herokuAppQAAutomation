package testCases.misc;

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

    @Test
    public void verifyLoadingBarExample2() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Loading");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.openExample2();

        Assert.assertTrue(dynamicLoadingPage.isLoadingBarDisplayed2());

    }

    @Test
    public void verifyFinalMessageDisplayedExample2() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Loading");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.openExample2();

        Assert.assertTrue(dynamicLoadingPage.isFinalMessageDisplayedExample2());

    }

    @Test
    public void verifyButtonDisappearExample1() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Loading");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.openExample1();

        Assert.assertFalse(dynamicLoadingPage.doesButtonDisappear1());

    }

    @Test
    public void verifyButtonDisappearExample2() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Loading");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.openExample2();

        Assert.assertFalse(dynamicLoadingPage.doesButtonDisappear2());

    }

    @Test
    public void verifyFinalTestExample1() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Loading");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.openExample1();

        Assert.assertEquals(dynamicLoadingPage.getFinalTextExample1(), "Hello World!");

    }

    @Test
    public void verifyFinalTestExample2() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Loading");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.openExample2();

        Assert.assertEquals(dynamicLoadingPage.getFinalTextExample2(), "Hello World!");

    }

}
