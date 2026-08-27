package testCases.auth;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DigestAuthPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class DigestAuthPageTest extends BaseTest {

    @Test
    public void verifySuccessfulDigestAuth() {

        ((HasAuthentication) driver).register(
                () -> new UsernameAndPassword("admin", "admin")
        );

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Digest Authentication");

        DigestAuthPage digestAuthPage = new DigestAuthPage(driver);
        String message = digestAuthPage.getSuccessText();

        Assert.assertEquals(message, "Congratulations! You must have the proper credentials.");

    }

    @Test
    public void verifyFailureDigestAuth() {

        ((HasAuthentication) driver).register(
                () -> new UsernameAndPassword("admin1", "admin")
        );

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Digest Authentication");

        DigestAuthPage digestAuthPage = new DigestAuthPage(driver);
        String message = digestAuthPage.getSuccessText();

        Assert.assertTrue(driver.getPageSource().contains("ERR_TOO_MANY_RETRIES"), "Expected a Chrome network error page due to failed digest authentication");

    }

}
