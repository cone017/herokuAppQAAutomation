package pageObjects;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DynamicContentPage extends AbstractComponent {

    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/dynamic_content?with_content=static']")
    WebElement refreshButton;

    @FindBy(xpath = "//div[@class='large-10 columns']")
    List<WebElement> listOfParagraphs;

    @FindBy(xpath = "//img[contains(@src, 'Avatar')]")
    List<WebElement> listOfAvatars;

    public List<WebElement> getListOfParagraphs() {
        return listOfParagraphs;
    }

    public List<WebElement> getListOfAvatars() {
        return listOfAvatars;
    }

    public void refreshPage() {
        refreshButton.click();
    }

    public List<String> getListOfAvatarsSrc() {

        return listOfAvatars.stream()
                .map(img -> img.getAttribute("src")).filter(Objects::nonNull)
                .map(src -> {
                    String filename = src.substring(src.lastIndexOf('/') + 1);
                    int avatarIndex = filename.indexOf("Avatar");
                    return filename.substring(avatarIndex);
                })
                .collect(Collectors.toList());
    }
}
