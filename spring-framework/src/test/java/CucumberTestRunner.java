import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

@RunWith(Cucumber.class)
@ActiveProfiles("chrome")
@CucumberOptions(
        glue = {"stepdefs"},
        features = {"src/test/resources/github/features"})
public class CucumberTestRunner {

}
