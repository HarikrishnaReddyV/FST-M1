package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity5 {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions act;
    private String firstname = "HRM";
    private String lastname = " User";

    @BeforeClass
    public  void setUp(){

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        WebElement dashboard = driver.findElement(By.id("menu_dashboard_index"));
        Assert.assertTrue(dashboard.isDisplayed(),"Homepage is not displayed");

    }

    @Test
    public void myInfoDetails() throws InterruptedException {
        WebElement myInfoTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
        act.moveToElement(myInfoTab).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Edit']")));
        driver.findElement(By.xpath("//input[@value='Edit']")).click();

        WebElement edtFname = driver.findElement(By.xpath("//input[@title='First Name']"));
        WebElement edtLname = driver.findElement(By.xpath("//input[@title='Last Name']"));
        edtFname.clear();
        edtLname.clear();
        edtFname.sendKeys("edt" + firstname);
        edtLname.sendKeys("edt" + lastname);
        WebElement maleGender = driver.findElement(By.xpath("//li//input[@value='1']"));
        WebElement femaleGender = driver.findElement(By.xpath("//li//input[@value='2']"));
        if(maleGender.isSelected()){
            femaleGender.click();
        }
        else {
            maleGender.click();
        }
        WebElement save = driver.findElement(By.xpath("//input[@value='Save']"));
        save.click();
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
