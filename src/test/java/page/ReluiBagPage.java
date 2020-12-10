package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReluiBagPage extends AbstractPage {

    @FindBy(xpath = "//div[@datatype=\\\"4810438013055\\\"]\"")
    private WebElement nameItem;

    @FindBy ( xpath = "//div[@datatype=\"3\"]")
    private WebElement productColor;

    public ReluiBagPage (WebDriver driver){
        super(driver);
    }

    public WebElement getNameOfFirstItem(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@datatype=\"4810438013055\"]")));
    }

    public WebElement getProductColor(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"cart-block\"]/descendant::div[ text()='Тон: 13']")));
    }


}
