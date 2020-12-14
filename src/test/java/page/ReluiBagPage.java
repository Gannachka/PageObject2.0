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
    public static String COLOR_PATTERN ="//div[following-sibling::div[contains(text(),\"$\")]]";

    public ReluiBagPage (WebDriver driver){
        super(driver);
    }

    public WebElement getNameOfFirstItem(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@datatype=\"4810438013055\"]")));
    }





    public WebElement getProductColor(String color){
       return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(COLOR_PATTERN.replace("$",color))));
    }


}
