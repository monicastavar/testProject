package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Modals extends BasePO {

    public Modals(WebDriver driver) {
        super(driver);

    }

    /*---------------------------- Web Elements -----------------------------*/

    By btnAcceptCookie = By.id("consent_prompt_submit");


    /*---------------------------- Web Methods -----------------------------*/
    public void acceptCookie() {
        if (driver.findElement(btnAcceptCookie).isDisplayed()){
            driver.findElement(btnAcceptCookie).click();
        }
    }
}
