package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentMethodPage extends BaseClass{
	
	public PaymentMethodPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.CLASS_NAME, using="page-heading")
	public static WebElement page_heading;
	
	@FindBy(how=How.CLASS_NAME, using="bankwire")
	public static WebElement bank_wire;
	
	@FindBy(how=How.CLASS_NAME, using="cheque")
	public static WebElement check;


}
