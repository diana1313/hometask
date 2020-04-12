package stepdefs;

import dto.UserDto;
import helpers.TestConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pages.github.GitHubLoginPage;

@ContextConfiguration(classes = TestConfig.class)
public class GitHubLoginPageStepsDef {

    @Autowired
    private GitHubLoginPage loginPage;

    @Given("I open GitHub Login page")
    public void iOpenGitHubLoginPage() {

    }

    @When("I login with credentials and click on button 'Sign In' on GitHub Login Page:")
    public void iLoginWithCredentialsAndClickOnButtonSignInOnGitHubLoginPage(UserDto credentials) {

    }
}
