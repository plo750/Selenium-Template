package com.j4me;

import com.j4me.base.WebDriverSetup;
import org.testng.annotations.*;

/**
 * Created by pedro at 22.02.21
 */
public class DefaultTest extends WebDriverSetup {

//      BeforeSuite
//          '   BeforeTest
//          '   '   BeforeClass
//          '   '   '   BeforeMethod
//          '   '   '   '   myTestMethod3
//          '   '   '   AfterMethod
//          '   '   AfterClass
//          '   AfterTest
//      AfterSuite

    @Test
    public void newTest() {
        String url = "http://the-internet.herokuapp.com/login";
        driver.get(url);
        return;
    }

    @AfterClass( alwaysRun = true )
    void closeDriver() {
        if( driver != null) {
            System.out.println("closeDriver called!");
            driver.quit();
        }
    }

}
