package github.framework.pages.components;

import github.framework.driver.DriverProvider;
import github.framework.pages.Loadable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GitHubSearchBar implements Loadable {
    @Autowired
    protected DriverProvider driver;

    @FindBy(xpath = "//div[@role='combobox']//form[@role='search']")
    private WebElement globalSearch;

    public void enterValueIntoSearchInput(String value) {
        globalSearch.sendKeys(value);
    }

    @Override
    public void waitOnLoad() {
        new WebDriverWait(driver.getInstance(), 20)
                .until(ExpectedConditions.visibilityOf(globalSearch));
    }
}