package com.j4me.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

/**
 * Created by pedro at 13.03.21
 */
public class WebDriverSetup {

    protected WebDriver driver;
    protected WebDriverWait wait;


    void sleep(int milliseonds) {
        try {
            Thread.sleep(milliseonds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // The annotated method will be run before the first test method in the current class is invoked.
    @Parameters({"selectedDriver"})
    @BeforeClass(alwaysRun = true)
    public void setupTest(@Optional("selectedDriver") String selectedDriver) {
        System.out.println("Before class");
        switch( selectedDriver) {
            case "chrome":
                System.out.println("Chrome selected");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

//                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("Firefox selected");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

//                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//                driver = new FirefoxDriver();
                break;
            case "safari":
//                System.out.println("Safary selected");
//                WebDriverManager.safaridriver().setup();
//                driver = new SafariDriver();
//                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//                driver = new SafariDriver();
                break;
            default:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        if( driver != null) {
            driver.manage().window().maximize();
            // Implicit wait default
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Explicit wait default timeout
            // Selenium 4
            //wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
            // Selenium 3
            wait = new WebDriverWait(driver, 10);
        }

    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        System.out.println("teardown called");
        if (driver != null) {
            //driver.quit();
        }
    }
}
