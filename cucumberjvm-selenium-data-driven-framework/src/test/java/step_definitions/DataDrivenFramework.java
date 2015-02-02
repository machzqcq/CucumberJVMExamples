package step_definitions;
import cucumber.api.PendingException;
import helpers.DataHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class DataDrivenFramework {
    public WebDriver driver;
    public List<HashMap<String,String>> datamap;
    public DataDrivenFramework()
    {
    	driver = Hooks.driver;
     	datamap = DataHelper.data(System.getProperty("user.dir")+"//src//test//resources//testData/default.xlsx","Sheet1");
    }
    @When("^I open automationpractice website$")
    public void i_open_automationpractice_website() throws Throwable {
        driver.get("http://automationpractice.com");
    }
    @When("^click contact us$")
    public void click_contact_us() throws Throwable {
        driver.findElement(By.linkText("Contact us")).click();
    }
    @Then("^I contact the customer service with excel row \"(.*?)\" dataset$")
    public void i_contact_the_customer_service_with_excel_row_dataset(String arg1) throws Throwable {
        int index = Integer.parseInt(arg1)-1;
        System.out.println("Printing current data set...");
        for(HashMap h:datamap)
        {
            System.out.println(h.keySet());
            System.out.println(h.values());
        }
        Select subjectHeading = new Select(driver.findElement(By.id("id_contact")));
        subjectHeading.selectByVisibleText(datamap.get(index).get("heading"));
        driver.findElement(By.id("email")).sendKeys(datamap.get(index).get("email"));
        driver.findElement(By.id("id_order")).sendKeys(datamap.get(index).get("order_reference"));
        driver.findElement(By.id("message")).sendKeys(datamap.get(index).get("message"));
        driver.findElement(By.id("submitMessage")).sendKeys(datamap.get(index).get("message"));
    }
}