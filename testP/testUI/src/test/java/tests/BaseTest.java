package tests;

import common.FileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.HomePagePO;
import pageObjects.SearchBarPO;
import pageObjects.SearchResultsPO;

public class BaseTest {
    public WebDriver driver;
    private FileReader fileReader = new FileReader();
    HomePagePO homePage;
    SearchResultsPO searchResultsPage;
    SearchBarPO searchBar;


    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", fileReader.getProperty("chromeDriverPath"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePagePO(driver);
        searchResultsPage = new SearchResultsPO(driver);
        searchBar =  new SearchBarPO(driver);
    }

    @AfterClass
    public void teardown() {
        driver.close();
        driver.quit();
    }
}
