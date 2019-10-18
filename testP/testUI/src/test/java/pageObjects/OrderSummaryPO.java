package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPO extends BasePO {

    public OrderSummaryPO(WebDriver driver){
        super(driver);
    }

    /*---------------------------- Web Elements -----------------------------*/

    By goToCheckoutButton = By.className("tr_cart_overview_gotocheckout");

    /*---------------------------- Web Methods -----------------------------*/


    public void clickOnGoToCheckout() {
        waitElement(goToCheckoutButton);
        clickElement(goToCheckoutButton);
    }
}
