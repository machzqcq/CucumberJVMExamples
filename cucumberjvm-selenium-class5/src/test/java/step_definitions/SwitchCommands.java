package step_definitions;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class SwitchCommands {
	public WebDriver driver;
	public SwitchCommands()
	{
		driver = Hooks.driver;
	}
	@When("^I open seleniumframework practiceform$")
	public void i_open_seleniumframework_practiceform() throws Throwable {
		driver.get("http://www.seleniumframework.com/Practiceform/");
	}
	@And("^I open a new window$")
	public void i_open_a_new_window() throws Throwable {
		// Store and Print the name of the First window on the console
        String handle= driver.getWindowHandle();
        System.out.println("Parent Window"+handle);
        // Click on the Button "New Browser Window"
        driver.findElement(By.id("button1")).click();
        Thread.sleep(5000);
        // Store and Print the name of all the windows open	              
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Number of window handles now--"+handles.size());
	}
	@Then("^I switch to the new window$")
	public void i_switch_to_the_new_window() throws Throwable {
	    // Pass a window handle to the other window
        for (String handle1 : driver.getWindowHandles()) {
        	driver.switchTo().window(handle1);
        	System.out.println("current window:" +handle1 +"has title:" +driver.getTitle());
        	}
        driver.close();
	}
	@And("^I open a new tab$")
	public void i_open_a_new_tab() throws Throwable {
		// Store and Print the name of the First window on the console
        String handle= driver.getWindowHandle();
        System.out.println("Parent Window"+handle);
        // Click on the Button "New Browser Tab"
        List<WebElement> allButtons = driver.findElements(By.tagName("button"));
        allButtons.get(2).click();
        Thread.sleep(5000);
        // Store and Print the name of all the windows open	              
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Number of window handles now--"+handles.size());
	}
	@Then("^I switch to the new tab$")
	public void i_switch_to_the_new_tab() throws Throwable {
	    // Pass a window handle to the other window
        for (String handle1 : driver.getWindowHandles()) {
        	driver.switchTo().window(handle1);
        	System.out.println("current window:" +handle1 +"has title:" +driver.getTitle());
        	}
        driver.close();
	}
	@When("^I click alert button$")
	public void i_click_alert_button() throws Throwable {
		 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        driver.findElement(By.id("alert")).click();
	}
	@Then("^I switch to alert and accept$")
	public void i_switch_to_alert_and_accept() throws Throwable {
        Alert my_alert = driver.switchTo().alert();
        System.out.println(my_alert.getText());
        //Just to print driver handles and show that alert is NOT a window
        System.out.println(driver.getWindowHandles());
        Thread.sleep(5000);   
        my_alert.accept();
	}
	@When("^I open yourhtmlsource website$")
	public void i_open_yourhtmlsource_website() throws Throwable {
		driver.get("http://www.yourhtmlsource.com/frames/inlineframes.html");
	}
	@When("^I switch to frame with name bomb$")
	public void i_switch_to_frame_with_name_bomb() throws Throwable {
		driver.switchTo().frame("bomb");
		WebElement frameBody = driver.findElement(By.tagName("body"));
		System.out.println(frameBody.getText());
	}
	@Then("^I print the text and switch back to parent$")
	public void i_print_the_text_and_switch_back_to_parent() throws Throwable {
		// try printing without switching to parentframe. Results in NoSuchElement Exception
		//System.out.println(driver.findElementByLinkText("Full Index").getText());
		driver.switchTo().parentFrame();
		System.out.println(driver.findElement(By.linkText("Full Index")).getText());
	}
}
