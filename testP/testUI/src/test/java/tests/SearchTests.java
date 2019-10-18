package tests;

import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test
    public void searchMobileItems() {

        homePage.openHomePage();
        navigationBar.searchForMatchingProducts("mobile");
        searchResultsPage.verifySearchResultPageIsOpened();
    }
}
