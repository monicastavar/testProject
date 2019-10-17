package pageObjects;

import common.FileReader;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePagePO extends BasePO {

    Modals modal = new Modals(driver);
    private final Logger LOGGER = LoggerFactory.getLogger(HomePagePO.class);


    public HomePagePO(WebDriver driver) {
        super(driver);
    }

    /*---------------------------- Web Elements -----------------------------*/


    /*---------------------------- Web Methods -----------------------------*/

    public void openHomePage() {
        FileReader fileReader = new FileReader();
        String url = fileReader.getProperty("url");
        driver.get(url);
        LOGGER.info("..............Page " + url + " is Launched.............");
        modal.acceptCookie();
    }
}
