import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HomePage;
import pages.ProductList;

public class CouponTest extends BaseTest {
    @Test
    public void testSuccessfulRun() throws Exception {

        driver.get("https://www.trendyol.com/epsilon-yayinevi/anne-frank-in-hatira-defteri-p-65306875?boutiqueId=558958&merchantId=156000");
        driver.findElement(By.className("add-to-bs-tx")).click();
        driver.findElement(By.className("goBasket")).click();
        //webDriver.findElement(By.id("Kod")).sendKeys("OR 1=1");
        driver.findElement(By.id("Kod")).sendKeys("BugsTeam");
        driver.findElement(By.id("addDiscountButton")).click();

        System.out.println(driver.findElement(By.className("lighboxcontainer")).getText());
        String result = driver.findElement(By.className("lighboxcontainer")).getText();
        String error ="Hata";
        long startTime = System.currentTimeMillis();
        long endTime;
        double seconds;
        while (!result.contains("Hata")) {
            endTime = System.currentTimeMillis();
            long estimatedTime = endTime - startTime;
            seconds = (double) estimatedTime / 1000;
            if (seconds > 5) break;
            result = driver.findElement(By.cssSelector(".lighboxcontainer")).getText();
        }
        driver.findElement(By.cssSelector(".buttonclose")).click();
        //driver.findElement("#Kod").clear();

        endTime = System.currentTimeMillis();
        long estimatedTime = endTime - startTime;
        System.out.println(estimatedTime + "");
        System.out.println(result);
    }
    @Test
    public void testUnsuccessfulRun() throws Exception {

        driver.get("https://www.trendyol.com/epsilon-yayinevi/anne-frank-in-hatira-defteri-p-65306875?boutiqueId=558958&merchantId=156000");
        driver.findElement(By.className("add-to-bs-tx")).click();
        driver.findElement(By.className("goBasket")).click();
        driver.findElement(By.id("Kod")).sendKeys("OR 1=1");
        driver.findElement(By.id("addDiscountButton")).click();

        System.out.println(driver.findElement(By.className("lighboxcontainer")).getText());
        String result = driver.findElement(By.className("lighboxcontainer")).getText();
        String error ="Hata";
        long startTime = System.currentTimeMillis();
        long endTime;
        double seconds;
        while (!result.contains("Hata")) {
            endTime = System.currentTimeMillis();
            long estimatedTime = endTime - startTime;
            seconds = (double) estimatedTime / 1000;
            if (seconds > 5) break;
            result = driver.findElement(By.cssSelector(".lighboxcontainer")).getText();
        }
        driver.findElement(By.cssSelector(".buttonclose")).click();
        //driver.findElement("#Kod").clear();

        endTime = System.currentTimeMillis();
        long estimatedTime = endTime - startTime;
        System.out.println(estimatedTime + "");
        System.out.println(result);

    }
}
