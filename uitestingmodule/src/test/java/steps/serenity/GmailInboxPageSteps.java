package steps.serenity;

import net.thucydides.core.annotations.Step;
import pages.GmailInboxPage;

public class GmailInboxPageSteps {
    protected GmailInboxPage gmailInboxPage;

    @Step
    public boolean checkIfIconForLoggedInUserIsDisplayed(String email) {
        gmailInboxPage.waitPageToLoad();
        return gmailInboxPage.getLoggedInUserIcon(email).isDisplayed();
    }

    @Step
    public void invokeMenuForLoggedInUser() {
        gmailInboxPage.getLoggedInUserIcon().waitUntilVisible().click();
    }

    @Step
    public void clickOnLogoutButtonInUserMenu() {
        gmailInboxPage.getLogoutButton().waitUntilVisible().click();
    }

    @Step
    public void clickOnComposeButton() {
        gmailInboxPage.getButtonCompose().waitUntilVisible().click();
    }

    @Step
    public void clickOnSendButton() {
        gmailInboxPage.getSendButton().click();
    }

    @Step
    public void closeWriteLetterDialog() {
        gmailInboxPage.getCloseLetterDialogIcon().waitUntilVisible().click();
    }

    @Step
    public boolean checkIfWriteLetterDialogIsOpened() {
        return gmailInboxPage.getToWhomInput().isDisplayed() &&
                gmailInboxPage.getLetterBodyInput().isDisplayed();
    }

    @Step
    public void enterValueIntoInputWithName(String inputName, String value) {
        gmailInboxPage.getInputWithName(inputName).waitUntilEnabled().typeAndEnter(value);
    }

    @Step
    public void selectTabWithNameInSideMenu(String tabName) {
        gmailInboxPage.getMenuItemByName(tabName).waitUntilEnabled().click();
    }

    @Step
    public void deleteEmailWithSubject(String subject) {
        gmailInboxPage.getLabelOfSentEmail(subject).waitUntilVisible().click();
        gmailInboxPage.getDeleteLetterIcon().waitUntilVisible().click();
    }

    @Step
    public boolean checkIfLetterWithSubjectIsDisplayed(String subject){
       return gmailInboxPage.getLabelOfSentEmail(subject).isDisplayed();
    }

    @Step
    public boolean checkIfLabelNoSentMessagesIsDisplayed(){
        return gmailInboxPage.getNoSentMessagesLabel().waitUntilVisible().isDisplayed();
    }

}
