package Activities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Activity4 {
    private WebDriver driver;
    private WebDriverWait wait;
    private String firstname = "HariKrishna";
    private String lastname = " Reddy V";

    @BeforeClass
    public  void setUp(){

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://alchemy.hguy.co/orangehrm");

    }
    @Test
    public void Login(){
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        WebElement button = driver.findElement(By.id("btnLogin"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        button.click();
        WebElement dashboard = driver.findElement(By.id("menu_dashboard_index"));
        Assert.assertTrue(dashboard.isDisplayed(),"Homepage is not displayed");

    }

    @Test
    public void addNewEmployee(){
        WebElement pim = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
        pim.click();

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnAdd']")));
        WebElement addEmployeeButton = driver.findElement(By.xpath("//a[text()='Add Employee']"));
        addEmployeeButton.click();
        WebElement fName = driver.findElement(By.id("firstName"));
        WebElement lName = driver.findElement(By.id("lastName"));
        WebElement save = driver.findElement(By.id("btnSave"));
        fName.sendKeys(firstname);
        lName.sendKeys(lastname);
        save.click();
    }
    @Test
    public void verifyEmployee() {

        driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
        driver.findElement(By.xpath("//a[text()='Employee List']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys(firstname + lastname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ac_results']/ul/li")));
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
        //int totalNames = names.size();
        String empName = null;
        for (WebElement name : names) {
            empName = name.getText();
        }
        Boolean ExpectedName = empName.contains(firstname + lastname);
        Assert.assertTrue(ExpectedName,"Employee is not added");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
