package testCases.fileHandling;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FileDownloadPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class FileDownloadPageTest extends BaseTest {

    @Test
    public void verifyFileDownloadsSuccessfully() throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("File Download");

        FileDownloadPage page = new FileDownloadPage(driver);

        WebElement firstFile = page.getAvailableFileLinks().get(1);
        String fileName = firstFile.getText();

        page.downloadFileByName(fileName);

        Assert.assertTrue(page.waitForFileDownload(fileName, 10),
                "Expected file '" + fileName + "' to be downloaded within 10 seconds");
    }

}
