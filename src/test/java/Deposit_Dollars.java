import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Deposit_Dollars {
    WebDriver driver;
    By Select_user = By.xpath("//select[@id = 'userSelect']");
    By Home_button = By.xpath("//button[contains(text(),'Home')]");
    By Login_button = By.xpath("//button[text()='Login']");
    By deposit_button = By.xpath("(//button[@class='btn btn-lg tab'])[2]");
    By Amount_input = By.xpath("//input[@type = 'number']");
    By final_deposit = By.xpath("//button[text() = 'Deposit']");
    By Balance_amount = By.xpath("//div[@class=  'center']/child::strong[@class='ng-binding'][2]");
    public Deposit_Dollars(WebDriver driver){
        this.driver = driver;
    }

    public void clickHome(){
        driver.findElement(Home_button).click();
    }
    public void selectName(){
        Select name = new Select(driver.findElement(Select_user));
        name.selectByIndex(3);
    }
    public void click_login(){
        driver.findElement(Login_button).click();
    }
    public void click_deposit(){
        driver.findElement(deposit_button).click();
    }
    public void inputAmmount(){
        driver.findElement(Amount_input).sendKeys("15000");
    }
    public void finalDeposit(){
        driver.findElement(final_deposit).click();
    }
    public void checkDeposit(){
        String amount = driver.findElement(Balance_amount).getText();
        if(amount=="15000")
            System.out.println("Successfull Deposit");
    }
}
