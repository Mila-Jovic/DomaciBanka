import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLogin extends BasePage {

    private By yourName = By.id("userSelect");
    private By loginBtn = By.xpath("/html/body/div/div/div[2]/div/form/button");
    private By welcomeMassage = By.xpath("/html/body/div/div/div[2]/div/div[1]");

    private By depositSection = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By depositAmountBar = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By submitDepositBtn = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By depositSubmitedMessage = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");


    private By customerLogoutBtn = By.xpath("/html/body/div/div/div[1]/button[2]");


    public CustomerLogin(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getYourName() {
        return yourName;
    }

    public By getLoginBtn() {
        return loginBtn;
    }

    public By getDepositSection() {
        return depositSection;
    }

    public By getDepositAmountBar() {
        return depositAmountBar;
    }


    public void selectLoginCustomerName(String customer) {
        Select selectCustomer = new Select(getDriver().findElement(yourName));
        selectCustomer.selectByVisibleText(customer);
    }

    public void clickLogin() {
        getDriver().findElement(loginBtn).click();
    }

    public void clickDeposit() {
        getDriver().findElement(depositSection).click();

    }

    public String getWelcomeMassageText() {
        String messageText = getDriver().findElement(welcomeMassage).getText();
        return messageText;
    }

    public void addDepositAmount(String amount) {
        // Integer number = Integer.valueOf(x);  postoji li metoda za unos numerickih vrijednosti
        getDriver().findElement(depositAmountBar).sendKeys(amount);
    }

    public String getDepositMessage() {
        String messageTxt = getDriver().findElement(this.depositSubmitedMessage).getText();
        return messageTxt;
    }

    public void confirmDeposit() {
        getDriver().findElement(submitDepositBtn).click();

    }

    public void customerLogout() {
        getDriver().findElement(customerLogoutBtn).click();
    }
}
