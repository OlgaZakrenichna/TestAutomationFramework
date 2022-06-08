package testAutomationFramework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testAutomationFramework.driver.DriverSingleton;
import testAutomationFramework.page.PricingCalculatorPage;
import testAutomationFramework.util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected final String textToSearch = "Google Cloud Pricing Calculator\n";
    protected PricingCalculatorPage pricingCalculatorPage;
    protected String costValue;
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
