package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Base64;

public class TestCalculator extends MainTest {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "kalkulacka.php");
    }

    @Test
    public void testSum(){
        checkSum("1", "2", "count", "3");
        checkSum("100", "20", "count", "120");
        checkSum("8", "2", "count", "10");
        checkSum("-100", "100", "count", "0");
    }

    @Test
    public void enterInputs(){
        enterInput("5","5");
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
    enterInput("5","4");
        driver.findElement(By.id("count")).click();
        driver.findElement(By.id("reset")).click();

        Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
        Assert.assertTrue(driver.findElement(By.id("result")).getText().isEmpty());
    }

    @Test
    public void testInvalidInputs(){
    enterInput("blud 1","blud 2");
    driver.findElement(By.id("count")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='firstInput']]"))
                .getAttribute("class").contains("has-error"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='secondInput']]"))
                .getAttribute("class").contains("has-error"));
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

    private void enterInput(String firstInput, String secondInput) {
        driver.findElement(By.id("firstInput")).clear();
        driver.findElement(By.id("firstInput")).sendKeys(firstInput);
        driver.findElement(By.id("secondInput")).clear();
        driver.findElement(By.id("secondInput")).sendKeys(secondInput);
    }
}
