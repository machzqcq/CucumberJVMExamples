package step_definitions;
import java.io.IOException;
import java.util.Properties;
import helpers.ObjectRepository;
import modules.ContactusModule;
import modules.SignInModule;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class KeywordDrivenFramework {
    public WebDriver driver;
    public Properties OR;
    public KeywordDrivenFramework() throws IOException {
    	driver = Hooks.driver;
     	OR = ObjectRepository.ObjectRepo(System.getProperty("user.dir")+"//src//test//resources//OR.properties");
    }
    @When("^I open \"(.*?)\" website$")
    public void i_open_website(String arg1) throws Throwable {
        driver.get(arg1);
    }
    @Then("^I login using credentials \"(.*?)\" and \"(.*?)\"$")
    public void i_login_using_credentials_and(String arg1, String arg2) throws Throwable {
        SignInModule.Execute(driver,OR,arg1,arg2);
    }
    @Then("^I contact customer service with order reference \"(.*?)\" and message \"(.*?)\"$")
    public void i_contact_customer_service_with_order_reference_and_message(String arg1, String arg2) throws Throwable {
        ContactusModule.Execute(driver,OR,arg1,arg2);
    }
}