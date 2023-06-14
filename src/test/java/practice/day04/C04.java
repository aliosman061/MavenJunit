package practice.day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;



public class C04 extends TestBase {

    @Test
    public void iframe() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
// Videoyu görecek kadar asagiya ininiz
        Actions action =new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                perform();//işimizin bittiğini ve uygula diyoruz
// Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        WebElement playTusu =driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        playTusu.click();

// Videoyu calistirdiginizi test ediniz

        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));

        Assert.assertTrue(youTubeYazisi.isDisplayed());
// 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

        driver.switchTo().parentFrame();


        WebElement powerYazisi = driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));


        Assert.assertTrue(powerYazisi.isDisplayed());
    }
}
