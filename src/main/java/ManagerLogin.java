import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ManagerLogin extends BasePage {

    private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");


    private By openAccount = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");


    private By customers = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");
    private By managerLogoutBtn = By.xpath("/html/body/div/div/div[1]/button[2]");
    //dugme je sakriveno i pojavi se kad mu izbrisem ng-hide klasu. sigurna sam da postoji nacin da se to modifikuje kroz test

    private By homeBtn = By.xpath("/html/body/div/div/div[1]/button[1]");


    public ManagerLogin(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickAddCustomer() {
        getDriver().findElement(addCustomer).click();
    }


    public By getAddCustomer() {
        return addCustomer;
    }

    public By getCustomers() {
        return customers;
    }

    public void clickOpenAccount() {
        getDriver().findElement(openAccount).click();
    }

    public void clickCustomers() {
        getDriver().findElement(customers).click();
    }


    public void managerLogout() {
        JavascriptExecutor j = (JavascriptExecutor) getDriver();
        WebElement hidenLogoutBtn = getDriver().findElement(managerLogoutBtn);
        j.executeScript("$(arguments[0]).click();", hidenLogoutBtn);

//        getDriver().findElement(managerLogoutBtn).click();
    }

    public void cliclkHomeBtn() {
        getDriver().findElement(homeBtn).click();
    }


}
