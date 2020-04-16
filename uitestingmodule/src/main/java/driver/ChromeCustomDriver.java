package driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeCustomDriver extends Driver {

    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();
    }
}
