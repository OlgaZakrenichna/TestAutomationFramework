package testAutomationFramework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;
    private static Logger logger = LogManager.getRootLogger();

    private DriverSingleton() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
            logger.info(driver.manage().window().getSize());
            driver.manage().window().setSize(new Dimension(1920, 980));
            logger.info(driver.manage().window().getSize());
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
