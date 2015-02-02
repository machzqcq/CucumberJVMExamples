package step_definitions;


import cucumber.api.java.en.Then;
import helpers.DataHelper;
import modules.PaymentAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.PaymentMethodPage;

import java.util.HashMap;
import java.util.List;

public class PaymentSteps {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;


    public PaymentSteps()
    {
        driver = Hooks.driver;
        datamap = DataHelper.data();
    }

    @Then("^I verify payment details page and proceed$")
    public void i_verify_payment_details_page_and_proceed() throws Throwable {
        PageFactory.initElements(driver, PaymentMethodPage.class);
        PaymentAction.Execute(driver,datamap);

    }

}
