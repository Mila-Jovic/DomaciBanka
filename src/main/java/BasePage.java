import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    /*Otići na https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login.

Test 4: Logovanje kao Customer
Test 5: Uspešan Deposit za nekog Customera
Test 6: Uspešan Withdrawal za nekog Customera
Test 7: Logout za Bank Managera
Test 8: Logout za Customera
Prolaz (ocena 3) - Testovi 1, 2, 4, 5.*/

    private WebDriver driver;
    private WebDriverWait driverWait;


    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver (WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public void setDriverWait(WebDriverWait driverWait) {
        this.driverWait = driverWait;
    }

    public BasePage(WebDriver driver, WebDriverWait driverWait){
        this.driver=driver;
        this.driverWait=driverWait;
    }
    public void clearField (By locator){
        driver.findElement(locator).clear();

    }
    public String alertMessages() {
       String alertMessages = driver.switchTo().alert().getText();
       return alertMessages;
    }

    public void skipAlertMessages() {
        Alert alertMessages = driver.switchTo().alert();
        alertMessages.accept();
    }
}
