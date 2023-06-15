package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {

    @Test
    public void windowHandles() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
//  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfa = driver.getWindowHandle();
        System.out.println(ilkSayfa);
//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement actualText = driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText.getText());
///  sayfa Title'ının "The Internet" olduğunu test edin.
        String actualTitle1 =driver.getTitle();
        Assert.assertEquals("The Internet", actualTitle1);
//  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
       bekle(3);
       String sayfa2handle="";
        Set<String> handles =driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(ilkSayfa)){
                 sayfa2handle=handle;
            }
        }
        driver.switchTo().window(sayfa2handle);

        /*windowHandlesSeti.
                stream().
                filter(t->!t.equals(sayfa1Handle)).
                forEach(t-> System.out.println("2.Sayfa Handle değeri : "+t));   */





//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
     String ikincisayfaTitle =driver.getTitle();
     Assert.assertEquals("New Window",ikincisayfaTitle);

//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfa);
        String actualTitle2 =driver.getTitle();
        Assert.assertEquals("The Internet", actualTitle2);

//  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2handle);
        bekle(2);
//  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfa);
    }
}
