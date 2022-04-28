package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement move = driver.findElement(by);
        actions.moveToElement(move).build().perform();
    }


    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement select = driver.findElement(by);
        actions.moveToElement(select).build().perform();
        actions.moveToElement(select).click().build().perform();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();

    }
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
    public void selectByVisibleFromDropDown(By by , String text){
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);}
    public List<WebElement> listOfWebElementsList(By by) {
        return driver.findElements(by);}


}