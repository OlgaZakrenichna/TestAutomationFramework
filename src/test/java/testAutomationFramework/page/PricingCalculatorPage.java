package testAutomationFramework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testAutomationFramework.model.ComputeEngine;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PricingCalculatorPage extends AbstractPage {
    private final String costPattern = "\\d,\\d{3}\\.\\d{2}";
    private final String operatingSystemOptionsXpath = "//*[contains(text(), '%s')]/ancestor::md-option";
    private final String machineClassOptionsXpath = "(//*[contains(text(), '%s')]/..)[2]";
    private final String seriesOptionsXpath = "//*[@value='%s']";
    private final String machineTypeOptionsXpath = "//*[ contains(text(), '%s')]/..";
    private final String gpuTypeOptionsXpath = "//*[contains(text(), '%s')]/ancestor::md-option";
    private final String numberOfGPUsOptionsXpath = "(//md-content/md-option[@value='%s'] )[14]";
    private final String localSsdOptionsXpath = "//*[contains(text(), '%s')]/..";
    private final String datacenterLocationOptionsXpath = "(//*[contains(text(), '%s')])[3]/..";
    private final String committedUsageOptionsXpath = "(//*[contains(text(), '%s')])[2]/..";
    private String calculatorPageId;

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement parentsFrame;

    @FindBy(id = "myFrame")
    WebElement childsFrame;

    @FindBy(xpath = "//div[@title='Compute Engine']/..")
    WebElement computeEngineBtn;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    WebElement numberOfInstancesInput;

    @FindBy(xpath = "//*[text()='Operating System / Software']/..//md-select-value")
    WebElement operatingSystemSelect;

    @FindBy(xpath = "//*[contains(text(), 'Provision')]/..//md-select-value")
    WebElement machineClassSelect;

    @FindBy(xpath = "//*[contains(text(), 'Series')]/../descendant::md-select-value")
    WebElement seriesSelect;

    @FindBy(xpath = "//*[text()='Machine type']/..//md-select-value")
    WebElement machineTypeSelect;

    @FindBy(xpath = "//*[ contains(text(), 'Add GPUs')]/..")
    WebElement addGPUsCheckbox;

    @FindBy(xpath = "//*[ contains(text(), 'GPU type')]/../md-select")
    WebElement gpuTypeSelect;

    @FindBy(xpath = "//*[ contains(text(), 'Number of GPUs')]/..//md-select-value")
    WebElement numberOfGPUsSelect;

    @FindBy(xpath = "//label[text()='Local SSD']/..//md-select-value")
    WebElement localSsdSelect;

    @FindBy(xpath = "//label[text()='Datacenter location']/..//md-select-value")
    WebElement datacenterLocationSelect;

    @FindBy(xpath = "//label[text()='Committed usage']/..//md-select-value")
    WebElement committedUsageSelect;

    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')]")
    WebElement addToEstimateBtn;

    @FindBy(xpath = "//*[@aria-label='Email']")
    WebElement emailBtn;

    @FindBy(xpath = "//label[contains(text(), 'Email')]/../input")
    WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    WebElement sendEmailBtn;

    @FindBy(xpath = "//b[contains(text(), 'Total')]")
    WebElement totalCostField;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage estimateCost(ComputeEngine computeEngine) {
        logger.info("Opened Pricing Calculator");
        switchIntoIframes();
        clickElement(computeEngineBtn);
        waitVisibilityFor(numberOfInstancesInput).sendKeys(computeEngine.getInstancesNumber());
        clickElement(operatingSystemSelect);
        clickElement(getElementWith(computeEngine.getOperatingSystem(), operatingSystemOptionsXpath));
        clickElement(machineClassSelect);
        clickElement(getElementWith(computeEngine.getMachineClass(), machineClassOptionsXpath));
        clickElement(seriesSelect);
        clickElement(getElementWith(computeEngine.getSeries(), seriesOptionsXpath));
        clickElement(machineTypeSelect);
        clickElement(getElementWith(computeEngine.getMachineType(), machineTypeOptionsXpath));
        clickElement(addGPUsCheckbox);
        clickElement(gpuTypeSelect);
        clickElement(getElementWith(computeEngine.getGpuType(), gpuTypeOptionsXpath));
        clickElement(numberOfGPUsSelect);
        clickElement(getElementWith(computeEngine.getNumberOfGPUs(), numberOfGPUsOptionsXpath));
        clickElement(localSsdSelect);
        clickElement(getElementWith(computeEngine.getLocalSsd(), localSsdOptionsXpath));
        clickElement(datacenterLocationSelect);
        clickElement(getElementWith(computeEngine.getDatacenterLocation(), datacenterLocationOptionsXpath));
        clickElement(committedUsageSelect);
        clickElement(getElementWith(computeEngine.getCommittedUsage(), committedUsageOptionsXpath));
        clickElement(addToEstimateBtn);
        return this;
    }

    public String getTotalCostFieldValue() {
        Matcher matcher = Pattern.compile(costPattern).matcher(getTextValueOf(totalCostField));
        return (matcher.find()) ? matcher.group() : "not found";
    }

    public YopmailPage initEmail() {
        clickElement(emailBtn);
        calculatorPageId = driver.getWindowHandle();
        return new YopmailPage(driver);
    }

    public PricingCalculatorPage sendEmail(String email) {
        driver.switchTo().window(calculatorPageId);
        switchIntoIframes();
        waitVisibilityFor(emailInput).sendKeys(email);
        clickElement(sendEmailBtn);
        return this;
    }

    private WebElement getElementWith(String option, String dropdownXpath) {
        return driver.findElement(By.xpath(String.format(dropdownXpath, option)));
    }

    private void clickElement(WebElement element) {
        waitToBeClickableFor(element).click();
    }

    private void switchIntoIframes() {
        driver.switchTo().frame(parentsFrame);
        driver.switchTo().frame(childsFrame);
    }

    private String getTextValueOf(WebElement element) {
        return waitVisibilityFor(element).getText();
    }
}
