package step_definitions;


import cucumber.api.java.en.Then;
import helpers.DataHelper;
import modules.VerifyAddressProceed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.AddressPage;

import java.util.HashMap;
import java.util.List;

public class AddressSteps {


    public WebDriver driver;
    public List<HashMap<String, String>> datamap;


    public AddressSteps() {
        driver = Hooks.driver;
        datamap = DataHelper.data();
    }

    @Then("^I verify address and proceed$")
    public void i_verify_address_and_proceed() throws Throwable {
        PageFactory.initElements(driver, AddressPage.class);
        VerifyAddressProceed.Execute(driver,datamap);

    }
}
