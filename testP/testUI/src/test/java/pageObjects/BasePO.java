package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePO {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePO (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
    }

}
