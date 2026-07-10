package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ABTestPage extends AbstractComponent {

    @FindBy(xpath = "//h3")
    private WebElement heading;

    public ABTestPage(WebDriver driver) {
        super(driver);
    }

    public String getHeadingText() {
        waitForVisibility(heading);
        return heading.getText();
    }

}
