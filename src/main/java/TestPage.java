import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPage {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private ManagerLogin managerLogin;
    private CustomerLogin customerLogin;
    private AddCustomerPage addCustomerPage;
    private CustomersPage customersPage;
    private BasePage basePage;
    private OpenAccountPage openAccountPage;
    private WithdrawalOptionsPage withdrawalOptionsPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mila-\\Desktop\\EXE file\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        loginPage = new LoginPage(driver, driverWait);
        managerLogin = new ManagerLogin(driver, driverWait);
        customerLogin = new CustomerLogin(driver, driverWait);
        addCustomerPage = new AddCustomerPage(driver, driverWait);
        basePage = new BasePage(driver, driverWait);
        openAccountPage = new OpenAccountPage(driver, driverWait);
        withdrawalOptionsPage = new WithdrawalOptionsPage(driver, driverWait);


        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterClass
    public void afterClass() {
        driver.close();
        System.out.println("P, sva ova cekanja su petty revenge (ﾒ﹏ﾒ)");
    }

    @BeforeMethod
    public void doBeforeMethod() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    @Test(priority = 1)
    public void bankManagerLogin() throws InterruptedException {
        //Test 1: Logovanje kao Bank Manager

        Thread.sleep(5000);
        driverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getManagerLogin()));
        Thread.sleep(5000);
        loginPage.clickManagerLogin();
        Thread.sleep(5000);
        Assert.assertEquals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager", driver.getCurrentUrl());

    }

    @Test(priority = 2)
    public void makeNewCustomer() throws InterruptedException {
        ////Test 2: Kreiranje Customera

//        Thread.sleep(10000);
        driverWait.until(ExpectedConditions.elementToBeClickable(managerLogin.getAddCustomer()));
        managerLogin.clickAddCustomer();
        Thread.sleep(10000);
        driverWait.until(ExpectedConditions.elementToBeClickable(addCustomerPage.getFirstName()));
        addCustomerPage.enterCustomerFirstName("Mila");
        addCustomerPage.enterCustomerLastName("Jovic");
        addCustomerPage.enterCustomerPostcode("21000");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        addCustomerPage.submitNewCustomer();
        String actualResult = basePage.alertMessages();
        Assert.assertTrue(actualResult.contains("Customer added successfully"));
        basePage.skipAlertMessages();
    }

    @Test(priority = 3)
    public void createCustomerAccount() {
        //Test 3: Kreiranje Accounta za tog Customera

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        managerLogin.clickOpenAccount();
        driverWait.until(ExpectedConditions.elementToBeClickable(openAccountPage.getOaCustomerSelect()));
        openAccountPage.selectOpenAccountCustomer("Mila Jovic");
        openAccountPage.selectOpenAccountCurrency("Dollar");
        openAccountPage.clickProcess();
        String actualResults = basePage.alertMessages();
        Assert.assertTrue(actualResults.contains("Account created successfully"));
        basePage.skipAlertMessages();
    }

    @Test(priority = 4)

    public void managerLogout() throws InterruptedException {
        managerLogin.managerLogout();
        Thread.sleep(5000);
        Assert.assertEquals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer", driver.getCurrentUrl());
    }


    @Test(priority = 5)
//Test 4: Logovanje kao Customer

    public void customerLogin() {
        managerLogin.cliclkHomeBtn();
        driverWait.until(ExpectedConditions.elementToBeClickable(loginPage.getCustomerLogin()));
        loginPage.clickCustomerLogin();
        driverWait.until(ExpectedConditions.elementToBeClickable(customerLogin.getYourName()));
        customerLogin.selectLoginCustomerName("Mila Jovic");
        driverWait.until(ExpectedConditions.elementToBeClickable(customerLogin.getLoginBtn()));
        customerLogin.clickLogin();
        String expectedResult = customerLogin.getWelcomeMassageText();
        Assert.assertTrue(expectedResult.contains("Welcome"));
    }

    @Test(priority = 6)
    //Test 5: Uspešan Deposit za nekog Customera

    public void depositMoney() throws InterruptedException {
        driverWait.until(ExpectedConditions.elementToBeClickable(customerLogin.getDepositSection()));
        customerLogin.clickDeposit();
        driverWait.until(ExpectedConditions.elementToBeClickable(customerLogin.getDepositAmountBar()));
        customerLogin.addDepositAmount("5");
        customerLogin.confirmDeposit();
        String actualResult = customerLogin.getDepositMessage();
        String expectedResult = "Deposit Successful";
        Assert.assertEquals(actualResult, expectedResult);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(3000);
    }

    @Test(priority = 7)

    public void customerWithdrawal() throws InterruptedException {
        //Test 6: Uspešan Withdrawal za nekog Customera
        driverWait.until(ExpectedConditions.elementToBeClickable(withdrawalOptionsPage.getWithdrawalSection()));
        withdrawalOptionsPage.clickWithdrawalSection();
        Thread.sleep(3000);
        driverWait.until(ExpectedConditions.elementToBeClickable(withdrawalOptionsPage.getWithdrawalAmountBar()));
        withdrawalOptionsPage.addWithdrawalAmount(4);
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        withdrawalOptionsPage.confirmWithdrawal();
        String actualMassage = withdrawalOptionsPage.getWithdrawalMessage();
        Assert.assertTrue(actualMassage.contains("successful"));
    }

    @Test(priority = 8)

    public void customerLogout() {
        customerLogin.customerLogout();
        Assert.assertEquals("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer", driver.getCurrentUrl());

    }
}
