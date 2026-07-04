package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends AbstractComponent {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        onClick(link);
    }

}
