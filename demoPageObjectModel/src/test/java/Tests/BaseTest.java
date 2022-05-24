package Tests;

import Objects.FacebookLoginPage;
import Objects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    WebDriverManager manager;

    String baseUrl = "https://www.google.com.tr/";

    GoogleSearchPage searchPage;

    FacebookLoginPage loginPage;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser){
        if (browser.equals("chrome")) {
            manager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")){
            manager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")){
            manager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void operationSearch(){
        searchPage = new GoogleSearchPage(driver);
        searchPage.searchGoogle("facebook");
    }

    @Test(priority = 2)
    public void clickFbLink(){
        searchPage.clickFacebookLink();
    }

    @Test(priority = 3)
    public void writeEmail(){
        loginPage = new FacebookLoginPage(driver);
        loginPage.usernameSet("thisEmailIsDemo@mail.com");
    }

    @Test(priority = 4)
    public void writePassword(){
        loginPage.passwordSet("123456");
    }

    @Test(priority = 5)
    public void clickLoginButton(){
        loginPage.clickLogin();
    }

    @AfterTest
    public void endTest(){
        driver.quit();
    }

}
