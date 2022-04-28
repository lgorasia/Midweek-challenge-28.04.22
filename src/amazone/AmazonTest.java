package amazone;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class AmazonTest extends Utility {

    String baseUrl = "https://www.amazon.co.uk/";

    @Before
    public void openUp() {
        openBrowser(baseUrl);
    }

    //  @After
    public void tearDown() {
        closeBrowser();
    }

    @Test
    public void searchBox() throws InterruptedException {
        //accept coockies
        clickOnElement(By.id("sp-cc-accept"));

        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");
        clickOnElement(By.id("nav-search-submit-button"));

        //click on Dell box
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//span[@class='a-list-item']//a[@class='a-link-normal s-navigation-item']//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']//label//i[@class='a-icon a-icon-checkbox']"));

        // verify the 30 items
        int expectedItem = 30;

        List<WebElement> numberOfItems = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

        int numberOfItemsOnPage = numberOfItems.size();
        System.out.println("Number of item on page :" + numberOfItemsOnPage);
        System.out.println("");
        System.out.println("");
        System.out.println("List of item are as below:");
        Assert.assertEquals(expectedItem, numberOfItemsOnPage);

        //Print items in console
        for (WebElement webElement : numberOfItems) {
            String name = webElement.getText();
            System.out.println(name);
        }
    }
}
