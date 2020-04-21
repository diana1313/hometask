package github.framework.stepdefs;

import github.framework.driver.DriverFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseStepsDef {

    @Autowired
    protected DriverFactory driver;

}