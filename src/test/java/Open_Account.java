import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Open_Account {
    WebDriver driver;
    By Open_account = By.xpath("(//button[@class='btn btn-lg tab'])[1]");
    By Customer_dropdown = By.xpath("//select[@name = 'userSelect']");
    By currency_type = By.xpath(("//select[@name = 'currency']"));
    By process_button = By.xpath("//button[text()='Process']");


    public Open_Account(WebDriver driver){
        this.driver = driver;
    }
    public void Click_Open_account(){
        //driver.findElement(Open_account);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/openAccount");

    }

    public void select_customer(){


        Select user = new Select(driver.findElement(By.id("userSelect")));
        user.selectByIndex(3);

        //selecting currency
        Select cur = new Select(driver.findElement(By.id("currency")));
        cur.selectByIndex(3);
        //click on process
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.switchTo().alert().accept();
    }

}
