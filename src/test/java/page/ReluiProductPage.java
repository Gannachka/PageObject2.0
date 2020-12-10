package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ReluiProductPage extends AbstractPage {
    
     @FindBy(xpath = "//div[@datatype=\"4810438017961\"]")
    private WebElement addButton;

    @FindBy(linkText ="Перейти в корзину")
    private WebElement addToCartButton;

    @FindBy ( xpath = "//div[@datatype=\"3\"]")
    private WebElement productcolorColor;

    public ReluiProductPage(WebDriver driver){
        super(driver);
    }
       
    public ReluiProductPage chooseColor() {
        waitForElementLocatedBy(driver,productcolorColor)
                .click();
        return this;
    }
    
    public ReluiProductPage addToBag() {
        waitForElementLocatedBy(driver,addButton)
                .click();
        return this;
    }
    
    public ReluiBagPage goToBag() {
        WebElement goToCartButton = waitForElementLocatedBy( driver,addToCartButton);
        waitForElementLocatedBy(driver,goToCartButton)
                .click();
        return new ReluiBagPage(driver);
    }
}
