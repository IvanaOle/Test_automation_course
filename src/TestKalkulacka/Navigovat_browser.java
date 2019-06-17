package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigovat_browser {

    private String BASE_URL = "http:/localhost:8888/registracia.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void test(){

    driver.get(BASE_URL);
    //First test is about moving back nad forward and check if it works and inputs are correctly displayed
    String email = "test@test.sk";
    driver.findElement(By.name("email")).sendKeys("test@test.sk");
    driver.findElement(By.xpath("//a[@href='zenaalebomuz.php']")).click();
    driver.navigate().back();
    new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
    System.out.println(driver.findElement(By.name("email")).getAttribute("value"));

    Assert.assertEquals(email,driver.findElement(By.name("email")).getAttribute("value"));

    driver.navigate().forward();
    new WebDriverWait(driver, 20)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='img/conchita.jpg']")));
    //driver.findElement(By.xpath("//img[@src='img/conchita.jpg']"));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='img/conchita.jpg']")).isDisplayed());

        //Second test is about refresh, it is ok to check it with click me baby, when refresh should check 0 clicks

     driver.get("http:/localhost:8888/clickmebaby.php");
        for (int i = 0; i < 10 ; i++) {
            driver.findElement(By.id("clickMe")).click();
            Assert.assertEquals(String.valueOf(i+1),driver.findElement(By.id("clicks")).getText());
        }
      driver.navigate().refresh();
        Assert.assertEquals(String.valueOf(0),driver.findElement(By.id("clicks")).getText());

    }
    @After
    public void tearDown() throws InterruptedException {
       // driver.close();

    }
}
