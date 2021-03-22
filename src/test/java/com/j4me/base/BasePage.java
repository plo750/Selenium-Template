package com.j4me.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


/**
 * Created by pedro at 13.03.21
 */
public class BasePage {

    protected Logger log;

    // The annotated method will be run before the first test method in the current class is invoked.
    @BeforeClass(alwaysRun = true)
    public void setupTest(ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        log.info("setupTest called");
    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        log.info("teardown called");
    }
}
