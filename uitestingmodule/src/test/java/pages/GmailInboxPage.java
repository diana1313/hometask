package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@DefaultUrl("https://mail.google.com/mail/u/0/#inbox")
public class GmailInboxPage extends PageObject {

    @FindBy(xpath = "//div[@role='button' and text()]")
    WebElementFacade buttonWriteEmail;
    private String iconXpath = "//div/a[contains(@aria-label,'%s')]";

    public WebElementFacade getEmailInput() {
        return buttonWriteEmail;
    }

    public void waitPageToLoad() {

        new WebDriverWait(getDriver(), 10, 50)
                .until(ExpectedConditions.visibilityOf(getEmailInput()));
    }

    public WebElementFacade getLoggedInUserIcon(String email) {
        return findBy(String.format(iconXpath, email));
    }
}
