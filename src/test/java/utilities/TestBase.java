package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    // Byu claasa extendsettiğimiz test clasllarından ulaşabiliriz
    //Test Base Clasında obje oluşturulmasının önüne abstract ile geçtik.


    protected WebDriver driver;//default halde diğer classlardan kullanılamaz, protected yaparak diğer clasların ulaşmasını sağladık.

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

    public void bekle(int saniye) {//sürekli Thread.sleep(); yazmamak icin bu methodu olusturduk.
        //parametre olarak int saniye dedik
        try {
            Thread.sleep(saniye * 1000);//icine ms cinsinden yazilir o yüzden 1000 ile carptik ve .try dedik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void alertAccept (){
        driver.switchTo().alert().accept();
    }

    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void alertSendKeys(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void alertText (){
        System.out.println(driver.switchTo().alert().getText());
    }

}