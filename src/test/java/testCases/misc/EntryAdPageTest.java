package testCases.misc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.EntryAdPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class EntryAdPageTest extends BaseTest {

    EntryAdPage entryAdPage;

    @BeforeMethod
    public void before() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Entry Ad");

        entryAdPage = new EntryAdPage(driver);
    }

    @Test
    public void verifyIsModalDisplayed() throws InterruptedException {
        Assert.assertTrue(entryAdPage.isModalDisplayed());
    }

    @Test
    public void verifyIsModalClosed() {
        entryAdPage.closeModal();
        Assert.assertFalse(entryAdPage.isModalHidden());
    }

    @Test
    public void verifyReEnablingModal() throws InterruptedException {
        entryAdPage.closeModal();
        entryAdPage.reEnableModal();
        Assert.assertTrue(entryAdPage.isModalDisplayed());
    }

}
