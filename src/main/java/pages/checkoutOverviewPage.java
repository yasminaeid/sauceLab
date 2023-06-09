package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutOverviewPage {

    private final WebDriver driver;

    public checkoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

     @FindBy (id="finish")
    WebElement finishBtn;

    public checkoutcompletePage clickFinishCheckout(){
        finishBtn.click();
        return new checkoutcompletePage(driver);
    }
}
