import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    String HomeURL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    By cLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    By mlogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCsLogin(){
        //WebElement customerLoginButton = driver.findElement(cLogin);
        //customerLoginButton.click();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
    }

    public void clickMgLogin() {
        //WebElement managerLoginButton = driver.findElement(mlogin);
        //managerLoginButton.click();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }

}
