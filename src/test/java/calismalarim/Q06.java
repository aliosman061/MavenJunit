package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q06 {
    public static void main(String[] args) {
       //Youtube web sayfasına gidin ve sayfa başlığının "youtube" olup olmadığını doğrulayın  (verify),
        // eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com/");
        String actualTitle=driver.getTitle();
        String expectedTitle="youtube";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        //Sayfa URL'sinin "youtube" içerip içermediğini (contains) doğrulayın, içermiyorsa doğru  URL'yi yazdırın.
        String actualUrl=driver.getCurrentUrl();
        String expectedUrlContains="youtube";
        if (actualUrl.contains(expectedUrlContains)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("actualUrl = " + actualUrl);
        }
       //Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com");
       //Youtube sayfasina geri donun
        driver.navigate().back();
       //Sayfayi yenileyin
        driver.navigate().refresh();
       //Amazon sayfasina donun
        driver.navigate().forward();
       //Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
       //Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        // Yoksa  doğru başlığı(Actual Title) yazdırın.
        String actualTitleAmazon= driver.getTitle();
        String expectedContainsTitleAmazon ="Amazon";
        if (actualTitleAmazon.contains(expectedContainsTitleAmazon)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("actualTitleAmazon = " + actualTitleAmazon);
        }

       //Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
       //URL'yi yazdırın

        String actualUrlAmazon=driver.getCurrentUrl();
        String expectedUrl="https://www.amazon.com/";
        if (actualUrl.contains(expectedUrlContains)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("actualTitleAmazon = " + actualTitleAmazon);
        }

       //Sayfayi kapatin
        driver.close();
    }
}
