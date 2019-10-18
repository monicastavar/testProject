package pageObjects;

import common.DataVariables;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPO extends BasePO {


    public SearchResultsPO(WebDriver driver) {
        super(driver);

    }

    /*---------------------------- Web Elements -----------------------------*/

    By pageTitle = By.cssSelector(".search-title .term");


    /*---------------------------- Web Methods -----------------------------*/

    public void verifySearchResultPageIsOpened() {

        String url = driver.getCurrentUrl();
        url = url.replace("%20", "");
        String title = getTextOfElement(pageTitle);
        String product = DataVariables.getProduct();

        Assert.assertTrue("Browser url doesn't contain " + product + ", instead it's " + url, url.contains(product));
        Assert.assertTrue("Page title url doesn't contain " + product + ", instead it's " + title, title.contains(product));

    }
}