package calismalarim.automationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase01 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(homePage.isDisplayed());
        //        4. Click on 'Signup / Login' button
        WebElement signIN=driver.findElement(By.xpath("//*[@href='/login']"));
        signIN.click();
        //        5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
        //        6. Enter name and email address
        //        7. Click 'Signup' button
        driver.findElement(By.name("name")).sendKeys("Mustafa", Keys.TAB,"mustafasagiroglu06452@gmail.com",Keys.TAB,Keys.ENTER);
        //        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//b)[1]")).isDisplayed());
        //     9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement button=driver.findElement(By.id("id_gender1"));
        button.click();
        button.sendKeys(Keys.TAB,"Mustafa",Keys.TAB,"Password",Keys.TAB);
        WebElement day=driver.findElement(By.id("days"));
        Select select=new Select(day);
        select.selectByValue("4");
        day.sendKeys(Keys.TAB,"May",Keys.TAB,"2021");
        //        10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.cssSelector("input#newsletter")).click();
//        11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkBox=driver.findElement(By.cssSelector("input#optin"));
        checkBox.click();
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //        13. Click 'Create Account button'
        checkBox.sendKeys(Keys.TAB,"Efe",Keys.TAB,"eff",Keys.TAB,"frr",Keys.TAB,"adıyaman",Keys.TAB,
                "adad",Keys.TAB,"Canada",Keys.TAB,"dasd",Keys.TAB,"urfa",Keys.TAB,"15151",Keys.TAB,"555555555",Keys.TAB,Keys.ENTER);

//        14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());
//        15. Click 'Continue' button
        driver.findElement(By.linkText("Continue")).click();
//        16. Verify that 'Logged in as username' is visible
       // driver.findElement(By.xpath("//span[@class='ns-62uje-e-7']")).click();
//        17. Click 'Delete Account' button
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }

    @After
    public void tearDown() throws Exception {

    }
}
