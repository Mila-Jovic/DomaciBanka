import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage extends BasePage {


    private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postcode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By submitCustomerBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");


    public AddCustomerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFirstName() {
        return firstName;
    }

    public void enterCustomerFirstName(String firstName) {
        getDriver().findElement(this.firstName).sendKeys(firstName);
    }

    public void enterCustomerLastName(String lastName) {
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }

    public void enterCustomerPostcode(String postcode) {
        getDriver().findElement(this.postcode).sendKeys(postcode);
    }

    public void submitNewCustomer() {
        getDriver().findElement(this.submitCustomerBtn).click();

    }
}
