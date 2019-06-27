package TestKalkulacka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class AfterFeatures extends MainTest {

    @Before
    public void openBase(){
        driver.get(getBASE_URL()+ "vybersi.php");
    }
    @Test
    public void test(){
        new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Charmander");
        Assert.assertEquals("I choose you Charmander !",driver.findElement(By.xpath("//div[contains(@class,'pokemon')]/h3")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'pokemon')]/h3")).getText().contains("Charmander"));

    }
    @After //sa vykona vzdy za vsetkych podmienok

    public void exception() throws IOException {
        System.out.println("predsa som tu");
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(screenShot,new File("C://Users//ivana.oleksakova//Pictures//Saved Pictures.png"));
        org.apache.commons.io.FileUtils.copyFile(screenShot,new File("C://tmp//screenshot.png"));
        System.out.println(driver.getPageSource());
    }

}
