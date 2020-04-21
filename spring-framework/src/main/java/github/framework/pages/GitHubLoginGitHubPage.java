package github.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class GitHubLoginGitHubPage extends BaseGitHubPage {
    private static final String BASE_URL = "https://github.com/login";
    @FindBy(id = "login_field")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement sighInButton;

    @Override
    public void openPage() {
        driver.getDriver().get(BASE_URL);
    }

    @Override
    public void waitOnLoad() {
        new WebDriverWait(driver.getDriver(), 20)
                .until(ExpectedConditions.visibilityOf(sighInButton));
    }

    public void enterValueIntoLoginField(String value) {
        loginField.sendKeys(value);
    }

    public void enterValueIntoPasswordField(String value) {
        passwordField.sendKeys(value);
    }

    public void clickOnSignInButton() {
        sighInButton.click();
    }
}
