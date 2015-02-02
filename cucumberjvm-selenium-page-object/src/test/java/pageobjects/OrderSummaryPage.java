package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class OrderSummaryPage extends BaseClass{
	
	public OrderSummaryPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(how=How.CLASS_NAME, using="page-heading")
	public static WebElement page_heading;
	
	@FindBy(how=How.TAG_NAME, using="button")
	public static List<WebElement> all_buttons;


}
