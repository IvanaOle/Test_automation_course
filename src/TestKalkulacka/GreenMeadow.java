package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GreenMeadow {
    private WebDriver driver;
    private String BASE_URL="http://localhost:8888/kalkulacka.php";

    @Before
    public void SetUp(){
    driver = new FirefoxDriver();
    }

    @Test
    public void Test(){
        driver.get(BASE_URL);
        //driver.findElement(By.id("clickMe")).click();
        //driver.findElement(By.name("email")).sendKeys("oleksakova.ivana@gmail.com");
        //driver.findElement(By.className("form-control")).sendKeys("tucko");
       // driver.findElement(By.tagName("input")).sendKeys("hovienko");
        driver.findElement(By.cssSelector("button.btn-success")).click();

    }

    @After
    public void tearDown(){
       driver.quit();
    }

}
