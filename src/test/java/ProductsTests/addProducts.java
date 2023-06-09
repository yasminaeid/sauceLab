package ProductsTests;

import Base.baseTests;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;


public class addProducts extends baseTests {


    @BeforeClass
    public void login() {
        loginPage.login("standard_user", "secret_sauce");
    }


//add single product
//need to change isCartEmpty to better solution, since catching the exception is not the best.

    @Test
    public void addSingleProduct() throws NoSuchElementException {
        homePage.clickAddToCart(homePage.addBackPack);
        Assert.assertEquals(homePage.addButtonAfterClick(homePage.removeBackpack)
                , "Remove"
                , "button name doesn't change");
        Assert.assertEquals(homePage.cartProducts(), "1"
                , "products number in the cart is wrong");
        pages.cartPage cart = homePage.clickCart();
        cart.clearCart(cart.sauceBackRemoveButton);
        Assert.assertTrue(cart.IsCartIsEmpty(cart.sauceBackRemoveButton));

    }


    //add multiple products
    @Test
    public void addMultipleProducts() {
        homePage.clickAddToCart(homePage.addBikeLight);
        homePage.clickAddToCart(homePage.addBoltShirt);
        Assert.assertEquals(homePage.cartProducts(), "2"
                , "products number in the cart is wrong");
        pages.cartPage cart = homePage.clickCart();
        cart.clearCart(cart.bikeRemoveButton);
        cart.clearCart(cart.boltShirtRemoveButton);

    }

    @AfterMethod
    public void goBackToHome() {
        goBackToHomePage();
    }

}
