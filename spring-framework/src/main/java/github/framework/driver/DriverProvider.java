package github.framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

@Component
public class DriverProvider {

    public WebDriver getDriverInstance() {
        if (driver == null) {
            WebDriverManager.getInstance(CHROME).setup();
            WebDriver driver ;

        }
        return driver.get();
    }

    public void killDriverInstance() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
