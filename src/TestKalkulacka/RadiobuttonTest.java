package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadiobuttonTest {

    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/zenaalebomuz.php";

    @Before
    public void setUp(){driver = new FirefoxDriver();}

    @Test
    public void test() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//input[@value = 'wurst']")).click();
        System.out.println(driver.findElement(By.xpath("//h1[@class='description text-center']")).getText());

        //da sa iba vypisat do consoly cez sout a hodnoty budu true and false
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value = 'wurst']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value = 'conchita']")).isSelected());
    }

    @After
    public void tearDown(){

    }

}
