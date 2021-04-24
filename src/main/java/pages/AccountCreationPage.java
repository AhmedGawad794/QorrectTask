package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class AccountCreationPage extends SigninPage{
    protected Select select;

    //region constructor
    public AccountCreationPage(WebDriver driver) { super(driver); }
    //endregion

    //region Locator
    private By genderMaleValue = By.id("id_gender1");
    private By genderFemaleValue = By.id("id_gender2");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By BirthDayDropdown = By.id("days");
    private By BirthMonthDropdown = By.id("months");
    private By BirthYearDropdown = By.id("years");
    List<WebElement> DropDownListValues;
    private By newsCheckBox = By.id("newsletter");
    private By offersCheckBox = By.id("optin");
    private By addressFirstNameField = By.id("firstname");
    private By addressLastNameField = By.id("lastname");
    private By addressField = By.id("address1");
    private By cityField = By.id("city");
    private By postalCodeField = By.id("postcode");
    private By mobileNumberField = By.id("phone_mobile");
    private By homePhoneNumberField = By.id("phone");
    private By stateDropdown = By.id("id_state");
    private By aliasAddressField = By.id("alias");
    private By registerButton = By.id("submitAccount");
    //endregion

    /**
     * This methods chooses gender and takes 1 for male or 2 for female
     * If any other value passed to this method, an error message will be displayed in the console
     * @param gender takes 1 for male or 2 for female
     */
    public void ChooseGender(int gender){
        switch (gender){
            case 1:
                wrapper.ClickButton(genderMaleValue);
                break;
            case 2:
                wrapper.ClickButton(genderFemaleValue);
                break;
            default:
                System.out.println("Invalid gender value, you should insert 1 for Mr or 2 for Mrs");
        }
    }

    /**
     * This methods takes dropdown list name and returns it as a web element
     * @param _dropdownType 'day' or 'month' or 'year' or 'state'
     * @return inserted dropdown web element
     */
    private WebElement SetDropdownType(String _dropdownType){
        switch (_dropdownType.toLowerCase()){
            case "day":
                return driver.findElement(BirthDayDropdown);
            case "month":
                return driver.findElement(BirthMonthDropdown);
            case "year":
                return driver.findElement(BirthYearDropdown);
            case "state":
                return driver.findElement(stateDropdown);
            default:
                System.out.println("Invalid dropdown value, kindly insert 'day' or 'month' or 'year' or 'state'");
                return null;
        }
    }

    /**
     * This methods chooses a random value of dropdown Web element
     * the random value boundaries between 1 and drop down list size - 1
     * @param _dropdownType 'day' or 'month' or 'year' or 'state'
     */
    private void SelectDropdownValue(String _dropdownType){
        WebElement dropdownType = SetDropdownType(_dropdownType);
        select = new Select(dropdownType);
        DropDownListValues = select.getOptions();
        int valueToBeSelected = wrapper.ChooseRandomNumber(DropDownListValues.size());
        if (valueToBeSelected ==1){
            valueToBeSelected =2;
        }
        select.selectByIndex(valueToBeSelected);
    }

    /**
     * This methods makes 19 steps inside the Account registration form by filling all form fields
     * @param gender 1,2
     * @param firstName string only
     * @param lastName string only
     * @param password not less than 5 chars
     * @param _addressFirstName string only
     * @param _addressLastName string only
     * @param address string only
     * @param city string only
     * @param postalCode 5 integers only
     * @param mobileNumber integers only
     * @param aliasAddress string only
     */
    public void FillRegistrationForm(int gender,
                                     String firstName,
                                     String lastName,
                                     String password,
                                     String _addressFirstName,
                                     String _addressLastName,
                                     String address,
                                     String city,
                                     String postalCode,
                                     String mobileNumber,
                                     String aliasAddress){
        ChooseGender(gender);
        wrapper.SendTextToElement(firstNameField, firstName);
        wrapper.SendTextToElement(lastNameField, lastName);
        wrapper.SendTextToElement(passwordField, password);
        SelectDropdownValue("day");
        SelectDropdownValue("month");
        SelectDropdownValue("year");
        wrapper.ClickButtonUsingJavaScript(driver, newsCheckBox);
        wrapper.ClickButtonUsingJavaScript(driver, offersCheckBox);
        wrapper.SendTextToElement(addressFirstNameField, _addressFirstName);
        wrapper.SendTextToElement(addressLastNameField, _addressLastName);
        wrapper.SendTextToElement(addressField, address);
        wrapper.SendTextToElement(cityField, city);
        wrapper.SendTextToElement(postalCodeField, postalCode);
        SelectDropdownValue("state");
        wrapper.SendTextToElement(mobileNumberField, mobileNumber);
        wrapper.SendTextToElement(homePhoneNumberField, mobileNumber);
        wrapper.SendTextToElement(aliasAddressField, aliasAddress);
    }

    public MyAccountPage ClickRegisterButton(){
        wrapper.ClickButton(registerButton);
        return new MyAccountPage(driver);
    }
}
