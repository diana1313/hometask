package github.framework.driver;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("firefox")
public class FirefoxDriverFactory implements DriverFactory {

    private WebDriver driver;

    @Bean(destroyMethod = "quit")
    @Override
    public WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    @Override
    public void quit() {
        if (driver != null) {
            driver.quit();
        driver=null;
        }
    }

    @Override
    public void initializeDriver() {
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        driver = new FirefoxDriver();
    }
}
