package testCases.misc;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BrokenImagesPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class BrokenImagesPageTest extends BaseTest {

    @Test
    public void verifyBrokenImagesAreDetected () {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Broken Images");

        BrokenImagesPage page = new BrokenImagesPage(driver);

        Assert.assertEquals(page.getImageCount(), 3, "Expected 3 images total on this page");
        Assert.assertEquals(page.getBrokenImageCount(), 2, "Expected 2 broken images on this page");
    }

    @Test
    public void verifyGoodImagesAreDetected () {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Broken Images");

        BrokenImagesPage page = new BrokenImagesPage(driver);

        Assert.assertEquals(page.getImageCount(), 3, "Expected 3 images total on this page");
        Assert.assertEquals(page.getGoodImageCount(), 1, "Expected 1 good image on this page");
    }

}
