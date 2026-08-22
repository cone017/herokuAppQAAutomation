package testCases.misc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ChallengingDomPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

import java.util.List;

public class ChallengingDomTest extends BaseTest {

    private ChallengingDomPage page;

    @BeforeMethod
    public void navigateToPage() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Challenging DOM");

        page = new ChallengingDomPage(driver);
    }

    @Test
    public void verifyAllThreeButtonsRefreshPage() throws InterruptedException {
        Assert.assertTrue(page.checkLeftButtonsClick());
    }

    @Test
    public void verifyHeadingText() {
        Assert.assertEquals(page.checkHeading(), "Challenging DOM");
    }

    @Test
    public void verifyTableHeadingsCount() {
        Assert.assertEquals(page.countTableHeadings(), 7);
    }

    @Test
    public void verifyTableHeadingsText() {
        List<String> headings = List.of("Lorem", "Ipsum", "Dolor", "Sit", "Amet", "Diceret", "Action");
        Assert.assertEquals(headings, page.getTableHeadings());
    }

    @Test
    public void verifyTableEditButtons() {
        Assert.assertTrue(page.checkEditButtons());
    }

    @Test
    public void verifyTableDeleteButtons() {
        Assert.assertTrue(page.checkDeleteButtons());
    }

    @Test
    public void verifyCanvasPresentWithCorrectDimensions() {
        Assert.assertTrue(page.isCanvasPresent(), "Expected canvas element to be present");
        Assert.assertEquals(page.getCanvasWidth(), "599", "Expected canvas width to be 599");
        Assert.assertEquals(page.getCanvasHeight(), "200", "Expected canvas height to be 200");
    }

    @Test
    public void verifyCanvasHasContent() {
        Assert.assertFalse(page.isCanvasBlank(), "Expected canvas to have visible drawn content, not be blank");
    }

}
