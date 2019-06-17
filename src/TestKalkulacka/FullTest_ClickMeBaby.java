package TestKalkulacka;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class FullTest_ClickMeBaby {
    private String BASE_URL = "http://localhost:8888/clickmebaby.php";
    private WebDriver driver;
    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void test() {
        driver.get(BASE_URL);
        //System.out.print(driver.findElement(By.id("clicks")).getText());
        //jUnit framework
        //Check why this is not working:
        //Assert.assertEquals("Zaciatocny pocet klikov nesedi","0",driver.findElement(By.id("clicks")).getText()); //Ctrl+D kopiruje cely riadok pod aktualny
        Assert.assertEquals("0",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("1",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("2",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("3",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("4",driver.findElement(By.id("clicks")).getText());
        driver.findElement(By.id("clickMe")).click();
        Assert.assertEquals("5",driver.findElement(By.id("clicks")).getText()); //DRY (Dont repeat yourself)
    }

    @After
    public void tearDown(){

    }


}
