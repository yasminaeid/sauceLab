package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.cartPage;
import pages.homePage;
import pages.loginPage;

public class baseTests {

    private WebDriver driver;
    protected pages.loginPage loginPage;
    protected pages.homePage homePage;

    protected pages.cartPage cartPage;
    @BeforeClass
    public void setup(){

        System.setProperty("Webdriver.chrome.driver","resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        homePage = new homePage(driver);
        loginPage = new loginPage(driver);
        cartPage = new cartPage(driver);


    }

    public void goBackToHomePage(){
        driver.navigate().back();
    }
    @AfterClass
    public void tearDown(){

        driver.quit();
    }


}
