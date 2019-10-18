package tests;

import common.FileReader;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    //Write at least 3 automated acceptance tests for login.
    //login with valid credentials
    @Test
    public void loginWithEmail() {
        FileReader fileReader = new FileReader();
        String username = fileReader.getProperty("username");
        String password = fileReader.getProperty("password");
        String nameOfUser = fileReader.getProperty("nameOfUser");

        loginPage.openLoginPage();
        loginPage.loginWithCredentials(username,password);
        loginPage.checkLoginIsSuccessful(nameOfUser);
    }

    @Test
    public void loginWithNonMatchingCredentials() {
        loginPage.openLoginPage();
        loginPage.loginWithCredentials("badusername@test.com","somePassword");
        loginPage.validateNonMatchingCredentiaslErrorMessage();
    }

    //this test will fail. The username placeholder is stating that login accepts both e-mail and user id, however login by id doesn't work
    @Test
    public void loginWithRakutenUserID() {
        FileReader fileReader = new FileReader();
        String username = fileReader.getProperty("nameOfUser");
        String password = fileReader.getProperty("password");
        String nameOfUser = fileReader.getProperty("nameOfUser");

        loginPage.openLoginPage();
        loginPage.loginWithCredentials(username,password);
        loginPage.checkLoginIsSuccessful(nameOfUser);
    }

}
