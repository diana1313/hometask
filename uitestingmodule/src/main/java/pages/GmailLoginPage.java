package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.temporal.ChronoUnit.SECONDS;

@DefaultUrl("https://accounts.google.com/signin/v2/identifier?service=mail&hl=en")
public class GmailLoginPage extends PageObject {

    @FindBy(xpath = "//input[@type='email']")
    private WebElementFacade emailInput;
    @FindBy(xpath = "//input[@type='password']")
    private WebElementFacade passwordInput;
    @FindBy(xpath = "//div[contains(text(),'Enter a valid email or phone number.')]")
    private WebElementFacade wrongEmailLabel;
    @FindBy(xpath = "//span[contains(text(),'Wrong password. Try again or click Forgot password to reset it.')] ")
    private WebElementFacade wrongPasswordLabel;
    @FindBy (xpath = "//div[@id='view_container' and contains(@data-app-config,'ServiceLogin')]")
    private WebElementFacade loginFormContainer;
    private String wrongEmailXpath = "//div[contains(text(),'%s')]";
    private String wrongPasswordXpath = "//span[contains(text(),'%s')] ";

    @WhenPageOpens
    public void setWaiter() {
        setImplicitTimeout(5, SECONDS);
        getDriver().manage().window().maximize();
    }

    public WebElementFacade getEmailInput() {
        return emailInput;
    }

    public WebElementFacade getLoginFormContainer() {
        return loginFormContainer;
    }

    public WebElementFacade getPasswordInput() {
        return passwordInput;
    }

    public void waitForPasswordInputToBeVisible() {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
    }

    public void waitForPageToLoad () {
        new WebDriverWait(getDriver(), 10, 20)
                .until(ExpectedConditions.visibilityOf(getLoginFormContainer()));
    }

    public WebElementFacade getWrongEmailLabel(String message) {
        return findBy(String.format(wrongEmailXpath, message));
    }

    public WebElementFacade getWrongPasswordLabel(String message) {
        return findBy(String.format(wrongPasswordXpath, message));
    }
}
