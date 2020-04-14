package stepdefs;

import github.framework.spring.TestConfig;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import github.framework.pages.GitHubMainPage;

@ContextConfiguration(classes = TestConfig.class)

public class GitHubMainPageStepsDef {
    @Autowired
    private GitHubMainPage mainPage;

    @Then("I check I was successfully logged in to GitHub")
    public void iCheckIWasSuccessfullyLoggedInToGitHub() {
    }

}
