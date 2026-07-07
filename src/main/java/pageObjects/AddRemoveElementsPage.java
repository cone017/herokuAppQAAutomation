package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRemoveElementsPage extends AbstractComponent {

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@onclick='addElement()']")
    private WebElement addButton;

    @FindBy(xpath = "//button[@class='added-manually']")
    private List<WebElement> deleteButtons;

    public void addElement() {
        onClick(addButton);
    }

    public void clickElement(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            onClick(addButton);
        }
    }

    public int getDeleteButtonCount() {
        return deleteButtons.size();
    }

    public void clickFirstDeleteButton() {
        onClick(deleteButtons.getFirst());
    }

    public void deleteAllButtons(int buttonsCounter) {
        for (int i = 0; i < buttonsCounter; i++) {
            onClick(deleteButtons.getFirst());
        }
    }
}
