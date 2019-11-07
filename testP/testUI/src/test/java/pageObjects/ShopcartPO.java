package pageObjects;

import common.DataVariables;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopcartPO extends BasePO {


    public ShopcartPO(WebDriver driver) {
        super(driver);

    }
    /*---------------------------- Web Elements -----------------------------*/

    By itemName = By.cssSelector(".checkout-item-description .item-text a");

    /*---------------------------- Web Methods -----------------------------*/
    public void checkShopcart() {
        waitElement(itemName);
        int lastIndex = DataVariables.getProduct().length()-4;

        String itemNameText = getTextOfElement(itemName);
        Assert.assertEquals("Checkout product is listed with another name", DataVariables.getProduct().substring(0,lastIndex),itemNameText.substring(0,lastIndex));
    }
}
