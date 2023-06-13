package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    /*
    Bir HTML dokumaninin icine yerlestirilmis baska bir HTML dokumanina inline frame yani IFRAME denir
 Bir sayfada iframe varsa iframe icindeki webelementi handle edebilmek icin switchTo() methodu ile iframe'e gecis yapmamiz
 gerekir.Eger gecis yapmazsak nosuchelementexception aliriz.
    Alert'ten farki alert ciktiginda hicbir webelementi locate edemeyiz. iframe olsada locate ederiz fakat handler edemeyiz
 */


    @Test
    public void iframe() {
        //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //➢Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        //➢Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
       driver.switchTo().frame(0);// geçiş yapmassak nosouchelemnt exepcition atar
        String lists = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Applications lists", lists);


        //Son olarak sayfa başınlığında iframe yazısının görünür olduğunu test ediniz
        driver.switchTo().
                defaultContent();//tüm iframelerden çıkmamızı sağlar
       // driver.navigate().refresh();//yaparsakta aynı işlemi yapmış oluruz.
        //driver.get(driver.getCurrentUrl()); buda refresh işlei görüyor
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
           /*
            Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */

        /*Nested iframe' lerde defaultContent ile refresh hangi iframe' de olursa olsun direk anasayfaya gecerken
        parentFrame sadece bir ust frame' e gecer
         */


    }

}
