package github.framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("firefox")
public class FirefoxDriverFactory implements DriverFactory {

    @Autowired
    protected WebDriver driver;

    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public void quit() {
        driver.quit();
    }
}
