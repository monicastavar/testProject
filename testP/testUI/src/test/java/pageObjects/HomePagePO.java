package pageObjects;

import common.DataVariables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePagePO extends BasePO {

	public HomePagePO( WebDriver driver ) {
		super( driver );
	}
	private static final Logger logger = LoggerFactory.getLogger( HomePagePO.class);


	/*---------------------------- Web Elements -----------------------------*/

	By firstSuggestedName = By.xpath( "(.//*[@class=\"vw-productSlider\"]//div[@class=\"name\"])[1]" );
	By firstSuggestedProduct = By.xpath( "(.//*[@class=\"vw-productSlider\"]//a)[1]" );

	/*---------------------------- Web Methods -----------------------------*/

	public void selectFirstProduct() {
		DataVariables.setProduct( getTextOfElement( firstSuggestedName ) );
		clickElement( firstSuggestedProduct );
		logger.info( "..............Product " + firstSuggestedName + " selected............." );

	}
}
