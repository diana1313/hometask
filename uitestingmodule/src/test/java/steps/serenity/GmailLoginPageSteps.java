package steps.serenity;

import net.thucydides.core.annotations.Step;
import pages.GmailLoginPage;

import java.util.concurrent.TimeUnit;


public class GmailLoginPageSteps {
    protected GmailLoginPage gmailLoginPage;

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
        gmailLoginPage.waitForPasswordInputToBeVisible();
        gmailLoginPage.getPasswordInput().typeAndEnter(password);
    }

    @Step
    public boolean checkIfErrorLabelWithMessageIsDisplayed(String message) {
        if (message.contains("email")) {
            return gmailLoginPage.getWrongEmailLabel(message).isDisplayed();
        }
        return gmailLoginPage.getWrongPasswordLabel(message).isDisplayed();
    }

    @Step
    public boolean checkIfLoginPageIsOpened() {
        gmailLoginPage.waitForPageToLoad();
        return gmailLoginPage.getLoginFormContainer().isDisplayed();
    }

}