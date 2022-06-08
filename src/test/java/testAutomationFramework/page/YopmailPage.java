package testAutomationFramework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;


public class YopmailPage extends AbstractPage {
    private String emailGeneratorPageId;

    @FindBy(xpath = "//b[contains(text(), 'Random')]/../..")
    WebElement generatorBtn;

    @FindBy(xpath = "//div[contains(text(), '@')]")
    WebElement emailField;

    @FindBy(xpath = "//*[text()='Check Inbox']/..")
    WebElement checkInboxBtn;

    public YopmailPage(WebDriver driver) {
        super(driver);
    }

    public String generateEmailAddress(String url) {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(url);
        logger.info("Navigated to Email generator: URL=" + url);

        waitToBeClickableFor(generatorBtn).click();
        emailGeneratorPageId = driver.getWindowHandle();
        logger.info("Generated Email address");
        return waitVisibilityFor(emailField).getText();
    }

   public InboxPage openInbox() {
       driver.switchTo().window(emailGeneratorPageId);
       waitToBeClickableFor(checkInboxBtn).click();
       logger.info("Navigated to Inbox page");
       return new InboxPage(driver);
   }
}
