package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alert extends TestBase {
    @Test
    public void acceptAlert() {
        /*
        *
        Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.*/


    driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
    driver.findElement(By.xpath("//button[@class='btn btn-primary'][1]")).click();
    driver.switchTo().//geçmek değiştirmek anlamında
            alert().//alert'e geçiş yaptı
            accept();//çıkan uyarıda okey yada tamam butonuna basar
      String result =  driver.findElement(By.id("result")).getText();
      String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, result);



    }

    @Test
    public void dismissAllert() {
    /*    Bir metod olusturun: dismissAlert
        2. butona tıklayın,
        uyarıdaki Cancel butonuna tıklayın
        ve result mesajının "successfuly" icermedigini test edin.*/
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@class='btn btn-primary'][2]")).click();
        driver.switchTo().alert().
                dismiss();//çıkan uyarıda cancel butonuna tıklar
        String result1 =driver.findElement(By.id("result")).getText();
        Assert.assertFalse(result1.contains("successfuly"));
    }

    @Test
    public void sendKeysAlert() {
        /*Bir metod olusturun: sendKeysAlert
        3. butona tıklayın,
        uyarıdaki mesajı konsolda yazdırın,
        uyarıdaki metin kutusuna isminizi yazin,
                OK butonuna tıklayın
        ve result mesajında isminizin görüntülendiğini doğrulayın.*/
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[@class='btn btn-primary'][3]")).click();
        System.out.println(driver.switchTo().alert().getText());//getTExt uyarıdaki mesajı bize string olarak getirir.
        driver.switchTo().alert().sendKeys("föhmi");
        driver.switchTo().alert().accept();
        WebElement result2 = driver.findElement(By.id("result"));
        Assert.assertTrue(result2.isDisplayed());

    }


    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.












     */



}
