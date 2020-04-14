package github.framework.pages;

import github.framework.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseGitHubPage implements Page, Loadable {
    private static final String GITHUB_ICON_XPATH = "//a[@class='Header-link' and @href='https://github.com/'][1]";
    private static final String BASE_URL = "https://github.com";
    @Autowired
    protected Driver driver;

    @Override
    public void openPage() {
        driver.getDriver().get(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    @Override
    public void waitForPageToLoad() {
        new WebDriverWait(driver.getDriver(), 20)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(GITHUB_ICON_XPATH)));
    }
}
