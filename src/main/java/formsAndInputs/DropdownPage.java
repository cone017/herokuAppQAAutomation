package formsAndInputs;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends AbstractComponent {

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@id='dropdown']")
    WebElement dropdown;

    @FindBy(xpath = "//select[@id='dropdown']//option[@selected='selected']")
    WebElement defaultOption;

    public String checkDefaultOption() {

        Select select = new Select(dropdown);

        return select.getFirstSelectedOption().getText();

    }

    public String checkFirstOption() {

        dropdown.click();

        Select select = new Select(dropdown);

        return select.getOptions().getFirst().getText();

    }

    public String checkOptionOne() {

        dropdown.click();

        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 1");

        return select.getFirstSelectedOption().getText();
    }

    public String checkOptionTwo() {

        dropdown.click();

        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");

        return select.getFirstSelectedOption().getText();
    }

    public Boolean checkIsDefaultOptionIsDisabled() {

        return !defaultOption.isEnabled();

    }


}
