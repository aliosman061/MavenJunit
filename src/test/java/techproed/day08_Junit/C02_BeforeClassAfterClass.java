package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClassAfterClass {

    /*
@BeforeClass class'da en once calısan methoddur.
@AfterClass class'da en son calısan methoddur.

@BeforeClass ve @AfterClass methodları sadece static methodlar ile calısır.
 */
     WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Classta en önce calisan methoddur ");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Classta en son çalisan methoddur");
    }

    @Before
    public void setUp() throws Exception {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("her test methodundan önce çalışır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("her test methodundan sonra çalışır.");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}
