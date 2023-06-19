package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    //craete webdriver
    private WebDriver driver ;
    @BeforeClass
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }
    @Test
    public void checkOriginalTitle(){
        String title = driver.getTitle();
        Assert.assertEquals("Training Support",title);

    }
    @Test
    public void clickAboutUsButton(){
        WebElement button = driver.findElement((By.id("about-link")));
       Assert.assertNotNull(button);
       button.click();

    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

}

