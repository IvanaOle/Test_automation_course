package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClickMeBabyTests {
    private WebDriver driver;
    private String Base_URL = "http:/localhost:8888/clickmebaby.php";

    @Before
    public void SetUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void Test(){
        driver.get(Base_URL);
        driver.findElement(By.cssSelector("button")).click();
        driver.findElement(By.cssSelector("div.container button")).click();
        driver.findElement(By.cssSelector("div.row>button")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
