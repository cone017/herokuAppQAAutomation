package testCases.misc;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FloatingMenuPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class FloatingMenuPageTest extends BaseTest {

    @Test
    public void verifyHomeButton() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Floating Menu");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);

        Assert.assertTrue(floatingMenuPage.checkHomeButton());

    }

    @Test
    public void verifyHomeButtonScroll() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Floating Menu");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);

        Assert.assertTrue(floatingMenuPage.checkHomeButtonScroll());

    }

    @Test
    public void verifyNewsButton() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Floating Menu");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);

        Assert.assertTrue(floatingMenuPage.checkNewsButton());

    }

    @Test
    public void verifyNewsButtonScroll() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Floating Menu");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);

        Assert.assertTrue(floatingMenuPage.checkNewsButtonScroll());

    }

    @Test
    public void verifyContactButton() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Floating Menu");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);

        Assert.assertTrue(floatingMenuPage.checkContactButton());

    }

    @Test
    public void verifyContactButtonScroll() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Floating Menu");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);

        Assert.assertTrue(floatingMenuPage.checkContactButtonScroll());

    }

    @Test
    public void verifyAboutButton() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Floating Menu");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);

        Assert.assertTrue(floatingMenuPage.checkAboutButton());

    }

    @Test
    public void verifyAboutButtonScroll() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Floating Menu");

        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);

        Assert.assertTrue(floatingMenuPage.checkAboutButtonScroll());

    }

}
