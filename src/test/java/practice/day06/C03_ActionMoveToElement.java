package practice.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C03_ActionMoveToElement extends TestBase {
    @Test
    public void test01() {
        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        System.out.println("1."+driver.getWindowHandle());
// sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        WebElement dilkutusu=driver.findElement(By.xpath("//*[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']"));
        Actions action = new Actions(driver);
        action.moveToElement(dilkutusu).perform();
        bekle(3);
        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("//div[@class='icp-mkt-change-lnk'][1]")).click();
// United States dropdown'undan 'Turkey (Türkiye)' seciniz
       WebElement diller= driver.findElement(By.xpath("(//select)[2]"));

        selectVisibleText(diller,"Turkey (Türkiye)");

        bekle(2);
// Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();

        driver.findElement(By.xpath("//*[@class='a-button-input']")).click();
// acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        switchToWindow1(1);
        bekle(2);
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Elektronik";
        System.out.println(driver.getWindowHandle());
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
