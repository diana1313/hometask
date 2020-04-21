package github.framework.spring;

import gherkin.ast.Scenario;
import github.framework.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.TestExecutionListeners;

@Configuration
@ComponentScan(basePackages = "github.framework")
@PropertySource(value = "classpath:application.properties")
@TestExecutionListeners(value = CustomTestExecutionListener.class)
public class ApplicationConfig {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);
    @Autowired
    DriverFactory driverFactory;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @After
    public void tearDown(Scenario scenario) {
        driverFactory.quit();
    }
}
