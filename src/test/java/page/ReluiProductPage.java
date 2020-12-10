package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReluiProductPage extends AbstractPage {
    public ReluiProductPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//div[@datatype=\"4810438017961\"]")
    private WebElement addButton;

    @FindBy(linkText ="Перейти в корзину")
    private WebElement addToCartButton;

    @FindBy ( xpath = "//div[@datatype=\"3\"]")
    private WebElement lipstickColor;

    public ReluiProductPage chooseColor() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(lipstickColor))
                .click();
        return this;
    }
    public ReluiProductPage addToBag() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addButton))
                .click();
        return this;
    }
    public ReluiBagPage goToBag() {
        WebElement goToCartButton = waitForElementLocatedBy( driver,addToCartButton);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(goToCartButton));
        goToCartButton.click();
        return new ReluiBagPage(driver);
    }
}
