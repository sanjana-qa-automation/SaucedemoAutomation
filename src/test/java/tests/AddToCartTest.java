package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.InventoryPage;

public class AddToCartTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void addItemToCartTest() {
        inventoryPage.addItemToCart();
        inventoryPage.goToCart();
        assert driver.getCurrentUrl().contains("cart.html");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
