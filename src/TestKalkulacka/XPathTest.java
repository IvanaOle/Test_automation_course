package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XPathTest {
    private String BASE_URL = "http:/localhost:8888/tabulka.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void test(){

    }
    @After
    public void tearDown(){

    }
}
