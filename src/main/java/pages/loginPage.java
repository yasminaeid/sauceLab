package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.homePage;

public class loginPage {

    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public homePage login(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        return new homePage(driver);

    }
public String loginErrorMsg(){
      String errorMsg =  driver
              .findElement(By.xpath("//h3[@data-test='error']")).getText();
        return errorMsg;
}
public String ErrorMsgForEmptyValues(){
       String msg = driver.findElement(By
               .xpath("//h3[@data-test='error']")).getText();
       return msg;
}
}
