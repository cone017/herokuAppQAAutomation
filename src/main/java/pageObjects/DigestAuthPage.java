package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DigestAuthPage extends AbstractComponent {

    public DigestAuthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3")
    private WebElement header;

    @FindBy(xpath = "//p")
    private WebElement successText;

    public String getHeader() {
        return header.getText();
    }

    public String getSuccessText() {
        return successText.getText();
    }

}
