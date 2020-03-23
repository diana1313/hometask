package stepdefinitions;

import cucumber.api.java.Before;
import helpers.PropertiesReader;
import io.github.bonigarcia.wdm.DriverManagerType;

import static io.github.bonigarcia.wdm.ChromeDriverManager.getInstance;

public class Hooks {

    @Before
    public void setupDriver() {
        getInstance(DriverManagerType.valueOf(PropertiesReader.getPropertyValue("webdriver.driver"))).setup();
    }


}
