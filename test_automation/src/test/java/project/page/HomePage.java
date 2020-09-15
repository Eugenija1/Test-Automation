package project.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    @FindBy(xpath = "//input[contains(@aria-label, 'Search box')]")
    private WebElement searchBox;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public SearchResultsPage searchForItem(String searchTerm) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//input[contains(@aria-label, 'Search box')]")));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
        return new SearchResultsPage(driver, searchTerm);
    }

}
