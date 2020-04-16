package driver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxCustomDriver extends Driver {

    public void initializeDriver() {
        System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver");
        setDriver(new FirefoxDriver());
        getDriver().manage().window().maximize();
    }
}
