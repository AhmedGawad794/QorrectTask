package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

public class BaseTests {

    //region Declaring Variables
    protected WebDriver driver;
    protected HomePage homePage;
    protected SigninPage signinPage;
    protected AccountCreationPage accountCreationPage;
    protected MyAccountPage myAccountPage;
    protected DressesPage dressesPage;
    protected ProductPage productPage;
    protected OrderScreen orderScreen;
    protected MyOrderScreen myOrderScreen;
    protected ReadDataFromExcel readDataFromExcel;
    public String GetExcelStringData(int rowNumber, int columnNumber){
        String projectPath = System.getProperty("user.dir");
        readDataFromExcel = new ReadDataFromExcel( projectPath + "/resources/Data.xlsx", "Sheet1");
        return readDataFromExcel.GetCellDataAsString(rowNumber, columnNumber);
    }
    public double GetExcelNumericData(int rowNumber, int columnNumber){
        String projectPath = System.getProperty("user.dir");
        readDataFromExcel = new ReadDataFromExcel( projectPath + "/resources/Data.xlsx", "Sheet1");
        return readDataFromExcel.GetCellDataAsNumericValues(rowNumber, columnNumber);
    }
    //endregion

    @BeforeClass
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        homePage = new HomePage(driver);
        signinPage = new SigninPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        dressesPage = new DressesPage(driver);
        productPage = new ProductPage(driver);
        orderScreen = new OrderScreen(driver);
        myOrderScreen = new MyOrderScreen(driver);
    }
    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
