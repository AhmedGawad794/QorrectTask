package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePages {
    protected WebDriver driver;
    public WebDriverWait wait;
    public Wrapper wrapper;

    public BasePages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver , 15);
        this.wrapper = new Wrapper(driver);
    }
}
