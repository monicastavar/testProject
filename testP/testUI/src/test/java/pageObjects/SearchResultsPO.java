package pageObjects;

import common.DataVariables;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchResultsPO extends BasePO {


    public SearchResultsPO(WebDriver driver) {
        super(driver);
    }
    private static final Logger logger = LoggerFactory.getLogger( SearchResultsPO.class);


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