package project.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.model.CalculatorForm;
import project.model.SelectContainer;

public class CalculatorPage extends AbstractPage {
    final String CALCULATOR_URL = "https://cloud.google.com/products/calculator";
    private String costFromCalculator;

    @FindBy(id="input_60")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//md-checkbox[contains(@aria-label,'Add GPUs')]")
    private WebElement checkboxGPU;

    private By buttonAddToEstimate = By.xpath("//button[@aria-label='Add to Estimate']");
    private By saveEstimation = By.xpath("//*[@aria-label='Save Estimate']");


    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CalculatorPage openPage() {
        driver.get(CALCULATOR_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    public CalculatorPage fillInForm(CalculatorForm form){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");

        numberOfInstances.sendKeys(form.getInstances());

        selectOption(SelectContainer.MACHINE_CLASS, form.getMachineClass());
        selectOption(SelectContainer.MACHINE_TYPE, form.getMachineType());
        addGPU(form.getAddGPU());
        selectOption(SelectContainer.NUMBER_GPU, form.getGpuNumber());
        selectOption(SelectContainer.TYPE_GPU, form.getGpuType());
        selectOption(SelectContainer.SSD, form.getLocalSSD());
        selectOption(SelectContainer.LOCATION, form.getLocation());
        selectOption(SelectContainer.COMMIT_USAGE, form.getCommittedUsage());

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(buttonAddToEstimate));
        driver.findElement(buttonAddToEstimate).click();
        return this;
    }

    private void selectOption(SelectContainer name, String data){
        getSelectContainer(name).click();
        getOption(name, data).click();
    }

    private WebElement getSelectContainer(SelectContainer selector){
        By locator = selectContainerLocator(selector);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    private WebElement getOption(SelectContainer name, String optionText){
        By locator = optionLocator(name, optionText);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    private By selectContainerLocator(SelectContainer selector){
        String id = SelectContainer.valueLabel(selector);
        String baseForLocator = "select_value_label_%s";
        String locator = String.format(baseForLocator, id);
        return By.id(locator);
    }

    private By optionLocator(SelectContainer name, String optionText){
        String baseForLocator = "//*[@id='select_container_%s']/descendant::div[contains(text(), '%s')]";
        String str = String.format(baseForLocator, SelectContainer.containerId(name), optionText);
        return By.xpath(str);
    }

    private void addGPU(String addGPU){
        if(addGPU.equals("true")){
            checkboxGPU.click();
        }
    }

    public boolean costSuccessfullyEstimated(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(saveEstimation));
        return driver.findElement(saveEstimation).isDisplayed();
    }

    public String getEstimatedCost() {
         return this.costFromCalculator;
    }
}
