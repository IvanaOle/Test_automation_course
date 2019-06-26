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
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }


    @Test
    public void testSum(){
        checkSum("1", "2", "count", "3");
        checkSum("100", "20", "count", "120");
        checkSum("8", "2", "count", "10");
        checkSum("-100", "100", "count", "0");
    }


    @Test
    public void testDeduc(){
        checkDeduct("1", "2", "deduct", "-1");
        checkDeduct("100", "20", "deduct", "80");
        checkDeduct("-1", "-2", "deduct", "1");
        checkDeduct("-50", "60", "deduct", "-110");
        checkDeduct("80", "2", "deduct", "78");
    }

    @Test
    public void testReset(){


    }

    @Test
    public void testInvalidInputs(){

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();

    }
    private void checkSum(String firstInput, String secondInput, String count, String s3) {
        checkDeduct(secondInput, firstInput, count, s3);
    }
    private void checkDeduct(String s, String s2, String deduct, String s3) {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(s);
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys(s2);
        driver.findElement(By.id(deduct)).click();
        Assert.assertEquals(s3, driver.findElement(By.id("result")).getText());
    }
}
