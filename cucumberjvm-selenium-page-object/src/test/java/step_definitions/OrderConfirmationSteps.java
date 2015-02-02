package step_definitions;


import cucumber.api.java.en.Then;
import helpers.DataHelper;
import modules.OrderConfirmationAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.OrderConfirmationPage;

import java.util.HashMap;
import java.util.List;

public class OrderConfirmationSteps {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;


    public OrderConfirmationSteps()
    {
        driver = Hooks.driver;
        datamap = DataHelper.data();
    }

    @Then("^I verify order confirmation page details and verify success message$")
    public void i_verify_order_confirmation_page_details_and_verify_success_message() throws Throwable {
        PageFactory.initElements(driver, OrderConfirmationPage.class);
        OrderConfirmationAction.Execute(driver,datamap);
    }
}
