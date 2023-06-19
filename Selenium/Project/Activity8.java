package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Activity8 {
    private WebDriver driver;
    private Actions act;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        act = new Actions(driver);
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
        driver.manage().window().maximize();
        WebElement dashboard = driver.findElement(By.id("menu_dashboard_index"));
        Assert.assertTrue(dashboard.isDisplayed(),"Homepage is not displayed");

    }
    @Test
    public void applyLeave(){
        driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();
        WebElement LeaveType = driver.findElement(By.xpath("//select[@name='applyleave[txtLeaveType]']"));
        Select sel = new Select(LeaveType);
        sel.selectByVisibleText("DayOff");
        //DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        //Date date = new Date();
       // String fromDate = dateFormat.format(date);
        String fromDate = "2023-06-16";
        String toDate = "2023-06-18";
        WebElement FromDate  =   driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
        WebElement ToDate  =   driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']"));
        FromDate.clear();
        FromDate.sendKeys(fromDate);
        ToDate.clear();
        ToDate.sendKeys(toDate);
        driver.findElement(By.xpath("//input[@id='applyBtn']")).click();


    }

    @Test
    public void leaveStatus(){
       // WebElement MyLeavetab = driver.findElement(By.xpath("//a[contains(@href,'MyLeaveList')]"));
       // act.moveToElement(MyLeavetab).click().build().perform();
        driver.findElement(By.xpath("//a[contains(@href,'MyLeaveList')]")).click();
        String status = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[6]")).getText();
        System.out.println("Status of My Leave Application is " + status);

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
