package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {
    @Test
    public void fileExist() {
        System.getProperty("user.dir");//içinde oldğumuz projenin dosya yolunu verir
        System.out.println(System.getProperty("user.dir"));//C:\Users\exper\IdeaProjects\B151MavenJunit
        System.out.println(System.getProperty("user.home"));//herkesin pc deki farklı olan kısmı verir//c:\Users\exper\IdeaProjects\B151MavenJunit
        // Desktop(masaustu)'da bir text dosyası olusturun

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
        //C:\Users\exper\OneDrive\Masaüstü\text.txt
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\exper\\OneDrive\\Masaüstü\\text.txt")));

        /*
        dosyanın,bilgisayarımda destop'da olup olmadıgını
        Java ile test edecegim.
        cunku selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki desktop'a mudahele edemez
         */
        String farkliKisim= System.getProperty("user.home");//herkesin bilgisayarında farklı kısım
        String ortakKisim="\\IdeaProjects\\B151MavenJunit";
        String dosyaYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }
}
