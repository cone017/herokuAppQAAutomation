package testCases.misc;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddRemoveElementsPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class AddRemoveElementsPageTest extends BaseTest {

    private String pageName = "Add/Remove Elements";

    @Test
    public void verifyAddButtonAddsDeleteButton() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage(pageName);

        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
        page.addElement();

        Assert.assertEquals(page.getDeleteButtonCount(), 1);
    }

    @Test
    public void verifyMultipleAddClicksAddMultipleDeleteButtons() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage(pageName);

        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
        page.clickElement(5);

        Assert.assertEquals(page.getDeleteButtonCount(), 5);
    }

    @Test
    public void verifyDeleteButtonRemovesElement() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage(pageName);

        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
        page.clickElement(3);
        page.clickFirstDeleteButton();

        Assert.assertEquals(page.getDeleteButtonCount(), 2);
    }

    @Test
    public void verifyDeleteAllButtons() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage(pageName);

        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);
        page.clickElement(3);
        page.deleteAllButtons(3);

        Assert.assertEquals(page.getDeleteButtonCount(), 0);
    }

}
