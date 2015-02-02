package modules;

import static org.testng.AssertJUnit.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import pageobjects.OrderSummaryPage;


public class OrderSummaryAction {

	@SuppressWarnings("deprecation")
	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
	
		WebDriverWait wait = new WebDriverWait(driver,10);
		assertEquals("ORDER SUMMARY", OrderSummaryPage.page_heading.getText());
		OrderSummaryPage.all_buttons.get(1).click();
	}
}
