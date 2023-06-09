package LoginTests;

import Base.baseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkLoginValidations extends baseTests {
    private String expectedErrorMsg = "Epic sadface: " +
            "Username and password do not match any user in this service";
    private  String expectedMsgForEmptyValues = "Epic sadface: Username is required";

    @Test
    public void checkPasswordValidation(){
        loginPage.login("standard_user","cc");
        Assert.assertEquals(loginPage.loginErrorMsg(),expectedErrorMsg,
                "Error message isn't correct");

    }

    @Test
    public void CheckUserNameAndPasswordAreEmpty(){
        loginPage.login("","");
        Assert.assertEquals(loginPage.ErrorMsgForEmptyValues(),
                expectedMsgForEmptyValues,"Error message isn't correct");

    }
}
