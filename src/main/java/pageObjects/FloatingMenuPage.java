package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class FloatingMenuPage extends AbstractComponent {

    public void scrollThePage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4500)");

    }

    public FloatingMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='#home']")
    WebElement homeButton;

    @FindBy(xpath = "//a[@href='#news']")
    WebElement newsButton;

    @FindBy(xpath = "//a[@href='#contact']")
    WebElement contactButton;

    @FindBy(xpath = "//a[@href='#about']")
    WebElement aboutButton;

    public boolean checkHomeButton() {

        onClick(homeButton);
        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu#home");

    }

    public boolean checkHomeButtonScroll() {

        scrollThePage();

        onClick(homeButton);
        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu#home");

    }

    public boolean checkNewsButton() {

        onClick(newsButton);
        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu#news");

    }

    public boolean checkNewsButtonScroll() {

        scrollThePage();

        onClick(newsButton);
        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu#news");

    }

    public boolean checkContactButton() {

        onClick(contactButton);
        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu#contact");

    }

    public boolean checkContactButtonScroll() throws InterruptedException {

        scrollThePage();

        Thread.sleep(3000);

        onClick(contactButton);
        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu#contact");

    }

    public boolean checkAboutButton() {

        onClick(aboutButton);
        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu#about");

    }

    public boolean checkAboutButtonScroll() {

        scrollThePage();

        onClick(aboutButton);
        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/floating_menu#about");

    }



}
