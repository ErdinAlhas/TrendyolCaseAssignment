package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavouritePage extends BaseMethods{
    By favouriteOrder = By.className("prdct-desc-cntnr-wrppr");

    public FavouritePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
        return driver.findElement(favouriteOrder).isDisplayed();
    }
}
