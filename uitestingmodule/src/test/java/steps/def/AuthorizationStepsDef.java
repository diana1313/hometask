package steps.def;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import steps.serenity.GmailLoginPageSteps;

public class AuthorizationStepsDef {
    @Steps
    protected GmailLoginPageSteps gmailAuthorizationSteps;

    @Given("^I open Gmail Login page$")
    public void iOpenGmailLoginPage() {
        gmailAuthorizationSteps.openGmailLoginPage();
    }

    @When("^I enter \"?([^\"]*)\"? into \"?'(email|password)'\"? field and press enter on Gmail Login Page$")
    public void iEnterEmailIntoFieldAndPressEnterOnGmailLoginPage(String value, String fieldName) {
        if (fieldName.equals("email")) {
            gmailAuthorizationSteps.enterEmailIntoField(value);
        } else gmailAuthorizationSteps.enterPasswordIntoField(value);
    }

    @Then("^I check that error message with text appeared on Gmail Login Page:$")
    public void iCheckThatErrorMessageWithTextAppeared(String expectedMessage) {
        Assert.assertTrue(String.format("Expected error message didn't appear: %s", expectedMessage),
                gmailAuthorizationSteps.checkIfErrorLabelWithMessageIsDisplayed(expectedMessage));
    }

    @Then("^I check that I was logged out and got back to Gmail Login Page$")
    public void iCheckThatIWasLoggedOutAndGotBackToGmailLoginPage() {
        Assert.assertTrue("Login page was expened to be opened",
                gmailAuthorizationSteps.checkIfLoginPageIsOpened());
    }
}
