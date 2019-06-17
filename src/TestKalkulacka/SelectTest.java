package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTest {

        private WebDriver driver;
        private String Base_URL = "http:/localhost:8888/vybersi.php";

        @Before
        public void SetUp(){
            driver = new FirefoxDriver();
        }
        @Test
        public void Test(){
            driver.get(Base_URL);
            //new Select(driver.findElement(By.className("form-control"))).selectByIndex(1); //vyber z comboboxu (dropdown)
            //new Select(driver.findElement(By.className("form-control"))).selectByValue("04");
            new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Diglett");
            System.out.println(driver.findElement(By.xpath("//div/h3")).getText()); //vypise element ktory nasiel cez XPath
            Assert.assertTrue("Diglet nie je v texte hoci je vybraty",driver.findElement(By.xpath("//div/h3")).getText().contains("Diglett")); // DOLEZITE JE Assert.assertTrue a tiez nezabudnut contains
            Assert.assertFalse(driver.findElement(By.xpath("//div/h3")).getText().contains("Pichacu")); // co sa nesmie nachadzat v texte //Asserty pochadzaju z JUnit frameworku

        }


        @After
        public void tearDown(){
           // driver.quit();
        }


    }

