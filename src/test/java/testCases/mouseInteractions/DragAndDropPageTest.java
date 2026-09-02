package testCases.mouseInteractions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DragAndDropPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

public class DragAndDropPageTest extends BaseTest {

    @Test
    public void verifyDragAndDropSwapsColumn() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Drag and Drop");

        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        Assert.assertEquals(dragAndDropPage.getColumnAText(), "A");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "B");

        dragAndDropPage.dragAndDropOnToB();

        Assert.assertEquals(dragAndDropPage.getColumnAText(), "B");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "A");

    }

    @Test
    public void verifyDoubleDragAndDropDoubleSwapsColumn() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Drag and Drop");

        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        dragAndDropPage.dragAndDropOnToB();

        Assert.assertEquals(dragAndDropPage.getColumnAText(), "B");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "A");

        dragAndDropPage.dragAndDropOnToB();

        Assert.assertEquals(dragAndDropPage.getColumnAText(), "A");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "B");

    }
}
