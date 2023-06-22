package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
     /*
        NoSuchElementException:
         Sayfada bulunmayan bir elemenente erisim saglanmaya calisildiginde
        NoSuchElementException hatasi aliriz.
         */

    @Test
    public void test01() {
        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com");
        bekle(3);
        //reklami kapatiniz
        driver.findElement(By.xpath("//*[@id='elementor-popup-modal-19118']/div/a/i")).click();
        //searchBox'a java yazip aratalim
        driver.findElement(By.xpath("//*[@id='YANLIŞelementor-search-form-9f26725']")).sendKeys("java", Keys.ENTER);

    }
}
