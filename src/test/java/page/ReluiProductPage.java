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

    public static String   COLOR_PATTERN ="//div[following-sibling::div[contains(text(),\"$\")]]";



    public ReluiProductPage chooseColor(String color) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COLOR_PATTERN.replace("$",color))))
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
        waitForElementLocatedBy(driver,goToCartButton);
        goToCartButton.click();
        return new ReluiBagPage(driver);
    }
}
