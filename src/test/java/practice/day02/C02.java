package practice.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test01() {
        // https://www.sahibinden.com/ sayfasina gidin
        driver.get("https://www.sahibinden.com");
        // Title ve Url'ini alın ve yazdırın
        String sahibindenTitle = driver.getTitle();
        System.out.println("Sahibimden title : "+sahibindenTitle);
        String sahibindenUrl = driver.getCurrentUrl();
        System.out.println("Sahibimden url : "+sahibindenUrl);
        // Title'in "Online" kelimesini içerip içermedigini test edin
        Assert.assertTrue(sahibindenTitle.contains("Online"));
        // Url'in "sahibinden" kelimesini içerip içermedigini test edin
        Assert.assertTrue(sahibindenUrl.contains("sahibinden"));
        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com");
        // Title'ini alın ve yazdırın
        String amazonTitle = driver.getTitle();
        System.out.println("Amazon title : "+amazonTitle);
        String amazonUrl = driver.getCurrentUrl();
        System.out.println("Amazon url : "+amazonUrl);
        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonTitle.contains("more"));
        // Url'in "amazon" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonUrl.contains("amazon"));
        // Title'in "more" kelimesini içerip içermedigini test edin

        // sahibinden.com'a geri dönün
        driver.navigate().back();
        // sayfayı yenileyin
        driver.navigate().refresh();
        // amazon.com'a tekrar gelin
        driver.navigate().forward();
    }



}
