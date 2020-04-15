package github.framework.driver;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class DriverProvider {

    DriverFactory factory;

    private ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    public WebDriver getInstance() {
        if (driverInstance.get() == null) {
            driverInstance.set(factory.getDriver());
        }
        return driverInstance.get();
    }

}
