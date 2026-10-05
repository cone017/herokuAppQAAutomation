package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class FileDownloadPage extends AbstractComponent {

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void downloadFileByName(String fileName) {
        WebElement link = driver.findElement(By.linkText(fileName));
        onClick(link);
    }

    public List<WebElement> getAvailableFileLinks() {
        return driver.findElements(By.cssSelector("#content a"));
    }

    public boolean isFileDownloaded(String fileName) {
        File file = new File(System.getProperty("user.dir") + "/downloads/" + fileName);
        return file.exists();
    }

    public boolean waitForFileDownload(String fileName, int timeoutSeconds) throws InterruptedException {
        File file = new File(System.getProperty("user.dir") + "/downloads/" + fileName);

        int waited = 0;
        while (!file.exists() && waited < timeoutSeconds) {
            Thread.sleep(500);
            waited++;
        }
        return file.exists();
    }
}
