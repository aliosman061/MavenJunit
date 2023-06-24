package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_ExtentReport extends TestBase {
    @Test
    public void test01() {
        extentReport("Chrome","Amazon Testi");
        extentTest=extentReports.createTest("ExtentReport","Test Raporu");//before içine koyulabilir
        //amazon sayfasına gidelim
        driver.get("https:amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        //sayfanı resmini alınız
        tumSayfaResmi();
        extentTest.info("Sayfanın resmi alındı");

        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratıldı");
        extentTest.pass("Sayfa kapatıldı");
       extentReports.flush();
    }
}
