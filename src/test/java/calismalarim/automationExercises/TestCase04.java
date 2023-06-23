package calismalarim.automationExercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase04 extends TestBase {
    @Test
    public void test01() {
     //1. Launch browser
     //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
     //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(homePage.isDisplayed());
     //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

     //5. Verify 'Login to your account' is visible
        WebElement loginPage = driver.findElement(By.xpath("(//h2)[1]'"));
        Assert.assertTrue(loginPage.isDisplayed());
     //6. Enter correct email address and password


     //7. Click 'login' button
     //8. Verify that 'Logged in as username' is visible
     //9. Click 'Logout' button
     //10. Verify that user is navigated to login page
    }
}
