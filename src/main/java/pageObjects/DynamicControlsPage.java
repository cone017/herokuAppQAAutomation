package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends AbstractComponent {

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    // REMOVE/ADD CHECKBOX

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBox;

    @FindBy(xpath = "//form[@id='checkbox-example']//button")
    WebElement removeOrAddCheckBoxButton;

    @FindBy(xpath = "//form[@id='checkbox-example']//p")
    WebElement checkBoxMessage;

    @FindBy(xpath = "(//div[@id='loading'])[1]")
    WebElement loadingElementCheckBox;

    // ENABLE/DISABLE TEXTFIELD

    @FindBy(xpath = "//input[@type='text']")
    WebElement enableDisableTextField;

    @FindBy(xpath = "//form[@id='input-example']//button")
    WebElement enableOrDisableTextFieldButton;

    @FindBy(xpath = "(//div[@id='loading'])[2]")
    WebElement loadingElementTextField;

    public void tickCheckBox() {
        checkBox.click();
    }

    public boolean isCheckBoxedTicked() {
        return checkBox.isSelected();
    }

    public void clickRemoveButton() {
        removeOrAddCheckBoxButton.click();
    }

    public boolean isCheckBoxDisappeared() {
        return waitForInvisibility(checkBox);
    }

    public boolean isLoadingElementDisplayed() throws InterruptedException {
        return waitForVisibility(loadingElementCheckBox).isDisplayed();
    }

}
