package modules;
import static org.testng.AssertJUnit.assertEquals;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.PaymentMethodPage;
public class PaymentAction {
	@SuppressWarnings("deprecation")
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		assertEquals("PLEASE CHOOSE YOUR PAYMENT METHOD", PaymentMethodPage.page_heading.getText());
		PaymentMethodPage.check.click();
		Reporter.log("Payment page verify and proceed successful");
	}
}
