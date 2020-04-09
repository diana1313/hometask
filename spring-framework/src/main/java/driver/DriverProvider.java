package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class DriverProvider {

    private static WebDriver driver;

    public WebDriver getDriverInstance() {
        if (driver == null) {
            WebDriverManager.getInstance(CHROME).setup();
            WebDriver driver = new ChromeDriver();

        }
        return driver;
    }

    public void killDriverInstance() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
