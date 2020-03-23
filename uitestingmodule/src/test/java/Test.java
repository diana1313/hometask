import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"uitestingmodule/src/test/resources/features/gmail"},
        glue = "uitestingmodule/src/test/java/stepdefinitions")
public class Test {
}