package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void verifyHomePageLoads() {
        Assert.assertTrue(driver.getTitle().contains("Internet"));
    }

}
