package github.framework.stepdefs;

import github.framework.pages.GitHubMainGitHubPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class GitHubMainPageStepsDef {

    @Autowired
    protected GitHubMainGitHubPage mainPage;

    @When("I enter repository {string} into search input and press Enter on GitHub Main Page")
    public void iEnterRepositoryIntoSearchInputAndPressEnterOnGitHubMainPage(String searchedName) {
        mainPage.waitOnLoad();
        mainPage.getSearchBar().enterValueIntoSearchInput(searchedName);
    }

    @Then("I check {string} result contains {string} of repository I searched for on GitHub Main Page")
    public void iCheckResultContainsOfRepositoryISearchedForOnGitHubMainPage(String numberOfResult, String searchedName) {
        mainPage.waitOnLoad();
        Assert.assertTrue(String.format("Searched name '%s' was expected to be displayed in '%s' result",
                searchedName, numberOfResult),
                mainPage.getSearchResult(numberOfResult, searchedName).isDisplayed());
    }

    @Then("I check I was successfully logged in with my {string} to GitHub")
    public void iCheckIWasSuccessfullyLoggedInWithMyToGitHub(String userName) {
        mainPage.waitOnLoad();
        Assert.assertTrue(String.format("User '%s' was expected to be logged in", userName),
                mainPage.getLoggedInUserIcon(userName).isEnabled());
    }
}
