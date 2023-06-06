package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.google.common.base.Objects.equal;
import static org.junit.Assert.assertTrue;

public class C05_Assertion {

    // 4 tane test methodu olusturun


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://amazon.com");

    }
    // test01
// https://amazon.com sayfasına gidin
// sayfa baslıgının "Amazon" kelimesini icerdigini test edin
    @Test
    public void test01() {
        String actualTitle =driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    // test02
// https://amazon.com sayfasına gidin
// Amazon resminin görüntülendiğini (isDisplayed()) test edin

    @Test
    public void test02() {
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    // test03
// https://amazon.com sayfasına gidin
// arama kutusunun erisilebilir oldugunu test edin

    @Test
    public void test03() {
        WebElement aramaKutusu =  driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Assert.assertTrue(aramaKutusu.isEnabled());
    }
    // test04
// https://amazon.com sayfasına gidin
// sayfa baslıgının "kitap" icermedigini test edin
    @Test
    public void test04() {
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains("kitap"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
