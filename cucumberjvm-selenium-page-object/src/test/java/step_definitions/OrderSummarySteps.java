package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import helpers.DataHelper;
import modules.OrderSummaryAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.OrderSummaryPage;

import java.util.HashMap;
import java.util.List;

public class OrderSummarySteps {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;


    public OrderSummarySteps()
    {
        driver = Hooks.driver;
        datamap = DataHelper.data();
    }


    @Then("^I verify order summary page and proceed$")
    public void i_verify_order_summary_page_and_proceed() throws Throwable {
        PageFactory.initElements(driver, OrderSummaryPage.class);
        OrderSummaryAction.Execute(driver,datamap);

    }
}
