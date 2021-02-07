package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import helpers.DataHelper;
import modules.VerifyShoppingCartSummaryAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.AutomationHomePage;
import pageobjects.ShoppingCartSummaryPage;

import java.util.HashMap;
import java.util.List;

public class ShoppingCartSummarySteps {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;


    public ShoppingCartSummarySteps()
    {
        driver = Hooks.driver;
        datamap = DataHelper.data();
    }

    @Then("^I verify details on shoppingCart summary page$")
    public void i_verify_details_on_shoppingCart_summary_page() throws Throwable {

        PageFactory.initElements(driver, ShoppingCartSummaryPage.class);
        VerifyShoppingCartSummaryAction.Execute(driver,datamap);

    }

}
