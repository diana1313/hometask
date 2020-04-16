package driver;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public abstract class Driver {

    @Getter
    @Setter
    protected WebDriver driver;

    public abstract void initializeDriver();

}
