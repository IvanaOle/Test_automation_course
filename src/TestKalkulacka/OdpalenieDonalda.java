package TestKalkulacka;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class OdpalenieDonalda {

    private String BASE_URL = "http://localhost:8888/moveme.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void test() throws IOException {
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        WebElement donald = driver.findElement(By.id("donald"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(donald).moveByOffset(5000,0).release().build().perform();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));


//        for (int i = 0; i < 500; i++) {
//            actions.clickAndHold(donald).moveByOffset(10,0).release().build().perform();
//            Thread.sleep(25);
//        }

    }
    @After
    public void tearDown(){

    }
}
