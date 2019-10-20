package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import common.FileReader;

public class BasePO {

	WebDriver driver;
	private WebDriverWait wait;
	private static final Logger logger = LoggerFactory.getLogger( BasePO.class);

	public BasePO( WebDriver driver ) {
		this.driver = driver;
		wait = new WebDriverWait( driver, 15 );
	}

	public void waitElement( By locator ) {
		wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) );
	}

	public void clickElement( By locator ) {
		driver.findElement( locator ).click();
	}

	public void inputText( By locator, String text ) {
		driver.findElement( locator ).sendKeys( text );
	}

	public String getTextOfElement( By locator ) {
		return driver.findElement( locator ).getText();
	}

	public boolean visibilityOfElement( By locator ) {
		return driver.findElement( locator ).isDisplayed();
	}

	public void openPage(String page) {
		Modals modal = new Modals(driver);
		FileReader fileReader = new FileReader();

		String url = fileReader.getProperty(page);
		driver.get( url );
		logger.info( "..............Page " + url + " is Launched............." );
		modal.acceptCookie();
	}
}
