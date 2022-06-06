import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccountPage extends BasePage {

    private By oaCustomerSelect = By.id("userSelect");
    private By oaCurrencySelect = By.id("currency");
    private By oaProcessBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");
    private By oaHomeBtn = By.xpath("/html/body/div/div/div[1]/button[1]");


    public OpenAccountPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getOaCustomerSelect() {
        return oaCustomerSelect;
    }

    public void selectOpenAccountCustomer(String customer) {
        Select selectCustomer = new Select(getDriver().findElement(oaCustomerSelect));
        selectCustomer.selectByVisibleText(customer);
    }

    public void selectOpenAccountCurrency(String currency) {
        Select selectCurrency = new Select(getDriver().findElement(oaCurrencySelect));
        selectCurrency.selectByVisibleText(currency);
    }

    public void clickProcess() {
        getDriver().findElement(oaProcessBtn).click();
    }

    public void clickOaHomeBtn() {
        getDriver().findElement(oaHomeBtn).click();
    }
}
