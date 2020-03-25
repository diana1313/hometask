package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@DefaultUrl("https://mail.google.com/mail/u/0/#inbox")
public class GmailInboxPage extends PageObject {

    @FindBy(xpath = "//div[@role='button' and text()]")
    WebElementFacade buttonWriteEmail;
    @FindBy(xpath = "//div/a[contains(@href,'SignOutOptions')]")
    WebElementFacade loggedInUserIcon;
    @FindBy(xpath = "//div/a[contains(@href,'Logout')]")
    WebElementFacade logoutButton;
    //write letter dialog
    @FindBy(xpath = "//textarea[@role='combobox'][1]")
    WebElementFacade toWhomInput;
    @FindBy(xpath = "//textarea[@role='combobox'][2]")
    WebElementFacade toWhomCopyInput;
    @FindBy(xpath = "//input[@name='subjectbox']")
    WebElementFacade letterSubjectInput;
    @FindBy(xpath = "//div[@role='textbox']")
    WebElementFacade letterBodyInput;
    @FindBy (xpath = "//div[@role='dialog']/descendant::img[3]")
    WebElementFacade closeLetterDialogIcon;
    private String iconXpath = "//div/a[contains(@aria-label,'%s')]";

    public WebElementFacade getToWhomCopyInput() {
        return toWhomCopyInput;
    }
    public WebElementFacade getCloseLetterDialogIcon() {
        return closeLetterDialogIcon;
    }

    public void waitPageToLoad() {
        new WebDriverWait(getDriver(), 10, 20)
                .until(ExpectedConditions.visibilityOf(getEmailInput()));
    }

    public WebElementFacade getButtonWriteEmail() {
        return buttonWriteEmail;
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

    public WebElementFacade getEmailInput() {
        return buttonWriteEmail;
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
}
