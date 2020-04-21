package github.framework.driver;

import org.openqa.selenium.WebDriver;

public interface DriverFactory {

    WebDriver getDriver();

    void quit();

    void initializeDriver();
}
