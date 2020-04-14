package github.framework.pages;

import github.framework.driver.DriverProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePage implements Page {

    private static final String BASE_URL = "https://github.com";
    @Autowired
    protected DriverProvider driverProvider;

    @Override
    public void openPage() {
        driverProvider.getDriverInstance().get(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }
}
