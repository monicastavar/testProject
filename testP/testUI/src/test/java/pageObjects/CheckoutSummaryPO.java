package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSummaryPO extends BasePO {

	public CheckoutSummaryPO( WebDriver driver ) {
		super( driver );
	}

	/*---------------------------- Web Elements -----------------------------*/

	By nextButton = By.id( "go_to_next_step" );


	/*---------------------------- Web Methods -----------------------------*/

	public void selectGoToNextStep() {
		waitElement( nextButton );
		clickElement( nextButton );
	}
}
