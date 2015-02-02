package modules;
import static org.testng.AssertJUnit.assertEquals;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.AddressPage;
public class VerifyAddressProceed {
	@SuppressWarnings("deprecation")
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		assertEquals("ADDRESSES", AddressPage.page_heading.getText());
		AddressPage.message.sendKeys(map.get(0).get("message"));
		AddressPage.proceed_to_checkout.click();
		Reporter.log("Address page verify and proceed successful");
	}
}
