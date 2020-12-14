package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReluiMainPage extends  AbstractPage {
    private static final String PAGE_URL = "https://relouis.by/";

    @FindBy(xpath = "//*[@id=\"header\"]//ul[contains(@class,\"main-menu clearfix\")]//li[contains(@class,\"expanded\")]//a[contains(text(),'Коллекции')]")
    private WebElement goToCollections;

    public ReluiCollectionsPage goToCollections() {
        WebElement goToCollectionsButton = waitForElementLocatedBy( driver,goToCollections);
        waitForElementLocatedBy(driver,goToCollectionsButton)
                .click();
        return new ReluiCollectionsPage(driver);
    }

    public ReluiMainPage(WebDriver driver){
        super(driver);
    }
    public ReluiMainPage openPage() {

        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return this;

    }
}
