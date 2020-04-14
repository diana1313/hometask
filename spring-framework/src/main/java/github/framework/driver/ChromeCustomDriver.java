package github.framework.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeCustomDriver extends Driver {


    public void initializeDriver() {
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();
    }
}
