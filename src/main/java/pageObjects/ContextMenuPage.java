package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends AbstractComponent {

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='hot-spot']")
    WebElement hotSpot;

    public void rightClickHotSpot() {

        Actions action = new Actions(driver);
        action.moveToElement(hotSpot).contextClick().build().perform();

    }

    public String getAlertTextAndAccept() {

        String alertText;

        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
        } catch (Exception e) {
            alertText = "";
        }
        return alertText;

    }

    public void leftClickHotSpot() {
        hotSpot.click();
    }

}
