package testCases.misc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DisappearingElementsPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class DisappearingElementsPageTest extends BaseTest {

    private DisappearingElementsPage disappearingElementsPage;

    @BeforeMethod
    public void beforeEachMethod() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Disappearing Elements");

       disappearingElementsPage = new DisappearingElementsPage(driver);
    }

    @Test
    public void verifyHomeElementNavigation() {
        Assert.assertTrue(disappearingElementsPage.checkHomeElement());
    }

    @Test
    public void verifyAboutElementNavigation() {
        Assert.assertTrue(disappearingElementsPage.checkAboutElement());
    }

    @Test
    public void verifyContactUsElementNavigation() {
        Assert.assertTrue(disappearingElementsPage.checkContactUsElement());
    }

    @Test
    public void verifyPortfolioElementNavigation() {
        Assert.assertTrue(disappearingElementsPage.checkPortfolioElement());
    }

    @Test
    public void verifyGalleryElementNavigation() {

        int attempts = 0;
        int maxAttempts = 20;

        while (disappearingElementsPage.getCountOfElements() == 4 && attempts <= maxAttempts) {
            disappearingElementsPage.reloadThePage();
            attempts++;
        }

        Assert.assertTrue(disappearingElementsPage.checkGalleryElement());
    }

}
