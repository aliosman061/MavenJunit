package practice.day06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String ilksayfa =driver.getWindowHandle();
// arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.id("searchData")).sendKeys("Oppo", Keys.ENTER);

// ilk ürüne tıklayın
        driver.findElement(By.xpath("//*[@id='p-546000141']")).click();
bekle(2);
// Basligin 'Oppo' icerdigini test edin.
        switchToWindow1(1);
        String actualtitle= driver.getTitle();
        String expectedtitle="Oppo";
        Assert.assertTrue(actualtitle.contains(expectedtitle));
// ilk sayfaya donun ve Title'ını yazdırın
        bekle(2);
        driver.switchTo().window(ilksayfa);
    }
}
