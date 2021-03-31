import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import user.User;

public class AddBasketTests extends BaseTest{
    @Test
    public void succesfulAddToBasket(){
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        ProductList productList =  homePage.goToTvDisplayAndSound();
        productList.addToBasketFirstProduct();
        String productTitle = productList.getFirstProductTitle();
        BasketPage basketPage = productList.clickBasket();
        String productTitleInBasket = basketPage.getProductTitleInBasket();
        driver.findElement(By.cssSelector(".Basket_CheckoutButton")).click();
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[2]/div/button[2]")).click();
        String expectedAccountName = "Hesabım";
        TakeMail takeMail = new TakeMail(driver);
        User user = new User();
        user.setEmail(takeMail.takeMail());
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.goToSignUpPage();
        HomePage homePage1 = signUpPage.signUp(user.getEmail(), user.getPassword());
        String accountText =  homePage1.getAccountText();
        driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"account-navigation-container\"]/div/div[2]")).click();

        Assert.assertEquals(accountText, expectedAccountName);
        Assert.assertTrue(productTitleInBasket.contains(productTitle));

    }
}
