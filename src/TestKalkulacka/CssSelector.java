package TestKalkulacka;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CssSelector {

    private WebDriver driver;
    private String Base_URL = "http://localhost:8888/kalkulacka.php";

    @Before
    public void SetUp() {
        driver = new FirefoxDriver();
    }
    @Test
    public void Test() {
        driver.get(Base_URL);
        driver.findElement(By.cssSelector("button#count")).click();
        driver.findElement(By.cssSelector("#count")).click();//oznacenie ID #
        driver.findElement(By.cssSelector("button.btn-success")).click();//oznacenie triedy - class sa deje bodkou
    driver.get("http://localhost:8888/clickmebaby.php");
    driver.findElement(By.cssSelector("div.row>button")).click(); //tu si najde najprv classu div.row a v nom prvy button
    driver.findElement(By.cssSelector("div.container button")).click();//priame dieta rodica sa oznaci ako >
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

