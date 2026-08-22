package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChallengingDomPage extends AbstractComponent {

    public ChallengingDomPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'large-2')]//a")
    List<WebElement> leftButtons;

    @FindBy(xpath = "//h3")
    WebElement heading;

    @FindBy(xpath = "//table//tr//th")
    List<WebElement> tableHeadings;

    @FindBy(xpath = "//a[@href='#edit']")
    List<WebElement> editButtons;

    @FindBy(xpath = "//a[@href='#delete']")
    List<WebElement> deleteButtons;

    @FindBy(xpath = "//canvas[@id='canvas']")
    WebElement canvasElement;

    // Left buttons
    public boolean checkLeftButtonsClick() throws InterruptedException {

        boolean allThree = true;

        for (int i = 0; i < leftButtons.size(); i++) {
            try {
                WebElement button = driver.findElements(
                                By.xpath("//div[contains(@class,'large-2')]//a"))
                        .get(i);

                button.click();
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.stalenessOf(button));
                //System.out.println("Success: page reloaded!");
                Thread.sleep(2000);

            } catch (StaleElementReferenceException | org.openqa.selenium.TimeoutException e) {
                System.out.println("Fail: Reload not detected on click: " + i);
                allThree = false;
            }
        }
        return allThree;
    }

    // Table
    public String checkHeading() {
        return heading.getText();
    }

    public int countTableHeadings() {
        return tableHeadings.size();
    }

    public List<String> getTableHeadings() {

        return tableHeadings.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean checkEditButtons() {

        boolean allButtons = true;
        String url1 = "https://the-internet.herokuapp.com/challenging_dom#edit";

        for (int i = 0; i < editButtons.size(); i++) {

            editButtons.get(i).click();
            //System.out.println("Clicked " + i + "st edit");

            if (!Objects.equals(driver.getCurrentUrl(), url1)) {
                allButtons = false;
                break;
            }
        }

        return allButtons;
    }

    public boolean checkDeleteButtons() {

        boolean allButtons = true;
        String url1 = "https://the-internet.herokuapp.com/challenging_dom#delete";

        for (int i = 0; i < deleteButtons.size(); i++) {

            deleteButtons.get(i).click();
            //System.out.println("Clicked " + i + "st delete");

            if (!Objects.equals(driver.getCurrentUrl(), url1)) {
                allButtons = false;
                break;
            }
        }

        return allButtons;
    }

    // Canvas
    public boolean isCanvasPresent() {
        return canvasElement.isDisplayed();
    }

    public String getCanvasWidth() {
        return canvasElement.getAttribute("width");
    }

    public String getCanvasHeight() {
        return canvasElement.getAttribute("height");
    }

    public boolean isCanvasBlank() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String canvasData = (String) js.executeScript(
                "return arguments[0].toDataURL();", canvasElement);

        String blankCanvasData = (String) js.executeScript(
                "var c = document.createElement('canvas');" +
                        "c.width = arguments[0].width;" +
                        "c.height = arguments[0].height;" +
                        "return c.toDataURL();", canvasElement);

        assert canvasData != null;
        return canvasData.equals(blankCanvasData);
    }
}