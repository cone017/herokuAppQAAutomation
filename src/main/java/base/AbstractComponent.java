package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractComponent {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForVisibility(WebElement element) throws InterruptedException {
        Thread.sleep(500);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean waitForInvisibility(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForClickabilty(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void onClick(WebElement element) {
        waitForClickabilty(element);
        element.click();
    }
}
