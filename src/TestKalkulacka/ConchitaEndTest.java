package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConchitaEndTest extends MainTest {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL()+ "zenaalebomuz.php");
    }

    @Test
    public void test(){
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }
}
