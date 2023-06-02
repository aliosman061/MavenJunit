package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     //
     //        https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/ ");
//        arama kutusunu locate edelim
        WebElement aramaKutusu= driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
//“Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

//        Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazısı = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
       String sonucSayısı[]=sonucYazısı.getText().split(" ");
        System.out.println("Sonuc sayısı : " +sonucSayısı[2]);
//        Ilk urunu tiklayalim
        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        ilkUrun.click();
//        Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1|//h2"));
        //çok önemli
        // (//*[@class='ads'])[1] | (//*[@class='ads'])[2] bu şekilde devam ederek aynı başlıktaki web elementleri geziyor.
        sayfaBasliklari.forEach(t-> System.out.println(t.getText()));


    }
}
