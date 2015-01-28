package stepDefinitions;

import cucumber.api.SnippetType;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"},
		snippets = SnippetType.CAMELCASE,
		tags = {}
		)
public class RunCukesTest{
	
}