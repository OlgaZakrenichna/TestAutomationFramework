package testAutomationFramework.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import testAutomationFramework.model.ComputeEngine;
import testAutomationFramework.page.CloudGoogleHomePage;
import testAutomationFramework.page.YopmailPage;
import testAutomationFramework.service.ComputeEngineCreator;


public class EmailEstimateTest extends CommonConditions{
    private final String urlYopmail = "https://yopmail.com/en/";
    private YopmailPage yopmailPage;

    @Test(description = "Check if the 'Total Estimated Cost' field in Email matches the counted value")
    public void checkCostFromEmailEqualsCountedValue() {
        ComputeEngine testComputeEngine = ComputeEngineCreator.configureFromProperty();
        pricingCalculatorPage = new CloudGoogleHomePage(driver)
                .searchFor(textToSearch)
                .getPricingCalculator()
                .estimateCost(testComputeEngine);
        costValue = pricingCalculatorPage.getTotalCostFieldValue();
        yopmailPage = pricingCalculatorPage.initEmail();
        pricingCalculatorPage.sendEmail(yopmailPage.generateEmailAddress(urlYopmail));

        Assert.assertEquals(yopmailPage.openInbox().getTotalCost(),
                costValue,
                "The 'Total Estimated Cost' field in Email is not equal to the counted value");
    }
}
