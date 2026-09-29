package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class ExitIntentPage extends AbstractComponent {

    public ExitIntentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='modal-footer']//p")
    WebElement closeModal;

    @FindBy(xpath = "//div[@id='ouibounce-modal']")
    WebElement modal;

    @FindBy(xpath = "//div[@class='modal-body']//p")
    WebElement modalBodyText;

    @FindBy(xpath = "//div[@class='modal-title']//h3")
    WebElement modalHeadingText;

    public void triggerExitIntent() throws AWTException {
        // 1. Get the position and size of the browser window
        Point windowPosition = driver.manage().window().getPosition();
        Dimension windowSize = driver.manage().window().getSize();

        // 2. Calculate the center point
        int centerX = windowPosition.getX() + (windowSize.getWidth() / 2);
        int centerY = windowPosition.getY() + (windowSize.getHeight() / 2);

        // 3. Move the mouse using Robot
        Robot robot = new Robot();
        robot.mouseMove(centerX, centerY);

        robot.mouseMove(600, 0);
    }

    public boolean isModalHidden() throws InterruptedException {

        waitForInvisibility(modal);
        return modal.isDisplayed();

    }

    public boolean isModalDisplayed() throws InterruptedException {

        waitForVisibility(modal);
        return modal.isDisplayed();

    }

    public void closeModalMethod() {
        onClick(closeModal);
    }

    public String getModalBodyText() {
        return modalBodyText.getText();
    }

    public String getHeadingText() throws InterruptedException {

        waitForVisibility(modalHeadingText);
        return modalHeadingText.getText();
    }
}
