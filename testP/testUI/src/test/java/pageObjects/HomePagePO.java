package pageObjects;

import common.FileReader;
import org.openqa.selenium.WebDriver;

public class HomePagePO extends BasePO {

    public HomePagePO(WebDriver driver) {
        super(driver);
    }



    /*---------------------------- Web Elements -----------------------------*/


    /*---------------------------- Web Methods -----------------------------*/

    public void openHomePage() {
        FileReader fileReader = new FileReader();
        driver.get(fileReader.getProperty("url"));
//        driver.get("https://www.rakuten.de");
    }
}
