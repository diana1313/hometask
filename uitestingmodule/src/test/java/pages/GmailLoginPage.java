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

@DefaultUrl("https://mail.google.com/")
public class GmailLoginPage extends PageObject {

    @FindBy(xpath = "//input[@type='email']")
    private WebElementFacade emailInput;
    @FindBy(xpath = "//input[@type='password']")
    private WebElementFacade passwordInput;
    @FindBy(xpath = "///div[contains(text(),'Enter a valid email or phone number.')]")
    private WebElementFacade wrongEmailLabel;
    @FindBy(xpath = "//span[contains(text(),'Wrong password. Try again or click Forgot password to reset it.')] ")
    private WebElementFacade wrongPasswordLabel;
    private String wrongEmailXpath = "//div/a[contains(@aria-label,'%s')]";
    private String wrongPasswordXpath = "//div/a[contains(@aria-label,'%s')]";


    public GmailLoginPage() {
    }

    @WhenPageOpens
    public void setWaiter() {
        setImplicitTimeout(5, SECONDS);
        getDriver().manage().window().maximize();
    }

    public WebElementFacade getEmailInput() {
        return emailInput;
    }

    public void waitForPageToLoad() {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));

    }

    public WebElementFacade getPasswordInput() {
        return passwordInput;
    }

    public WebElementFacade getWrongEmailLabel() {
        return wrongEmailLabel;
    }

    public WebElementFacade getWrongPasswordLabel() {
        return wrongPasswordLabel;
    }

}
