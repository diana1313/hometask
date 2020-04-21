package github.framework.spring;

import github.framework.driver.DriverFactory;
import github.framework.pages.Loadable;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class PageInitializingBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    protected DriverFactory driver;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Loadable) {
            PageFactory.initElements(driver.getDriver(), bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

