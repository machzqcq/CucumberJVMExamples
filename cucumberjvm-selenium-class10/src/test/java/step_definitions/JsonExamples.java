package step_definitions;
import com.google.gson.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.*;
import java.util.Arrays;
public class JsonExamples {
public WebDriver driver;
public String json;
    public JsonExamples()
    {
    	driver = Hooks.driver;
    }
	@When("^I create json string from object and write to file$")
	public void i_create_json_string_from_object_and_write_to_file() throws Throwable {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstName("Pradeep");
		employee.setLastName("Kumar");
		employee.setRoles(Arrays.asList("ADMIN", "MANAGER"));
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileOutputStream fout = new FileOutputStream("output.json");
		fout.write(gson.toJson(employee).getBytes());
		fout.flush();
		fout.close();
	}
	@Then("^I print it as a string$")
	public void i_print_it_as_a_string() throws Throwable {
		FileInputStream fin = new FileInputStream(new File("output.json"));
		InputStreamReader in = new InputStreamReader(fin);
		BufferedReader bufferedReader = new BufferedReader(in);
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
		}
		String json = sb.toString();
		System.out.println(json);
		Gson gson = new Gson();
		Employee employee = gson.fromJson(json, Employee.class);
//		System.out.println(employee.getFirstName());
	}
	@When("^I read json string from a file$")
	public void i_read_json_string_from_a_file() throws Throwable {
		FileInputStream fin = new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//resources//sample.json"));
		InputStreamReader in = new InputStreamReader(fin);
		BufferedReader bufferedReader = new BufferedReader(in);
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
		}
		json = sb.toString();
	}
	@Then("^I parse the string and print keys and values$")
	public void i_parse_the_string_and_print_keys_and_values() throws Throwable {
		System.out.println(json);
		JsonParser parser = new JsonParser();
		JsonObject myobject = (JsonObject)parser.parse(json);
		//Accessing the value of "desc"
		System.out.println(myobject.get("desc"));
		//Deserializing the value into JSONObject
		JsonObject descValue = (JsonObject)myobject.get("desc");
		// Printing the someKey value using JsonObject
		System.out.println("SomeKey Value--"+descValue.get("someKey"));
		// Retrieving the JSON Element -- JsonElement can represent a string, array or other data types
		JsonElement someElement = descValue.get("someKey");
		// Printing a value again
		System.out.println("SomeKey Value--"+someElement.getAsString());
	}
	@When("^I open practiceselenium website$")
	public void i_open_practiceselenium_website() throws Throwable {
		driver.get("http://www.practiceselenium.com/practice-form.html");
	}
	@When("^I read the json data file \"(.*?)\"$")
	public void i_read_the_json_data_file(String arg1) throws Throwable {
		FileInputStream fin = new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//resources//"+arg1));
		InputStreamReader in = new InputStreamReader(fin);
		BufferedReader bufferedReader = new BufferedReader(in);
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
		}
		json = sb.toString();
		System.out.println(json);
	}
	@When("^I fill the form with data from json and submit$")
	public void i_fill_the_form_with_data_from_json_and_submit() throws Throwable {
		JsonParser parser = new JsonParser();
		JsonObject myobject = (JsonObject)parser.parse(json);
		JsonArray myarray = myobject.get("table").getAsJsonArray();
		JsonObject pradeep = myarray.get(0).getAsJsonObject();
		driver.findElement(By.name("firstname")).sendKeys(pradeep.get("firstname").getAsString());
		driver.findElement(By.name("lastname")).sendKeys(pradeep.get("lastname").getAsString());
		driver.findElement(By.id("sex-1")).click();
		driver.findElement(By.id("exp-2")).click();
		driver.findElement(By.id("datepicker")).sendKeys(pradeep.get("date_stopped").getAsString());
		driver.findElement(By.id("tea3")).click();
		driver.findElement(By.id("tool-1")).click();
		Select continents_select = new Select(driver.findElement(By.id("continents")));
		continents_select.selectByVisibleText(pradeep.get("continent").getAsString());
		Select another_select_list = new Select(driver.findElement(By.id("selenium_commands")));
		another_select_list.selectByVisibleText(pradeep.get("selenium_commands").getAsString());
		driver.findElement(By.id("submit")).click();
		AssertJUnit.assertEquals("Welcome", driver.getTitle());
	}
}
