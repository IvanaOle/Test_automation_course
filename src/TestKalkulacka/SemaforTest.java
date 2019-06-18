package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class SemaforTest {
    private String BASE_URL = "http://localhost:8888/semafor.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }
    @Test
    public void test(){
        String expectedGreen = "rgba(10, 129, 0, 1)";
        String expectedRed = "rgba(205, 58, 63, 1)";

        driver.get(BASE_URL);

        WebElement trafficLight = driver.findElement(By.xpath("//div[@class='light']"));
        System.out.println(trafficLight.getCssValue("background-color"));
        String redcolor = trafficLight.getCssValue("background-color");
        //Classic red color as background color
        Assert.assertEquals(expectedRed,redcolor);
        //When hover is applied - green color TRIEDA Actions!!! vykonava akciu
        Actions action = new Actions(driver);
        action.moveToElement(trafficLight).build().perform();
        String actualGreenColor = trafficLight.getCssValue("background-color");
        Assert.assertEquals(expectedGreen,actualGreenColor);



    }
    @After
    public void tearDown(){
        //driver.close();
        //driver.quit();

    }
}
