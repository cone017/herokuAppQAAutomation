package testCases.misc;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DynamicControlsPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class DynamicControlsPageTest extends BaseTest {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void before() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Controls");

        dynamicControlsPage = new DynamicControlsPage(driver);

    }

    @Test
    public void verifyIsCheckBoxUncheckedByDefault() {
        Assert.assertFalse(dynamicControlsPage.isCheckBoxedTicked());
    }

    @Test
    public void verifyCheckingCheckBox() {
        dynamicControlsPage.tickCheckBox();
        Assert.assertTrue(dynamicControlsPage.isCheckBoxedTicked());
    }

    @Test
    public void verifyCheckBoxDisappear() {
        dynamicControlsPage.clickRemoveButton();
        Assert.assertTrue(dynamicControlsPage.isCheckBoxDisappeared());
    }

    @Test
    public void verifyLoadingBarDisplayCheckBox() throws InterruptedException {
        dynamicControlsPage.clickRemoveButton();
        Assert.assertTrue(dynamicControlsPage.isLoadingElementDisplayedCheckBox());
    }

    @Test
    public void verifyMessageAfterRemovingCheckBox() throws InterruptedException {
        dynamicControlsPage.clickRemoveButton();
        Assert.assertEquals(dynamicControlsPage.messageAfterRemovingCheckBox(), "It's gone!");
    }

    @Test
    public void verifyIsTextFieldDisabledByDefault() {
        Assert.assertFalse(dynamicControlsPage.isTextBFieldDisabled());
    }

    @Test
    public void verifyLoadingBarDisplayTextField() throws InterruptedException {
        dynamicControlsPage.clickEnableOrDisableTextField();
        Assert.assertTrue(dynamicControlsPage.isLoadingElementDisplayedTextField());
    }

    @Test
    public void verifyBothLoadingBarsDisplayed() throws InterruptedException {
        dynamicControlsPage.clickEnableOrDisableTextField();
        dynamicControlsPage.clickRemoveButton();
        Assert.assertEquals(dynamicControlsPage.isBothLoadingElementsDisplayed(), 2);
    }

}
