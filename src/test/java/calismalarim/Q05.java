package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q05 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
        ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) "facebook"
        oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        */
        driver.get("https://facebook.com/");
        String expectedTitle ="facebook";
        System.out.println("expectedTitle = " + expectedTitle);
        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        if(expectedTitle.contains(actualTitle)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        /*
        Sayfa URL'inin "facebook" kelimesi icerdigini dogrulayin, icermiyorsa "actual" URL'i
        yazdirin.
        */
        String actualUrl=driver.getCurrentUrl();

        String expectedWord="facebook";
        System.out.println("expectedWord = " + expectedWord);
        if (actualUrl.contains(expectedWord)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
            System.out.println("actualUrl = " + actualUrl);
        }
        /*
        https://www.walmart.com/ sayfasina gidin.*/
        driver.get("https://www.walmart.com");


        /*
        Sayfa basliginin "Walmart.com" icerdigini dogrulayin.
        */
        String actualWallMartTitle=driver.getTitle();
        String expectedContainsWallMartTitle="Walmart.com";
        if (actualWallMartTitle.contains(expectedContainsWallMartTitle)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        /*
        Tekrar "facebook" sayfasina donun*/
        driver.navigate().back();
        /*
        Sayfayi yenileyin*/
        driver.navigate().refresh();
        /*
        Sayfayi tam sayfa (maximize) yapin  9.Browser'i kapatin
         */
        driver.manage().window().maximize();
        driver.close();

    }
}
