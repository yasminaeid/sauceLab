package pages;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
    private final WebDriver driver;
    public @FindBy(name = "remove-sauce-labs-backpack")
    WebElement sauceBackRemoveButton;

    public @FindBy(name = "remove-sauce-labs-bolt-t-shirt")
    WebElement boltShirtRemoveButton;

    public @FindBy(name = "remove-sauce-labs-bike-light")
    WebElement bikeRemoveButton;

    @FindBy(name = "checkout")
    WebElement checkOutButton;

    public cartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearCart(WebElement element) {
        element.click();

    }

    public boolean IsCartIsEmpty(WebElement element) throws NoSuchElementException {

        try {
            element.click();
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("Element absent");
            return true;
        }


    }

    public CheckoutPage clickCheckout() {
        checkOutButton.click();
        return new CheckoutPage(driver);
    }


}
