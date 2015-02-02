package modules;
import static org.testng.AssertJUnit.assertEquals;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.ShippingAddressPage;
public class VerifyShippingAddressProceed {
	@SuppressWarnings("deprecation")
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		assertEquals("SHIPPING", ShippingAddressPage.page_heading.getText());
		ShippingAddressPage.terms.click();
		ShippingAddressPage.proceed_to_checkout.click();
		Reporter.log("Shipping Address page verify and proceed successful");
	}
}
