package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

    WebDriver driver;

    By searchBox = By.xpath("//input[@name='q']");

    By fbLink = By.xpath("//a//h3[text()='Facebook - Giriş Yap veya Kaydol']");
                                                    // This text mean is |EN : Facebook - Login or Sign Up|

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchGoogle(String searchInput){
        try {
            driver.findElement(searchBox).sendKeys(searchInput, Keys.ENTER);
        }catch (Exception exception){
            System.out.println("EXCEPTION CAUGHT !!!" +exception.getMessage());
        }

    }

    public void clickFacebookLink(){
        try {
            driver.findElement(fbLink).click();
        }catch (Exception exception){
            System.out.println("EXCEPTION CAUGHT !!!" +exception.getMessage());
        }
    }
}
