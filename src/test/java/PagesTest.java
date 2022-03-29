import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PagesTest {
    WebDriver driver;
    HomePage home;
    AddCustomerPage customer;
    Open_Account account;
    Deposit_Dollars deposit;
    Withdrawl_dollars withdraw;
    String url = "https://www.google.com/";
    String HomePageURL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    String managerloginPage = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";
    String customerLoginPage = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\prajchaudhary\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void clickBankManagerLogin(){
        home = new HomePage(driver);
        driver.get(HomePageURL);
        home.clickMgLogin();
    }


    public void clickCustomerLogin(){
        home = new HomePage(driver);
        driver.get(HomePageURL);
        home.clickCsLogin();
    }

    @Test
    public void addCustomer(){
        customer = new AddCustomerPage(driver);
        customer.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        home = new HomePage(driver);
        home.clickMgLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        customer.clickAddCustomer();
        customer.AddData();
    }

    @Test
    public void OpenAccount(){
        account = new Open_Account(driver);
        account.Click_Open_account();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        account.select_customer();
    }

    @Test
    public void checkDeposit(){
        deposit = new Deposit_Dollars(driver);
        deposit.clickHome();
        home = new HomePage(driver);
        home.clickCsLogin();
        deposit.selectName();
        deposit.click_login();
        deposit.click_deposit();
        deposit.inputAmmount();
        deposit.finalDeposit();
        deposit.checkDeposit();

    }

    @Test
    public void withdrawAmount(){
        withdraw = new Withdrawl_dollars(driver);
        withdraw.clickWithdrawl();
        withdraw.enterAmount();
        withdraw.clickFinalWithdrawl();

    }

}
