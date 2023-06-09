package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutcompletePage {

    private final WebDriver driver;

    public checkoutcompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "complete-header")
    WebElement checkoutSuccessMsg;

    public String checkoutSuccess(){
     return checkoutSuccessMsg.getText();

    }
}

