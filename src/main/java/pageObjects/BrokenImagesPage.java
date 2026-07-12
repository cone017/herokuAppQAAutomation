package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends AbstractComponent {

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='example']//img")
    private List<WebElement> images;

    public int getImageCount() {
        return images.size();
    }

    public boolean isImageBroken(WebElement image) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long naturalWidth = (long) js.executeScript(
                "return arguments[0].naturalWidth;", image);
        return naturalWidth == 0;
    }

    public boolean isImageGood(WebElement image) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long naturalWidth = (long) js.executeScript(
                "return arguments[0].naturalWidth;", image);
        return naturalWidth != 0;
    }

    public int getBrokenImageCount() {
        int brokenCount = 0;

        for(WebElement el : images) {
            if(isImageBroken(el))
                brokenCount++;
        }

        return brokenCount;
    }

    public int getGoodImageCount() {
        int goodCount = 0;

        for(WebElement el : images) {
            if(isImageGood(el))
                goodCount++;
        }

        return goodCount;
    }
}
