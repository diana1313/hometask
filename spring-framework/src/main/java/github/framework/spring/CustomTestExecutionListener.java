package github.framework.spring;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestExecutionListener;

public class CustomTestExecutionListener implements TestExecutionListener, Ordered {
    private static final Logger logger = LoggerFactory.getLogger(CustomTestExecutionListener.class);

    public void beforeTestClass() {
        logger.info("beforeTestClass : {}");
    }

    public void prepareTestInstance() {
        logger.info("prepareTestInstance : {}");
    }

    public void beforeTestMethod() {
        logger.info("beforeTestMethod : {}");
    }


    public void afterTestMethod() {
        logger.info("afterTestMethod : {}");
    }

    public void afterTestClass() {
        logger.info("afterTestClass : {}");
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
