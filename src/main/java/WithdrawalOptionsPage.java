import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WithdrawalOptionsPage extends BasePage {

    private By withdrawalSection = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By withdrawalAmountBar = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By submitWithdrawalBtn = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By withdrawalMessage = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");

    public WithdrawalOptionsPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getWithdrawalSection() {
        return withdrawalSection;
    }

    public By getWithdrawalAmountBar() {
        return withdrawalAmountBar;
    }

    public void clickWithdrawalSection() {
        getDriver().findElement(withdrawalSection).click();
    }

    public void addWithdrawalAmount(int amount) {
        // Integer number = Integer.valueOf(x);  postoji li metoda za unos numerickih vrijednosti
        getDriver().findElement(withdrawalAmountBar).sendKeys((String.valueOf(amount)));
    }

    public void confirmWithdrawal() {
        getDriver().findElement(submitWithdrawalBtn).click();
    }

    public String getWithdrawalMessage() {
        String message = getDriver().findElement(this.withdrawalMessage).getText();
        return message;
    }
}
