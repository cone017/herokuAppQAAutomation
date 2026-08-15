package testCases.misc;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ChallengingDomPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class ChallengingDomTest extends BaseTest {

    @Test
    public void verifyAllThreeButtonsRefreshPage() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Challenging DOM");

        ChallengingDomPage challengingDomPage = new ChallengingDomPage(driver);

        Assert.assertTrue(challengingDomPage.checkLeftButtonsClick());
    }

}
