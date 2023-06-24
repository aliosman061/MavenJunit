package calismalarim.automationExercises;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestCase06 extends TestBase {

    @Test
    public void test01() throws IOException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']")).isDisplayed());

        //6. Enter name, email, subject and message
        Faker faker = new Faker();
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        name.sendKeys(faker.name().fullName(), Keys.TAB, faker.internet().emailAddress(),
                Keys.TAB, faker.expression("Konu : Bla Bla").toUpperCase(), Keys.TAB, faker.shakespeare().hamletQuote());

        //7. Upload file
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@name='upload_file']"));
        dosyaSec.sendKeys("C:\\Users\\AEN\\Desktop\\Yeni Text Document.txt");

        bekle(2);

        //7-1 sayfanin tamamnin screenshot'unu alalim
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        String dosyaYolu = "src/test/java/techproed/grup_calismasi/testexerciese_com_sorular/screenshot/erol " + tarih + ".jpeg";
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //9. Click OK button  alert' e geci yapacagiz
        bekle(2);
        driver.switchTo().alert().accept();
        //acceptAlert();  methodumuz da var


        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        bekle(2);
        WebElement success = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Actions actions = new Actions(driver);

        actions.doubleClick(success).click().perform();

        //actions.clickAndHold(success).doubleClick().click().perform();  ==FArkli yol


        //screenshot al
        tumSayfaResmi();
        bekle(2);

        //web element screeshot yap
        FileUtils.copyFile(success.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));


        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement element = driver.findElement(By.xpath("(//a[@href='/'])[2]"));
        element.click();

        String actual = element.getCssValue("color");
        String expected = "rgb(255, 165, 0)";

        Assert.assertEquals(expected, actual);
        //Assert.assertTrue(driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed());


    }
}