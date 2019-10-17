package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchBarPO extends BasePO {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchBarPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /*---------------------------- Web Elements -----------------------------*/

    By searchBox = By.name("uid");

    By searchButton = By.name("password");

    By suggestionList = By.name("btnLogin");


    /*---------------------------- Web Methods -----------------------------*/


    private List<WebElement> searchMatchingProducts(String searchTerm) {

        driver.findElement(searchBox).sendKeys(searchTerm);
        //wait for suggestion list
        wait.until(ExpectedConditions.elementToBeClickable(suggestionList));
        return driver.findElements(suggestionList);
    }

    private void selectSomeProductFromList(List<WebElement> list) {
        list.get(list.size() / 2).click();
    }

    public void clickOnSearch() {
        driver.findElement(searchButton).click();
    }

    public void searchForMatchingProducts(String searchTerm) {
        selectSomeProductFromList(searchMatchingProducts(searchTerm));

    }
}
