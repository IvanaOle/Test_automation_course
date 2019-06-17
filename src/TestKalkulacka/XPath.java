package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XPath {

    private String BASE_URL = "http://localhost:8888/tabulka.php";
    private WebDriver driver;
    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void test(){
    driver.get(BASE_URL);
    driver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[4]/td[3]"));
    driver.get("http://localhost:8888/registracia.php");//absolutny XPath
    driver.findElement(By.xpath("/html/body/div/div/form/div[1]/input")).sendKeys("holla hop");
    driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input")).sendKeys("test xpath");
    driver.findElement(By.xpath("/html/body/div/div/form/div[3]/input")).sendKeys("test xpath priezvisko");

    }
    @After
    public void tearDown(){

    }
}
