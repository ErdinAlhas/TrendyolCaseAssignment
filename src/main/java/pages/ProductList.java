package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductList extends BaseMethods {
    private By addToBasket = By.className("add-to-basket-button");
    private By productTitle = By.className("prdct-desc-cntnr-name");
    private By basketBtn = By.className("account-basket");
    private By favouriteBtn = By.className("fvrt-btn");
    private By favouritePageBtn = By.partialLinkText("Favorilerim");

    public ProductList(WebDriver driver){
        super(driver);
    }

    public void addToBasketFirstProduct(){
        List<WebElement> productList =  driver.findElements(addToBasket);
        productList.get(0).click();

    }

    public String getFirstProductTitle(){
        List<WebElement> list = driver.findElements(productTitle);
        String title = list.get(0).getAttribute("title");
        return title;
    }


    public BasketPage clickBasket(){
        click(basketBtn,5);
        return new BasketPage(driver);
    }

    public FavouritePage addToFavourite(){
        addToFavouriteFirstProduct();
        click(favouritePageBtn, 5);
        FavouritePage favouritePage= new FavouritePage(driver);
        return favouritePage;
    }
    public void addToFavouriteFirstProduct(){
        List<WebElement> productList =  driver.findElements(favouriteBtn);
        productList.get(0).click();
    }
}
