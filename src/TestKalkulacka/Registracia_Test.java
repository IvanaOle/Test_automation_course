package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.List;

public class Registracia_Test extends MainTest {
        private String validEmail = "iva@test.sk";
        private String validName = "Ivana";
        private String validSurname = "Testersen";

        @Before
        public void openBaseUrl(){
            driver.get(getBASE_URL() + "registracia.php");
        }

        @Test
        public void test() {
            driver.findElement(By.id("checkbox")).click();
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());
        }
        @Test
            public void testMissingPassword(){
            driver.findElement(By.id("checkbox")).click();
            driver.findElement(By.name("email")).sendKeys(validEmail);
            driver.findElement(By.name("name")).sendKeys(validName);
            driver.findElement(By.name("surname")).sendKeys(validSurname);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());

        }

        @Test
        public void MissmathcedPassword(){
            driver.findElement(By.id("checkbox")).click();
            driver.findElement(By.name("email")).sendKeys(validEmail);
            driver.findElement(By.name("name")).sendKeys(validName);
            driver.findElement(By.name("surname")).sendKeys(validSurname);
            driver.findElement(By.name("password")).sendKeys("blud");
            driver.findElement(By.name("password-repeat")).sendKeys("nieblud");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());

        }

        @Test
        public void testMissingRobotCheckbox(){
            driver.findElement(By.name("email")).sendKeys(validEmail);
            driver.findElement(By.name("name")).sendKeys(validName);
            driver.findElement(By.name("surname")).sendKeys(validSurname);
            driver.findElement(By.name("password")).sendKeys("blud");
            driver.findElement(By.name("password-repeat")).sendKeys("blud");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).isDisplayed());

        }
        @Test
        public void testHappyScenar(){
            driver.findElement(By.name("email")).sendKeys(validEmail);
            driver.findElement(By.name("name")).sendKeys(validName);
            driver.findElement(By.name("surname")).sendKeys(validSurname);
            driver.findElement(By.name("password")).sendKeys("blud123");
            driver.findElement(By.name("password-repeat")).sendKeys("blud123");
            driver.findElement(By.id("checkbox")).click();
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).isDisplayed());
        }

        @Test
        public void testInputErrorBorder(){
            String expectedClass = "has-error";
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            List<WebElement> formDivs = driver.findElements(By.xpath("//div[input]"));
            for (WebElement formDiv : formDivs) {
                Assert.assertTrue(formDiv.getAttribute("class").contains(expectedClass));
            }
            //ak chcem najst iba jeden specificky field
            driver.findElement(By.xpath("//div[input[@name='email']]")).getAttribute("class");
            Assert.assertTrue(driver.findElement(By.xpath("//div[input[@name='email']]")).getAttribute("class").contains(expectedClass));

            Assert.assertTrue(driver.findElement(By.xpath("//div[label[input[@id='checkbox']]]")).
                    getAttribute("class").
                    contains("has-error"));

        }

}