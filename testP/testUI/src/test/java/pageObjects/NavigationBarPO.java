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

    private final Logger LOGGER = LoggerFactory.getLogger(HomePagePO.class);

    public NavigationBarPO(WebDriver driver) {
        super(driver);

}

    /*---------------------------- Web Elements -----------------------------*/

    By searchBox = By.id("search-input");

    By searchButton = By.className("button-search");

    By loginButton = By.cssSelector("a[href='/kundenkonto']");

    By greetingsMessage = By.className("message");

    By userNameLabel = By.className("name");

    /*---------------------------- Web Methods -----------------------------*/


    private List<WebElement> searchMatchingProducts(String searchTerm) {
        inputText(searchBox, searchTerm);
        By suggestionList = By.xpath("//*[contains(text(),'" + searchTerm + "')]");
        waitElement(suggestionList);
        return driver.findElements(suggestionList);
    }

    private void selectSomeProductFromList(List<WebElement> list) {
        WebElement product = list.get(list.size() / 2);
        DataVariables.setProduct(product.getText());
        LOGGER.debug("..............Clicking on " + product.getText() + " from suggestion list.");
        product.click();
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
