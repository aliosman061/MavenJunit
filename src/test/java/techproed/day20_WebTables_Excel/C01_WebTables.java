package techproed.day20_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
/*
Thead , tr, th başlık kısmıyla ilgili işlemler içinken
tbody , tr ,td  tabloda bulunan verilerler ilgli işlemler yapmak için kullanılır.

// thead--> tablonun baslıgı          // tbody-->tablonun ici(body)
    // tr--> satır                        // tr --> satır
    // th--> sütun                        // td --> sütun

 */

public class C01_WebTables extends TestBase {

    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //table 1 yazıdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo : 1");
        System.out.println(table1.getText());
        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");

        //3. satır verilerini yazdırın
        List<WebElement> list = driver.findElements(By.xpath("//table[1]//tbody//tr[3]//td"));
        list.stream().forEach(t -> System.out.print(t.getText() + " - "));

        //son satırın verilerini yazdırın
        List<WebElement> sonsatır = driver.findElements(By.xpath("//table[1]//tbody//tr[4]//td "));
        sonsatır.stream().forEach(t -> System.out.print(t.getText() + " - "));

        //5. sütun başlığını yazıdırın
        WebElement besincisütun=driver.findElement(By.xpath("//table[1]//thead//tr//th[5]"));
        System.out.println(besincisütun.getText());

        //5. sütun verilerini yazdırın
        List<WebElement> listbeş=driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        list.stream().forEach(t-> System.out.println(t.getText()+"----------------"));
    }



    @Test
    public void webTablesTest5() {

        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        // iki parametreli bir java methodu olusturalım
        // Parametre 1 => satır numarasını
        // Parametre 2 => sutun numarası

        // prinData(2,3) ==> 2. satır, 3. sutundaki veriyi yazdırın


        printData(2,3);


    }


    public void printData(int satir, int sutun) {

        WebElement satirSutun = driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));

        System.out.println(satirSutun.getText());

    }
}
