package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
TimeOutException:

sayfada aradıgımız elementi wait ile belirttigimiz max. sürede
bulamadıgı durumda TimeOutException hatası alırız.

 */

    @Test
    public void test01() {
        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com");
        bekle(3);
        //reklami kapatiniz
        driver.findElement(By.xpath("//*[@id='elementor-popup-modal-19118']/div/a/i")).click();
        //searchBox'a görünür olana kadar bekleyin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='YANLIŞelementor-search-form-9f26725']")));


    }
       /*
       TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
        BASKASININ NOTUUUU
         -------------------
          TimeOutException:
        Explicit wait kullanildiginda, ve element bulunamadiginda
        alinir.
        Explicit wait & yanlis locator-> timeout
        Explicit wait & doğru locator & sure yeterli degil -> timeout
        Explicit wait & dogru locator & sure yeterli & iframe var ->
        time out


            Solution:
       -Sureyi arttirmak
       -Farkli explicit kullanmak: wait visibilityOfElementLocated
        YERINE presenceOfElementLocated. Yada javascript executor
        da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
       -Locatori tekrar kontrol etmek
       -Frameworkunde hazir reusable method lar var Bu durumda
        timeoutexception aldigimda hızlıca o metotlar yardımıyla
        problemi cozebiliyoruz
        */

    @Test
    public void TimeoutException() {


        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorldYAzi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(1));
        wait2.until(ExpectedConditions.visibilityOf(helloWorldYAzi));

        Assert.assertTrue(helloWorldYAzi.isDisplayed());
        /*
gercekte Hello World! yazisi ortalama 6 saniyede gozukuyor
TimeOutException alabilmek icin Explicit Wait'e max bekleme sureisni 1 saniye verdik.
Bu sebeple TimeOutException hatasi aldik.
 */
    }
}

