package step_definitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class HtmlLocators{
    public WebDriver driver;
    public HtmlLocators()
    {
    	driver = Hooks.driver;
    }
    @When("^I login to practiceselenium website$")
    public void i_login_to_practiceselenium_website() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://www.practiceselenium.com/");
        AssertJUnit.assertEquals("Welcome", driver.getTitle());
    }
    @Then("^I access elements and use watir commands$")
    public void i_access_elements_and_use_watir_commands() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    		 WebElement welcomeLink = driver.findElement(By.linkText("Welcome"));
    		  System.out.println("Welcome text "+welcomeLink.getText());
    		  System.out.println("Tag Name "+welcomeLink.getAttribute("tagName"));
    		  System.out.println("Href "+welcomeLink.getAttribute("href"));
    		  System.out.println("Outer HTML "+welcomeLink.getAttribute("outerHTML"));
    		  System.out.println("Inner Html "+welcomeLink.getAttribute("innerHTML"));
    }
}