package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePO {
    public WebDriver driver;
//    public WebDriverWait wait = new WebDriverWait(driver,15);

    public BasePO (WebDriver driver){
        this.driver = driver;
    }

}
