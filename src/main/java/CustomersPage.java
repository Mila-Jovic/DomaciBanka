import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomersPage extends BasePage {

    private By customerListXpath = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr");
    private List<WebElement> customerList;

//    private By search = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input");
//    private By searchNameResults = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[1]");
//    private By accountNumber = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[4]/span");

    public CustomersPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

        public int  getCustomerListLength(){
        this.customerList = getDriver().findElements(this.customerListXpath);
        return customerList.size();

    }
//    public void inputCustomerNameInSearch(String addFirstName) {
//        getDriver().findElement(search).sendKeys(addFirstName);
//    }
//
//    public boolean isCustomerExist() {
//        return getDriver().findElement(searchNameResults).isDisplayed();
//    }
//
//    public boolean isAccountNumberExist() {
//        return getDriver().findElement(accountNumber).isDisplayed();
//    }
}
