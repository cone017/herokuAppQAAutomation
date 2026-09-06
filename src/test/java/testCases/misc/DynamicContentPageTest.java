package testCases.misc;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DynamicContentPage;
import pageObjects.LandingPage;
import testCases.BaseTest;

import java.util.List;

public class DynamicContentPageTest extends BaseTest {

    @Test
    public void verifyCountOfAvatars() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Content");

        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);

        Assert.assertEquals(dynamicContentPage.getListOfAvatars().size(), 3);

    }

    @Test
    public void verifyCountOfParagraphs() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Content");

        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);

        Assert.assertEquals(dynamicContentPage.getListOfParagraphs().size(), 3);

    }

    @Test
    public void verifyOnFirstRefreshNewParagraphsPrint() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Content");

        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);

        List<String> listOfParagraphsText = dynamicContentPage.getListOfParagraphs().stream()
                .map(WebElement::getText)
                .toList();

        dynamicContentPage.refreshPage();

        List<String> listOfParagraphsText2 = dynamicContentPage.getListOfParagraphs().stream()
                .map(WebElement::getText)
                .toList();

        Assert.assertNotEquals(listOfParagraphsText2, listOfParagraphsText);

    }

    @Test
    public void verifyOnFirstRefreshNewAvatarsPrint() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Content");

        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);

        List<String> listOfAvatars = dynamicContentPage.getListOfAvatarsSrc();

        dynamicContentPage.refreshPage();

        List<String> listOfAvatars2 = dynamicContentPage.getListOfAvatarsSrc();

        Assert.assertNotEquals(listOfAvatars, listOfAvatars2);

    }

    @Test
    public void verifyAfterFirstRefreshFirstTwoAvatarsAreNotChanging() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage("Dynamic Content");

        DynamicContentPage dynamicContentPage = new DynamicContentPage(driver);

        dynamicContentPage.refreshPage();

        List<String> listOfAvatars = dynamicContentPage.getListOfAvatarsSrc();

        dynamicContentPage.refreshPage();

        List<String> listOfAvatars2 = dynamicContentPage.getListOfAvatarsSrc();

        Assert.assertEquals(listOfAvatars.getFirst(), listOfAvatars2.getFirst());
        Assert.assertEquals(listOfAvatars.get(1), listOfAvatars2.get(1));

        dynamicContentPage.refreshPage();

        listOfAvatars2 = dynamicContentPage.getListOfAvatarsSrc();

        Assert.assertEquals(listOfAvatars.getFirst(), listOfAvatars2.getFirst());
        Assert.assertEquals(listOfAvatars.get(1), listOfAvatars2.get(1));

    }

}
