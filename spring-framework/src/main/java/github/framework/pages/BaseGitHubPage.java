package github.framework.pages;

import github.framework.driver.DriverFactory;
import github.framework.pages.components.GitHubSearchBar;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseGitHubPage implements Page, Loadable {
    private static final String GITHUB_ICON_XPATH = "//a[@class='Header-link' and @href='https://github.com/'][1]";
    private static final String BASE_URL = "https://github.com";

    @Getter
    @Autowired
    public GitHubSearchBar searchBar;
    @Autowired
    protected DriverFactory driver;

    @Override
    public void openPage() {
        driver.getDriver().get(BASE_URL);
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    @Override
    public void waitOnLoad() {
        new WebDriverWait(driver.getDriver(), 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GITHUB_ICON_XPATH)));
    }
}
