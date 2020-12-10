package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ReluiComplimentiPage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://relouis.by/collection/complimenti/";

    @FindBy(xpath = "//div[@datatype=\"4810438013055\"]")
    private WebElement addButton;

    @FindBy(linkText ="Перейти в корзину")
    private WebElement goCartButton;

    @FindBy (xpath="//*[@id='content']/descendant::a[@href='https://relouis.by/product/nude-matte-complimenti/'][ text()='Выбрать']")
    WebElement addCartButton;

    public ReluiComplimentiPage(WebDriver driver){
        super(driver);
    }
    public ReluiComplimentiPage openPage() {

        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return this;

    }
    public ReluiComplimentiPage addToCart() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addButton))
                .click();
        return this;
    }
    public ReluiBagPage goToCart() {
        WebElement goToCartButton = waitForElementLocatedBy( driver,goCartButton);
          new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                  .until(ExpectedConditions.elementToBeClickable(goToCartButton));
        goToCartButton.click();
       return new ReluiBagPage(driver);
    }
    public ReluiProductPage goToProduct(){
        WebElement goToCartButton = waitForElementLocatedBy(driver, addCartButton);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(goToCartButton));
        goToCartButton.click();
        return new ReluiProductPage(driver);
    }
}
