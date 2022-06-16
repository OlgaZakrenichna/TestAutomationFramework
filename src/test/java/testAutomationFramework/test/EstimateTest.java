package testAutomationFramework.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import testAutomationFramework.model.ComputeEngine;
import testAutomationFramework.page.CloudGoogleHomePage;
import testAutomationFramework.service.ComputeEngineCreator;

public class EstimateTest extends CommonConditions{
    private final String expectedCostValue = "4,024.56";

    @Test(description = "Check if the 'Total Estimated Cost' field matches the expectedCostValue")
    public void checkCostEqualsCountedValue() {
        ComputeEngine testComputeEngine = ComputeEngineCreator.configureItem();
        pricingCalculatorPage = new CloudGoogleHomePage(driver)
                .searchFor(textToSearch)
                .getPricingCalculator()
                .estimateCost(testComputeEngine);

        Assert.assertEquals(pricingCalculatorPage.getTotalCostFieldValue(),
                expectedCostValue,
                "The 'Total Estimated Cost' field  not equal to the expectedCostValue");
    }
}
