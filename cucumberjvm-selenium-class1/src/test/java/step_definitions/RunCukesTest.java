package step_definitions;

import org.junit.runner.RunWith;
import org.w3c.dom.views.AbstractView;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"},
		tags = {}
		)
public class RunCukesTest{
	
}