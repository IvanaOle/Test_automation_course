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

public class TabulkaTest {
    private WebDriver driver;
    private String Base_URL = "http://localhost:8888/tabulka.php";

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void test(){

        driver.get(Base_URL);
        //driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText(); //iba najde element, vypise posledny riadok
        System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());

            // teraz idem pre vsetky riadky az po konecny nieco robit
        int rows = Integer.parseInt(driver.findElement(By.xpath("//table/tbody/tr[last()]/td[1]")).getText());
        for (int i = 1; i < rows+1; i++) {
            //driver.findElement(By.xpath("//table/tbody/tr[" + i +"]"));
            //System.out.println(driver.findElement(By.xpath("//table/tbody/tr[" + i +"]/td[3]")).getText());
            Assert.assertFalse(driver.findElement(By.xpath("//table/tbody/tr[" + i +"]/td[3]")).getText().isEmpty());
        }

        List<WebElement> rows2 = driver.findElements(By.xpath("//table/tbody/tr")); //alt+enter - importne sa tato trieda
        System.out.println(rows2);
        for (WebElement row : rows2) {
            //System.out.println(row.getText());
            System.out.println(row.findElement(By.xpath("./td[3]")).getText());
            Assert.assertFalse(row.findElement(By.xpath("./td[3]")).getText().isEmpty());
        }


    }
    @After
    public void tearDown(){

    }
}
