package calismalarim.automationExercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class TestCase03 extends TestBase {
    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // Verify that home page is visible successfully
        assert driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed();
        // Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        assert driver.findElement(By.xpath("(//h2)[1]")).isDisplayed();
        //Enter incorrect email address and password
        //. Click 'login' button
        driver.findElement(By.xpath("(//input)[2]")).
                sendKeys("123@gmail.com", Keys.TAB,"12345",Keys.TAB,Keys.ENTER);
        //Verify error 'Your email or password is incorrect!' is visible
        assert driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).isDisplayed();
        //Verify error 'Your email or password is incorrect!' not equals "ali"
        assert !driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).getText().equals("ali");
    }
}
