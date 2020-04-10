package processor;

import driver.DriverProvider;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import pages.BasePage;

@Component
public class PageInitializingBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private DriverProvider driverProvider;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BasePage) {
            PageFactory.initElements(driverProvider.getDriverInstance(), bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
