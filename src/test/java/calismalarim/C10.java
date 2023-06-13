package calismalarim;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class C10 extends TestBase1 {
    /*
    -Amazon sayfasına gidelim
    -Arama Kutusundaki Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    Not: Select Class'ı kullanalım
     */

    @Test
    public void tes01() {
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement categories = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(categories);
        select.getOptions().forEach(w -> System.out.println(w.getText()));
        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //    başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        for (int i = 1; i < 6; i++) {
            categories = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            select = new Select(categories);
            select.selectByIndex(i);
            wait(2);
            driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();
            System.out.println(i + ". Title = " + driver.getTitle());
            wait(1);
        }
    }
}