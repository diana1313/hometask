package github.framework.stepdefs;

import github.framework.pages.GitHubLoginGitHubPage;
import github.framework.spring.ApplicationConfig;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.Map;

@ContextConfiguration(classes = ApplicationConfig.class)
public class GitHubLoginPageStepsDef extends BaseStepsDef {

    @Autowired
    private GitHubLoginGitHubPage loginPage;

    @Given("I open GitHub Login page")
    public void iOpenGitHubLoginPage() {
        loginPage.openPage();
    }

    @When("I login with credentials and click on button 'Sign In' on GitHub Login Page:")
    public void iLoginWithCredentialsAndClickOnButtonSignInOnGitHubLoginPage(DataTable dataTable) {
        Map<String, String> credentials = dataTable.asMap(String.class, String.class);
        String loginValue = credentials.get("email");
        String passwordValue = credentials.get("password");
        loginPage.enterValueIntoLoginField(loginValue);
        loginPage.enterValueIntoPasswordField(passwordValue);
        loginPage.clickOnSignInButton();
    }
}
