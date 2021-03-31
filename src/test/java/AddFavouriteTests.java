import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.*;
import user.User;

import static org.testng.Assert.assertEquals;

public class AddFavouriteTests extends BaseTest{
    @Test
    public void succesfulAddToFavourite(){
        String expectedAccountName = "Hesabım";
        TakeMail takeMail = new TakeMail(driver);
        User user = new User();
        user.setEmail(takeMail.takeMail());
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.goToSignUpPage();
        HomePage homePage = signUpPage.signUp(user.getEmail(), user.getPassword());
        String accountText =  homePage.getAccountText();
        ProductList productList =  homePage.goToTvDisplayAndSound();
        driver.navigate().refresh();
        FavouritePage favouritePage = productList.addToFavourite();
        boolean isDisplayed = favouritePage.isDisplayed();
        assertEquals(isDisplayed , true);
    }
}
