package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicLoadingPage extends AbstractComponent {

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/dynamic_loading/1']")
    WebElement example1;

    @FindBy(xpath = "//div[@id='start']//button")
    WebElement buttonExample1;

    @FindBy(xpath = "//div[@id='loading']")
    WebElement loadingBarExample1;

    @FindBy(xpath = "//div[@id='finish']")
    WebElement hiddenElementExample1;

    @FindBy(xpath = "//a[@href='/dynamic_loading/2']")
    WebElement example2;

    public void openExample1() {
        onClick(example1);
    }

    public void openExample2() {
        onClick(example2);
    }

    public boolean isLoadingBarDisplayed() throws InterruptedException {

        onClick(buttonExample1);
        waitForVisibility(loadingBarExample1);

        return loadingBarExample1.isDisplayed();
    }

    public boolean isFinalMessageDisplayedExample1() throws InterruptedException {

        onClick(buttonExample1);
        waitForVisibility(hiddenElementExample1);

        return hiddenElementExample1.isDisplayed();
    }
}
