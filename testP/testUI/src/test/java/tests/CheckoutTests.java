package tests;

import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    /*Write an automated test,testest that starts from Product selection, goes through Checkout and ends on “Select
   payment Method” Page (“Zahlungsart wählen”). You do not need to purchase a product. */
    @Test
    public void validateCheckoutProcess() {
        homePage.openHomePage();
        homePage.selectFirstProduct();
        productPage.addProductToBasket();
        shopcartPage.checkShopcart();
        orderSummaryPage.clickOnGoToCheckout();
        myDataPage.selectGuestOption();
        checkoutSummaryPage.selectGoToNextStep();//
        checkoutAddressPage.fillInAddressForm();
        checkoutSummaryPage.selectGoToNextStep();
        paymentMethodPage.checkPaymentMethodIsDisplayed();
    }
}