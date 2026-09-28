package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EntryAdPage extends AbstractComponent {

    public EntryAdPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "modal")
    private WebElement modalContainer;

    @FindBy(xpath = "//div[@class='modal-title']//h3")
    private WebElement modalHeading;

    @FindBy(xpath = "//div[@class='modal-body']//p")
    private WebElement modalBody;

    @FindBy(xpath = "//div[@class='modal-footer']//p")
    private WebElement modalFooter;

    @FindBy(xpath = "//a[@id='restart-ad']")
    private WebElement reEnable;

    public boolean isModalDisplayed() throws InterruptedException {

        waitForVisibility(modalContainer);
        return modalContainer.isDisplayed();
    }

    public boolean isModalHidden() {

        waitForInvisibility(modalContainer);
        return modalContainer.isDisplayed();
    }

    public void closeModal() {
        onClick(modalFooter);
    }

    public void reEnableModal() {
        onClick(reEnable);
    }
}