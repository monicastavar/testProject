package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderSummaryPO extends BasePO {

    public OrderSummaryPO(WebDriver driver){
        super(driver);
    }

    private static final Logger logger = LoggerFactory.getLogger( OrderSummaryPO.class);

    /*---------------------------- Web Elements -----------------------------*/

    By goToCheckoutButton = By.className("tr_cart_overview_gotocheckout");

    /*---------------------------- Web Methods -----------------------------*/


    public void clickOnGoToCheckout() {
        waitElement(goToCheckoutButton);
        clickElement(goToCheckoutButton);
        logger.info( "..............Checkout started............." );

    }
}
