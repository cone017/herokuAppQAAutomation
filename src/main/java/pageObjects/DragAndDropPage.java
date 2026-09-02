package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends AbstractComponent {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='column-a']")
    private WebElement columnA;

    @FindBy(xpath = "//div[@id='column-b']")
    private WebElement columnB;

    public String getColumnAText() {
        return columnA.getText();
    }

    public String getColumnBText() {
        return columnB.getText();
    }

    public void dragAndDropOnToB() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String dragAndDropScript = "function createEvent(typeOfEvent) {" +
                "  var event = document.createEvent('CustomEvent');" +
                "  event.initCustomEvent(typeOfEvent, true, true, null);" +
                "  event.dataTransfer = {" +
                "    data: {}," +
                "    setData: function(key, value) { this.data[key] = value; }," +
                "    getData: function(key) { return this.data[key]; }" +
                "  };" +
                "  return event;" +
                "}" +
                "function dispatchEvent(element, event, transferData) {" +
                "  if (transferData !== undefined) { event.dataTransfer = transferData; }" +
                "  if (element.dispatchEvent) { element.dispatchEvent(event); }" +
                "  else if (element.fireEvent) { element.fireEvent('on' + event.type, event); }" +
                "}" +
                "function simulateHTML5DragAndDrop(element, target) {" +
                "  var dragStartEvent = createEvent('dragstart');" +
                "  dispatchEvent(element, dragStartEvent);" +
                "  var dropEvent = createEvent('drop');" +
                "  dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);" +
                "  var dragEndEvent = createEvent('dragend');" +
                "  dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);" +
                "}" +
                "simulateHTML5DragAndDrop(arguments[0], arguments[1]);";

        js.executeScript(dragAndDropScript, columnA, columnB);

    }

}
