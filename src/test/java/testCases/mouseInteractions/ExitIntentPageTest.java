package testCases.mouseInteractions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ExitIntentPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

import java.awt.*;

public class ExitIntentPageTest extends BaseTest {

    // Run these tests only in headless=false mode

    @Test
    public void verifyModalPopUp() throws InterruptedException, AWTException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Exit Intent");

        ExitIntentPage exitIntentPage = new ExitIntentPage(driver);
        exitIntentPage.triggerExitIntent();

        Assert.assertTrue(exitIntentPage.isModalDisplayed());

    }

    @Test
    public void verifyModalClose() throws InterruptedException, AWTException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Exit Intent");

        ExitIntentPage exitIntentPage = new ExitIntentPage(driver);

        exitIntentPage.triggerExitIntent();
        exitIntentPage.closeModalMethod();

        Assert.assertFalse(exitIntentPage.isModalHidden());

    }

    @Test
    public void verifyModalHeadingText() throws AWTException, InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Exit Intent");

        ExitIntentPage exitIntentPage = new ExitIntentPage(driver);

        exitIntentPage.triggerExitIntent();

        Assert.assertEquals(exitIntentPage.getHeadingText(), "THIS IS A MODAL WINDOW");

    }

    @Test
    public void verifyModalText() throws AWTException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Exit Intent");

        ExitIntentPage exitIntentPage = new ExitIntentPage(driver);

        exitIntentPage.triggerExitIntent();

        //Assert.assertEquals(exitIntentPage.getHeadingText(), "This is a modal window");


        Assert.assertEquals(exitIntentPage.getModalBodyText(), "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something).");

    }

}

