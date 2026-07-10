package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuthPage extends AbstractComponent {

    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p")
    private WebElement message;

    public String getResultMessage() {
        waitForVisibility(message);
        return message.getText();
    }
}
