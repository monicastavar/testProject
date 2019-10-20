package tests;

import common.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;

import pageObjects.*;

public class BaseTest {

	private WebDriver driver;
	private FileReader fileReader = new FileReader();
	HomePagePO homePage;
	SearchResultsPO searchResultsPage;
	NavigationBarPO navigationBar;
	ProductPO productPage;
	ShopcartPO shopcartPage;
	OrderSummaryPO orderSummaryPage;
	MyDataPO myDataPage;
	CheckoutSummaryPO checkoutSummaryPage;
	CheckoutAddressPO checkoutAddressPage;
	PaymentMethodPO paymentMethodPage;
	LoginPO loginPage;
	private static final Logger logger = LoggerFactory.getLogger( BaseTest.class );

	@BeforeMethod
	public void setup() {

		logger.debug( "..............Setting webdriver............." );

		String driverType = fileReader.getProperty( "driver" );
		if ( "FIREFOX".equals( driverType ) ) {
			driver = new FirefoxDriver();
		} else if ( "IE".equals( driverType ) ) {
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty( "webdriver.chrome.driver", fileReader.getProperty( "chromeDriverPath" ) );
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		homePage = new HomePagePO( driver );
		searchResultsPage = new SearchResultsPO( driver );
		navigationBar = new NavigationBarPO( driver );
		productPage = new ProductPO( driver );
		shopcartPage = new ShopcartPO( driver );
		orderSummaryPage = new OrderSummaryPO( driver );
		myDataPage = new MyDataPO( driver );
		checkoutSummaryPage = new CheckoutSummaryPO( driver );
		checkoutAddressPage = new CheckoutAddressPO( driver );
		paymentMethodPage = new PaymentMethodPO( driver );
		loginPage = new LoginPO( driver );
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
		logger.debug( "..............Diver closed............." );

	}
}
