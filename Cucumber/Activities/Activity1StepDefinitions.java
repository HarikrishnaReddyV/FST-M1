package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1StepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on the Google webpage")
    public void userIsOnGoogleWebPage() {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://google.com");
    }
    @When("User types in cheese and hit enter")
     public void userTypeInCheeseAndHitsEnter(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);

    }
    @Then("User should see how many search results were found")
    public void userShouldSeeSearhResults(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("The Total number of results found is : " + resultStats);

    }

    @And("The browser should close")
    public void closeBrowser(){
        driver.quit();
    }
}
