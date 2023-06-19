package Activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Activity2 {
    //craete webdriver
    private WebDriver driver ;
    @BeforeClass
    public void setUp(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public  void checkOriginalTitle() {
        String title = driver.getTitle();
        Assert.assertEquals("Target Practice", title);
    }
    @Test
    public void clickBlackButton(){
        WebElement button = driver.findElement((By.xpath("//button[text()='Black']")));
        Assert.assertNull(button);

    }
    @Test(enabled = false)
    public void skipTestWithEnabled(){

    }
    @Test
    public void skipTestWithException(){
        throw new SkipException("This test is skipped!");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
