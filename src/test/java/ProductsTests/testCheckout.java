package ProductsTests;

import Base.baseTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testCheckout extends baseTests {
    @BeforeClass
    public void login() {
        loginPage.login("standard_user", "secret_sauce");
    }


    @Test
    public void checkoutProducts() {
        homePage.clickAddToCart(homePage.addBackPack);
        homePage.clickAddToCart(homePage.addBikeLight);
        homePage.clickAddToCart(homePage.addBoltShirt);
        Assert.assertEquals(homePage.cartProducts(), "3"
                , "products number in the cart is wrong");
        pages.cartPage cart = homePage.clickCart();
        pages.CheckoutPage checkout = cart.clickCheckout();
        pages.checkoutOverviewPage checkOutReview = checkout.enterCheckoutInfo("Yasmina"
                , "Eid"
                , "126621");
        pages.checkoutcompletePage checkoutsuccess = checkOutReview.clickFinishCheckout();
        Assert.assertTrue(checkoutsuccess.checkoutSuccess().contains("Thank"),
                "checkout failed");
    }
}
