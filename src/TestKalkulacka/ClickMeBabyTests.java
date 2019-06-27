package TestKalkulacka;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickMeBabyTests extends MainTest{
    private WebDriver driver;

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL()+ "clickmebaby.php");
    }
    @Test
    public void Test(){
        driver.findElement(By.cssSelector("button")).click();
        driver.findElement(By.cssSelector("div.container button")).click();
        driver.findElement(By.cssSelector("div.row>button")).click();
    }

}
