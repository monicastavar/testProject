package pageObjects;

import common.FileReader;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public class LoginPO extends BasePO {
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    Modals modal = new Modals(driver);
    NavigationBarPO navbar = new NavigationBarPO(driver);
    private static final Logger LOGGER = Logger.getLogger(HomePagePO.class);

    /*---------------------------- Web Elements -----------------------------*/

    By usernameInputField = By.cssSelector("input[name='loginEmail']");

    By paswordInputField = By.cssSelector("input[name='loginPassword']");

    By submitButton = By.id("recaptcha-submit");

    By errorMessage = By.className("message-error");

    /*---------------------------- Web Methods -----------------------------*/
    public void openLoginPage() {
        FileReader fileReader = new FileReader();
        String url = fileReader.getProperty("loginUrl");
        driver.get(url);
        LOGGER.debug("..............Page " + url + " is Launched.............");
    }

    public void loginWithCredentials(String username, String password) {
        modal.acceptCookie();

        inputText(usernameInputField, username);
        inputText(paswordInputField, password);
        waitElement(submitButton);
        clickElement(submitButton);
    }

    public void checkLoginIsSuccessful(String name) {
        Assert.assertEquals("Name of user is not correctly displayed.", name, navbar.getUserLabelName());
        Assert.assertTrue("Greetings message is not displayed.", navbar.checkGreetingsMessage());
    }


    public void validateNonMatchingCredentiaslErrorMessage() {
        waitElement(errorMessage);
        Assert.assertEquals("Error message is not correctly displayed","Diese E-Mail-Passwort-Kombination ist uns nicht bekannt. Bitte korrigieren Sie Ihre Eingabe.",getTextOfElement(errorMessage));
    }
}



