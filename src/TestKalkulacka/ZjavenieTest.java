package TestKalkulacka;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZjavenieTest {
    private String BASE_URL = "http://localhost:8888/zjavenie.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get(BASE_URL);
        driver.findElement(By.id("showHim")).click();
        //Thread.sleep(2500);//fixna hodnota v milisekundach
        new WebDriverWait(driver,5).
                until(ExpectedConditions.
                        visibilityOfElementLocated(By.xpath("//img[@class='brano']"))); //maximalne cakanie
        //driver.findElement(By.xpath("//img[@class='brano']"));

    }
    @After
    public void tearDown(){

    }
}
