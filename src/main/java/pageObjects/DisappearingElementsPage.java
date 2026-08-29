package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class DisappearingElementsPage extends AbstractComponent {

    public DisappearingElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul//li")
    List<WebElement> listedElements;
    // gallery item ima text samo "Gallery"

    public int getCountOfElements() {
        return listedElements.size();
    }

    public boolean checkHomeElement() {

        WebElement home = listedElements.stream()
                .filter(x -> x.getText().equals("Home"))
                .findFirst()
                .orElseThrow();

        home.click();

        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/");
    }

    public boolean checkAboutElement() {

        WebElement about = listedElements.stream()
                .filter(x -> x.getText().equals("About"))
                .findFirst()
                .orElseThrow();

        about.click();

        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/about/");
    }

    public boolean checkContactUsElement() {

        WebElement contactUs = listedElements.stream()
                .filter(x -> x.getText().equals("Contact Us"))
                .findFirst()
                .orElseThrow();

        contactUs.click();

        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/contact-us/");
    }

    public boolean checkPortfolioElement() {

        WebElement portfolio = listedElements.stream()
                .filter(x -> x.getText().equals("Portfolio"))
                .findFirst()
                .orElseThrow();

        portfolio.click();

        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/portfolio/");
    }

    public void reloadThePage() {
        driver.navigate().refresh();
    }

    public boolean checkGalleryElement() {

        WebElement gallery = listedElements.stream()
                .filter(x -> x.getText().equals("Gallery"))
                .findFirst()
                .orElseThrow();

        gallery.click();

        return Objects.equals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/gallery/");
    }


}
