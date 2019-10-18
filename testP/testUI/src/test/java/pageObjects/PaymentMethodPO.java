package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PaymentMethodPO extends BasePO {
    public PaymentMethodPO(WebDriver driver){
        super(driver);
    }


    /*---------------------------- Web Elements -----------------------------*/

    By paymentPageHeader = By.id("credit_card_header");

    /*---------------------------- Web Methods -----------------------------*/

    public void checkPaymentMethodIsDisplayed() {

        Assert.assertTrue(visibilityOfElement(paymentPageHeader), "Payment page header is snot visible.");


    }
}
