package testCases.mouseInteractions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ContextMenuPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class ContextMenuPageTest extends BaseTest {

    private ContextMenuPage contextMenuPage;

    @BeforeMethod
    public void navigateToPage() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Context Menu");

        contextMenuPage = new ContextMenuPage(driver);
    }

    @Test
    public void verifyContextMenuAppears() {

        contextMenuPage.rightClickHotSpot();

        String alertText = contextMenuPage.getAlertTextAndAccept();

        Assert.assertEquals(alertText, "You selected a context menu");
    }

    @Test
    public void verifyContextMenuNotPresent() {

        contextMenuPage.leftClickHotSpot();

        String alertText = contextMenuPage.getAlertTextAndAccept();

        Assert.assertNotEquals(alertText, "You selected a context menu");

    }

}
