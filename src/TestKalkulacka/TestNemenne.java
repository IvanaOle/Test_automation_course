package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TestNemenne {
    private WebDriver driver;
    private String Base_URL = "http://localhost:8888/nemenne.php";

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void test(){

        driver.get(Base_URL);
        System.out.println(driver.findElement(By.xpath("//input[@value = 'Eva Mazikova']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value = 'Eva Mazikova']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());

        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());

        //Assert.assertFalse(driver.findElement(By.className("btn-danger")).isEnabled()); // iny sposob je tento nasledujuci podla xpath:: moze sa podla toho, ze je button a obsahuje tuto klasu:
        Assert.assertFalse(driver.findElement(By.xpath("//button[contains(@class, 'btn-danger')]")).isEnabled());
        //Assert.assertTrue(driver.findElement(By.className("btn-success")).isEnabled());
        Assert.assertTrue((driver.findElement(By.xpath("//button[contains(@class, 'btn-success')]"))).isEnabled());

    }
    @After
    public void tearDown(){

    }

}