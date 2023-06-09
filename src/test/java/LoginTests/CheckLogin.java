package LoginTests;

import Base.baseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckLogin extends baseTests {

    @Test
    public void testLogin(){
        loginPage.login("standard_user","secret_sauce");
        Assert.assertEquals(homePage
                .titleOfHomePage(),"Swag Labs","Title isn't correct");
    }


}
