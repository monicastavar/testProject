package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutAddressPO extends BasePO {

	public CheckoutAddressPO( WebDriver driver ) {
		super( driver );
	}

	private static final Logger logger = LoggerFactory.getLogger( CheckoutAddressPO.class);

	/*---------------------------- Web Elements -----------------------------*/

	By genderDropdown = By.className( "gender-container" );  //#gender
	By genderOptionFemale = By.xpath( "//a[contains(text(),'Frau')]" );
	By firstNameInputFiled = By.id( "first-name" );
	By lastNameInputFiled = By.id( "last-name" );
	By streetNameInputField = By.id( "street" );
	By streetNoInputField = By.id( "street-number" );
	By emailInputField = By.id( "email" );
	By zipCodeInputField = By.id( "zip-code" );
	By cityInputField = By.id( "city" );
	By agrementCheckbox = By.id( "privacy" );
	By monthInputField = By.id( "invoice-month-container" );
	By dayInputField = By.id( "invoice-day-container" );
	By yearInputField = By.id( "invoice-year-container" );
	By firstDay = By.cssSelector( "#invoice-day-container a[index='1']" );
	By firstMonth = By.cssSelector( "#invoice-month-container a[index='1']" );
	By firstYear = By.cssSelector( "#invoice-year-container a[index='1']" );

	/*---------------------------- Web Methods -----------------------------*/

	public void fillInAddressForm() {
		fillInMandatoryFields();
		agreeTermsOfUse();
		logger.info( "..............Filled in address form............." );
	}

	private void fillInMandatoryFields() {
		clickElement( genderDropdown );
		waitElement( genderOptionFemale );
		clickElement( genderOptionFemale );
		inputText( firstNameInputFiled, "testFirstName" );
		inputText( lastNameInputFiled, "testLastname" );
		inputText( streetNameInputField, "Auf der Ziehmark" );
		inputText( streetNoInputField, "8" );
		inputText( emailInputField, "test@test.com" );
		inputText( zipCodeInputField, "35075" );
		inputText( cityInputField, "Gladenbach" );

		clickElement( dayInputField );
		waitElement( firstDay );
		clickElement( firstDay );
		clickElement( monthInputField );
		waitElement( firstMonth );
		clickElement( firstMonth );
		clickElement( yearInputField );
		waitElement( firstYear );
		clickElement( firstYear );
	}

	private void agreeTermsOfUse() {

		clickElement( agrementCheckbox );
	}
}
