package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        assert driver.getCurrentUrl().contains("inventory.html");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
