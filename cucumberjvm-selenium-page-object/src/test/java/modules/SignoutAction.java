package modules;
import helpers.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.AutomationHomePage;
import java.util.HashMap;
import java.util.List;
public class SignoutAction {
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		AutomationHomePage.sign_out.click();
		Log.info("Sign out is performed");
		Reporter.log("Sign out is performed");
	}
}
