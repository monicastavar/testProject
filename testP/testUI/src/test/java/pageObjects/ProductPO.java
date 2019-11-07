package pageObjects;

import common.DataVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ProductPO extends BasePO {

    public ProductPO(WebDriver driver) {
        super(driver);

    }

    private static final Logger logger = LoggerFactory.getLogger( ProductPO.class);

    /*---------------------------- Web Elements -----------------------------*/

    By productPageTitle = By.cssSelector("h1.title");

    By addToCartButton = By.cssSelector(".button.add-cart");

    By confirmAddToCartButton = By.cssSelector("a[href=\"/shopcart\"]");


    /*---------------------------- Web Methods -----------------------------*/

    public void addProductToBasket() {
        checkCorrectProductPageIsOpened();
        clickElement(addToCartButton);
        waitElementToBeClickable(confirmAddToCartButton);
        clickElement(confirmAddToCartButton);
        logger.info( "..............Product added to backet............." );

    }

    public String getProductPageTitle() {
        return getTextOfElement(productPageTitle);
    }

    public void checkCorrectProductPageIsOpened() {
        int lastIndex = DataVariables.getProduct().length()-4;
        Assert.assertEquals(getProductPageTitle().substring(0, lastIndex), DataVariables.getProduct().substring(0, lastIndex), "Different product title is displayed on product page.");
    }

}
