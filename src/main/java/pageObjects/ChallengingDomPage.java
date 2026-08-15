package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
                System.out.println("Success: page reloaded!");
                Thread.sleep(2000);

            } catch (StaleElementReferenceException | org.openqa.selenium.TimeoutException e) {
                System.out.println("Fail: Reload not detected on click: " + i);
                allThree = false;
            }
        }
        return allThree;
    }
}