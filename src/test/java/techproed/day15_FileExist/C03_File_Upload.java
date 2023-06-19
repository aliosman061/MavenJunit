package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Paths;

public class C03_File_Upload extends TestBase {
    @Test
    public void test01() {
        // masaustunde bir deneme dosyası olusturun
// 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
// 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaseç =driver.findElement(By.id("file-upload"));
        //dosyaseç.click();  click yaparsak selenium pcye müdahale edemiyor

       // dosyaseç.sendKeys(Paths.get("C:\\Users\\exper\\OneDrive\\Masaüstü\\deneme"));
        String farklıolankısım =System.getProperty("user.home");
        String ortakolankısım = "\\OneDrive\\Masaüstü\\deneme.txt";
       String yol= farklıolankısım+ortakolankısım;
       dosyaseç.sendKeys(yol);
       bekle(2);

// 'Upload' butonuna basın
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
      bekle(2);
// 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement yazi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yazi.isDisplayed());

    }
}
