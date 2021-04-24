package Base;

import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.SigninPage;

import static org.testng.Assert.assertTrue;

public class CreateNewAccountTests extends BaseTests {

    /*
     This class for testing purposes only, you can find the required test cases on OrdersTests class
     */

    //region Declaring variables
    private final int trialNumber = (int) GetExcelNumericData(1,0);
    private final String registrationMail = GetExcelStringData(1,1);
    private final int gender = (int) GetExcelNumericData(1,4);
    private final String firstName = GetExcelStringData(1,5);
    private final String lastName = GetExcelStringData(1,6);
    private final String password = String.valueOf(GetExcelNumericData(1,3)) ;
    private final String _addressFirstName = GetExcelStringData(1,7);
    private final String _addressLastName = GetExcelStringData(1,8);
    private final String address = GetExcelStringData(1,9) + trialNumber;
    private final String city = GetExcelStringData(1,10) + trialNumber;
    private final String postalCode = String.valueOf((int) GetExcelNumericData(1,11));
    private final String mobileNumber = String.valueOf((int) GetExcelNumericData(1,12)) + trialNumber;
    private final String aliasAddress = GetExcelStringData(1,13) + trialNumber;
    //endregion
    @Test
    public void ValidateThatUserCanCreateNewAccount(){
        homePage.clickLoginButton();
        signinPage.InsertRegistrationMail(registrationMail);
        signinPage.ClickCreateAccountButton();
        accountCreationPage.FillRegistrationForm(gender, firstName, lastName, password, _addressFirstName, _addressLastName, address, city, postalCode, mobileNumber, aliasAddress);
        accountCreationPage.ClickRegisterButton();
        assertTrue(myAccountPage.IsMyAccountPageDisplayed());
    }
    @Test
    public void ValidateThatUserCanLoginWithRecentlyCreatedAccount(){
        SigninPage signinPage = homePage.clickLoginButton();
        MyAccountPage myAccountPage = signinPage.Signin(registrationMail, password);
        assertTrue(myAccountPage.IsMyAccountPageDisplayed());
    }
}
