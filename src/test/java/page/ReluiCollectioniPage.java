package page;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ReluiCollectioniPage extends AbstractPage {

    private static final String COLLECTION_URL = "https://relouis.by/collection/complimenti/";

    @FindBy(xpath = "//div[@datatype=\"4810438013055\"]")
    private WebElement addButton;

    @FindBy(linkText ="Перейти в корзину")
    private WebElement goCartButton;

    @FindBy (xpath="//*[@id='content']/descendant::a[@href='https://relouis.by/product/nude-matte-complimenti/'][ text()='Выбрать']")
    WebElement addCartButton;

    public ReluiCollectioniPage(WebDriver driver){
        super(driver);
    }
    
    public ReluiCollectioniPage openPage() {
        driver.get(COLLECTION_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(jQueryAJAXCompleted());
        return this;
    }
    
    public ReluiCollectioniPage addToCart() {
        waitForElementLocatedBy(driver,addButton)
                .click();
        return this;
    }
    
    public ReluiBagPage goToCart() {
        WebElement goToCartButton = waitForElementLocatedBy( driver,goCartButton);
        waitForElementLocatedBy(driver,goToCartButton)
                            .click();
       return new ReluiBagPage(driver);
    }
    
    public ReluiProductPage goToProduct(){
        WebElement goToCartButton = waitForElementLocatedBy(driver, addCartButton);
        waitForElementLocatedBy(driver,goToCartButton)
                           .click();
        return new ReluiProductPage(driver);
    }
}
