package practice.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test01() {

        driver.get("https://ebay.com");
        driver.findElement(By.xpath("//li[@class='hl-cat-nav__js-tab'][1]")).click();

        List<WebElement> images = driver.findElements(By.xpath("//*[@width='225' and @height='225'] "));

        for (int i = 0; i < images.size(); i++) {
            images = driver.findElements(By.xpath("//*[@width='225' and @height='225'] "));
            images.get(i).click();

            System.out.println(driver.getTitle());

            driver.navigate().back();
        }

    }
    // https://ebay.com sayfasına gidiniz
    // electronics bolumune tıklayınız
    // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız


    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}


