package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q08 {
    public static void main(String[] args) {
        //http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz,
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        //Add Element butonuna 100 defa basınız
        WebElement AddButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
       int count=0;
       for (int i = 0; i < 100; i++) {
           AddButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
           AddButton.click();
           count++;
       }
       System.out.println(count);
        //100 defa basıldığını test ediniz
        List<WebElement> element=driver.findElements(By.xpath("//button[@class='added-manually']"));
        System.out.println(element.size());
        if (element.size()==100){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        //90 defa delete butonuna basınız
        WebElement element2=driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]"));
        for (int i = 0; i < 90; i++) {
            element2=driver.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]"));
            element2.click();
        }

      //90 defa basıldığını doğrulayınız
      List<WebElement> element3=driver.findElements(By.xpath("//button[@class='added-manually']"));
      if (element3.size()==10){
        System.out.println("TEST PASSED");
      }else {
          System.out.println("TEST FAILED");
      }

        //Sayfayı kapatınız
       // driver.close();


    }
}
