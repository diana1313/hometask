import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@CucumberOptions(features = {"github/features"},
        glue = {"stepdefs"})
public class CucumberTestRunner {

}
