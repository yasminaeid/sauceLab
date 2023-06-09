package ProductsTests;

import Base.baseTests;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckProductsInfo extends baseTests {

    @BeforeClass
    public void login() {
        loginPage.login("standard_user", "secret_sauce");
    }

    private final String[] expectedProductsTitles = {"Sauce Labs Bike Light", "Sauce Labs Backpack"
            , "Sauce Labs Bolt T-Shirt", "Sauce Labs Fleece Jacket"
            , "Sauce Labs Onesie"
            , "Test.allTheThings() T-Shirt (Red)"};

    @Test
    public void checkProductsNumber() {
        Assert.assertEquals(homePage.productsNumber()
                , 6, "Products count is wrong");
    }

    @Test
    public void checkProductsTitles() {
        List<String> titlesList = new ArrayList<>();
        for (WebElement title : homePage.ListOfTitles()
        ) {
            titlesList.add(title.getText());
        }
        List<String> expected = Arrays.asList(expectedProductsTitles);
        Assert.assertTrue(titlesList.containsAll(expected));
    }


    @Test
    public void checkProductImgs() {
        int iBrokenImageCount = 0;
        for (WebElement image : homePage.images()
        ) {
            String src = image.getAttribute("src");
            System.out.println(src);
            if (image != null) {

                HttpClient client = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet(src);
                try {
                    HttpResponse response = client.execute(request);
                    if (response.getStatusLine().getStatusCode() != 200) {
                        System.out.println(image.getAttribute("outerHTML") + " is broken.");
                        iBrokenImageCount++;

                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        }

    }

    //another approach to check broken images
    @Test
    public void checkImageIsBroken(){
        for (WebElement image: homePage.images()
             ) { homePage.ifImageExists(image);

        }
    }

}

