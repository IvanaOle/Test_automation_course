package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCalculator {
    private String BASE_URL = "http:/localhost:8888/kalkulacka.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void testSum(){
        driver.get(BASE_URL);
        driver.findElement(By.id("firstInput")).sendKeys("5");
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();

    System.out.println(driver.findElement(By.id("result")).getText());

    }

    @Test
    public void testDeduc(){

    }

    @Test
    public void testReset(){
        driver.get(BASE_URL);
        driver.findElement(By.id("firstInput")).sendKeys("1");
        driver.findElement(By.id("secondInput")).sendKeys("2");
        driver.findElement(By.id("count")).click();
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("3",result);

        driver.findElement(By.id("reset")).click();
        Assert.assertEquals("",driver.findElement(By.id("result")).getText());

    }

    @Test
    public void testInvalidInputs(){

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }
}
