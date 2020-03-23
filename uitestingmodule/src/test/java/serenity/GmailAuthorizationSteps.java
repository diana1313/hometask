package serenity;

import net.thucydides.core.annotations.Step;
import pages.GmailInboxPage;
import pages.GmailLoginPage;

import java.time.Duration;

public class GmailAuthorizationSteps {
    GmailLoginPage gmailLoginPage;
    GmailInboxPage gmailInboxPage;

    @Step
    public void openGmailLoginPage() {
        gmailLoginPage.open();
    }

    @Step
    public void enterEmailIntoField(String email) {
        gmailLoginPage.getEmailInput().waitUntilEnabled().typeAndEnter(email);
    }

    @Step
    public void enterPasswordIntoField(String password) {
        gmailLoginPage.waitForPageToLoad();
        gmailLoginPage.getPasswordInput().typeAndEnter(password);
    }

    @Step
    public boolean checkIfWrongEmailLabelIsDisplayed(String message) {
        return gmailLoginPage.getWrongEmailLabel().isDisabled();
    }

    @Step
    public boolean checkIfWrongPasswordLabelIsDisplayed() {
        return gmailLoginPage.getWrongPasswordLabel().isDisabled();
    }

    @Step
    public boolean checkIfIconForLoggedInUserIsDisplayed(String email) {
        gmailInboxPage.waitPageToLoad();
        return gmailInboxPage.getLoggedInUserIcon(email).isDisabled();
    }
}