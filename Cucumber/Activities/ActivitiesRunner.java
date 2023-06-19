import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = {"stepDefinitions"},
        //tags = "@activity1"
        // tags = "@activity2"
        //tags = "@activity3"
        //tags = "@activity4"
        //tags = "@activity5"
        tags = "@SmokeTest",
        plugin = {"pretty"},
        monochrome = true
)
public class ActivitiesRunner {

}
