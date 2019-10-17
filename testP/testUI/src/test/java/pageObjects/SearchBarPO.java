package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchBarPO extends BasePO {

    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger LOGGER = LoggerFactory.getLogger(HomePagePO.class);

    public SearchBarPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /*---------------------------- Web Elements -----------------------------*/

    By searchBox = By.id("search-input");

    By searchButton = By.className("button-search");

    /*---------------------------- Web Methods -----------------------------*/


    private List<WebElement> searchMatchingProducts(String searchTerm) {

        driver.findElement(searchBox).sendKeys(searchTerm);
        By suggestionList = By.xpath("//*[contains(text(),'" + searchTerm + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(suggestionList));
        List<WebElement> list = driver.findElements(suggestionList);
        return list;
    }

    private String selectSomeProductFromList(List<WebElement> list) {
        String searchedProduct = list.get(list.size() / 2).getText();
        LOGGER.debug("..............Clicking on " + searchedProduct + " from suggestion list.");
        list.get(list.size() / 2).click();
        return searchedProduct;
    }

    private void clickOnSearch() {
        driver.findElement(searchButton).click();
    }

    public String searchForMatchingProducts(String searchTerm) {
        String productName = selectSomeProductFromList(searchMatchingProducts(searchTerm));
        clickOnSearch();
        return productName;
    }
}
