package calismalarim;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class odev1 extends TestBase {
    /*
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over  Me First" kutusunun ustune gelin
    3- Link 1" e tiklayin
    4- Popup mesajini yazdirin
    5- Popup'i tamam diyerek kapatin
    6- “Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin  8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
     */

    @Test
    public void test01() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //  2- Hover over  Me First" kutusunun ustune gelin
        WebElement first1 = driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(first1).perform();

        //  3- Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//a)[2]"));
        link1.click();

        //   4- Popup mesajini yazdirin
        String popup = driver.switchTo().alert().getText();
        System.out.println(" Popup mesaji:" + popup);
        bekle(3);

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        bekle(2);

        // 6- "Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("(//*[@class='dropbtn'])[2]"));
        bekle(2);
        actions.moveToElement(clickAndHold).perform();
        actions.contextClick(clickAndHold).perform();


    }
}

