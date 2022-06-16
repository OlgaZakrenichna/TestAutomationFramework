package testAutomationFramework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InboxPage extends AbstractPage {
    private final String patternCost = "\\d,\\d{3}\\.\\d{2}";

    @FindBy(id = "ifmail")
    WebElement iframe;

    @FindBy(xpath = "(//h3)[2]")
    WebElement costField;

    @FindBy(id = "refresh")
    WebElement refreshBtn;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public String getTotalCost() {
        int refreshingNumber = 5;
        String cost = "not found";

        while (cost.contentEquals("not found") && refreshingNumber > 0) {
            try {
                driver.switchTo().frame(iframe);
                cost = waitVisibilityFor(costField).getText();
            } catch (Exception ex) {
                driver.switchTo().defaultContent();
                waitToBeClickableFor(refreshBtn).click();
                refreshingNumber--;
            }
        }
        Matcher matcher = Pattern.compile(patternCost).matcher(cost);
        return matcher.find() ? matcher.group() : cost;
    }
}
