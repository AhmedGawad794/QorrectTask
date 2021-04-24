package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage extends HomePage{
    //region constructor
    public SigninPage(WebDriver driver) { super(driver); }
    //endregion

    //region Locators
    private final By registrationMailField = By.id("email_create");
    private By CreateAccountButton = By.id("SubmitCreate");
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By signinButton = By.id("SubmitLogin");
    //endregion

    public void InsertRegistrationMail(String registrationMail) {
        wrapper.SendTextToElement(registrationMailField, registrationMail);
    }
    public AccountCreationPage ClickCreateAccountButton(){
        wrapper.SubmitButton(CreateAccountButton);
        return new AccountCreationPage(driver);
    }
    public MyAccountPage Signin(String email, String password){
        wrapper.SendTextToElement(emailField, email);
        wrapper.SendTextToElement(passwordField, password);
        wrapper.ClickElementUsingActionsClass(signinButton);
        return new MyAccountPage(driver);
    }
}
