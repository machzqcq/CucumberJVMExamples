package step_definitions;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DatabaseExamples {
    public Connection conn;
    public WebDriver driver;

    public DatabaseExamples() {
        conn = Hooks.conn;
        driver = Hooks.driver;
    }

    @When("^I connect to practiceselenium sqlite3 database$")
    public void i_connect_to_practiceselenium_sqlite3_database() throws Throwable {

        System.out.println("Connection has been established");

    }

    @Then("I print the rows in products table using columns")
    public void i_print_the_rows_in_products_table_using_columns() {
        // Write code here that turns the phrase above into concrete actions
        String sql = "SELECT * FROM products";

        try (Statement stmt = this.conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            // Retrieving the ResultSetMetadata object
            ResultSetMetaData rsMetaData = rs.getMetaData();
            String columnNames = "";
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                columnNames = columnNames + rsMetaData.getColumnName(i) + "\t";
            }

            System.out.println(columnNames);
            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getInt("ID") + "\t" + rs.getString("CATEGORY_ID") + "\t" + rs.getString("DESCRIPTION"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("I print the row that has id {string}")
    public void i_print_the_row_that_has_id(String id) {
        String sql = "SELECT * FROM products where ID=" + id;

        try (Statement stmt = this.conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            // Retrieving the ResultSetMetadata object
            ResultSetMetaData rsMetaData = rs.getMetaData();
            String columnNames = "";
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
                columnNames = columnNames + rsMetaData.getColumnName(i) + "\t";
            }

            System.out.println(columnNames);
            // loop through the result set
            while (rs.next()) {
                System.out.println(
                        rs.getInt("ID") + "\t" + rs.getString("CATEGORY_ID") + "\t" + rs.getString("DESCRIPTION"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("I update the row whose id is {string} and reset it back")
    public void i_update_the_row_whose_id_is_and_reset_it_back(String id) throws Exception {
        conn.setAutoCommit(false);
        String sql = "UPDATE products SET DESCRIPTION = ? WHERE id = ?";

        try (Connection conn = this.conn; PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, "updated");
            pstmt.setInt(2, Integer.parseInt(id));
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Rolling back data here....");
        try {
            if (conn != null)
                conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Thread.sleep(5);
        // try (Connection conn = this.conn; PreparedStatement pstmt = conn.prepareStatement(sql)) {

        //     // set the corresponding param
        //     pstmt.setString(1, "Red Tea");
        //     pstmt.setInt(2, Integer.parseInt(id));
        //     // update
        //     pstmt.executeUpdate();
        // } catch (SQLException e) {
        //     System.out.println(e.getMessage());
        // }

    }

    @When("I retrieve the tea names")
    public void i_retrieve_the_tea_names() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://www.practiceselenium.com/practice-form.html");
        WebElement tea1 = driver.findElement(By.id("tea1"));
        WebElement tea2 = driver.findElement(By.id("tea2"));
        WebElement tea3 = driver.findElement(By.id("tea3"));

        ArrayList<String> arr1 = new ArrayList<String>();
        arr1.add(tea1.getAttribute("value"));
        arr1.add(tea2.getAttribute("value"));
        arr1.add(tea3.getAttribute("value"));
        System.out.println("Tea values from website:" + arr1);

        String sql = "SELECT * FROM products";
        ArrayList<String> arr2 = new ArrayList<String>();
        try (Statement stmt = this.conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("DESCRIPTION"));
                arr2.add(rs.getString("DESCRIPTION"));
            }
            System.out.println("Tea values from database:" + arr2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        arr1.replaceAll(String::toLowerCase);
        Collections.sort(arr1);
        Collections.sort(arr2);
        arr2.replaceAll(String::toLowerCase);
        AssertJUnit.assertEquals(arr1, arr2);

    }

    @Then("I compare the values with the values from database using sqlite sql")
    public void i_compare_the_values_with_the_values_from_database_using_activerecord_class() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Testing");
    }

}
