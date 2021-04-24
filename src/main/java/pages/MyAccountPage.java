package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends AccountCreationPage {
    public MyAccountPage(WebDriver driver) { super(driver); }
    private By myAccountLabel = By.xpath("//span[contains(text(),'My account')]");
    private By homePageButton = By.xpath("//a[contains(@title, 'Home')]");
    public Boolean IsMyAccountPageDisplayed(){
        return wrapper.IsElementDisplayed(myAccountLabel);
    }

    public HomePage ClickHomePageButton() {
        wrapper.ClickButton(homePageButton);
        return new HomePage(driver);
    }
}
