Feature: Demonstrate CRUD operations with Excel and read data from excel into a web form

  Scenario: Create, update excel workbook,add data and delete data
    When I create the excel worbook "Random.xlsx"
    Then I print the data inside the workbook
    And I perform delete operations on a workbook

  Scenario: Read existing excel file print all its contents
    When I read the excel file "Sample.xlsx"
    Then I access a worksheet
    Then I access the rows and cells

  Scenario: Read excel worksheet and convert data to hash by using column headers
    When I read the excel file "Sample.xlsx"
    Then I convert the sheet data into hash with keys as column headers

    @web
  Scenario: Accessing a workbook and its data into a web application
    When I open practiceselenium website
    And I read the excel file "Sample.xlsx"
    And I fill the form with data from excel
    And I hit submit button
    Then I go back to Welcome page and verify title