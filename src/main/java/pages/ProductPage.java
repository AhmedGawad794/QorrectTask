package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePages{

    //region constructor
    public ProductPage(WebDriver driver) { super(driver); }
    //endregion

    //region Locators
    private By orangeColor = By.xpath("//*[@id='color_13'][@name='Orange']");
    private By sizeDropDownList = By.name("group_1");
    private By addToCartButton = By.name("Submit");
    private By proceedToCheckoutButton = By.xpath("//*[@title='Proceed to checkout']");
    //endregion

    private void SelectColor(){
        wrapper.ClickButton(orangeColor);
    }

    /**
     * This methods selects by value from the drop down list
     * @param _size takes only 1,2 or 3 as these are the exact values in the DOM for small,medium & large
     */
    private void SelectSize(int _size){
        Select select = new Select(driver.findElement(sizeDropDownList));
        switch (_size){
            case 1:
                select.selectByValue("1");
                break;
            case 2:
                select.selectByValue("2");
                break;
            case 3:
                select.selectByValue("3");
                break;
            default:
                System.out.println("Invalid value, the size drop down list has only 3 values 1 for small, 2 for medium and 3 for large");
                break;
        }
    }
    private void ClickAddToCartButton(){
        wrapper.SubmitButton(addToCartButton);
    }
    public OrderScreen ClickProceedToCheckoutButton(){
        wrapper.ClickButton(proceedToCheckoutButton);
        return new OrderScreen(driver);
    }

    /**
     * Instead of making 3 lines of code in the test class, this method select color, size, and clicks add to cart button
     * @param _size
     * @return
     */
    public OrderScreen ExecuteProductPageSteps(int _size) {
        SelectColor();
        SelectSize(_size);
        ClickAddToCartButton();
        return new OrderScreen(driver);
    }
}
