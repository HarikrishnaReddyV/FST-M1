package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
     private WebDriver driver;
    @BeforeClass
    public  void setUp(){

       System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
                driver.get("http://alchemy.hguy.co/orangehrm");

    }
    @Test
    public void assertTitle(){
        Assert.assertEquals("OrangeHRM",driver.getTitle());
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
