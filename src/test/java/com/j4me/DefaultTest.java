package com.j4me;

import com.j4me.base.BasePage;
import com.j4me.factory.BrowserDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

/**
 * Created by pedro at 22.02.21
 */
public class DefaultTest extends BasePage {

//      BeforeSuite
//          '   BeforeTest
//          '   '   BeforeClass
//          '   '   '   BeforeMethod
//          '   '   '   '   myTestMethod3
//          '   '   '   AfterMethod
//          '   '   AfterClass
//          '   AfterTest
//      AfterSuite

    protected WebDriver driver;

    @Parameters({ "browser" })
    @Test
    public void newTest(String browser, ITestContext ctx) {

        log.info("Starting negativeTest");
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);

        driver = factory.createDriver();

        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        return;
    }

    @AfterClass( alwaysRun = true )
    void closeDriver() {
        if( driver != null) {
            log.info("closeDriver called!");
            driver.quit();
        }
    }

}
