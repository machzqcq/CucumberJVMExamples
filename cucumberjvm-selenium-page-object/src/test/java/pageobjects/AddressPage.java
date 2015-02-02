package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddressPage extends BaseClass{
	
	public AddressPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.CLASS_NAME, using="page-heading")
	public static WebElement page_heading;
	
	
	@FindBy(how=How.NAME, using="message")
	public static WebElement message;
	
	@FindBy(how=How.NAME, using="processAddress")
	public static WebElement proceed_to_checkout;
	

	



}
