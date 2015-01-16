package step_definitions;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Waits {
	public WebDriver driver;
	public Waits()
	{
		driver = Hooks.driver;
	}
	@When("^I open seleniumframework website$")
	public void i_open_seleniumframework_website() throws Throwable {
		driver.get("http://www.seleniumframework.com/Practiceform/");
	}
	@When("^I set pageload timeout$")
	public void i_set_pageload_timeout() throws Throwable {
		Timeouts timeouts = driver.manage().timeouts();
		//Here we look at pageloadTimeout. By default pageload is infinite
		timeouts.pageLoadTimeout(10, TimeUnit.SECONDS);
		//		 System.out.println(driver.getPageSource());
		WebElement targetElement = driver.findElement(By.id("periodicElement"));
		System.out.println(targetElement.getText());
	}
	@When("^I set implicit timeout$")
	public void i_set_implicit_timeout() throws Throwable {
		Timeouts timeouts = driver.manage().timeouts();
		//Implict waits apply to all Webelements i.e. once you set implictWait , driver would wait
		// for that amount of max time on every element before throwing WaitTimeout Exception
		// DO NOT mix up Implict and Explicit Timeouts
		timeouts.implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Then("^I print the text for target element$")
	public void i_print_the_text_for_target_element() throws Throwable {
		WebElement targetElement = driver.findElement(By.id("periodicElement"));
		System.out.println(targetElement.getText());
	}
	@When("^I set script timeout$")
	public void i_set_script_timeout() throws Throwable {
		Timeouts timeouts = driver.manage().timeouts();
		//Script waits apply to Javascript executor , driver would wait
		// for that amount of max time for the script to complete execution throwing WaitTimeout Exception
		timeouts.setScriptTimeout(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println(js.executeScript("return window.onload='myFunction()';"));
	}
	@Then("^I set explicit wait block on target element until it becomes clickable$")
	public void i_set_explicit_wait_block_on_target_element_using_exists() throws Throwable {
		Timeouts timeouts = driver.manage().timeouts();
		 timeouts.implicitlyWait(5, TimeUnit.SECONDS);
		 //First create a WebDriverWait object and pass the driver and timeout as arguments
		WebDriverWait waiter = new WebDriverWait(driver, 5);
		//Specify the expectedcondition to become true until the timeout defined by wait.
		// If condition becomes true before timeout, the the WebElement is returned
		// If condition is not true, it results in TimeoutException
		WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(By.id("periodicElement")));
		System.out.println("Expected condition found this element with HTML" + element.getAttribute("outerHTML"));
	}
	@Then("^I set explicit wait block on on alert present$")
	public void i_set_explicit_wait_block_on_on_alert_present() throws Throwable {
		WebDriverWait waiter1 = new WebDriverWait(driver, 6);
		driver.findElement(By.id("timingAlert")).click();
		Alert alert = waiter1.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(4000);
		System.out.println("Found alert");
		alert.accept();
	}
	@Then("^I wait until I find five periodicElements$")
	public void i_wait_until_I_find_five_periodicElements() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		FluentWait<ChromeDriver> wait = new FluentWait<ChromeDriver>((ChromeDriver) driver);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.pollingEvery(2, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		List<WebElement> targetElements = wait.until(new Function<ChromeDriver, List<WebElement>>()
				{
			public List<WebElement> apply(ChromeDriver driver) {
				List<WebElement> elements = driver.findElements(By.id("periodicElement"));
				int length = elements.size();
				System.out.println("current Length is"+length);
				if(length==5)
				{
					System.out.println("Target Length is hit"+length);
					return elements;
				}
				return null;
			}
				});
	}
}
