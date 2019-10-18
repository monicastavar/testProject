package pageObjects;

import common.DataVariables;
import common.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public class HomePagePO extends BasePO {

    Modals modal = new Modals(driver);
    private static final Logger LOGGER = Logger.getLogger(HomePagePO.class);


    public HomePagePO(WebDriver driver) {
        super(driver);
    }

    /*---------------------------- Web Elements -----------------------------*/

    By firstSuggestedName = By.xpath("(.//*[@class=\"vw-productSlider\"]//div[@class=\"name\"])[1]");
    By firstSuggestedProduct = By.xpath("(.//*[@class=\"vw-productSlider\"]//a)[1]");

    /*---------------------------- Web Methods -----------------------------*/

    public void openHomePage() {
        FileReader fileReader = new FileReader();
        String url = fileReader.getProperty("url");
        driver.get(url);
        LOGGER.debug("..............Page " + url + " is Launched.............");
        modal.acceptCookie();
    }

    public void selectFirstProduct() {

        DataVariables.setProduct(getTextOfElement(firstSuggestedName));
        clickElement(firstSuggestedProduct);

    }


}
