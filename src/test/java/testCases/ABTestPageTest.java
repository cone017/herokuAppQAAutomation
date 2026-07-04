package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ABTestPage;
import pageObjects.LandingPage;

public class ABTestPageTest extends BaseTest {

    @Test
    public void verifyABTestPageLoads() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("A/B Testing");

        ABTestPage abTestPage = new ABTestPage(driver);
        String heading = abTestPage.getHeadingText();

        Assert.assertTrue(heading.contains("A/B Test"),
                "Expected heading to contain 'A/B Test' but was: " + heading);
    }

}
