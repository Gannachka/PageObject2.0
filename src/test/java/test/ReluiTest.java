package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ReluiMainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReluiTest {

    private static WebDriver driver;

    @BeforeAll
    static void BrowserSetup(){

        driver = new ChromeDriver();
    }

    @BeforeEach
    public void clearCookies(){
        //Удалил всё куки
        driver.manage().deleteAllCookies();
    }

    @Test
    public void addingItemsToCartTest(){
        WebElement itemName = new ReluiMainPage(driver)
                .openPage()
                .goToCollections()
                .goToCollection()
                .addToCart()
                .goToCart()
                .getNameOfFirstItem();
        assertTrue(itemName.isDisplayed());
    }

    @Test
    public void сhooseColorAndAddToCartTest(){
        WebElement itemColor=new ReluiMainPage(driver)
                .openPage()
                .goToCollections()
                .goToCollection()
                .goToProduct()
                .chooseColor("13")
                .addToBag()
                .goToBag()
                .getProductColor("13");
        assertTrue(itemColor.isDisplayed());
    }

    @AfterAll
    static void driverShutDown(){
        driver.quit();
        driver=null;
    }
}
