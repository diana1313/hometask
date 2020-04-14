package github.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class GitHubMainPage extends BasePage {
    private final String searchResultXpath = "//ul[@class='repo-list']/li[%s]/*[contains(., '%s')]";
    @FindBy(xpath = "//div[@role='search']/input")
    private WebElement searchInput;
    @FindBy(xpath = "//div[@role='combobox']//form[@role='search']")
    private WebElement globalSearch;


    public WebElement getSearchResult(String number, String name) {
        return driverProvider.getDriverInstance().findElement(
                By.xpath(String.format(searchResultXpath, number, name)));
    }


}
