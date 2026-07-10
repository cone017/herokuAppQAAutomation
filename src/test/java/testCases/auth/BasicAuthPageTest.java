package testCases.auth;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BasicAuthPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class BasicAuthPageTest extends BaseTest {

    private String pageName = "Basic Auth";

    @Test
    public void verifySuccessfulBasicAuth() {

        ((HasAuthentication) driver).register(
                () -> new UsernameAndPassword("admin", "admin")
        );

        LandingPage page = new LandingPage(driver);
        page.goToPage(pageName);

        BasicAuthPage basicAuthPage = new BasicAuthPage(driver);
        String message = basicAuthPage.getResultMessage();

        Assert.assertEquals(message, "Congratulations! You must have the proper credentials.");

    }

    @Test
    public void verifyFailedBasicAuth() {

        ((HasAuthentication) driver).register(
                () -> new UsernameAndPassword("admin1", "admin")
        );

        LandingPage page = new LandingPage(driver);
        page.goToPage(pageName);

        Assert.assertTrue(driver.getPageSource().contains("ERR_TOO_MANY_RETRIES"),
                "Expected a Chrome network error (ERR_TOO_MANY_RETRIES) due to repeated failed authentication attempts");

    }

}
