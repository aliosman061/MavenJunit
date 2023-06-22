package techproed.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase {

    WebDriver driver;

    Faker faker;

    Actions actions;

    Integer sayi;

    String isim;
    @Test
    public void test01() {
     /*
    NullPointerException:

    degisken yada obje olusturup bu degiskene atama yapmadıgımızda yada esitlemedigimizde
    NullPointerException hatası alırız.

     */

        // driver = new ChromeDriver(); atamasını yapmadıgımız icin NullPointerException hatasını aldık.
            driver.get("https://amazon.com");

    }
    @Test
    public void NullPointerExceptionTest3() {
        // actions = new Actions() atamasını yapmadıgımız icin NullPointerException hatasını aldık
        actions.doubleClick().perform();

    }


    @Test
    public void NullPointerExceptionTest4() {
        // sayi=6; sayi degiskenine atama yapmadıgımız icin NullPointerException hatası aldık.
        System.out.println(sayi+5);

    }


    @Test
    public void NullPointerExceptionTest5() {
        // isim="Burak"; isim degiskenine atama yapıladıgı icin NullPointerException hatası aldık.
        System.out.println(isim.charAt(0));
    }





}
