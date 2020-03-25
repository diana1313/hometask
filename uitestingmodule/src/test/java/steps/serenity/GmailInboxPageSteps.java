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
}
