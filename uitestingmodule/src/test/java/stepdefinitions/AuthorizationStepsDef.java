package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.GmailAuthorizationSteps;

public class AuthorizationStepsDef {

    @Steps
    GmailAuthorizationSteps gmailAuthorizationSteps;

    @Given("^I open Gmail Login page$")
    public void iOpenGmailLoginPage() {
        gmailAuthorizationSteps.openGmailLoginPage();
    }


    @When("^I enter \"?([^\"]*)\"? into \"?(email|password)\"? field and press enter on Gmail Login Page$")
    public void iEnterEmailIntoFieldAndPressEnterOnGmailLoginPage( String value, String fieldName) {
        if (fieldName.equals("email")) {
            gmailAuthorizationSteps.enterEmailIntoField(value);
        } else gmailAuthorizationSteps.enterPasswordIntoField(value);
    }


    @Then("^I check that I was successfully logged in with email \"?([^\"]*)\"? to Gmail Inbox$")
    public void iCheckThatIWasSuccessfullyLoggedInWithEmailUser_emailToGmailInbox(String email) {
        gmailAuthorizationSteps.checkIfIconForLoggedInUserIsDisplayed(email);

    }

    @Then("^I check that error message with text appeared:$")
    public void iCheckThatErrorMessageWithTextAppeared(String expectedMessage) {

    }
}
