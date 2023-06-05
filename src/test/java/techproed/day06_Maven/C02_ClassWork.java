package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com ");
        //2.Signin buttonuna tiklayin
        WebElement signinButonu = driver.findElement(By.xpath("//*[@id='signin_button']"));
        signinButonu.click();

        // 3.Login alanine "username" yazdirin
        WebElement userName = driver.findElement(By.xpath("//*[@id='user_login']"));
        userName.sendKeys("username"+ Keys.TAB+"password"+ Keys.ENTER);
        //4.Password alanine "password" yazdirin
       //5.Sign in buttonuna tiklayin
        driver.navigate().back();
       //6.online banking altındaki Pay Bills sayfasina gidin
        WebElement bakingButonu = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        bakingButonu.click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
       //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("2000"+Keys.TAB);
       //8.tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10"+Keys.ENTER);

       //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();
      //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement sonucYazısı =driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        String sonuc= sonucYazısı.getText();
        String beklenenYazı = "The payment was successfully submitted.";
        if (sonuc.equals(beklenenYazı)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED->"+ sonuc);

        driver.close();

    }
}
