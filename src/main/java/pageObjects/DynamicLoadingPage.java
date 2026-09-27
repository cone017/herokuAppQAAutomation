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
    WebElement loadingBarExample;

    @FindBy(xpath = "//div[@id='finish']")
    WebElement hiddenElementExample1;

    @FindBy(xpath = "//a[@href='/dynamic_loading/2']")
    WebElement example2;

    @FindBy(xpath = "//div[@id='start']//button")
    WebElement buttonExample2;

    @FindBy(xpath = "//div[@id='finish']")
    WebElement hiddenElementExample2;

    @FindBy(xpath = "//div[@id='finish']//h4")
    WebElement finalText;

    public void openExample1() {
        onClick(example1);
    }

    public void openExample2() {
        onClick(example2);
    }

    public boolean isLoadingBarDisplayed() throws InterruptedException {

        onClick(buttonExample1);
        waitForVisibility(loadingBarExample);

        return loadingBarExample.isDisplayed();
    }

    public boolean isFinalMessageDisplayedExample1() throws InterruptedException {

        onClick(buttonExample1);
        waitForVisibility(hiddenElementExample1);

        return hiddenElementExample1.isDisplayed();
    }

    public boolean isLoadingBarDisplayed2() throws InterruptedException {

        onClick(buttonExample2);
        waitForVisibility(loadingBarExample);

        return loadingBarExample.isDisplayed();
    }

    public boolean isFinalMessageDisplayedExample2() throws InterruptedException {

        onClick(buttonExample2);
        waitForVisibility(hiddenElementExample2);

        return hiddenElementExample2.isDisplayed();
    }

    public boolean doesButtonDisappear1() throws InterruptedException {

        onClick(buttonExample1);
        waitForVisibility(hiddenElementExample1);

        return buttonExample1.isDisplayed();

    }

    public boolean doesButtonDisappear2() throws InterruptedException {

        onClick(buttonExample2);
        waitForVisibility(hiddenElementExample2);

        return buttonExample2.isDisplayed();

    }

    public String getFinalTextExample1() throws InterruptedException {

        buttonExample1.click();

        return waitForVisibility(finalText).getText();
    }

    public String getFinalTextExample2() throws InterruptedException {

        buttonExample2.click();

        return waitForVisibility(finalText).getText();
    }

}
