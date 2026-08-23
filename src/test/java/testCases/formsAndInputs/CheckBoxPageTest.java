package testCases.formsAndInputs;

import formsAndInputs.CheckBoxPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class CheckBoxPageTest extends BaseTest {

    private CheckBoxPage page;

    @BeforeMethod
    public void navigateToPage() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Checkboxes");

        page = new CheckBoxPage(driver);
    }

    @Test
    public void verifyIsCheckBox1Checked () {
        Assert.assertTrue(page.isCheckBox1Checked());
    }

    @Test
    public void verifyCheckBox1DefaultState () {
        Assert.assertFalse(page.isCheckBox1CheckedByDefault());
    }

    @Test
    public void verifyCheckBox2DefaultState () {
        Assert.assertTrue(page.isCheckBox2CheckedByDefault());
    }

    @Test
    public void verifyIsCheckBox2Checked() {
        Assert.assertTrue(page.isCheckBox2Checked());
    }

    @Test
    public void verifyIsBothCheckBoxChecked() {
        Assert.assertTrue(page.isBothCheckBoxChecked());
    }

    @Test
    public void verifyIsBothCheckBoxUnchecked() {
        Assert.assertTrue(page.isBothCheckBoxUnchecked());
    }

}
