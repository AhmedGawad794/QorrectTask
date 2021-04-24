package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyOrderScreen extends BasePages {
    public MyOrderScreen(WebDriver driver) { super(driver); }
    private By orderReferenceColumnValuesIdentifier = By.xpath("//td[contains(@class, 'history_link')]");
    List<WebElement> orderReferenceColumnValuesList;
    public int GetNumberOfOrders(){
        orderReferenceColumnValuesList = driver.findElements(orderReferenceColumnValuesIdentifier);
        return orderReferenceColumnValuesList.size();
    }
}
