package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DressesPage extends BasePages{

    //region constructor
    public DressesPage(WebDriver driver) {
        super(driver);
    }
    //endregion

    //region Locators
    private By summerCategoryField = By.xpath("//a[contains(text(), 'Summer')][contains(@title, 'the perfect dress for summer.')]");
    private By selectedItemAddToCartButton = By.xpath("//a[@data-id-product='5'][@title='Add to cart']");
    private By viewProductButton = By.xpath("//span[contains(text(), 'More')]");
    private By listViewButton = By.xpath("//a[contains(@title, 'List')]");
    //endregion

    private void SelectSummerCategory(){
        wrapper.ClickButton(summerCategoryField, 0);
    }
    private void SelectListView() {
        wrapper.ClickElementUsingActionsClass(listViewButton);
    }
    private ProductPage ClickViewMoreButton(){
        wrapper.ClickButton(viewProductButton, 0);
        return new ProductPage(driver);
    }

    /**
     * This method doing the following steps:
     * 1) Select Summer Category
     * 2) Select List View
     * 3) Click View more button for a specific product and navigates to that product page.
     */
    public ProductPage FillDressesPageSteps(){
        SelectSummerCategory();
        SelectListView();
        ClickViewMoreButton();
        return new ProductPage(driver);
    }
}
