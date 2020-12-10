package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.ReluiCollectioniPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReluiTest {

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
        WebElement itemName = new ReluiCollectioniPage(driver)
                .openPage()
                .addToCart()
                .goToCart()
                .getNameOfFirstItem();
        assertTrue(itemName.isDisplayed());
    }

    @Test
    public void сhooseColorAndAddToCartTest(){
        WebElement itemColor=new ReluiCollectioniPage(driver)
                .openPage()
                .goToProduct()
                .chooseColor()
                .addToBag()
                .goToBag()
                .getProductColor();
        assertTrue(itemColor.isDisplayed());
    }

    @AfterAll
    static void driverShutDown(){
        driver.quit();
        driver=null;
    }
}
