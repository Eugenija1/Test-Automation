//mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-all.xml -Denvironment=dev clean test

package project.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import project.model.CalculatorForm;
import project.page.CalculatorPage;
import project.page.HomePage;
import project.page.SearchResultsPage;
import project.service.CalculatorFormCreator;

public class GoogleCloudTest extends CommonConditions{

    protected static final String SEARCH_TERM = "Google Cloud Pricing Calculator";

    @Test(priority = 1)
    public void estimatePanelDisplayed(){
        CalculatorForm form = CalculatorFormCreator.withCredentialsFromProperty();
        SearchResultsPage resultsPage = new HomePage(driver)
                .openPage()
                .searchForItem(SEARCH_TERM);
        CalculatorPage calculatorPage = resultsPage.openFirstLink()
                .fillInForm(form);
        Assert.assertTrue(calculatorPage.costSuccessfullyEstimated());
    }

    @Test(priority = 0)
    public void resultsPageLoadedProperly(){
        SearchResultsPage resultsPage = new HomePage(driver)
                .openPage()
                .searchForItem(SEARCH_TERM);
        String actualPageTitle = resultsPage.getPageTitle();
        Assert.assertEquals(actualPageTitle, "Search results for Google Cloud Pricing Calculator");
    }
}
