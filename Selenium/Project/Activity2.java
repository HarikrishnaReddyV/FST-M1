package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    private WebDriver driver;
    @BeforeClass
    public  void setUp(){

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");

    }
    @Test
    public void printHeaderUrl(){
    String url = driver.findElement(By.xpath("//div[@id='divLogo']/img")).getAttribute("src");
    System.out.println("url of the header image is " + url);
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
