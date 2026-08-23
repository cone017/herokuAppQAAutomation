package formsAndInputs;

import base.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends AbstractComponent {

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='checkbox'][following-sibling::text()[1][contains(., 'checkbox 1')]]")
    private WebElement checkBoxOne;

    @FindBy(xpath = "//input[@type='checkbox'][following-sibling::text()[1][contains(., 'checkbox 2')]]")
    private WebElement checkBoxTwo;

    public void tickCheckBox(WebElement chBox) {
        chBox.click();
    }

    public void tickBothCheckBox() {

        tickCheckBox(checkBoxTwo);

        if (!checkBoxOne.isSelected() && !checkBoxTwo.isSelected()) {
            tickCheckBox(checkBoxOne);
            tickCheckBox(checkBoxTwo);
        }
    }

    public void untickBothCheckBox() {

        tickCheckBox(checkBoxOne);

        if (checkBoxOne.isSelected() && checkBoxTwo.isSelected()) {
            tickCheckBox(checkBoxOne);
            tickCheckBox(checkBoxTwo);
        }
    }

    public boolean isCheckBox1Checked () {

        tickCheckBox(checkBoxOne);

        return checkBoxOne.isSelected();
    }

    public boolean isCheckBox1CheckedByDefault() {

        return checkBoxOne.isSelected();
    }

    public boolean isCheckBox2Checked() {

        tickCheckBox(checkBoxTwo);
        tickCheckBox(checkBoxTwo);

        return checkBoxTwo.isSelected();
    }

    public boolean isCheckBox2CheckedByDefault() {

        return checkBoxTwo.isSelected();
    }

    public boolean isBothCheckBoxChecked() {

        tickBothCheckBox();

        return checkBoxOne.isSelected() && checkBoxTwo.isSelected();
    }

    public boolean isBothCheckBoxUnchecked() {

        untickBothCheckBox();

        return !isBothCheckBoxChecked();
    }

}
