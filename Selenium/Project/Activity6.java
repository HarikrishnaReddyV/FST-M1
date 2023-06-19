package Activities;

import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions act;

    @BeforeClass
    public void setUp(){
       System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
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
    public void verifyDirectory(){

        WebElement directoryButton = driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']"));
        act.moveToElement(directoryButton).build().perform();
        Assert.assertNotNull(directoryButton);
        directoryButton.click();
        String header = driver.findElement(By.xpath("//div[@class='head']/h1")).getText();
        Assert.assertEquals("Search Directory",header);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
