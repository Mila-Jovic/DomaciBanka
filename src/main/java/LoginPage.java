import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By customerLogin =By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By managerLogin= By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getCustomerLogin() {
        return customerLogin;
    }

    public By getManagerLogin() {
        return managerLogin;
    }

    public void clickCustomerLogin (){
        getDriver().findElement(customerLogin).click();
    }
    public void clickManagerLogin (){
        getDriver().findElement(managerLogin).click();
    }
}
