package steps.serenity;

import net.thucydides.core.annotations.Step;
import github.framework.pages.GmailLoginPage;


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
        gmailLoginPage.getPasswordInput().waitUntilPresent().typeAndEnter(password);
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