package tests;

import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test (groups = { "include" })
    public void searchMobileItems() {

        homePage.openPage("url");
        navigationBar.searchForMatchingProducts("mobile");
        searchResultsPage.verifySearchResultPageIsOpened();
    }
}
