package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestSteps {
     WebDriverWait wait;
     WebDriver driver;

     @Given("User is on Login page")
    public void userLogin(){
         System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
         WebDriverManager.firefoxdriver().setup();
         driver= new FirefoxDriver();
         driver.get("https://www.training-support.net/selenium/login-form");
     }
     @When("^User enters \"(.*)\" and \"(.*)\"$")
             public void userEntersCredentials(String username, String pwd){
             WebElement userName = driver.findElement(By.id("username"));
             WebElement password = driver.findElement(By.id("password"));
             userName.sendKeys(username);
             password.sendKeys(pwd);
             driver.findElement(By.xpath("//button[text()='Log in']")).click();
      }
      @Then("Read the page title and confirmation message")
     public void readPageTitle(){
         String pageTitle = driver.getTitle();
         String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
         System.out.println("Page Title is " +pageTitle);
          System.out.println("login message is " + loginMessage);
      }
      @And("Close the Browser")
    public void closeBrowser(){
         driver.quit();
      }

}
