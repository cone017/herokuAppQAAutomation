package testCases.formsAndInputs;

import formsAndInputs.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class DropdownPageTest extends BaseTest {

    @Test
    public void verifyFirstOption() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);

        Assert.assertEquals(dropdownPage.checkFirstOption(), "Please select an option");
    }

    @Test
    public void verifyFirstOptionIsDefaultValue() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);

        Assert.assertEquals(dropdownPage.checkDefaultOption(), "Please select an option");
    }

    @Test
    public void verifyOptionOneIsSelected() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);

        Assert.assertEquals(dropdownPage.checkOptionOne(), "Option 1");
    }

    @Test
    public void verifyOptionTwoIsSelected() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);

        Assert.assertEquals(dropdownPage.checkOptionTwo(), "Option 2");
    }

    @Test
    public void verifyDefaultOptionIsDisabled() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dropdown");

        DropdownPage dropdownPage = new DropdownPage(driver);

        Assert.assertTrue(dropdownPage.checkIsDefaultOptionIsDisabled());
    }

}
