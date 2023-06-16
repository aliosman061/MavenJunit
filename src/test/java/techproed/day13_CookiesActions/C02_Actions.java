package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
       driver.get("https://the-internet.herokuapp.com/context_menu");
        //Kutuya sag tıklayın
      WebElement kutu= driver.findElement(By.id("hot-spot"));
      //sağ click yapabilmek için öncelikle Actions clasından bir obje oluşturmalıyız
        Actions actions = new Actions(driver);
        actions.contextClick(kutu).//sağ click yapma methodu kullandık
                    perform();//action objemizle yapacagimiz islemi uygulamasi icin veya sonlandirmasi icin perform() kullaniriz
        //Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        Assert.assertEquals("You selected a context menu", getTextAlert());
        //Tamam diyerek alert'i kapatın
        alertAccept();

    }
}
