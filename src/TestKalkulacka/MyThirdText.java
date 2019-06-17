package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyThirdText {
    private WebDriver driver;
    private final String BASE_URL = "http://localhost:8888/registracia.php";

    @Before
    public void setUp(){driver = new FirefoxDriver();}

    @Test
    public void test(){
        driver.get(BASE_URL);
        driver.findElement(By.name("email")).sendKeys("ivana@test.sk");
        driver.findElement(By.className("form-control")).sendKeys(("TEST"));
        driver.findElement(By.tagName("input")).sendKeys("Test TagName");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).sendKeys("novyemail@test.sk");
        // now there is an error message present and cannot be submitted
        driver.findElement(By.className("form-control")).clear();
        driver.findElement(By.name("email")).sendKeys("ivana@test.sk");
        driver.findElement(By.tagName("button")).click();
        // all fields are required so error message is present
        //driver.findElement(By.name("email")).sendKeys("test@test.sk");
        driver.findElement(By.name("name")).sendKeys("First name");
        driver.findElement(By.name("surname")).sendKeys("Last Name");
        driver.findElement(By.name("password")).sendKeys("nbs123");
        driver.findElement(By.name("password-repeat")).sendKeys("nbs123");
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.tagName("button")).click();
    }

    @After
    public void tearDown(){

    }
}
