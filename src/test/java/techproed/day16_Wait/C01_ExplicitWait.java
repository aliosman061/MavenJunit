package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

    // Implictly Wait==> Sayfadaki tüm webelementlerim yüklenebilmesi icin max. bekleme süresi

    // Explict Wait==> Belirli bir kosul gerceklesene kadar max sure boyunca
    // default olarak 500ms aralıklarla webelementi kontrol ederek bekler.
    // (sadece belirli bir webelement icin kullanılır)


    @Test
    public void test01() {
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //==> Start buttonuna tıklayın
        WebElement button =driver.findElement(By.xpath("//button"));
        button.click();
        //==> Hello World! yazısının görünürlügünü test edin
        WebElement hello  =driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(hello));

        assert hello.isDisplayed();

    }
    /*
Thread.Sleep(): Javadan gelir. Belirttigimiz sure kadar kodlari bekletir.

Implicitly Wait: Selenium'dan gelir. Sayfadaki tum webelementlerin yuklenebilmesi icin max bekleme suresidir.

Explicitly Wait 2'ye ayrilir:

1.) WebDriver Wait: Belirli bir kosul gerceklesene kadar max sure boyunca,
default olarak 500ms araliklarla webelementi kontrol ederek bekler.

2.) Fluent Wait: Belirli bir kosul gerceklesene kadar max sure boyunca,
belirttigimiz araliklarla webelementi kontrol ederek bekler.
 */
}
