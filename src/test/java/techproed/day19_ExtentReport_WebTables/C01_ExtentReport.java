package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {
    /*
    EXTENTREPORT:
       1- ExtentReport(aventstack) kullanabilmek icin oncelikle mvn adresinden 4.0.9 versiyon numarali dependency'i pom.xml
        dosyamiza ekleriz
  2- ExtentReports class'ından class seviyeninde obje oluştururuz
   3- ExtentHtmlReporter class'ından class seviyeninde obje oluştururuz
   4- ExtentTest class'ından class seviyeninde obje oluştururuz
   // ExtentReport diyince aklimiza 3 class gelmeli!!! ==> ExtentReports, ExtentHtmlReporter, ExtentTest
 */
     /*
    Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class' larini kullanrak
    testle ilgili bilgileri rapora ekleyebiliriz
     */
    ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan class
    ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTML formatında düzenler
    ExtentTest extentTest;//--> Test adımlarına eklemek istediğimiz bilgileri bu class ile oluştururuz

    @Test

    public void test01() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//---> html formatında raporlamayı başlatacak

        //Raporda gözükmesini istediğiniz bilgiler için
        extentReports.setSystemInfo("browser","Chrome");
        extentReports.setSystemInfo("Tester","Erol");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
        //amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        //başlığın amazon içerdiğini test edelim
        String actualTitle= driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        extentTest.info("Başlığın Amazon içerdiği test edildi");

        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratıldı");

        //sonuc yazısını yazdıralım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuç Yazısı : "+sonucYazisi.getText());
        extentTest.info("Sonuc yazısı yazdırıldı");
        extentTest.pass("Sayfa Kapatıldı");//sayfa kapatılırken en son pass kullanılır.
        /*
    extentTest objesi ile info() methodunu kullanarak her step'de ne yaptığımızla alakalı bilgi yazabiliriz
testimizin en sonunda testin bittiğini ifade eden pass() methodu ile testimiz ile alakalı son bilgiyi
ekleyebiliriz.
    Ve son olarak actions daki perform methodu gibi extentReport objesi ile flush() methodu kullanarak
raporu sonlandırırız
 */
        extentReports.flush();//-->bu methodu kullanmazsak rapor oluşmaz.
    }
}
