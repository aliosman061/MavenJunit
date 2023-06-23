package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.awt.*;

public class C05_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//-->Reklamı kapatır
        bekle(2);
        //sayfanın resmini alalım
        tumSayfaResmi();
        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("java", Keys.ENTER);
        bekle(2);

        //ve sonuc yazısının resmini alalım
        WebElement element = driver.findElement(By.xpath("//h1"));
        webElementResmi(element);

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        bekle(2);
        //sayfanın resmini alalım
        tumSayfaResmi();
        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //ve sonuc yazısının resmini alalım
        bekle(2);
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementResmi(sonucYazisi);
        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow1(0);

        tumSayfaResmi();
    }
}
