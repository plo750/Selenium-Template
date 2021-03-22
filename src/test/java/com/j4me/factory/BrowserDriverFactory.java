package com.j4me.factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by pedro at 22.03.21
 */
public class BrowserDriverFactory {

    protected Logger log;
    protected String browser;

    /**
     *
     * @param browser
     * @param log
     */
    public BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser;
        this.log = log;
    }

    /**
     *
     * @param driver
     * @return
     */
    public WebDriverWait createDriverWait( WebDriver driver) {
        // Explicit wait default timeout
        // Selenium 4
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        // Selenium 3
        return new WebDriverWait(driver, 10);
    }

    /**
     *
     * @return
     */
    public WebDriver createDriver() {
        WebDriver driver = null;
        log.info("Before class");
        switch (browser) {
            case "chrome":
                log.info("Chrome selected");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

//                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//                driver = new ChromeDriver();
                break;
            case "firefox":
                log.info("Firefox selected");
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
        }
        return driver;
    }

    /**
     *
     * @param driver
     * @param timeout
     */
    public void setDefaultTimeout(WebDriver driver, Long timeout) {
        // Implicit wait default
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }
}

