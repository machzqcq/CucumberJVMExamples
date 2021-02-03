package stepDefinitions;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.*;
import java.util.Arrays;
public class DatabaseExamples {
public Connection conn;
    public DatabaseExamples()
    {

		try {
            // db parameters
            String url = System.getProperty("user.dir")+"//src//test//resources//practiceselenium.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }

	@When("I connect to practiceselenium sqlite3 database")
	public void i_connect_to_practiceselenium_sqlite3_database() throws Throwable {

        System.out.println("Connection has been established");

	}
    @Then("I print the rows in products table")
	public void i_print_the_rows_in_products_table() throws Throwable {
        String sql = "SELECT * FROM products";
        
        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("ID") +  "\t" + 
                                   rs.getString("CATEGORY_ID") + "\t" +
                                   rs.getDouble("DESCRIPTION"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	

}
