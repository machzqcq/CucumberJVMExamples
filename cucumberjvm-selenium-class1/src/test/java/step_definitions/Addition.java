package step_definitions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Addition {
	int a, b,sum;
	@Given("^I have variable a$")
	public void i_have_variable_a() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		a = 3;
	}
	@Given("^I have variable b$")
	public void i_have_variable_b() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    b = 4;
	}
	@When("^I add a and b$")
	public void i_add_a_and_b() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    sum = a + b;
	}
	@Then("^I display the sum$")
	public void i_display_the_sum() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Sum is "+sum);
	}
}
