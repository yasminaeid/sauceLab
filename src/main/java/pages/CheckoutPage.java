package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

  public   @FindBy (id = "first-name")
    WebElement firstNameKey;

     @FindBy (id = "last-name")
    WebElement lastNameKey;

     @FindBy (id = "postal-code")
    WebElement postalCodeKey;

   @FindBy (id="continue")
  WebElement continueBtn;

    public checkoutOverviewPage enterCheckoutInfo(String firstName
            , String lastName
            , String postalCode)
    {
        firstNameKey.sendKeys(firstName);
        lastNameKey.sendKeys(lastName);
        postalCodeKey.sendKeys(postalCode);
        continueBtn.click();
        return new checkoutOverviewPage(driver);

    }
}
