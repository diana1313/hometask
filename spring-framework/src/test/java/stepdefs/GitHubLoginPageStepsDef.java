package stepdefs;

import dto.UserDto;
import github.framework.spring.TestConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import github.framework.pages.GitHubLoginGitHubPage;

@ContextConfiguration(classes = TestConfig.class)
public class GitHubLoginPageStepsDef {

    @Autowired
    private GitHubLoginGitHubPage loginPage;

    @Given("I open GitHub Login page")
    public void iOpenGitHubLoginPage() {
        loginPage.openPage();
    }

    @When("I login with credentials and click on button 'Sign In' on GitHub Login Page:")
    public void iLoginWithCredentialsAndClickOnButtonSignInOnGitHubLoginPage(UserDto credentials) {
        loginPage.enterValueIntoLoginField(credentials.getEmail());
        loginPage.enterValueIntoPasswordField(credentials.getPassword());
        loginPage.clickOnSignInButton();
    }
}
