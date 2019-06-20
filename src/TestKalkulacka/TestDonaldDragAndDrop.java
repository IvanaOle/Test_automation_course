package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class TestDonaldDragAndDrop {

    private String BASE_URL = "http://localhost:8888/moveme.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }


    @Test
    public void test(){
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        WebElement donald = driver.findElement(By.id("donald"));
        WebElement strom = driver.findElement(By.id("tree"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(donald,strom).build().perform();
        WebElement excpectedTitle = driver.findElement(By.xpath("//div[contains(@class, 'success')]/h2"));
        Assert.assertTrue(excpectedTitle.isDisplayed());
        Assert.assertEquals("HOOO HOOOOO !!!!",excpectedTitle.getText());



    }
    @After
    public void tearDown(){

    }
}
