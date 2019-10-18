package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyDataPO extends BasePO {

    public MyDataPO(WebDriver driver) {
        super(driver);
    }

    /*---------------------------- Web Elements -----------------------------*/

    By continueAsGuestRadiobutton = By.id("login-method1");


    /*---------------------------- Web Methods -----------------------------*/
    public void selectGuestOption() {

        waitElement(continueAsGuestRadiobutton);
        clickElement(continueAsGuestRadiobutton);
    }
}
