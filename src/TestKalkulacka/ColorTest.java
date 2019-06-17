package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

import java.util.List;

public class ColorTest {
    private String BASE_URL = "http:/localhost:8888/stroopeffect.php";
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
    }


    @Test
    public void test(){
        driver.get(BASE_URL);
        //System.out.println(driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getText());
        //driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getCssValue("color");
        //System.out.println(driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getCssValue("color"));

        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class,'colours')]/h1"));
        for (WebElement title : titles) {
            System.out.println(title.getText());
            System.out.println(title.getCssValue("color"));
            System.out.println(title.getCssValue("font-size")); // vieme vypisat uplne hocico lubovlne ako len chceme
            String hexColor = Color.fromString(title.getCssValue("color")).asHex(); //toto meni rgb farbu na hexadecimalnu reprezentaciu farby
            System.out.println(hexColor);
        }
        String rgba = driver.findElement(By.xpath("//div[contains(@class,'colours')]/h1[1]")).getCssValue("color");
        String hexColor = Color.fromString(rgba).asHex();
        Assert.assertEquals("#ff0e0e",hexColor);

    }
    @After
    public void tearDown(){

    }


}
