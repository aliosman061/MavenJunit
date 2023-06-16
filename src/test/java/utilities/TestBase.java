package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
        // driver.quit();
    }

    public void bekle(int saniye) {//sürekli Thread.sleep(); yazmamak icin bu methodu olusturduk.
        //parametre olarak int saniye dedik
        try {
            Thread.sleep(saniye * 1000);//icine ms cinsinden yazilir o yüzden 1000 ile carptik ve .try dedik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void alertAccept() {
        driver.switchTo().alert().accept();
    }

    public void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void alertSendKeys(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }
    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //DropDown Index
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    //SwitchTo Window-1
    public void switchToWindow1(int index) {
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }

    //SwitchTo Window-2
    public void switchToWindow2(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());

    }
}