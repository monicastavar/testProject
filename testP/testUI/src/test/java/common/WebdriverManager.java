package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebdriverManager {
    private WebDriver driver;
    private String driverType;
    private FileReader fileReader= new FileReader();


    public WebdriverManager() {
        driverType = fileReader.getProperty("driver");
    }


    public WebDriver getDriver() {
        if (driver == null){
            if ("FIREFOX".equals(driverType)) {
                driver = new FirefoxDriver();
            } else if ("IE".equals(driverType)) {
                driver = new InternetExplorerDriver();
            } else {
                System.setProperty("webdriver.chrome.driver", fileReader.getProperty("chromeDriverPath"));
                driver = new ChromeDriver();
            }
        }
        return driver;
    }


    public void closeDriver() {
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
}
