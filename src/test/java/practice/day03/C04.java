package practice.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {

    WebDriver driver;

    @Before
    public void setUp() {
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
        // https://www.amazon.com/ adresine gidin

        driver.get("https://www.amazon.com");
// arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);
        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın

        List<WebElement> linkler = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        for (int i = 0; i <linkler.size() ; i++) {
            linkler = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
            linkler.get(i).click();
            System.out.println(i+". ürün title : "+driver.getTitle());
            driver.navigate().back();


        }


    }
}
