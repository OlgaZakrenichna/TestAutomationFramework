package testAutomationFramework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleHomePage extends AbstractPage {
    private final String url = "https://cloud.google.com";

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchInput;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage searchFor(String textToSearch) {
        driver.get(url);
        logger.info("Opened page: URL=" + url);
        waitToBeClickableFor(searchInput);
        searchInput.click();
        waitVisibilityFor(searchInput).sendKeys(textToSearch);
        return new SearchResultsPage(driver);
    }
}
