package pageObjects;

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

    By searchBox = By.name("uid");

    By searchButton = By.name("password");

    By suggestionList = By.name("btnLogin");


    /*---------------------------- Web Methods -----------------------------*/

    public void verifySearchresultpageIsOpened(){

    }

//    public SearchResultsPO(WebDriver driver){
//        this.driver = driver;
//    }
//}


}