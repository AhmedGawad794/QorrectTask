package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderScreen extends BasePages {
    public OrderScreen(WebDriver driver) { super(driver); }
    private By firstStepSubmitButton = By.xpath("//p[contains(@class,'cart_navigation clearfix')]/child::a");
    private By thirdStepSubmitButton = By.name("processAddress");
    private By fourthStepSubmitButton = By.name("processCarrier");
    private By fourthStepAgreeToTermsButton = By.id("cgv");
    private By payByCheckButton = By.xpath("//*[@title='Pay by check.']");
    private By payByWireButton = By.xpath("//*[@title='Pay by bank wire']");
    private By confirmOrderButton = By.xpath("//span[contains(text(), 'confirm')]");
    private By myOrdersButton = By.xpath("//a[contains(@title, 'My orders')]");
    private void ClickFirstStepSubmitButton(){
        wrapper.ClickButton(firstStepSubmitButton);
    }
    private void ClickThirdStepSubmitButton(){
        wrapper.SubmitButton(thirdStepSubmitButton);
    }
    private void ClickFourthStepSubmitButton(){
        wrapper.ClickButtonUsingJavaScript(driver, fourthStepSubmitButton);
    }
    private void ClickFourthStepAgreeToTermsButton(){
        wrapper.ClickButtonUsingJavaScript(driver, fourthStepAgreeToTermsButton);
    }
    private void SelectPaymentMethod(String paymentMethod){
        switch (paymentMethod.toLowerCase()){
            case "check":
                wrapper.ClickButton(payByCheckButton);
                break;
            case "wire":
                wrapper.ClickButton(payByWireButton);
                break;
            default:
                System.out.println("Invalid payment method, you should only insert check or wire as payment method");
        }
    }
    private void ClickConfirmOrderButton(){
        wrapper.ClickButtonUsingJavaScript(driver, confirmOrderButton);
    }
    private MyOrderScreen ClickMyOrderScreenButton(){
        wrapper.ClickButton(myOrdersButton);
        return new MyOrderScreen(driver);
    }
    public MyOrderScreen ExecuteOrderScreenSteps(String paymentMethod) {
        ClickFirstStepSubmitButton();
        ClickThirdStepSubmitButton();
        ClickFourthStepAgreeToTermsButton();
        ClickFourthStepSubmitButton();
        SelectPaymentMethod(paymentMethod);
        ClickConfirmOrderButton();
        ClickMyOrderScreenButton();
        return new MyOrderScreen(driver);
    }
}
