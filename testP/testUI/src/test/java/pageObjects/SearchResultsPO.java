package pageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPO extends BasePO {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /*---------------------------- Web Elements -----------------------------*/

    By pageTitle = By.cssSelector(".search-title .term");


    /*---------------------------- Web Methods -----------------------------*/

    public void verifySearchresultpageIsOpened(String productName) {

        String url = driver.getCurrentUrl();
        url = url.replace("%20", "");
        String title = driver.findElement(pageTitle).getText();

        Assert.assertTrue("Browser url doesn't contain " + productName + ", instead it's " + url, url.contains(productName));
        Assert.assertTrue("Page title url doesn't contain " + productName + ", instead it's " + title, title.contains(productName));

    }

//    public SearchResultsPO(WebDriver driver){
//        this.driver = driver;
//    }
//}


}