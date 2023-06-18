package techproed.day13_CookiesActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com");


        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
  WebElement accountList = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).
                perform();
        bekle(2);
        WebElement account = driver.findElement(By.xpath("//*[text()='Account']"));
        account.click();
        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        String actualTitle =driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Your Account"));
    }
}