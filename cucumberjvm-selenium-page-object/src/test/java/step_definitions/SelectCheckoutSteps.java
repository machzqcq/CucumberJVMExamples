package step_definitions;

import cucumber.api.java.en.Then;
import helpers.DataHelper;
import modules.SelectAndCheckout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.AutomationHomePage;
import pageobjects.SummerDressesCatalogPage;

import java.util.HashMap;
import java.util.List;

public class SelectCheckoutSteps {

    public WebDriver driver;
    public List<HashMap<String,String>> datamap;


    public SelectCheckoutSteps()
    {
        driver = Hooks.driver;
        datamap = DataHelper.data();
    }

    @Then("^I select a dress and proceed to checkout$")
    public void i_select_a_dress_and_proceed_to_checkout() throws Throwable {

        PageFactory.initElements(driver,AutomationHomePage.HeaderPage.class);
        PageFactory.initElements(driver,AutomationHomePage.HeaderPage.WomenPage.class);
        PageFactory.initElements(driver,AutomationHomePage.HeaderPage.WomenPage.DressesPage.class);
        PageFactory.initElements(driver, SummerDressesCatalogPage.class);
        PageFactory.initElements(driver, SummerDressesCatalogPage.PrintedSummerDress1.class);
        PageFactory.initElements(driver, SummerDressesCatalogPage.CartPopup.class);

        SelectAndCheckout.Execute(driver,datamap);

    }

}
