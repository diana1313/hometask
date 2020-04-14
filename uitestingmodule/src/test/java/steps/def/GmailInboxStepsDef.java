package steps.def;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import steps.serenity.GmailInboxPageSteps;

import java.util.List;
import java.util.Map;

public class GmailInboxStepsDef {
    @Steps
    protected GmailInboxPageSteps gmailInboxPageSteps;

    @When("^I make logout from my account on Gmail Inbox Page$")
    public void iMakeLogoutFromMyAccountOnGmailInboxPage() {
        gmailInboxPageSteps.invokeMenuForLoggedInUser();
        gmailInboxPageSteps.clickOnLogoutButtonInUserMenu();
    }

    @Then("^I check that I was successfully logged in with email \"?([^\"]*)\"? to Gmail Inbox$")
    public void iCheckThatIWasSuccessfullyLoggedInWithEmailUser_emailToGmailInbox(String email) {
        Assert.assertTrue(String.format("Icon for logged in user '%s' was not displayed", email),
                gmailInboxPageSteps.checkIfIconForLoggedInUserIsDisplayed(email));
    }

    @When("^I fill input fields of 'Write Letter dialog' with set of following data and SEND email:$")
    public void iFillInputFieldsOfWriteLetterDialogWithSetOfFollowingData(DataTable dataTable) {
        List<Map<String, String>> listOfMaps = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> data : listOfMaps) {
            String inputFieldName = data.get("input_name");
            String value = data.get("value");
            gmailInboxPageSteps.enterValueIntoInputWithName(inputFieldName, value);
        }
        gmailInboxPageSteps.clickOnSendButton();
    }

    @When("^I \"?(invoke|close)\"? 'Write Letter dialog' on Gmail Inbox Page$")
    public void iInvokeWriteLetterDialogOnGmailInboxPage(String state) {
        if ("invoke".equals(state)) {
            gmailInboxPageSteps.clickOnComposeButton();
        } else gmailInboxPageSteps.closeWriteLetterDialog();
    }

    @When("^I open a tab \"?([^\"]*)\"? from side menu on Gmail Inbox page$")
    public void iOpenATabFromSideMenuOnGmailInboxPage(String tabName) {
        gmailInboxPageSteps.selectTabWithNameInSideMenu(tabName);
    }


    @Then("^I the letter with \"?([^\"]*)\"? is present in Sent$")
    public void iTheLetterWithSubjectIsPresentInSent(String subject) {
        Assert.assertTrue(String.format("Letter with subject: '%s' is not displayed in Sent", subject),
                gmailInboxPageSteps.checkIfLetterWithSubjectIsPresent(subject));
    }

    @When("^I delete the message with \"?([^\"]*)\"? from Sent$")
    public void iDeleteTheMessageWithSubjectFromSent(String subject) {
        gmailInboxPageSteps.deleteEmailWithSubject(subject);
    }

    @Then("^I check there is no messages in Sent$")
    public void iCheckThereIsNoMessagesInSent() {
        Assert.assertTrue("'No Sent messages' laber is not displayed. Sent are not empty",
                gmailInboxPageSteps.checkIfLabelNoSentMessagesIsDisplayed());
    }
}