import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"github/framework/stepdefs"},
        tags = {"@first"},
        features = {"src/test/resources/github/features"},
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"})
public class CucumberTestRunner {

}
