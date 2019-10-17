package common;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {

    private WebDriver driver;
    private CheckoutPO checkoutPO;
    private FilterPO filterPO;
    private HomePagePO homePagePO;
    private MyDataPO myDataPO;
    private PaymentMethodPO paymentMethodPO;
    private ProductPO productPO;
    private SearchBarPO searchBarPO;
    private SearchResultsPO searchResultsPO;
    private ShopcartPO shopcartPO;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public CheckoutPO getCheckoutPageObject() {
        return (checkoutPO == null) ? checkoutPO = new CheckoutPO(driver) : checkoutPO;
    }

    public HomePagePO getHomenPageObject() {
        return (homePagePO == null) ? homePagePO = new HomePagePO(driver) : homePagePO;
    }

    public HomePagePO getSearchBarPageObject() {
        return (homePagePO == null) ? homePagePO = new HomePagePO(driver) : homePagePO;
    }

    public HomePagePO getSearchResultsPageObject() {
        return (homePagePO == null) ? homePagePO = new HomePagePO(driver) : homePagePO;
    }
}
