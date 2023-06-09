package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class homePage {

    private final WebDriver driver;

    public @FindBy(name = "add-to-cart-sauce-labs-backpack")
    WebElement addBackPack;

    public @FindBy(name = "add-to-cart-sauce-labs-bike-light")
    WebElement addBikeLight;

    public @FindBy(name = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addBoltShirt;

    public @FindBy(name = "remove-sauce-labs-backpack")
    WebElement removeBackpack;

    public homePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String titleOfHomePage() {
        String title = driver
                .findElement(By.xpath("//div[@class='app_logo']")).getText();
        return title;
    }

    public int productsNumber() {
        int productsNumber = driver
                .findElements(By.xpath("//div[@class='inventory_item']")).size();
        return productsNumber;
    }

    public List<WebElement> ListOfTitles() {
        List<WebElement> productTitles = driver
                .findElements(By.xpath("//div[@class='inventory_item_name']"));
        return productTitles;
    }

    public List<WebElement> images() {
        List<WebElement> imgs = driver
                .findElements(By.xpath("//img[@class='inventory_item_img']"));
        return imgs;
    }

    public boolean ifImageExists(WebElement image) {
        return !image.getAttribute("naturalWidth").equals("0");
    }

    public void clickAddToCart(WebElement element) {
        element.click();
    }

    public String addButtonAfterClick(WebElement element) {
        return element.getText();
    }

    public String cartProducts() {
        return driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
    }

    public cartPage clickCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        return new cartPage(driver);

    }
}