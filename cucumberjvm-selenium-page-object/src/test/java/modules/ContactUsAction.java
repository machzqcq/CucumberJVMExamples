package modules;

import static org.testng.AssertJUnit.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import pageobjects.AutomationHomePage;
import pageobjects.ContactusPage;


public class ContactUsAction {

	public static void Execute(WebDriver driver,List<HashMap<String,String>> map) throws Exception{
		
		AutomationHomePage.contact_us.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(10,0)");
		ContactusPage.email.sendKeys((String)map.get(0).get("email"));
		ContactusPage.message.sendKeys(map.get(0).get("message"));
		ContactusPage.submit.click();
		Assert.assertTrue(ContactusPage.error_message.getText().contains("There is 1 error"));
	}
}
