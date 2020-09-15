package project.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage{
    private String searchTerm;

    private By result = By.xpath("//a[@class='gs-title']");
    private String titleLocator = "//h1[contains(text(), 'Search results for ')]/span[contains(text(), '%s')]";

    public SearchResultsPage(WebDriver driver, String searchTerm){
        super(driver);
        this.searchTerm = searchTerm;
    }

    @Override
    protected AbstractPage openPage(){
        throw new RuntimeException();
    }

    public CalculatorPage openFirstLink(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(result));
        WebElement resultLink = driver.findElement(result);
        resultLink.click();
        return new CalculatorPage(driver);
    }

    public String getPageTitle(){
        String locator = String.format(titleLocator, searchTerm);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(locator)));
        WebElement title = driver.findElement(By.xpath(locator));
        return "Search results for " + title.getText();
    }
}
