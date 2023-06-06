package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C07 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");

//iphone aratınız

        //xpath ile lacator bulma
        WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("iphone", Keys.ENTER);
        driver.navigate().back();

        //css ile
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("samsung",Keys.ENTER);
        driver.navigate().back();
        //id ile
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);


//çıkan sonuç yazısını konsola yazdırınız

        WebElement yazdir = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(yazdir.getText());
        // driver.findElement(By.cssSelector("[class='a-section a-spacing-small a-spacing-top-small']"));


//çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız

      // List<WebElement> listele = driver.findElements(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[position()>=1 and position()<=5]"));
      // for (int i = 0; i <listele.size() ; i++) {
      //     listele=driver.findElements(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[position()>=1 and position()<=5]"));
      //     System.out.println("product isimleri = " + listele.get(i).getText());
      //     listele.get(i).click();
      //     Thread.sleep(1000);
      //     driver.navigate().back();


      // }

    }
}