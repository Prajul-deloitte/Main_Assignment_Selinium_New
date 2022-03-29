import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddCustomerPage {
    WebDriver driver;
    By add_customer = By.xpath("(//button[@class = 'btn btn-lg tab'])[1]");

    By Customer_table = By.xpath("(//button[@class = 'btn btn-lg tab'])[3]");
    By First_name = By.xpath("//input[@placeholder='First Name']");
    By last_name = By.xpath("//input[@placeholder='Last Name']");
    By Post_code = By.xpath("//input[@placeholder='Post Code']");
    String URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    By AddCustomer = By.xpath("//*[@class='btn btn-lg tab' and @ng-click='addCust()']");
    By Add_button =By.xpath("//button[text()='Add Customer']");
    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
    }

    public void click(){
        driver.get(URL);
    }

    public void clickAddCustomer(){
        driver.findElement(AddCustomer).click();
    }
    public void AddData() {
        String Excel_file_path = ("C:\\Users\\prajchaudhary\\Downloads\\customerinfo.xlsx");
        try {
            FileInputStream fis = new FileInputStream(Excel_file_path);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = null;
            XSSFCell cell = null;
            String first_name = null;
            String Last_name = null;
            String Postal_code = null;

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    cell = row.getCell(j);
                    if (j == 0) {
                        first_name = cell.getStringCellValue();
                    }
                    if (j == 1) {
                        Last_name = cell.getStringCellValue();
                    }
                    if (j == 2) {
                        Postal_code = cell.getStringCellValue();
                    }

                }
                driver.findElement(First_name).sendKeys(first_name);
                driver.findElement(last_name).sendKeys(Last_name);
                driver.findElement(Post_code).sendKeys(Postal_code);
                driver.findElement(Add_button).click();
                driver.switchTo().alert().accept();
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
