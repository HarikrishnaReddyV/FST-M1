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

import java.util.List;

public class Activity7 {

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
   public void addQulaifications(){
       WebElement myInfoTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']"));
       act.moveToElement(myInfoTab).click().build().perform();
       List<WebElement> sideNavigationMenu = driver.findElements(By.xpath("//ul[@id='sidenav']/li"));
       for (WebElement menuitems : sideNavigationMenu){
           String MenuList = menuitems.getText();
           if(MenuList.equals("Qualifications")){
               menuitems.click();
               break;
           }

       }
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='actionWorkExperience']/input")));
       driver.findElement(By.xpath("//p[@id='actionWorkExperience']/input")).click();
       driver.findElement(By.xpath("//input[@name='experience[employer]']")).sendKeys("IBM");
       driver.findElement(By.xpath("//input[@name='experience[jobtitle]']")).sendKeys("QA");
       driver.findElement(By.xpath(" //input[@id='btnWorkExpSave']")).click();

   }
   @AfterClass
    public void tearDown(){
        driver.quit();
   }






}
