package testAutomationFramework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "(//div['gs-title']/a[contains(@href, 'cloud.google.com/products/calculator')])[1]")
    WebElement searchResult;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage getPricingCalculator() {
        logger.info("Navigated to Search page");
        waitVisibilityFor(searchResult).click();

        return new PricingCalculatorPage(driver);
    }
}
