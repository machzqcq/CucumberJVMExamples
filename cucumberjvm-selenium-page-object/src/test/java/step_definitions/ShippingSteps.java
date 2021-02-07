package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import helpers.DataHelper;
import modules.VerifyShippingAddressProceed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.ShippingAddressPage;

import java.util.HashMap;
import java.util.List;

public class ShippingSteps {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;


    public ShippingSteps()
    {
        driver = Hooks.driver;
        datamap = DataHelper.data();
    }

    @Then("^I verify shipping details and proceed$")
    public void i_verify_shipping_details_and_proceed() throws Throwable {
        PageFactory.initElements(driver, ShippingAddressPage.class);
        VerifyShippingAddressProceed.Execute(driver,datamap);

    }

}
