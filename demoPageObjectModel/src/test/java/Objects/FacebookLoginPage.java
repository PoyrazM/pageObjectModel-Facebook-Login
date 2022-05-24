package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;

public class FacebookLoginPage {

    WebDriver driver;

    By usernameText = By.id("email");

    By passwordText = By.id("pass");

    By loginButton = By.xpath("//div//button");

    String title;

    Assertion assertion;
    public FacebookLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void usernameSet(String username){
        driver.findElement(usernameText).sendKeys(username);
    }

    public void passwordSet(String password){
            driver.findElement(passwordText).sendKeys(password);
    }

    public void clickLogin(){
            driver.findElement(loginButton).click();
            assertion = new Assertion();
            title = driver.getTitle();
            assertion.assertEquals(title , "Facebook - Giriş Yap veya Kaydol"); //This message is a title |EN : Login Page|
    }


}
