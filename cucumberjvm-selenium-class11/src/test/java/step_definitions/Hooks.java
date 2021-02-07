package step_definitions;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.JDBC.*;

public class Hooks{
    public static WebDriver driver;
    public static Connection conn;

    
    @Before("@web")
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {

        driver = new ChromeDriver();
   	    System.out.println("Opening Browser....");
    	driver.manage().deleteAllCookies();
    }

    @Before("@database")
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openConn() throws MalformedURLException {
        try {
            // db parameters
            String url = "jdbc:sqlite:"+System.getProperty("user.dir")+"//src//test//resources//practiceselenium.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

    @After("@web")
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
       
        if (scenario.isFailed()) {
        try {
        	//  scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "blah.png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
        driver.quit();
        
    }

    @After("@database")
    public void closeConn(Scenario scenario) {
        try {
            conn.close();
            System.out.println("Successfully closed database connection!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}