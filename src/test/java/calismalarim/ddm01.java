package calismalarim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.print.DocFlavor;
import java.util.List;

public class ddm01 extends TestBase {

    @Test
    public void test01() {


        // -Amazon sayfasına gidelim
        driver.navigate().to("https://amazon.com");

        // -Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> webElementList = select.getOptions();
        for (WebElement w : webElementList) {
            System.out.println(w.getText());
        }

        // -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        // başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
        List<WebElement> webElementList1 = driver.findElements(By.xpath("(//option)[position()>=2 and position()<=6] "));
        System.out.println("************************************");
        webElementList1.forEach(t -> System.out.println(t.getText()));
        for (int i = 0; i < webElementList1.size(); i++) {
            bekle(2);
            webElementList1 = driver.findElements(By.xpath("(//option)[position()>=2 and position()<=6] "));
            bekle(2);
            webElementList1.get(i).click();
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            bekle(2);
            System.out.println("Sayfa Başlıkları = " + driver.getTitle());
            bekle(2);
            driver.navigate().back();
            bekle(2);


        }


        // Not: Select Class'ı kullanalım

}

}