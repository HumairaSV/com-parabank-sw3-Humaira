package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    //1.method to click on element
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    //2.method to send text to element
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    //3. method to get text from the element
    public String getTextFromElement(By by){
        WebElement actualText = driver.findElement(by);
        return actualText.getText();
    }
    //4.method to verify expected vs actual text
    public void verifyTextMessage(String message,String expected,By by){
        String actual = driver.findElement(by).getText();
        Assert.assertEquals(message, expected, actual);
    }
    //5. method to select visible text from dropdown for select class
    public void selectByVisibleTextFromDropDown(By by, String text){
       WebElement dropDown = driver.findElement(by);
       Select select = new Select(dropDown);
       select.selectByVisibleText(text);
    }
    //6. method to select by value from dropdown for select class
    public void selectByValueFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }
    //7. method to select by index from dropdown for select class
    public void selectByValueFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }
    //8. Select from dropdown and click
    public void selectFromDropDownAndClick(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement element : allOptions) {
            if (element.getText().equalsIgnoreCase(text)) {
                element.click();
                break;
            }
        }
    }
    //9. method to hover mouse on an element
    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    //10. method to hover mouse on an element and navigate to sub menu
    public void mouseHoverAndNavigateToSubMenu(By by1, By by2){
        Actions actions = new Actions(driver);
        WebElement ele1 = driver.findElement(by1);
        WebElement ele2 = driver.findElement(by2);
        actions.moveToElement(ele1).moveToElement(ele2).click().build().perform();
    }
    //11. method to hover mouse on an element and click on it
    public void mouseHoverAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement ele = driver.findElement(by);
        actions.moveToElement(ele).click().build().perform();
    }
    //12. method to drag and drop element
    public void dragAndDrop(By by1, By by2) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(by1);
        WebElement droppable = driver.findElement(by2);
        actions.dragAndDrop(draggable, droppable).build().perform();
    }
    //13. method to move slider element
    public void sliderAction(By by, int x, int y) {
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(by);
        actions.dragAndDropBy(slider, x, y).build().perform();
    }

}
