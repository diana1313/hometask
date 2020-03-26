package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@DefaultUrl("https://mail.google.com/mail/u/0/#inbox")
public class GmailInboxPage extends PageObject {

    @FindBy(xpath = "//div[@role='button' and text()]")
    WebElementFacade buttonCompose;
    @FindBy(xpath = "//div/a[contains(@href,'SignOutOptions')]")
    WebElementFacade loggedInUserIcon;
    @FindBy(xpath = "//div/a[contains(@href,'Logout')]")
    WebElementFacade logoutButton;
    //write letter dialog
    @FindBy(xpath = "//textarea[@aria-label='To']")
    WebElementFacade toWhomInput;
    @FindBy(xpath = "//div[@role='dialog']//span/span[@role='link']")
    WebElementFacade toWhomCopyInputInvoker;
    @FindBy(xpath = "//textarea[@aria-label='Cc']")
    WebElementFacade toWhomCopyInput;
    @FindBy(xpath = "//input[@name='subjectbox']")
    WebElementFacade letterSubjectInput;
    @FindBy(xpath = "//div[@aria-label='Message Body']")
    WebElementFacade letterBodyInput;
    @FindBy(xpath = "//div[text()='Send']")
    WebElementFacade sendButton;
    @FindBy(xpath = "//div[@role='dialog']/descendant::img[3]")
    WebElementFacade closeLetterDialogIcon;
    @FindBy(xpath = "//div[@aria-label='Delete']")
    WebElementFacade deleteLetterIcon;
    @FindBy(xpath = "//td[contains(text(),'No sent messages!')]")
    WebElementFacade noSentMessagesLabel;
    private String iconXpath = "//div/a[contains(@aria-label,'%s')]";
    private String menuItemXpath = "//div[@class='TK']//div[@data-tooltip='%s']";
    private String sentEmailХpath = "(//span[contains(text(),'%s')])[2]";

    public WebElementFacade getSendButton() {
        return sendButton;
    }


    public WebElementFacade getNoSentMessagesLabel() {
        return noSentMessagesLabel;
    }

    public WebElementFacade getLabelOfSentEmail(String subject) {
        return findBy(String.format(sentEmailХpath, subject));
    }

    public WebElementFacade getDeleteLetterIcon() {
        return deleteLetterIcon;
    }

    public void waitPageToLoad() {
        new WebDriverWait(getDriver(), 10, 20)
                .until(ExpectedConditions.visibilityOf(getButtonCompose()));
    }

    public WebElementFacade getCloseLetterDialogIcon() {
        return closeLetterDialogIcon;
    }

    public WebElementFacade getButtonCompose() {
        return buttonCompose;
    }

    public WebElementFacade getToWhomCopyInputInvoker() {
        return toWhomCopyInputInvoker;
    }

    public WebElementFacade getToWhomCopyInput() {
        return toWhomCopyInput;
    }

    public WebElementFacade getToWhomInput() {
        return toWhomInput;
    }

    public WebElementFacade getLetterSubjectInput() {
        return letterSubjectInput;
    }

    public WebElementFacade getLetterBodyInput() {
        return letterBodyInput;
    }


    public WebElementFacade getLoggedInUserIcon(String email) {
        return findBy(String.format(iconXpath, email));
    }

    public WebElementFacade getLoggedInUserIcon() {
        return loggedInUserIcon;
    }

    public WebElementFacade getLogoutButton() {
        return logoutButton;
    }

    public WebElementFacade getInputWithName(String inputName) {
        switch (inputName) {
            case "to":
                return getToWhomInput();
            case "cc":
                getToWhomCopyInputInvoker().click();
                return getToWhomCopyInput();
            case "subject":
                return getLetterSubjectInput();
            case "body":
                return getLetterBodyInput();
            default:
                throw new WebDriverException(String.format("Input with name '%s' does not much to any on page.", inputName));
        }
    }

    public WebElementFacade getMenuItemByName(String name) {
        return findBy(String.format(menuItemXpath, name));
    }

}
