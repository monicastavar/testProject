package pageObjects;

import common.DataVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

public class NavigationBarPO extends BasePO {

    public NavigationBarPO(WebDriver driver) {
        super(driver);
}

    private static final Logger logger = LoggerFactory.getLogger( NavigationBarPO.class);


    /*---------------------------- Web Elements -----------------------------*/

    By searchBox = By.id("search-input");

    By searchButton = By.className("button-search");

    By loginButton = By.cssSelector("a[href='/kundenkonto']");

    By greetingsMessage = By.className("message");

    By userNameLabel = By.className("name");

    /*---------------------------- Web Methods -----------------------------*/


    private List<WebElement> searchMatchingProducts(String searchTerm) {
        logger.info( "..............Search for " + searchTerm +"............." );
        inputText(searchBox, searchTerm);
        logger.info( "..............Waiting for suggestion lists to load............." );
        By suggestionList = By.xpath("//*[contains(text(),'" + searchTerm + "')]");
        waitElement(suggestionList);
        return driver.findElements(suggestionList);
    }

    private void selectSomeProductFromList(List<WebElement> list) {
        WebElement product = list.get(list.size() / 2);
        DataVariables.setProduct(product.getText());
        product.click();
        logger.info( "..............Clicking on \" + product.getText() + \" ............." );
    }

    private void clickOnSearch() {
        driver.findElement(searchButton).click();
    }

    public void searchForMatchingProducts(String searchTerm) {
        List<WebElement> productList = searchMatchingProducts(searchTerm);
        selectSomeProductFromList(productList);
        clickOnSearch();
    }

    public String getUserLabelName(){
        waitElement(userNameLabel);
        return getTextOfElement(userNameLabel);
    }

    public boolean checkGreetingsMessage(){
        return visibilityOfElement(greetingsMessage);
    }
}
