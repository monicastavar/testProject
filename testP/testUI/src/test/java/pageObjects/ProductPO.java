package pageObjects;

import common.DataVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPO extends BasePO {

    public ProductPO(WebDriver driver) {
        super(driver);

    }

    /*---------------------------- Web Elements -----------------------------*/

    By productPageTitle = By.cssSelector("h1.title");

    By addToCartButton = By.cssSelector(".button.add-cart");

    By confirmAddToCartButton = By.cssSelector("a[href=\"/shopcart\"]");


    /*---------------------------- Web Methods -----------------------------*/

    public void addProductToBasket() {
        checkCorrectProductPageIsOpened();
        clickElement(addToCartButton);
        waitElement(confirmAddToCartButton);
        clickElement(confirmAddToCartButton);
    }

    public String getProductPageTitle() {
        return getTextOfElement(productPageTitle);
    }

    public void checkCorrectProductPageIsOpened() {
        Assert.assertEquals(getProductPageTitle().substring(0, 60), DataVariables.getProduct().substring(0, 60), "Different product title is displayed on product page.");
    }

}
