import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Withdrawl_dollars {
    WebDriver driver;
    By withdrawl_button = By.xpath("//*[@class='btn btn-lg tab btn-primary' and @ng-click='withdrawl()']");
    By Amount_withdraw = By.xpath("//label['Amount to be Withdrawn :']/following-sibling::input");
    By final_Withdraw_button = By.xpath("//button[@type = 'submit']");

    public Withdrawl_dollars(WebDriver driver){
        this.driver = driver;
    }

    public void clickWithdrawl(){
        driver.findElement(withdrawl_button).click();
    }

    public void enterAmount(){
        driver.findElement(Amount_withdraw).sendKeys("10000");
    }

    public void clickFinalWithdrawl(){
        driver.findElement(final_Withdraw_button).click();
    }

}
