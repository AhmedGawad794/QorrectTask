package Base;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrdersTests extends BaseTests {

    //region Declaring variables and read from excel data
    private final int trialNumber = (int) GetExcelNumericData(1,0);
    private final String registrationMail = GetExcelStringData(1,1);
    private final int gender = (int) GetExcelNumericData(1,4);
    private final String firstName = GetExcelStringData(1,5);
    private final String lastName = GetExcelStringData(1,6);
    private final String password = String.valueOf((int) GetExcelNumericData(1,3));
    private final String _addressFirstName = GetExcelStringData(1,7);
    private final String _addressLastName = GetExcelStringData(1,8);
    private final String address = GetExcelStringData(1,9) + trialNumber;
    private final String city = GetExcelStringData(1,10) + trialNumber;
    private final String postalCode = String.valueOf((int) GetExcelNumericData(1,11));
    private final String mobileNumber = String.valueOf((int) GetExcelNumericData(1,12)) + trialNumber;
    private final String aliasAddress = GetExcelStringData(1,13) + trialNumber;
    private final String checkPaymentMethod = GetExcelStringData(1,14);
    private final String wirePaymentMethod = GetExcelStringData(2,14);
    private final String signinEmail = GetExcelStringData(1,2);
    private final int size = (int) GetExcelNumericData(3,15);
    //endregion

    @Test
    public void CreateNewAccountThenCreateOrder(){
        homePage.clickLoginButton();
        signinPage.InsertRegistrationMail(registrationMail);
        signinPage.ClickCreateAccountButton();
        accountCreationPage.FillRegistrationForm(gender, firstName, lastName, password, _addressFirstName, _addressLastName, address, city, postalCode, mobileNumber, aliasAddress);
        accountCreationPage.ClickRegisterButton();
        myAccountPage.ClickHomePageButton();
        homePage.ClickDressesButton();
        dressesPage.FillDressesPageSteps();
        productPage.ExecuteProductPageSteps(size);
        //This step only displayed while testing manually and does not display while running the automation script so it's commented.
        //productPage.ClickProceedToCheckoutButton();
        orderScreen.ExecuteOrderScreenSteps(checkPaymentMethod);
        int currentNumberOfOrders = myOrderScreen.GetNumberOfOrders();
        assertEquals(currentNumberOfOrders, 1);
    }
    @Test
    public void LoginAndCreateOrder(){
        homePage.clickLoginButton();
        signinPage.Signin(signinEmail, password);
        myAccountPage.ClickHomePageButton();
        homePage.ClickDressesButton();
        dressesPage.FillDressesPageSteps();
        productPage.ExecuteProductPageSteps(size);
        //This step only displayed while testing manually and does not display while running the automation script so it's commented.
        //productPage.ClickProceedToCheckoutButton();
        orderScreen.ExecuteOrderScreenSteps(wirePaymentMethod);
        int currentNumberOfOrders = myOrderScreen.GetNumberOfOrders();
        assertTrue(currentNumberOfOrders >= 1);
    }
}
