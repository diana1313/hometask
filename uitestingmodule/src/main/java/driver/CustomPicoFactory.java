package driver;


import cucumber.runtime.java.picocontainer.PicoFactory;
import helpers.PropertiesReader;

public class CustomPicoFactory extends PicoFactory {

    public CustomPicoFactory() {
        String browser = PropertiesReader.getPropertyValue("driver").toLowerCase();
        switch (browser) {
            case "firefox":
                addClass(FirefoxCustomDriver.class);
                break;
            case "chrome":
                addClass(ChromeCustomDriver.class);
                break;
        }
    }
}