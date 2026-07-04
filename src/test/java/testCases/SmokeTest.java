package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class SmokeTest extends BaseTest {

    @Test
    public void verifyHomePageLoads() {
        Assert.assertTrue(Objects.requireNonNull(driver.getTitle()).contains("Internet"));
    }

}
