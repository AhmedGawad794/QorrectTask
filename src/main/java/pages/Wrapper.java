package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class Wrapper {

    //region Instance of used classes
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Random random;
    //endregion

    //region Constructor of the class
    public Wrapper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
        random = new Random();
    }
    //endregion

    //region Methods to manipulate web elements
    //usually wait for element to be clickable before clicking it, scroll element into view before interacting with it etc..
    /**
     * @param element the locator of the field
     * @param text the text to be passed to the field
     */
    public void SendTextToElement(By element, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }
    /**
     * @param element the locator of the field
     * @param Driver the driver
     */
    public void ScrollElementToBeVisible(WebDriver Driver, By element){
        JavascriptExecutor executor = (JavascriptExecutor)Driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", Driver.findElement(element));
    }
    /**
     * @param button the locator of the button
     */
    public void ClickButton(By button){
        wait.until(ExpectedConditions.elementToBeClickable(button));
        ScrollElementToBeVisible(driver, button);
        driver.findElement(button).click();
    }
    /**
     * @param button the locator of the button
     * @param numOfButtonInTheDOM the number of button on the page starting from 0
     */
    public void ClickButton(By button, int numOfButtonInTheDOM){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(button));
        driver.findElements(button).get(numOfButtonInTheDOM).click();
    }
    /**
     * @param button the locator of the button
     */
    public void SubmitButton(By button){
        wait.until(ExpectedConditions.elementToBeClickable(button));
        ScrollElementToBeVisible(driver, button);
        driver.findElement(button).submit();
    }
    /**
     * @param button the locator of the button
     * @param Driver the driver
     */
    public void ClickButtonUsingJavaScript(WebDriver Driver, By button){
        JavascriptExecutor executor = (JavascriptExecutor)Driver;
        executor.executeScript("arguments[0].click();", Driver.findElement(button));
    }
    /**
     * @param button the locator of the button
     */
    public void ClickElementUsingActionsClass(By button){
        wait.until(ExpectedConditions.elementToBeClickable(button));
        actions.moveToElement(driver.findElement(button)).click().perform();
    }
    /**
     * @param element the locator of the element
     */
    public Boolean IsElementDisplayed(By element){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        return driver.findElement(element).isDisplayed();
    }
    /**
     * this method chooses random integer number from 1 to maximum number
     * @param maxNumber the maximum number to be chosen
     */
    public int ChooseRandomNumber(int maxNumber){
        return random.nextInt(maxNumber);
    }
    //endregion
}
