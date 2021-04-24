package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePages{
    //private WebDriver driver;
    private By signinButton = By.xpath("//*[@class ='login']");
    private By dressesButton = By.xpath("//a[@title='Dresses']");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void WaitForHomePageToBeLoaded(){
        wait.until(ExpectedConditions.elementToBeClickable(signinButton));
    }

    public SigninPage clickLoginButton(){
        wrapper.ClickButton(signinButton);
        return new SigninPage(driver);
    }
    public DressesPage ClickDressesButton(){
        wrapper.ClickButton(dressesButton, 1);
        return new DressesPage(driver);
    }
}
