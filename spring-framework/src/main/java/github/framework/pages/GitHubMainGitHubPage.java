package github.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class GitHubMainGitHubPage extends BaseGitHubPage {
    private final String searchResultXpath = "//ul[@class='repo-list']/li[%s]/*[contains(., '%s')]";
    private final String userIconXpath = "//div/a[@role='menuitem' and @href='/%s'][1]";

    @FindBy(xpath = "//div[@role='search']/input")
    private WebElement searchInput;

    public WebElement getLoggedInUserIcon(String userName) {
        return driver.getDriver().findElement(
                By.xpath(String.format(userIconXpath, userName)));
    }

    public WebElement getSearchResult(String number, String name) {
        return driver.getDriver().findElement(
                By.xpath(String.format(searchResultXpath, number, name)));
    }
}
