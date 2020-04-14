package github.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class GitHubLoginPage extends BasePage {
    private static final String BASE_URL = "https://github.com/login";
    @FindBy(id = "login_field")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement sighInButton;

    @Override
    public void openPage() {
        driverProvider.getDriverInstance().get(BASE_URL);
    }

    public void enterValueIntoLoginField (String value){
        loginField.sendKeys(value);
    }

    public void enterValueIntoPasswordField (String value){
        loginField.sendKeys(value);
    }

    public void clickOnSignInButton() {
        sighInButton.click();
    }
}
