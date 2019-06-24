package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Registracia_Test {
        private String BASE_URL = "http:/localhost:8888/registracia.php";
        private WebDriver driver;

        @Before
        public void setUp(){
            driver = new FirefoxDriver();
        }

        @Test
        public void test() {
            driver.get(BASE_URL);
            driver.manage().window().maximize();
            driver.findElement(By.id("checkbox")).click();
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());
        }
        @Test
            public void testMissingPassword(){
            driver.get(BASE_URL);
            driver.manage().window().maximize();
            driver.findElement(By.id("checkbox")).click();

            driver.findElement(By.name("email")).sendKeys("iva@test.sk");
            driver.findElement(By.name("name")).sendKeys("Ivana");
            driver.findElement(By.name("surname")).sendKeys("Testersonova");
            driver.findElement(By.xpath("//button[@type='submit']")).click();

        }

        @Test
        public void MissmathcedPassword(){
            driver.get(BASE_URL);
            driver.manage().window().maximize();
            driver.findElement(By.id("checkbox")).click();

            driver.findElement(By.name("email")).sendKeys("iva@test.sk");
            driver.findElement(By.name("name")).sendKeys("Ivana");
            driver.findElement(By.name("surname")).sendKeys("Testersonova");
            driver.findElement(By.name("password")).sendKeys("blud");
            driver.findElement(By.name("password-repeat")).sendKeys("nieblud");
            driver.findElement(By.xpath("//button[@type='submit']")).click();

        }

        @After
        public void tearDown(){
        driver.close();
        driver.quit();

        }
}
