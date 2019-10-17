package tests;

import common.PageObjectManager;
import org.testng.annotations.Test;
import pageObjects.HomePagePO;
import pageObjects.SearchBarPO;
import pageObjects.SearchResultsPO;

public class SearchTests extends BaseTest {


//    HomePagePO homePage;




    //wait for autocompleted list to appear
    //select any item
//    verify that Search Results Page is opened    Resultpage

    @Test
    public void searchMobileItems() {
        homePage.openHomePage();
        String p = searchBar.searchForMatchingProducts("mobile");
        searchResultsPage.verifySearchresultpageIsOpened(p);
    }

}
