package TestKalkulacka;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RedAlert {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/redalert.php";

    @Before
    public void setUp(){driver = new FirefoxDriver();}

    @Test
    public void test(){
        driver.get(BASE_URL);
        //ALERT 1
        driver.findElement(By.id("alert1")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());
        Assert.assertTrue("Red Alert 1 is not ok",driver.findElement(By.xpath("//div[@class='result']/h1")).getText().contains("Kirov Reporting"));

        //ALERT 2
        driver.findElement(By.id("alert2")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Second alert!",alert.getText());
        alert2.dismiss();
        System.out.println(driver.findElement(By.xpath("//div[@class='result']/h1")).getText());

        //ALERT 3
        driver.findElement(By.id("alert3")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Ivana");
        alert3.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result']/h1")).getText().contains("Ivana"));
    }

    @After
    public void tearDown(){

    }
}
