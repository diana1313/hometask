package github.framework.driver;

import org.openqa.selenium.firefox.FirefoxDriver;;

public class FirefoxCustomDriver extends Driver {

    public void initializeDriver() {
        setDriver(new FirefoxDriver());
        getDriver().manage().window().maximize();
    }
}
