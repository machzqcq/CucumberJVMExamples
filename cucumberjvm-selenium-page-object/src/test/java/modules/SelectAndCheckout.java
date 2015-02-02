package modules;
import static org.testng.AssertJUnit.assertEquals;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import helpers.DataHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import pageobjects.AutomationHomePage;
import pageobjects.SummerDressesCatalogPage;
public class SelectAndCheckout {
	@SuppressWarnings("deprecation")
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		WebDriverWait wait = new WebDriverWait(driver,10);
		AutomationHomePage.HeaderPage.menu_women.click();
		AutomationHomePage.HeaderPage.WomenPage.dresses.click();
		AutomationHomePage.HeaderPage.WomenPage.DressesPage.summer_dresses.click();
		assertEquals("SUMMER DRESSES ", SummerDressesCatalogPage.category_name.getText());
		Actions action = new Actions(driver);
		action.moveToElement(SummerDressesCatalogPage.PrintedSummerDress1.img_dress1);
		action.perform();
		DataHelper.storeValues.put("product_price",SummerDressesCatalogPage.PrintedSummerDress1.product_price.getText());
		SummerDressesCatalogPage.PrintedSummerDress1.add_cart_dress1.click();
		wait.until(ExpectedConditions.elementToBeClickable(SummerDressesCatalogPage.CartPopup.proceed_to_checkout));
		SummerDressesCatalogPage.CartPopup.proceed_to_checkout.click();
		Reporter.log("Select product successful");
	}
}
