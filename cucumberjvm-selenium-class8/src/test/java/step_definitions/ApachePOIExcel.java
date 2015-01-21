package step_definitions;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ApachePOIExcel {

    public XSSFWorkbook workbook;

    public ApachePOIExcel()
    {

    }

    @When("^I create the excel worbook \"(.*?)\"$")
    public void i_create_the_excel_worbook(String arg1) throws Throwable {
        workbook = new XSSFWorkbook();
        //Add a worksheet
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        //Create two rows and add content in first 3 cells of each row
        for(int i=0;i<2;i++)
        {
            XSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue(new Faker().name().firstName());
            row.createCell(1).setCellValue(new Faker().address().streetAddressNumber());
            row.createCell(2).setCellValue(new Faker().phoneNumber().phoneNumber());
        }
        FileOutputStream fout = new FileOutputStream(arg1);
        workbook.write(fout);
        fout.flush();
        fout.close();
    }

    @Then("^I print the data inside the workbook$")
    public void i_print_the_data_inside_the_workbook() throws Throwable {

        System.out.println("Printing Excel Workbook data from Sheet1 after adding data.......");
        try
        {

            XSSFSheet sheet = workbook.getSheet("Sheet1");
            for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
            {
                Row currentRow = sheet.getRow(i);
                for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
                {
                    Cell currentCell = currentRow.getCell(j);
                    System.out.print(currentCell.getStringCellValue() + "\t");

                }
                System.out.println("\n");

            }

            }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @When("^I perform delete operations on a workbook$")
    public void i_perform_delete_operations_on_a_workbook() throws Throwable {
        System.out.println("Deleting data from Random.xlsx.....");
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        System.out.println("removing Row 1....");
        sheet.removeRow(sheet.getRow(1));
        System.out.println("Removing column 2 from Row 0....");
        Row firstRow = sheet.getRow(0);
        firstRow.removeCell(firstRow.getCell(2));
        System.out.println("Printing the contents of Random.xlsx now.....");

        for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
        {
            Row currentRow = sheet.getRow(i);
            for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
            {
                Cell currentCell = currentRow.getCell(j);
                System.out.print(currentCell.getStringCellValue() + "\t");

            }

        }
    }

    @When("^I read the excel file \"(.*?)\"$")
    public void i_read_the_excel_file(String arg1) throws Throwable {
            workbook = new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"//"+"src//test//resources//"+arg1));
    }

    @Then("^I access a worksheet$")
    public void i_access_a_worksheet() throws Throwable {
        XSSFSheet sheet = workbook.getSheet("Sheet1");
    }

    @Then("^I access the rows and cells$")
    public void i_access_the_rows_and_cells() throws Throwable {
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
        {
            Row currentRow = sheet.getRow(i);
            for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
            {
                Cell currentCell = currentRow.getCell(j);
                switch (currentCell.getCellType())
                {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(currentCell.getStringCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(currentCell.getNumericCellValue() + "\t");
                        break;
                }
            }
            System.out.println("\n");

        }
    }

    @Then("^I convert the sheet data into hash with keys as column headers$")
    public void i_convert_the_sheet_data_into_hash_with_keys_as_column_headers() throws Throwable {

            List<HashMap<String, String>> mydata = new ArrayList<HashMap<String, String>>();
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            Row HeaderRow = sheet.getRow(0);
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = sheet.getRow(i);
                HashMap<String, String> currentHash = new HashMap<String, String>();
                for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    Cell currentCell = currentRow.getCell(j);
                    switch (currentCell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            currentHash.put(HeaderRow.getCell(j).getStringCellValue(), String.valueOf(currentCell.getNumericCellValue()));
                            break;
                    }

                }
                mydata.add(currentHash);
            }

            for (HashMap<String, String> h : mydata) {
                for (String key : h.keySet()) {
                    System.out.println(key + "\t" + h.get(key));
                }
                System.out.println("\n");
            }

        }

    @When("^I open practiceselenium website$")
    public void i_open_practiceselenium_website() throws Throwable {
        Hooks.driver.get("http://www.practiceselenium.com/practice-form.html");
    }

    @When("^I fill the form with data from excel$")
    public void i_fill_the_form_with_data_from_excel() throws Throwable {
        WebDriver driver = Hooks.driver;

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        driver.findElement(By.name("firstname")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
        driver.findElement(By.name("lastname")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-2")).click();
        driver.findElement(By.id("datepicker")).sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());
        driver.findElement(By.id("tea3")).click();
        driver.findElement(By.id("tool-1")).click();
        Select continents_select = new Select(driver.findElement(By.id("continents")));
        continents_select.selectByVisibleText(sheet.getRow(1).getCell(7).getStringCellValue());
        Select another_select_list = new Select(driver.findElement(By.id("selenium_commands")));
        another_select_list.selectByVisibleText(sheet.getRow(1).getCell(8).getStringCellValue());
    }

    @When("^I hit submit button$")
    public void i_hit_submit_button() throws Throwable {
        Hooks.driver.findElement(By.id("submit")).click();
    }

    @Then("^I go back to Welcome page and verify title$")
    public void i_go_back_to_Welcome_page_and_verify_title() throws Throwable {
        String actualTitle = Hooks.driver.getTitle();
        Assert.assertEquals(actualTitle,"Welcome");
    }

}
