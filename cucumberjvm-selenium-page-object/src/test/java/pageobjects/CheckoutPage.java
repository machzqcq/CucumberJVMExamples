package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage extends BaseClass{
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.CLASS_NAME, using="special-price")
	public static WebElement unit_price;
	
	@FindBy(how=How.ID, using="total_price")
	public static WebElement total_price;
	@FindBy(how=How.ID, using="Proceed to checkout")
	public static WebElement proceed_to_checkout;
	



}
