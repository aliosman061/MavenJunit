package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {

    @Test
    public void window() {
         /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degisken handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabiliriz
         */

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
         String actualTitle = driver.getTitle();
         String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle, expectedTitle);
        String twh =driver.getWindowHandle();

        //Window 2'de(yeni bir pencere) https://www.youtube.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.TAB);//yeni bir pencereye driver ı taşır//window type window dersen yeni pencere tab dersen yeni bir sekme açar.
        driver.get("https:www.youtube.com");
        String ywh = driver.getWindowHandle();

        //Window 3'te(yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
         driver.switchTo().newWindow(WindowType.WINDOW);
         driver.get("https:www.linkedin.com");
         String lwh = driver.getWindowHandle();
        //techproeducation sayfasına geçiniz:
       driver.switchTo().window(twh);
       bekle(1);

        //youtube sayfasına geçiniz:
        bekle(1);
        driver.switchTo().window(ywh);

        //linkedIn sayfasına geçiniz:
        bekle(2);
        driver.switchTo().window(lwh);
        bekle(3);
    }
}
