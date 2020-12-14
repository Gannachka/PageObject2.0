package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReluiCollectionsPage extends  AbstractPage {

    @FindBy(xpath = "//*[@id=\"content\"]/descendant::a[@href='https://relouis.by/collection/complimenti/']")
    private WebElement collectionButton;

    public ReluiCollectionsPage(WebDriver driver){
        super(driver);
    }

    public ReluiSpecialCollectioniPage goToCollection() {
        WebElement goToCartButton = waitForElementLocatedBy( driver,collectionButton);
        waitForElementLocatedBy(driver,goToCartButton)
                .click();
        return new ReluiSpecialCollectioniPage(driver);
    }
}
