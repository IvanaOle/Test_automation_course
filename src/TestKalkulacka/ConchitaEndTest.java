package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConchitaEndTest {
    private String BASE_URL = "http://localhost:8888/zenaalebomuz.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void test(){
        driver.get(BASE_URL);
        System.out.println(driver.findElement(By.tagName("h1")).getText());

    }
    @After
    public void tearDown(){
        driver.close(); //zavrie aktivne okno - jedno konkretne okno ale chceme v teste pokracovat
        driver.quit(); //uzavrie celu session - vsetko zavrie



    }
}
